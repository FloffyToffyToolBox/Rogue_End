package toffy.rogue_end;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import toffy.rogue_end.entity.EndersentEntity;
import toffy.rogue_end.init.*;

public class RogueEnd implements ModInitializer {
	public static final String MOD_ID = "rogue_end";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.register();
		ModComponentTypes.register();
		ModBlocks.register();
		ModBlockTags.register();
		ModItemGroups.setup();
		ModEntities.registerModEntities();
		ModBlockEntities.register();
		ModEntityModelLayers.register();
		FabricDefaultAttributeRegistry.register(ModEntities.ENDERSENT, EndersentEntity.createEndersentAttributes());
		LOGGER.info("Hello Fabric world!");
	}
}