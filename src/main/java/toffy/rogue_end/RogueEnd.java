package toffy.rogue_end;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.SurfaceRuleManager;
import toffy.rogue_end.entity.EndersentEntity;
import toffy.rogue_end.init.*;
import toffy.rogue_end.world.biome.ModSurfaceRules;
import toffy.rogue_end.world.biome.ModWorldGeneration;
import toffy.rogue_end.world.features.ModFeatures;
import toffy.rogue_end.world.features.ModTrunkPlacerType;

public class RogueEnd implements ModInitializer {
	public static final String MOD_ID = "rogue_end";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.register();
		ModPotions.register();
		ModComponentTypes.register();
		ModSoundEvents.register();
		ModBlocks.register();
		ModFeatures.register();
		ModBlockTags.register();
		ModItemGroups.setup();
		ModArmourMaterials.register();
		ModTrunkPlacerType.register();
		StrippableBlockRegistry.register(ModBlocks.CHORUS_LOG,ModBlocks.STRIPPED_CHORUS_LOG);
		ModEntities.registerModEntities();
		ModBlockEntities.register();
		ModEntityModelLayers.register();
		FabricDefaultAttributeRegistry.register(ModEntities.ENDERSENT, EndersentEntity.createEndersentAttributes());
		ModWorldGeneration.generateModWorldGen();
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END,	RogueEnd.MOD_ID, ModSurfaceRules.end());
		LOGGER.info("Hello Fabric world!");
	}
}