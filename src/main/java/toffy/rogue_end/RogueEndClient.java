package toffy.rogue_end;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import toffy.rogue_end.entity.EndersentModel;
import toffy.rogue_end.entity.EndersentRenderer;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModEntities;

public class RogueEndClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
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