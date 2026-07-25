package toffy.rogue_end.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.util.Identifier;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModEntities;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerItemModel(ModBlocks.CHORAL_BLOOM.asItem());

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHORUS_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_PLANKS);

        blockStateModelGenerator.registerAxisRotated(ModBlocks.CHORUS_LOG, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.STRIPPED_CHORUS_LOG, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);

        blockStateModelGenerator.registerAxisRotated(ModBlocks.ENDSTONE_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.CHISELLED_ENDSTONE_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        BlockStateModelGenerator.BlockTexturePool EndBonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.END_BONE);
        EndBonePool.wall(ModBlocks.END_BONE_WALL);
        EndBonePool.stairs(ModBlocks.END_BONE_STAIRS);
        EndBonePool.slab(ModBlocks.END_BONE_SLAB);

        BlockStateModelGenerator.BlockTexturePool SmoothEndstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_ENDSTONE);
        SmoothEndstonePool.wall(ModBlocks.SMOOTH_ENDSTONE_WALL);
        SmoothEndstonePool.stairs(ModBlocks.SMOOTH_ENDSTONE_STAIRS);
        SmoothEndstonePool.slab(ModBlocks.SMOOTH_ENDSTONE_SLAB);

        BlockStateModelGenerator.BlockTexturePool PurpurPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PURPUR_BLOCK);
        PurpurPool.wall(ModBlocks.PURPUR_WALL);

        BlockStateModelGenerator.BlockTexturePool DarkPurpur = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DARK_PURPUR_BRICKS);
        DarkPurpur.wall(ModBlocks.DARK_PURPUR_BRICK_WALL);
        DarkPurpur.stairs(ModBlocks.DARK_PURPUR_BRICK_STAIRS);
        DarkPurpur.slab(ModBlocks.DARK_PURPUR_BRICK_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }

}
