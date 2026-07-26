package toffy.rogue_end.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import toffy.rogue_end.init.ModBlockTags;
import toffy.rogue_end.init.ModBlocks;

public class ShortEndPlantBlock extends ShortPlantBlock {
    public ShortEndPlantBlock(Settings settings) {
        super(settings);
    }
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        TallPlantBlock tallPlantBlock = (TallPlantBlock)(state.isOf(ModBlocks.SHORT_ENDER_TUBES) ? ModBlocks.ENDER_TUBES : ModBlocks.TALL_END_FERN);
        if (tallPlantBlock.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
            TallPlantBlock.placeAt(world, tallPlantBlock.getDefaultState(), pos, 2);
        }
    }
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(ModBlockTags.MAGMA_ROOT_PLACEABLE_ON) || super.canPlantOnTop(floor, world, pos);
    }
}
