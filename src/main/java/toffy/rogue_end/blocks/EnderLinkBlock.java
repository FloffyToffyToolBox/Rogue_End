package toffy.rogue_end.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import toffy.rogue_end.init.ModBlockEntities;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModComponentTypes;
import toffy.rogue_end.items.EnderEyeComponent;

import java.util.Objects;
import java.util.Optional;

public class EnderLinkBlock extends BlockWithEntity {
    public static final MapCodec<EnderLinkBlock> CODEC = createCodec(EnderLinkBlock::new);
    public static final BooleanProperty POWERED;
    protected static final VoxelShape FRAME_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);
    public static final BooleanProperty LIT;
    public static final BooleanProperty EYE;
    protected MapCodec<? extends EnderLinkBlock> getCodec() {
        return CODEC;
    }
    public EnderLinkBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false).with(LIT, false).with(EYE,false));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        NbtComponent nbtComponent = (NbtComponent)itemStack.getOrDefault(DataComponentTypes.BLOCK_ENTITY_DATA, NbtComponent.DEFAULT);
        if (nbtComponent.contains("eyeStack")) {
            world.setBlockState(pos, (BlockState)state.with(EYE, true), 2);
        }
    }
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FRAME_SHAPE;
    }
    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.ENDER_EYE)){
            if (stack.contains(ModComponentTypes.ENDER_EYE)){
                if (Objects.requireNonNull(stack.get(ModComponentTypes.ENDER_EYE)).tracked()) {
                    ((EnderLinkBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).setStack(stack);
                    world.setBlockState(pos, state.with(EYE, true));
                    return ItemActionResult.CONSUME;
                }
            }
        }
        return ItemActionResult.FAIL;
    }
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    protected boolean hasSidedTransparency(BlockState state) {
        return true;
    }
    public void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean)state.get(POWERED)) {
            world.setBlockState(pos, (BlockState)state.with(POWERED, bl), 3);
            if (state.get(EYE)){
                GlobalPos receiverPos = ((EnderLinkBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getReceiverPos();
                if (receiverPos.dimension()==world.getRegistryKey())
                {
                    if (world.getBlockState(receiverPos.pos()).isOf(ModBlocks.ENDER_LINK)){
                        world.setBlockState(receiverPos.pos(),world.getBlockState(receiverPos.pos()).with(LIT,bl));
                    }
                }
            }
        }
    }
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    static {
        POWERED = Properties.POWERED;
        EYE = Properties.EYE;
        LIT = Properties.LIT;
    }
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return (Boolean)world.getBlockState(pos).get(LIT) ? 15 : 0;
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{POWERED});
        builder.add(new Property[]{LIT});
        builder.add(new Property[]{EYE});
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EnderLinkBlockEntity(pos, state);
    }
}
