package toffy.rogue_end.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import toffy.rogue_end.init.ModBlockTags;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerPlanksRecipe(exporter,ModBlocks.CHORUS_PLANKS, ModItemTags.YELLOW_LOGS,4);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_PLANK_SLAB, ModBlocks.CHORUS_PLANKS);
        createStairsRecipe(ModBlocks.CHORUS_PLANK_STAIRS, Ingredient.ofItems(ModBlocks.CHORUS_PLANKS)).criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.CHORUS_TRAPDOOR, Ingredient.ofItems(ModBlocks.CHORUS_PLANKS)).criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS)).offerTo(exporter);
        createDoorRecipe(ModBlocks.CHORUS_DOOR, Ingredient.ofItems(ModBlocks.CHORUS_PLANKS)).criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS)).offerTo(exporter);
        createTransmutationRecipe(ModBlocks.CHORUS_BUTTON, Ingredient.ofItems(ModBlocks.CHORUS_PLANKS)).criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS)).offerTo(exporter);
        offerPressurePlateRecipe(exporter, ModBlocks.CHORUS_PRESSURE_PLATE, ModBlocks.CHORUS_PLANKS);

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRUPTED_PLANK_SLAB, ModBlocks.CORRUPTED_PLANKS);
        createStairsRecipe(ModBlocks.CORRUPTED_PLANK_STAIRS, Ingredient.ofItems(ModBlocks.CORRUPTED_PLANKS)).criterion(hasItem(ModBlocks.CORRUPTED_PLANKS), conditionsFromItem(ModBlocks.CORRUPTED_PLANKS)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.CORRUPTED_TRAPDOOR, Ingredient.ofItems(ModBlocks.CORRUPTED_PLANKS)).criterion(hasItem(ModBlocks.CORRUPTED_PLANKS), conditionsFromItem(ModBlocks.CORRUPTED_PLANKS)).offerTo(exporter);
        createDoorRecipe(ModBlocks.CORRUPTED_DOOR, Ingredient.ofItems(ModBlocks.CORRUPTED_PLANKS)).criterion(hasItem(ModBlocks.CORRUPTED_PLANKS), conditionsFromItem(ModBlocks.CORRUPTED_PLANKS)).offerTo(exporter);
        createTransmutationRecipe(ModBlocks.CORRUPTED_BUTTON, Ingredient.ofItems(ModBlocks.CORRUPTED_PLANKS)).criterion(hasItem(ModBlocks.CORRUPTED_PLANKS), conditionsFromItem(ModBlocks.CORRUPTED_PLANKS)).offerTo(exporter);
        offerPressurePlateRecipe(exporter, ModBlocks.CORRUPTED_PRESSURE_PLATE, ModBlocks.CORRUPTED_PLANKS);
    }
}
