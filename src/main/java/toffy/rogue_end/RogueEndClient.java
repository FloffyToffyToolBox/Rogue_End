package toffy.rogue_end;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import toffy.rogue_end.entity.EndersentModel;
import toffy.rogue_end.entity.EndersentRenderer;
import toffy.rogue_end.init.ModBlockTags;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModEntities;
import toffy.rogue_end.init.ModItems;

public class RogueEndClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((content) -> {
			content.addAfter(Items.ENDER_EYE, ModItems.CORRUPTED_VOID_AMULET);
			content.addAfter(Items.NETHERITE_HOE, ModItems.ENDSTEEL_HOE);
			content.addAfter(Items.NETHERITE_HOE, ModItems.ENDSTEEL_AXE);
			content.addAfter(Items.NETHERITE_HOE, ModItems.ENDSTEEL_PICKAXE);
			content.addAfter(Items.NETHERITE_HOE, ModItems.ENDSTEEL_SHOVEL);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((content) -> {
			content.addAfter(Items.NETHERITE_SWORD, ModItems.ENDSTEEL_SWORD);
			content.addAfter(Items.NETHERITE_AXE, ModItems.ENDSTEEL_AXE);
			content.addAfter(Items.MACE, ModItems.BACK_STABBER);

			content.addAfter(Items.NETHERITE_BOOTS, ModItems.ENDSTEEL_BOOTS);
			content.addAfter(Items.NETHERITE_BOOTS, ModItems.ENDSTEEL_LEGGINGS);
			content.addAfter(Items.NETHERITE_BOOTS, ModItems.ENDSTEEL_CHESTPLATE);
			content.addAfter(Items.NETHERITE_BOOTS, ModItems.ENDSTEEL_HELMET);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register((content) -> {
			content.addAfter(Blocks.SCULK_SHRIEKER, Items.ENDER_EYE);
			content.addAfter(Blocks.SCULK_SHRIEKER, ModBlocks.ENDER_LINK);
			content.addAfter(Blocks.SCULK_SHRIEKER, ModBlocks.ENDER_PORTER);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((content) -> {
			content.addAfter(Items.NETHERITE_INGOT, ModItems.ENDSTEEL_INGOT);
		});

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_THORN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOUNCE_BLOOM, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.END_BUSH, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.END_SHRUB, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRY_END_SHRUB, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.END_GRASS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRY_END_GRASS, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_TUBES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDER_TUBES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHORT_ENDER_TUBES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_END_FERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.END_FERN, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOWROOT_LICHEN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAGMA_ROOTS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDER_LINK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDER_PORTER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORAL_BLOOM, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_LEAVES, RenderLayer.getCutout());
		EntityModelLayerRegistry.registerModelLayer(EndersentModel.LAYER_LOCATION, EndersentModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.ENDERSENT, EndersentRenderer::new);
	}
}