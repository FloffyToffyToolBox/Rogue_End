package toffy.rogue_end.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import toffy.rogue_end.init.ModBlockTags;
import toffy.rogue_end.init.ModBlocks;

import static net.minecraft.block.AbstractBlock.createCodec;

public class MagmaRootBlock extends PlantBlock{
public static final MapCodec<MagmaRootBlock> CODEC = createCodec(MagmaRootBlock::new);
protected static final float field_31235 = 6.0F;
protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

public MapCodec<MagmaRootBlock> getCodec() {
    return CODEC;
}

public MagmaRootBlock(AbstractBlock.Settings settings) {
    super(settings);
}

protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
}

protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(ModBlockTags.MAGMA_ROOT_PLACEABLE_ON) || super.canPlantOnTop(floor, world, pos);
    }
}
