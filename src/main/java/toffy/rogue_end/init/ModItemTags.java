package toffy.rogue_end.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

public class ModItemTags {
    public static void register() {
        RogueEnd.LOGGER.debug("Registering itemTags for " + RogueEnd.MOD_ID);
    }
    public static final TagKey<Item> CORRUPTED_LOGS = registerItemTag("corrupted_logs");
    public static final TagKey<Item> CHORUS_LOGS = registerItemTag("chorus_logs");
    public static final TagKey<Item> YELLOW_LOGS = registerItemTag("yellow_logs");

    private static TagKey<Item> registerItemTag(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(RogueEnd.MOD_ID,id));
    }

}
