package toffy.rogue_end.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.world.features.ModFeatures;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ENDSLATE_BLOBS = registerKey("endslate_blobs");
    public static final RegistryKey<PlacedFeature> DARK_PURPUR_BLOBS = registerKey("dark_purpur_blobs");
    public static final RegistryKey<PlacedFeature> END_BONE_BLOBS = registerKey("end_bone_blobs");

    public static final RegistryKey<PlacedFeature> CHORAL_BLOOMS = registerKey("choral_blooms");
    public static final RegistryKey<PlacedFeature> END_SHRUB = registerKey("end_shrub");
    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry1 = configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDSLATE_BLOB_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry2 = configuredFeatures.getOrThrow(ModConfiguredFeatures.DARK_PURPUR_BLOB_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry3 = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_BONE_KEY);

        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry4 = configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORAL_BLOOM_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry5 = configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SHRUB_KEY);
        PlacedFeatures.register(context, ENDSLATE_BLOBS, registryEntry1,  new PlacementModifier[]{CountPlacementModifier.of(25), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(35)), BiomePlacementModifier.of()});
        PlacedFeatures.register(context, DARK_PURPUR_BLOBS, registryEntry2,  new PlacementModifier[]{CountPlacementModifier.of(25), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(25)), BiomePlacementModifier.of()});
        PlacedFeatures.register(context, END_BONE_BLOBS, registryEntry3,  new PlacementModifier[]{CountPlacementModifier.of(25), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(15)), BiomePlacementModifier.of()});

        PlacedFeatures.register(context, CHORAL_BLOOMS, registryEntry4, new PlacementModifier[]{RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        PlacedFeatures.register(context, END_SHRUB, registryEntry5, new PlacementModifier[]{NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()});
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
