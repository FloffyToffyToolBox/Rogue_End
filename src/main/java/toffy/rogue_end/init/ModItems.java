package toffy.rogue_end.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.items.BackstabberItem;
import toffy.rogue_end.items.CorruptedAmuletItem;
import toffy.rogue_end.items.PurifiedAmuletItem;

public class ModItems {
    public static final Item ENDSTEEL_HELMET = registerItem((String)"endsteel_helmet", (Item)(new ArmorItem(ModArmourMaterials.ENDSTEEL, net.minecraft.item.ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.HELMET.getMaxDamage(33)))));
    public static final Item ENDSTEEL_CHESTPLATE = registerItem((String)"endsteel_chestplate", (Item)(new ArmorItem(ModArmourMaterials.ENDSTEEL, net.minecraft.item.ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.CHESTPLATE.getMaxDamage(33)))));
    public static final Item ENDSTEEL_LEGGINGS = registerItem((String)"endsteel_leggings", (Item)(new ArmorItem(ModArmourMaterials.ENDSTEEL, net.minecraft.item.ArmorItem.Type.LEGGINGS, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.LEGGINGS.getMaxDamage(33)))));
    public static final Item ENDSTEEL_BOOTS = registerItem((String)"endsteel_boots", (Item)(new ArmorItem(ModArmourMaterials.ENDSTEEL, net.minecraft.item.ArmorItem.Type.BOOTS, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.BOOTS.getMaxDamage(33)))));

    public static final Item ENDSTEEL_SWORD = registerItem("endsteel_sword", new SwordItem(ModToolMaterials.ENDSTEEL,
            new Item.Settings().maxCount(1).attributeModifiers(SwordItem.createAttributeModifiers((ModToolMaterials.ENDSTEEL),3, -2.4F))));
    public static final Item ENDSTEEL_SHOVEL = registerItem("endsteel_shovel", new ShovelItem(ModToolMaterials.ENDSTEEL,
            new Item.Settings().maxCount(1).attributeModifiers(ShovelItem.createAttributeModifiers((ModToolMaterials.ENDSTEEL),1.5F, -3.0F))));
    public static final Item ENDSTEEL_PICKAXE = registerItem("endsteel_pickaxe", new PickaxeItem(ModToolMaterials.ENDSTEEL,
            new Item.Settings().maxCount(1).attributeModifiers(PickaxeItem.createAttributeModifiers((ModToolMaterials.ENDSTEEL),1.0F, -2.8F))));
    public static final Item ENDSTEEL_AXE = registerItem("endsteel_axe", new AxeItem(ModToolMaterials.ENDSTEEL,
            new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers((ModToolMaterials.ENDSTEEL),6.0F, -3.1F))));
    public static final Item ENDSTEEL_HOE = registerItem("endsteel_hoe", new HoeItem(ModToolMaterials.ENDSTEEL,
            new Item.Settings().maxCount(1).attributeModifiers(HoeItem.createAttributeModifiers((ModToolMaterials.ENDSTEEL),-2.0F, -1.0F))));


    public static final Item BACK_STABBER = registerItem("backstabber", (new BackstabberItem((new Item.Settings()).rarity(Rarity.EPIC).maxDamage(500).fireproof().component(DataComponentTypes.TOOL, BackstabberItem.createToolComponent()).attributeModifiers(BackstabberItem.createAttributeModifiers()))));
    public static final Item ENDSTEEL_INGOT = registerItem("endsteel_ingot", (new Item(new Item.Settings())));
    public static final Item ENDERSENT_SPAWN_EGG= registerItem("endersent_spawn_egg", (new SpawnEggItem(ModEntities.ENDERSENT,16777215,16777215, new Item.Settings())));
    public static final Item ENDLING_SPAWN_EGG= registerItem("endling_spawn_egg", (new SpawnEggItem(ModEntities.ENDLING,16777215,16777215, new Item.Settings())));

    public static final Item PURIFIED_VOID_AMULET = registerItem("purified_void_amulet", (new PurifiedAmuletItem(new Item.Settings().maxCount(1).fireproof())));
    public static final Item CORRUPTED_VOID_AMULET = registerItem("corrupted_void_amulet", (new CorruptedAmuletItem(new Item.Settings().maxCount(1).fireproof())));

    public static void register() {
        RogueEnd.LOGGER.debug("Registering blocks for " + RogueEnd.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RogueEnd.MOD_ID, name),
                item);
    }
}
