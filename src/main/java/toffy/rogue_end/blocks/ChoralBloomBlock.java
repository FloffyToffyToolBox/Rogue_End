package toffy.rogue_end.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import toffy.rogue_end.init.ModBlockTags;

public class ChoralBloomBlock extends TallPlantBlock {
    public ChoralBloomBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(ModBlockTags.MAGMA_ROOT_PLACEABLE_ON) || super.canPlantOnTop(floor, world, pos);
    }
}
