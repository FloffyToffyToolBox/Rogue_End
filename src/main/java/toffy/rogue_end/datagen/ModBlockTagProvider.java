package toffy.rogue_end.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import toffy.rogue_end.init.ModBlockTags;
import toffy.rogue_end.init.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.END_BONE_WALL).add(ModBlocks.DARK_PURPUR_BRICKS).add(ModBlocks.DARK_PURPUR_BRICK_SLAB).add(ModBlocks.DARK_PURPUR_BRICK_STAIRS).add(ModBlocks.DARK_PURPUR_BRICK_WALL).add(ModBlocks.PURPUR_WALL);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.END_BONE).add(ModBlocks.END_BONE_WALL).add(ModBlocks.END_BONE_SLAB).add(ModBlocks.END_BONE_STAIRS)
                .add(ModBlocks.ENDSLATE)
                .add(ModBlocks.DARK_PURPUR)
                .add(ModBlocks.DARK_PURPUR_BRICKS).add(ModBlocks.DARK_PURPUR_BRICK_SLAB).add(ModBlocks.DARK_PURPUR_BRICK_STAIRS).add(ModBlocks.DARK_PURPUR_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.SMOOTH_ENDSTONE_SLAB).add(ModBlocks.END_BONE_SLAB).add(ModBlocks.DARK_PURPUR_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.SMOOTH_ENDSTONE_STAIRS).add(ModBlocks.END_BONE_STAIRS).add(ModBlocks.DARK_PURPUR_BRICK_STAIRS);

        getOrCreateTagBuilder(BlockTags.CLIMBABLE).add(ModBlocks.YELLOWROOT_LICHEN);

        getOrCreateTagBuilder(ModBlockTags.MAGMA_ROOT_PLACEABLE_ON).add(ModBlocks.DARK_PURPUR).add(ModBlocks.END_BONE).add(Blocks.END_STONE).add(Blocks.MAGMA_BLOCK).add(ModBlocks.END_MAGMA).add(ModBlocks.ENDSLATE).add(ModBlocks.ENDER_ASH).add(ModBlocks.LICHENROOT);
        getOrCreateTagBuilder(ModBlockTags.DRIES_SPONGE).add(ModBlocks.END_MAGMA).add(Blocks.MAGMA_BLOCK).add(Blocks.LAVA).add(Blocks.LAVA_CAULDRON);

        getOrCreateTagBuilder(BlockTags.LOGS).add(ModBlocks.CHORUS_LOG).add(ModBlocks.STRIPPED_CHORUS_LOG);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.CHORUS_BUTTON).add(ModBlocks.CORRUPTED_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.CHORUS_FENCE).add(ModBlocks.CORRUPTED_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.CHORUS_FENCEGATE).add(ModBlocks.CORRUPTED_FENCEGATE);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(ModBlocks.CHORUS_PRESSURE_PLATE).add(ModBlocks.CORRUPTED_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.CHORUS_PLANK_SLAB).add(ModBlocks.CORRUPTED_PLANK_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.CHORUS_PLANK_STAIRS).add(ModBlocks.CORRUPTED_PLANK_STAIRS);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.CHORUS_PLANKS).add(ModBlocks.CORRUPTED_PLANKS);
        getOrCreateTagBuilder(ModBlockTags.CHORUS_LOGS).add(ModBlocks.CHORUS_LOG).add(ModBlocks.STRIPPED_CHORUS_LOG);
        getOrCreateTagBuilder(ModBlockTags.CHORUS_PLANT_CAN_REPLACE).add(ModBlocks.END_GRASS).add(ModBlocks.DRY_END_GRASS).add(ModBlocks.DRY_END_SHRUB).add(ModBlocks.END_SHRUB).add(ModBlocks.END_BUSH);
    }
}
