package toffy.rogue_end.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import toffy.rogue_end.init.ModSoundEvents;

public class BounceBloomBlock extends Block {
    public static final MapCodec<BounceBloomBlock> CODEC = createCodec(BounceBloomBlock::new);

    public BounceBloomBlock(Settings settings) {
        super(settings);
    }
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return  world.getBlockState(blockPos).isFullCube(world,blockPos);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public MapCodec<BounceBloomBlock> getCodec() {
        return CODEC;
    }
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        world.playSound(null,pos, ModSoundEvents.BOUNCE_BLOOM_LAND, SoundCategory.BLOCKS,0.25f,1f);
        entity.handleFallDamage(fallDistance, 0f, world.getDamageSources().fall());
    }
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        super.onEntityLand(world, entity);
    }
}
