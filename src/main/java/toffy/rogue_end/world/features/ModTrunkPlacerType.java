package toffy.rogue_end.world.features;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.trunk.*;
import toffy.rogue_end.RogueEnd;

public class ModTrunkPlacerType<P extends TrunkPlacer> {
    public static final TrunkPlacerType<ChorusTrunkPlacer> CHORUS_TRUNK_PLACER;
    private final MapCodec<P> codec;

    private static <P extends TrunkPlacer> TrunkPlacerType<P> register(String id, MapCodec<P> codec) {
        return Registry.register(Registries.TRUNK_PLACER_TYPE, id, new TrunkPlacerType<>(codec));
    }

    public ModTrunkPlacerType(MapCodec<P> codec) {
        this.codec = codec;
    }
    public static void register() {

        RogueEnd.LOGGER.debug("Registering blocks for " + RogueEnd.MOD_ID);
    }
    public MapCodec<P> getCodec() {
        return this.codec;
    }

    static {
        CHORUS_TRUNK_PLACER = register("chorus_trunk_placer", ChorusTrunkPlacer.CODEC);
    }
}
