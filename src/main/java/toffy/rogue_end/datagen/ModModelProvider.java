package toffy.rogue_end.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModEntities;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(ModBlocks.ENDSTONE_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);

        BlockStateModelGenerator.BlockTexturePool EndBonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.END_BONE);
        EndBonePool.wall(ModBlocks.END_BONE_WALL);
        EndBonePool.stairs(ModBlocks.END_BONE_STAIRS);
        EndBonePool.slab(ModBlocks.END_BONE_SLAB);

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
