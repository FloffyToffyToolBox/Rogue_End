package toffy.rogue_end.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import toffy.rogue_end.blocks.YellowLichenBlock;
import toffy.rogue_end.init.ModBlocks;

public class LeavesYellowVineTreeDecorator extends TreeDecorator {
    public static final MapCodec<LeavesYellowVineTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(LeavesYellowVineTreeDecorator::new, (treeDecorator) -> treeDecorator.probability);
    private final float probability;

    protected TreeDecoratorType<?> getType() {
        return ModTreeDecoratorType.YELLOW_LEAVE_VINE;
    }

    public LeavesYellowVineTreeDecorator(float probability) {
        this.probability = probability;
    }

    public void generate(TreeDecorator.Generator generator) {
        Random random = generator.getRandom();
        generator.getLeavesPositions().forEach((pos) -> {
            if (random.nextFloat() < this.probability) {
                BlockPos blockPos = pos.west();
                if (generator.isAir(blockPos)) {
                    placeVines(blockPos, YellowLichenBlock.EAST, generator);
                }
            }

            if (random.nextFloat() < this.probability) {
                BlockPos blockPos = pos.east();
                if (generator.isAir(blockPos)) {
                    placeVines(blockPos, YellowLichenBlock.WEST, generator);
                }
            }

            if (random.nextFloat() < this.probability) {
                BlockPos blockPos = pos.north();
                if (generator.isAir(blockPos)) {
                    placeVines(blockPos, YellowLichenBlock.SOUTH, generator);
                }
            }

            if (random.nextFloat() < this.probability) {
                BlockPos blockPos = pos.south();
                if (generator.isAir(blockPos)) {
                    placeVines(blockPos, YellowLichenBlock.NORTH, generator);
                }
            }

        });
    }

    private static void placeVines(BlockPos pos, BooleanProperty faceProperty, TreeDecorator.Generator generator) {
        generator.replace(pos, (BlockState) ModBlocks.YELLOWROOT_LICHEN.getDefaultState().with(faceProperty, true));
        int i = 4;

        for(BlockPos var4 = pos.up(); generator.isAir(var4) && i > 0; --i) {
            generator.replace(var4, (BlockState) ModBlocks.YELLOWROOT_LICHEN.getDefaultState().with(faceProperty, true));
            var4 = var4.up();
        }

    }
}
