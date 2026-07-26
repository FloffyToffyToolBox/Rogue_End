package toffy.rogue_end.world.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
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


        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.CHORAL_BLOOMS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.END_SHRUB);
    }
}
