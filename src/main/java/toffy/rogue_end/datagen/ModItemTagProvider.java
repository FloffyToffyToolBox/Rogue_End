package toffy.rogue_end.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import toffy.rogue_end.init.ModBlockTags;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModItemTags;
import toffy.rogue_end.init.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.ENDSTEEL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.ENDSTEEL_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.ENDSTEEL_AXE);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.ENDSTEEL_SWORD);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.ENDSTEEL_HOE);


        getOrCreateTagBuilder(ModItemTags.CHORUS_LOGS).add(ModBlocks.CHORUS_LOG.asItem());
        getOrCreateTagBuilder(ModItemTags.YELLOW_LOGS).add(ModBlocks.YELLOW_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.CHORUS_PLANKS.asItem()).add(ModBlocks.CORRUPTED_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.ENDSTEEL_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ModItems.ENDSTEEL_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ModItems.ENDSTEEL_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ModItems.ENDSTEEL_BOOTS);
    }
}
