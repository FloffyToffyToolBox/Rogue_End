package toffy.rogue_end.world.features;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import toffy.rogue_end.RogueEnd;

public class ModFeatures {

    public static final Feature<BasaltColumnsFeatureConfig> END_COLUMNS_FEATURE;
    static{
        END_COLUMNS_FEATURE = registerFeature("end_columns", new EndColumnsFeature(BasaltColumnsFeatureConfig.CODEC));
    }
    private static <C extends FeatureConfig, F extends Feature<C>> F registerFeature(String name, F feature) {
        return (F) Registry.register(Registries.FEATURE, name, feature);
    }

    public static void register() {

        RogueEnd.LOGGER.debug("Registering blocks for " + RogueEnd.MOD_ID);
    }
}
