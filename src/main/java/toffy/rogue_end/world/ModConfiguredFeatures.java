package toffy.rogue_end.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.world.features.ChorusTrunkPlacer;
import toffy.rogue_end.world.features.ModFeatures;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> ENDSLATE_BLOB_KEY = registerKey("endslate_blob");
    public static final RegistryKey<ConfiguredFeature<?,?>> DARK_PURPUR_BLOB_KEY = registerKey("dark_purpur_blob");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_BONE_KEY = registerKey("end_bone");


    public static final RegistryKey<ConfiguredFeature<?,?>> ENDER_TUBE_PATCH_KEY = registerKey("ender_tube_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> MAGMA_ROOT_PATCH_KEY = registerKey("magma_root_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> CHORAL_BLOOM_KEY = registerKey("choral_bloom");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_SHRUB_KEY = registerKey("end_shrub");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_GRASS_KEY = registerKey("end_grass");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_DELTA_KEY = registerKey("end_delta");
    public static final RegistryKey<ConfiguredFeature<?,?>> DARK_COLUMN_KEY = registerKey("dark_column");

    public static final RegistryKey<ConfiguredFeature<?,?>> CHORUS_TREE_KEY = registerKey("chorus_tree");

    private static TreeFeatureConfig.Builder chorus() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.CHORUS_LOG),
                new ChorusTrunkPlacer(7, 2, 0, UniformIntProvider.create(1,2), UniformIntProvider.create(1, 5), UniformIntProvider.create(-2, -1), UniformIntProvider.create(-3, -2)), BlockStateProvider.of(ModBlocks.CHORUS_LEAVES),
                new LargeOakFoliagePlacer(UniformIntProvider.create(1,2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context,END_SHRUB_KEY,Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.DRY_END_GRASS.getDefaultState(), 3).add(ModBlocks.DRY_END_SHRUB.getDefaultState(), 3).add(ModBlocks.END_BUSH.getDefaultState(), 3)))));

        register(context,END_GRASS_KEY,Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.END_GRASS.getDefaultState(), 3).add(ModBlocks.END_SHRUB.getDefaultState(), 3)))));

        register(context,ENDER_TUBE_PATCH_KEY,Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.ENDER_TUBES.getDefaultState(), 3).add(ModBlocks.SHORT_ENDER_TUBES.getDefaultState(), 3)))));
        ConfiguredFeatures.register(context, ENDSLATE_BLOB_KEY, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.END_STONE.getDefaultState(), ModBlocks.ENDSLATE.getDefaultState(), UniformIntProvider.create(3, 7)));
        ConfiguredFeatures.register(context, DARK_PURPUR_BLOB_KEY, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.END_STONE.getDefaultState(), ModBlocks.DARK_PURPUR.getDefaultState(), UniformIntProvider.create(4, 8)));
        ConfiguredFeatures.register(context, END_BONE_KEY, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.END_STONE.getDefaultState(), ModBlocks.END_BONE.getDefaultState(), UniformIntProvider.create(5, 9)));

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
