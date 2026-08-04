package toffy.rogue_end.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.items.BackstabberItem;
import toffy.rogue_end.items.CorruptedAmuletItem;

public class ModItems {
    public static final Item BACK_STABBER = registerItem("backstabber", (new BackstabberItem((new Item.Settings()).rarity(Rarity.EPIC).maxDamage(500).fireproof().component(DataComponentTypes.TOOL, BackstabberItem.createToolComponent()).attributeModifiers(BackstabberItem.createAttributeModifiers()))));
    public static final Item ENDSTEEL_INGOT = registerItem("endsteel_ingot", (new Item(new Item.Settings())));
    public static final Item ENDERSENT_SPAWN_EGG= registerItem("endersent_spawn_egg", (new SpawnEggItem(ModEntities.ENDERSENT,0,1447446, new Item.Settings())));

    public static final Item PURIFIED_VOID_AMULET = registerItem("purified_void_amulet", (new Item(new Item.Settings().maxCount(1).fireproof())));
    public static final Item CORRUPTED_VOID_AMULET = registerItem("corrupted_void_amulet", (new CorruptedAmuletItem(new Item.Settings().maxCount(1).fireproof())));

    public static void register() {
        RogueEnd.LOGGER.debug("Registering blocks for " + RogueEnd.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RogueEnd.MOD_ID, name),
                item);
    }
}
