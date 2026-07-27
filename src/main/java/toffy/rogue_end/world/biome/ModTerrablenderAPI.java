package toffy.rogue_end.world.biome;

import net.minecraft.world.biome.BiomeKeys;
import terrablender.api.EndBiomeRegistry;
import terrablender.api.Region;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        EndBiomeRegistry.registerHighlandsBiome(ModBiomes.CORRUPTED_FOREST, 10);
    }
}
