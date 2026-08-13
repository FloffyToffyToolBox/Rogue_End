package toffy.rogue_end.world.features;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.treedecorator.*;
import toffy.rogue_end.RogueEnd;

public class ModTreeDecoratorType<P extends TreeDecorator> {
    public static final TreeDecoratorType<LeavesYellowVineTreeDecorator> YELLOW_LEAVE_VINE;
    private final MapCodec<P> codec;

    private static <P extends TreeDecorator> TreeDecoratorType<P> register(String id, MapCodec<P> codec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE, id, new TreeDecoratorType<>(codec));
    }

    public static void register() {
        RogueEnd.LOGGER.debug("Registering tree decorator types for " + RogueEnd.MOD_ID);
    }
    public ModTreeDecoratorType(MapCodec<P> codec) {
        this.codec = codec;
    }

    public MapCodec<P> getCodec() {
        return this.codec;
    }

    static {
        YELLOW_LEAVE_VINE = register("yellow_leave_vine", LeavesYellowVineTreeDecorator.CODEC);
    }
}
