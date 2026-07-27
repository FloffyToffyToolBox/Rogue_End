package toffy.rogue_end.world.biome;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.MaterialRules.*;
import toffy.rogue_end.init.ModBlocks;

public class ModSurfaceRules {
    static MaterialRule CHORAL_ENDLSATE = MaterialRules.block(ModBlocks.CHORAL_ENDSLATE.getDefaultState());
    static MaterialRule ENDLSATE = MaterialRules.block(ModBlocks.ENDSLATE.getDefaultState());
    public static MaterialRule end()
    {
        return MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomes.CORRUPTED_FOREST),
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                                MaterialRules.sequence(
                                        CHORAL_ENDLSATE
                                ))
                        )
                )
        );
    }
}
