package toffy.rogue_end.world.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.EndPlacedFeatures;
import toffy.rogue_end.init.ModEntities;
import toffy.rogue_end.world.ModPlacedFeatures;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS,BiomeKeys.END_MIDLANDS,BiomeKeys.END_BARRENS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.END_BONE_BLOBS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS,BiomeKeys.END_MIDLANDS,BiomeKeys.END_BARRENS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.DARK_PURPUR_BLOBS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS,BiomeKeys.END_MIDLANDS,BiomeKeys.END_BARRENS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.ENDSLATE_BLOBS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS,BiomeKeys.END_MIDLANDS,BiomeKeys.END_BARRENS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.SMOOTH_END_STONE_BLOBS);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.CHORAL_BLOOMS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.END_SHRUB);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.END_FERN);

        //end wilds
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ENDER_WILDS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.END_ARCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ENDER_WILDS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.END_PILLAR);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ENDER_WILDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.YELLOW_TREES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ENDER_WILDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.END_GRASS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ENDER_WILDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.END_FERN);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ENDER_WILDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.ENDER_TUBES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ENDER_WILDS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.SMOOTH_END_STONE_BLOBS);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CORRUPTED_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.CORRUPTED_TUBES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CORRUPTED_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.CHORAL_BLOOMS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.END_DELTAS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.END_DELTA);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.END_DELTAS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.DELTA_COLUMN);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.END_DELTAS),
                GenerationStep.Feature.RAW_GENERATION,
                ModPlacedFeatures.TOOTH_FOSSIL);
    }
}
