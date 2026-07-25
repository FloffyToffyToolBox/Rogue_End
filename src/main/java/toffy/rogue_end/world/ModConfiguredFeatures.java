package toffy.rogue_end.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.world.features.ChorusTrunkPlacer;
import toffy.rogue_end.world.features.ModFeatures;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> MAGMA_ROOT_PATCH_KEY = registerKey("magma_root_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> CHORAL_BLOOM_KEY = registerKey("choral_bloom");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_DELTA_KEY = registerKey("end_delta");
    public static final RegistryKey<ConfiguredFeature<?,?>> DARK_COLUMN_KEY = registerKey("dark_column");

    public static final RegistryKey<ConfiguredFeature<?,?>> CHORUS_TREE_KEY = registerKey("chorus_tree");

    private static TreeFeatureConfig.Builder chorus() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.CHORUS_LOG),
                new ChorusTrunkPlacer(6, 1, 0, UniformIntProvider.create(1,2), UniformIntProvider.create(1, 5), UniformIntProvider.create(-2, -1), UniformIntProvider.create(-3, -2)), BlockStateProvider.of(ModBlocks.YELLOW_LEAVES),
                new LargeOakFoliagePlacer(UniformIntProvider.create(1,2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, CHORUS_TREE_KEY, Feature.TREE, chorus().build());

        register(context, MAGMA_ROOT_PATCH_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MAGMA_ROOTS))));
        register(context, CHORAL_BLOOM_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CHORAL_BLOOM))));
        register(context, END_DELTA_KEY, Feature.DELTA_FEATURE, new DeltaFeatureConfig(Blocks.LAVA.getDefaultState(), ModBlocks.END_MAGMA.getDefaultState(), UniformIntProvider.create(3, 7), UniformIntProvider.create(0, 2)));
        register(context, DARK_COLUMN_KEY, ModFeatures.END_COLUMNS_FEATURE, new BasaltColumnsFeatureConfig(ConstantIntProvider.create(1), UniformIntProvider.create(1, 2)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(RogueEnd.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
