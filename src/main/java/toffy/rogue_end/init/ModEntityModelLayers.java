package toffy.rogue_end.init;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

public class ModEntityModelLayers {
    public static final EntityModelLayer ENDERMAN_HEAD = registerMain("enderman_head");
    private static EntityModelLayer registerMain(String id) {
    return register(id, "main");
}

    public static void register() {
        RogueEnd.LOGGER.debug("Registering blocks for " + RogueEnd.MOD_ID);
    }

    private static EntityModelLayer register(String id, String layer) {
        return create(id, layer);
    }

    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(Identifier.ofVanilla(id), layer);
    }
}
