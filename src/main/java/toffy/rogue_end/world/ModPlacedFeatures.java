package toffy.rogue_end.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.world.features.ModFeatures;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> END_DELTA = registerKey("end_delta");
    public static final RegistryKey<PlacedFeature> DELTA_COLUMN = registerKey("delta_column");
    public static final RegistryKey<PlacedFeature> ENDSLATE_BLOBS = registerKey("endslate_blobs");
    public static final RegistryKey<PlacedFeature> DARK_PURPUR_BLOBS = registerKey("dark_purpur_blobs");
    public static final RegistryKey<PlacedFeature> END_BONE_BLOBS = registerKey("end_bone_blobs");
    public static final RegistryKey<PlacedFeature> SMOOTH_END_STONE_BLOBS = registerKey("smooth_end_stone_blobs");

    public static final RegistryKey<PlacedFeature> TOOTH_FOSSIL = registerKey("tooth_fossil");

    public static final RegistryKey<PlacedFeature> END_ARCH = registerKey("end_arch");
    public static final RegistryKey<PlacedFeature> END_PILLAR = registerKey("end_pillar");

    public static final RegistryKey<PlacedFeature> CHORAL_BLOOMS = registerKey("choral_blooms");



    public static final RegistryKey<PlacedFeature> CORRUPTED_TUBES = registerKey("corrupted_tubes");
    public static final RegistryKey<PlacedFeature> ENDER_TUBES = registerKey("ender_tubes");
    public static final RegistryKey<PlacedFeature> YELLOW_TREES = registerKey("yellow_trees");
    public static final RegistryKey<PlacedFeature> END_GRASS = registerKey("end_grass");
    public static final RegistryKey<PlacedFeature> END_SHRUB = registerKey("end_shrub");
    public static final RegistryKey<PlacedFeature> END_FERN = registerKey("end_fern");
    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_DELTA_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry2 = configuredFeatures.getOrThrow(ModConfiguredFeatures.DARK_COLUMN_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry3 = configuredFeatures.getOrThrow(ModConfiguredFeatures.YELLOW_TREE_KEY);

        RegistryEntry<ConfiguredFeature<?, ?>> endslate_blobs = configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDSLATE_BLOB_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> dark_purpur_blobs = configuredFeatures.getOrThrow(ModConfiguredFeatures.DARK_PURPUR_BLOB_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> end_bone_blobs = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_BONE_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> smooth_end_stone_blobs = configuredFeatures.getOrThrow(ModConfiguredFeatures.SMOOTH_END_STONE_BLOBS);
        RegistryEntry<ConfiguredFeature<?, ?>> tooth_fossil = configuredFeatures.getOrThrow(ModConfiguredFeatures.TOOTH_FOSSIL);

        RegistryEntry<ConfiguredFeature<?, ?>> end_arch = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ARCH);
        RegistryEntry<ConfiguredFeature<?, ?>> end_pillar = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_PILLAR);

        RegistryEntry<ConfiguredFeature<?, ?>> choral_blooms = configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORAL_BLOOM_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> corrupted_tubes = configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPTED_TUBE_PATCH_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> ender_tubes = configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDER_TUBE_PATCH_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> end_shrub = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SHRUB_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> end_grass = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_GRASS_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> end_fern = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_FERN_KEY);
        PlacedFeatures.register(context, END_DELTA, registryEntry, new PlacementModifier[]{CountPlacementModifier.of(75),SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        PlacedFeatures.register(context, DELTA_COLUMN, registryEntry2, new PlacementModifier[]{CountPlacementModifier.of(6), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        PlacedFeatures.register(context, SMOOTH_END_STONE_BLOBS, smooth_end_stone_blobs,  new PlacementModifier[]{CountPlacementModifier.of(10), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(25), YOffset.aboveBottom(50)), BiomePlacementModifier.of()});

        PlacedFeatures.register(context, TOOTH_FOSSIL, tooth_fossil,  new PlacementModifier[]{RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, END_ARCH, end_arch,  new PlacementModifier[]{RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR), BiomePlacementModifier.of()});
        PlacedFeatures.register(context, END_PILLAR, end_pillar,  new PlacementModifier[]{RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR), BiomePlacementModifier.of()});

        PlacedFeatures.register(context, ENDSLATE_BLOBS, endslate_blobs,  new PlacementModifier[]{CountPlacementModifier.of(25), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(35)), BiomePlacementModifier.of()});
        PlacedFeatures.register(context, DARK_PURPUR_BLOBS, dark_purpur_blobs,  new PlacementModifier[]{CountPlacementModifier.of(25), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(25)), BiomePlacementModifier.of()});
        PlacedFeatures.register(context, END_BONE_BLOBS, end_bone_blobs,  new PlacementModifier[]{CountPlacementModifier.of(25), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(15)), BiomePlacementModifier.of()});

        PlacedFeatures.register(context, CHORAL_BLOOMS, choral_blooms, new PlacementModifier[]{RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        PlacedFeatures.register(context, CORRUPTED_TUBES, corrupted_tubes, new PlacementModifier[]{RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        PlacedFeatures.register(context, ENDER_TUBES, ender_tubes, new PlacementModifier[]{RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        PlacedFeatures.register(context, YELLOW_TREES, registryEntry3, new PlacementModifier[]{PlacedFeatures.createCountExtraModifier(3, 0.1F, 1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()});
        PlacedFeatures.register(context, END_SHRUB, end_shrub, new PlacementModifier[]{NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR), BiomePlacementModifier.of()});
        PlacedFeatures.register(context, END_GRASS, end_grass, new PlacementModifier[]{NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR), BiomePlacementModifier.of()});
        PlacedFeatures.register(context, END_FERN, end_fern, new PlacementModifier[]{RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR), BiomePlacementModifier.of()});
    }



    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(RogueEnd.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
