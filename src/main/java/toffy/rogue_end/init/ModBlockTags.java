package toffy.rogue_end.init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

public class ModBlockTags {
    public static void register() {
        RogueEnd.LOGGER.debug("Registering blocks for " + RogueEnd.MOD_ID);
}
    public static final TagKey<Block> MAGMA_ROOT_PLACEABLE_ON = registerBlockTag("magma_root_placeable_on");
    public static final TagKey<Block> DRIES_SPONGE = registerBlockTag("dries_sponge");
    public static final TagKey<Block> CORRUPTED_LOGS = registerBlockTag("corrupted_logs");
    public static final TagKey<Block> CHORUS_LOGS = registerBlockTag("chorus_logs");
    public static final TagKey<Block> CHORUS_PLANT_CAN_REPLACE = registerBlockTag("chorus_plant_can_replace");
    private static TagKey<Block> registerBlockTag(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(RogueEnd.MOD_ID,id));
    }

}
