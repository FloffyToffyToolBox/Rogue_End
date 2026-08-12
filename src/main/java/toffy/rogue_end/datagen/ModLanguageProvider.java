package toffy.rogue_end.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.registry.RegistryWrapper;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModItemGroups;
import toffy.rogue_end.init.ModItems;
import toffy.rogue_end.init.ModSoundEvents;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {

    public ModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput,"en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add("sounds.rogue_end.bounce_bloom_jump","Player jumps on Bounce Bloom");
        translationBuilder.add("sounds.rogue_end.bounce_bloom_land","Player lands on Bounce Bloom");

        translationBuilder.add(ModItems.ENDSTEEL_SWORD,"Endsteel Sword");
        translationBuilder.add(ModItems.ENDSTEEL_PICKAXE,"Endsteel Pickaxe");
        translationBuilder.add(ModItems.ENDSTEEL_AXE,"Endsteel Axe");
        translationBuilder.add(ModItems.ENDSTEEL_HOE,"Endsteel Hoe");
        translationBuilder.add(ModItems.ENDSTEEL_SHOVEL,"Endsteel Shovel");

        translationBuilder.add(ModItems.ENDSTEEL_HELMET,"Endsteel Helmet");
        translationBuilder.add(ModItems.ENDSTEEL_CHESTPLATE,"Endsteel Chestplate");
        translationBuilder.add(ModItems.ENDSTEEL_LEGGINGS,"Endsteel Leggings");
        translationBuilder.add(ModItems.ENDSTEEL_BOOTS,"Endsteel Boots");

        translationBuilder.add(ModItems.BACK_STABBER,"Back Stabber");
        translationBuilder.add("tooltip.rogue_end.backstabber.tooltip","+Backstab Damage");
        translationBuilder.add(ModItems.CORRUPTED_VOID_AMULET,"Corrupted Void Amulet");
        translationBuilder.add(ModItems.ENDERSENT_SPAWN_EGG,"Endersent Spawn Egg");
        translationBuilder.add(ModItems.ENDSTEEL_INGOT,"Endsteel Ingot");
        translationBuilder.add(ModItems.PURIFIED_VOID_AMULET,"Purified Void Amulet");

        translationBuilder.add(ModBlocks.CHORUS_LEAVES,"Chorus Leaves");
        translationBuilder.add(ModBlocks.CHORUS_PLANKS,"Chorus Planks");
        translationBuilder.add(ModBlocks.CHORUS_PLANK_STAIRS,"Chorus Stairs");
        translationBuilder.add(ModBlocks.CHORUS_BUTTON,"Chorus Button");
        translationBuilder.add(ModBlocks.CHORUS_FENCE,"Chorus Fence");
        translationBuilder.add(ModBlocks.CHORUS_FENCEGATE,"Chorus FenceGate");
        translationBuilder.add(ModBlocks.CHORUS_LOG,"Chorus Log");
        translationBuilder.add(ModBlocks.CHORUS_PRESSURE_PLATE,"Chorus Pressure Plate");
        translationBuilder.add(ModBlocks.STRIPPED_CHORUS_LOG,"Stripped Chorus Log");

        translationBuilder.add(ModBlocks.YELLOW_LEAVES,"Yellow Leaves");
        translationBuilder.add(ModBlocks.ENDER_ASH,"Ender Ash");

        translationBuilder.add(ModBlocks.MAGMA_ROOTS,"Magma Roots");
        translationBuilder.add(ModBlocks.END_MAGMA,"End Magma");
        translationBuilder.add(ModBlocks.END_MIASMA,"End Miasma");

        translationBuilder.add(ModBlocks.BOUNCE_BLOOM,"Bounce Bloom");
        translationBuilder.add(ModBlocks.CORRUPTED_THORN,"Corrupted Thorn");

        translationBuilder.add(ModBlocks.CHORAL_BLOOM,"Choral Bloom");
        translationBuilder.add(ModBlocks.CORRUPTED_TUBES,"Corrupted Tubes");

        translationBuilder.add(ModBlocks.TALL_END_FERN,"Tall End Fern");

        translationBuilder.add(ModBlocks.ENDSLATE,"Endslate");
        translationBuilder.add(ModBlocks.CHORAL_ENDSLATE,"Choral Endslate");
        translationBuilder.add(ModBlocks.DARK_PURPUR,"Dark Purpur");

        translationBuilder.add(ModBlocks.ENDSTONE_PILLAR,"Endstone Pillar");

        translationBuilder.add(ModBlocks.CHISELLED_ENDSTONE_PILLAR,"Chiselled Endstone Pillar");

        translationBuilder.add(ModBlocks.SMOOTH_ENDSTONE,"Smooth Endstone");
        translationBuilder.add(ModBlocks.SMOOTH_ENDSTONE_SLAB,"Smooth Endstone Slab");
        translationBuilder.add(ModBlocks.SMOOTH_ENDSTONE_STAIRS,"Smooth Endstone Stairs");
        translationBuilder.add(ModBlocks.SMOOTH_ENDSTONE_WALL,"Smooth Endstone Wall");

        translationBuilder.add(ModBlocks.PURPUR_WALL,"Purpur Wall");

        translationBuilder.add(ModBlocks.END_BONE,"Endbone");
        translationBuilder.add(ModBlocks.ENDSTEEL_ORE,"Endsteel Ore");
        translationBuilder.add(ModBlocks.END_BONE_STAIRS,"Endbone Stairs");
        translationBuilder.add(ModBlocks.END_BONE_SLAB,"Endbone Slab");
        translationBuilder.add(ModBlocks.END_BONE_WALL,"Endbone Wall");

        translationBuilder.add(ModBlocks.YELLOWROOT,"Yellowroot");
        translationBuilder.add(ModBlocks.YELLOWROOT_LICHEN,"Yellowroot Lichen");
        translationBuilder.add(ModBlocks.LICHENROOT,"Lichenroot");

        translationBuilder.add(ModBlocks.DARK_PURPUR_BRICKS,"Dark Purpur Bricks");
        translationBuilder.add(ModBlocks.DARK_PURPUR_BRICK_SLAB,"Dark Purpur Brick Slab");
        translationBuilder.add(ModBlocks.DARK_PURPUR_BRICK_STAIRS,"Dark Purpur Brick Stairs");
        translationBuilder.add(ModBlocks.DARK_PURPUR_BRICK_WALL,"Dark Purpur Brick Walls");

        translationBuilder.add(ModBlocks.CORRUPTED_PLANKS,"Corrupted Planks");
        translationBuilder.add(ModBlocks.CORRUPTED_PLANK_STAIRS,"Corrupted Stairs");
        translationBuilder.add(ModBlocks.CORRUPTED_BUTTON,"Corrupted Button");
        translationBuilder.add(ModBlocks.CORRUPTED_FENCE,"Corrupted Fence");
        translationBuilder.add(ModBlocks.CORRUPTED_FENCEGATE,"Corrupted Fence Gate");
        translationBuilder.add(ModBlocks.CORRUPTED_PRESSURE_PLATE,"Corrupted Pressure Plate");

        translationBuilder.add(ModBlocks.ENDER_LINK,"Ender Link");
        translationBuilder.add(ModBlocks.ENDER_PORTER,"Ender Porter");

        translationBuilder.add(ModBlocks.END_GRASS,"End Grass");
        translationBuilder.add(ModBlocks.ENDER_TUBES,"Ender Tubes");
        translationBuilder.add(ModBlocks.END_BULB,"End Bulb");
        translationBuilder.add(ModBlocks.END_BUSH,"End Bush");
        translationBuilder.add(ModBlocks.END_FERN,"End Fern");
        translationBuilder.add(ModBlocks.END_SHRUB,"End Shrub");
        translationBuilder.add(ModBlocks.DRY_END_GRASS,"Dry End Grass");
        translationBuilder.add(ModBlocks.DRY_END_SHRUB,"Dry End Shrub");
        translationBuilder.add(ModBlocks.SHORT_ENDER_TUBES,"End Shrub");
    }
}
