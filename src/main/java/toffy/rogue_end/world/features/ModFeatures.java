package toffy.rogue_end.world.features;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import toffy.rogue_end.RogueEnd;

public class ModFeatures {

    static  {
    }
    private static <C extends FeatureConfig, F extends Feature<C>> F registerFeature(String name, F feature) {
        return (F) Registry.register(Registries.FEATURE, name, feature);
    }

    public static void register() {

        RogueEnd.LOGGER.debug("Registering blocks for " + RogueEnd.MOD_ID);
    }
}
