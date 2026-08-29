package toffy.rogue_end.world.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import toffy.rogue_end.entity.EndlingEntity;
import toffy.rogue_end.init.ModEntities;

public class ModSpawns {
    public static void addSpawns() {

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS,BiomeKeys.END_MIDLANDS,BiomeKeys.END_BARRENS,BiomeKeys.THE_END,ModBiomes.ENDER_WILDS,ModBiomes.CORRUPTED_FOREST,ModBiomes.END_DELTAS),
                SpawnGroup.MONSTER, ModEntities.ENDLING,2,1,1);

        SpawnRestriction.register(ModEntities.ENDLING, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EndlingEntity::canMobSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.ENDER_WILDS,ModBiomes.CORRUPTED_FOREST,ModBiomes.END_DELTAS),
                SpawnGroup.MONSTER, EntityType.ENDERMAN,10,4,4);
    }
}
