package toffy.rogue_end.world.biome;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.source.BiomeSupplier;
import terrablender.api.EndBiomeRegistry;
import toffy.rogue_end.RogueEnd;

public class ModBiomes {
    public static final RegistryKey<Biome> CORRUPTED_FOREST = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(RogueEnd.MOD_ID, "corrupted_forest"));
    public static final RegistryKey<Biome> ENDER_WILDS = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(RogueEnd.MOD_ID, "ender_wilds"));
    public static final RegistryKey<Biome> END_DELTAS = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(RogueEnd.MOD_ID, "end_deltas"));
    public static void bootstrap(Registerable<Biome> context)
    {
        context.register(CORRUPTED_FOREST, corruptedForest(context));
        context.register(ENDER_WILDS, enderWilds(context));
        context.register(END_DELTAS, endDeltas(context));
    }
    private static Biome corruptedForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.5F)
                .downfall(0.5F)
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(7907327)
                        .grassColor(13672277)
                        .foliageColor(16746042)
                        .fogColor(12638463)
                        .build()).generationSettings(biomeBuilder.build()).build();
    }
    private static Biome enderWilds(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.5F)
                .downfall(0.5F)
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(7907327)
                        .grassColor(13672277)
                        .foliageColor(16746042)
                        .fogColor(12638463)
                        .build()).generationSettings(biomeBuilder.build()).build();
    }
    private static Biome endDeltas(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        return new Biome.Builder()
                .precipitation(false)
                .temperature(0.5F)
                .downfall(0.5F)
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(7907327)
                        .grassColor(13672277)
                        .foliageColor(16746042)
                        .fogColor(12638463)
                        .build()).generationSettings(biomeBuilder.build()).build();
    }
}
