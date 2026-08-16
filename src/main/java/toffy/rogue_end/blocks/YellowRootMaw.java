package toffy.rogue_end.blocks;

import com.jcraft.jorbis.DspState;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TrackedPosition;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class YellowRootMaw extends Block {
    public static final MapCodec<YellowRootMaw> CODEC = createCodec(YellowRootMaw::new);
    public static final BooleanProperty TRIGGERED = Properties.TRIGGERED;
    private static final VoxelShape RAYCAST_SHAPE = createCuboidShape((double)2.0F, (double)4.0F, (double)2.0F, (double)14.0F, (double)16.0F, (double)14.0F);
    protected static final VoxelShape OUTLINE_SHAPE = VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(),
            RAYCAST_SHAPE,
            BooleanBiFunction.ONLY_FIRST);
    public YellowRootMaw(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(TRIGGERED,false));
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity!=null){
            if (pos.toCenterPos().getY() > entity.getPos().getY()) {
                entity.damage(world.getDamageSources().cactus(), 1f);
            }
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity){
            if (!state.get(TRIGGERED)){
                entity.setPosition(pos.toBottomCenterPos().add(0,.25f,0));
                world.setBlockState(pos,state.with(TRIGGERED,true));
            }
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos,state.with(TRIGGERED,false));
        super.randomTick(state, world, pos, random);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TRIGGERED});
    }
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPE;
    }
}
