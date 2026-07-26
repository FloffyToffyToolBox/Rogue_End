package toffy.rogue_end.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import toffy.rogue_end.init.ModBlockTags;

public class TallEndPlantBlock extends TallPlantBlock {
    public TallEndPlantBlock(Settings settings) {
        super(settings);
    }
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(ModBlockTags.MAGMA_ROOT_PLACEABLE_ON) || super.canPlantOnTop(floor, world, pos);
    }
}
