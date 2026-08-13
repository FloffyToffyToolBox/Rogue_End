package toffy.rogue_end.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.world.features.ChorusTrunkPlacer;
import toffy.rogue_end.world.features.LeavesYellowVineTreeDecorator;
import toffy.rogue_end.world.features.ModFeatures;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> ENDSLATE_BLOB_KEY = registerKey("endslate_blob");
    public static final RegistryKey<ConfiguredFeature<?,?>> DARK_PURPUR_BLOB_KEY = registerKey("dark_purpur_blob");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_BONE_KEY = registerKey("end_bone");
    public static final RegistryKey<ConfiguredFeature<?,?>> SMOOTH_END_STONE_BLOBS = registerKey("smooth_end_stone_blobs");


    public static final RegistryKey<ConfiguredFeature<?,?>> CORRUPTED_TUBE_PATCH_KEY = registerKey("corrupted_tube_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> ENDER_TUBE_PATCH_KEY = registerKey("ender_tube_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> MAGMA_ROOT_PATCH_KEY = registerKey("magma_root_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> CHORAL_BLOOM_KEY = registerKey("choral_bloom");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_SHRUB_KEY = registerKey("end_shrub");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_GRASS_KEY = registerKey("end_grass");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_FERN_KEY = registerKey("end_fern");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_DELTA_KEY = registerKey("end_delta");
    public static final RegistryKey<ConfiguredFeature<?,?>> DARK_COLUMN_KEY = registerKey("dark_column");

    public static final RegistryKey<ConfiguredFeature<?,?>> YELLOW_TREE_KEY = registerKey("chorus_tree");

    private static TreeFeatureConfig.Builder chorus() {
        return (new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.YELLOW_LOG),
                new ChorusTrunkPlacer(6, 1, 0, UniformIntProvider.create(1, 2), UniformIntProvider.create(1, 4),
                        UniformIntProvider.create(-2, -1), UniformIntProvider.create(-4, -3)), BlockStateProvider.of(ModBlocks.YELLOW_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), ConstantIntProvider.create(3),75) {
                },
                new TwoLayersFeatureSize(1, 0, 2))).decorators(ImmutableList.of(new LeavesYellowVineTreeDecorator(0.25F)));
    }
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context,END_SHRUB_KEY,Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.DRY_END_GRASS.getDefaultState(), 3).add(ModBlocks.DRY_END_SHRUB.getDefaultState(), 3).add(ModBlocks.END_BUSH.getDefaultState(), 3)))));

        register(context,END_GRASS_KEY,Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.END_GRASS.getDefaultState(), 3).add(ModBlocks.END_SHRUB.getDefaultState(), 3)))));

        register(context,ENDER_TUBE_PATCH_KEY,Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.ENDER_TUBES.getDefaultState(), 3).add(ModBlocks.SHORT_ENDER_TUBES.getDefaultState(), 3)))));

        register(context,END_FERN_KEY,Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(ModBlocks.TALL_END_FERN.getDefaultState(), 1).add(ModBlocks.END_FERN.getDefaultState(), 3)))));
        ConfiguredFeatures.register(context, ENDSLATE_BLOB_KEY, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.END_STONE.getDefaultState(), ModBlocks.ENDSLATE.getDefaultState(), UniformIntProvider.create(3, 7)));
        ConfiguredFeatures.register(context, SMOOTH_END_STONE_BLOBS, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.END_STONE.getDefaultState(), ModBlocks.SMOOTH_ENDSTONE.getDefaultState(), UniformIntProvider.create(7, 11)));
        ConfiguredFeatures.register(context, DARK_PURPUR_BLOB_KEY, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.END_STONE.getDefaultState(), ModBlocks.DARK_PURPUR.getDefaultState(), UniformIntProvider.create(4, 8)));
        ConfiguredFeatures.register(context, END_BONE_KEY, Feature.NETHERRACK_REPLACE_BLOBS, new ReplaceBlobsFeatureConfig(Blocks.END_STONE.getDefaultState(), ModBlocks.END_BONE.getDefaultState(), UniformIntProvider.create(5, 9)));

        register(context, YELLOW_TREE_KEY, Feature.TREE, chorus().build());

        register(context, MAGMA_ROOT_PATCH_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MAGMA_ROOTS))));
        register(context, CHORAL_BLOOM_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CHORAL_BLOOM))));
        register(context, CORRUPTED_TUBE_PATCH_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CORRUPTED_TUBES))));
        register(context, END_DELTA_KEY, Feature.DELTA_FEATURE, new DeltaFeatureConfig(ModBlocks.END_MAGMA.getDefaultState(), ModBlocks.END_MAGMA.getDefaultState(), UniformIntProvider.create(1, 4), UniformIntProvider.create(0, 2)));
        register(context, DARK_COLUMN_KEY, ModFeatures.END_COLUMNS_FEATURE, new BasaltColumnsFeatureConfig(ConstantIntProvider.create(1), UniformIntProvider.create(1, 3)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(RogueEnd.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
