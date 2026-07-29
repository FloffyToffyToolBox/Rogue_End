package toffy.rogue_end.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.RegistryWrapper;
import toffy.rogue_end.blocks.EnderPorterBlock;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModItemGroups;
import toffy.rogue_end.init.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.END_MIASMA);
        addDrop(ModBlocks.CORRUPTED_THORN);
        addDrop(ModBlocks.END_BUSH);
        addDrop(ModBlocks.END_SHRUB);
        addDrop(ModBlocks.DRY_END_SHRUB);
        addDrop(ModBlocks.END_GRASS);
        addDrop(ModBlocks.DRY_END_GRASS);
        addDrop(ModBlocks.CHORAL_BLOOM, (tallPlant(ModBlocks.CHORAL_BLOOM)));

        addDrop(ModBlocks.SHORT_ENDER_TUBES);
        addDrop(ModBlocks.END_FERN);

        addDrop(ModBlocks.ENDER_TUBES,ModBlocks.SHORT_ENDER_TUBES);
        addDrop(ModBlocks.TALL_END_FERN,ModBlocks.END_FERN);

        addDrop(ModBlocks.CORRUPTED_BUTTON);
        addDrop(ModBlocks.CORRUPTED_PRESSURE_PLATE);
        addDrop(ModBlocks.CORRUPTED_PLANKS);
        addDrop(ModBlocks.CORRUPTED_FENCE);
        addDrop(ModBlocks.CORRUPTED_FENCEGATE);
        addDrop(ModBlocks.CORRUPTED_PLANK_SLAB, (slabDrops(ModBlocks.CORRUPTED_PLANK_SLAB)));
        addDrop(ModBlocks.CORRUPTED_PLANK_STAIRS);

        addDrop(ModBlocks.MAGMA_ROOTS);

        addDrop(ModBlocks.CHORUS_BUTTON);
        addDrop(ModBlocks.CHORUS_PRESSURE_PLATE);
        addDrop(ModBlocks.CHORUS_PLANKS);
        addDrop(ModBlocks.CHORUS_FENCE);
        addDrop(ModBlocks.CHORUS_FENCEGATE);
        addDrop(ModBlocks.CHORUS_PLANK_SLAB, (slabDrops(ModBlocks.CHORUS_PLANK_SLAB)));
        addDrop(ModBlocks.CHORUS_PLANK_STAIRS);

        addDrop(ModBlocks.ENDSTONE_PILLAR);
        addDrop(ModBlocks.CHISELLED_ENDSTONE_PILLAR);
        addDrop(ModBlocks.SMOOTH_ENDSTONE);
        addDrop(ModBlocks.SMOOTH_ENDSTONE_WALL);
        addDrop(ModBlocks.SMOOTH_ENDSTONE_SLAB, (slabDrops(ModBlocks.SMOOTH_ENDSTONE_SLAB)));
        addDrop(ModBlocks.SMOOTH_ENDSTONE_STAIRS);

        addDrop(ModBlocks.ENDER_ASH);
        addDrop(ModBlocks.MAGMA_ROOTS);
        addDrop(ModBlocks.END_MAGMA);
        addDrop(ModBlocks.ENDSLATE);
        addDrop(ModBlocks.DARK_PURPUR);

        addDrop(ModBlocks.PURPUR_WALL);

        addDrop(ModBlocks.ENDSTONE_PILLAR);
        addDrop(ModBlocks.CHORUS_LEAVES);

        addDrop(ModBlocks.LICHENROOT);

        addDrop(ModBlocks.ENDSTEEL_ORE, oreDrops(ModBlocks.ENDSTEEL_ORE, ModItems.ENDSTEEL_INGOT));

        addDrop(ModBlocks.END_BONE);
        addDrop(ModBlocks.END_BONE_WALL);
        addDrop(ModBlocks.END_BONE_SLAB, (slabDrops(ModBlocks.END_BONE_SLAB)));
        addDrop(ModBlocks.END_BONE_STAIRS);

        addDrop(ModBlocks.ENDER_LINK,nameableContainerDrops(ModBlocks.ENDER_LINK));
        addDrop(ModBlocks.ENDER_PORTER,nameableContainerDrops(ModBlocks.ENDER_PORTER));

        addDrop(ModBlocks.DARK_PURPUR_BRICKS);
        addDrop(ModBlocks.DARK_PURPUR_BRICK_WALL);
        addDrop(ModBlocks.DARK_PURPUR_BRICK_SLAB, (slabDrops(ModBlocks.DARK_PURPUR_BRICK_SLAB)));
        addDrop(ModBlocks.DARK_PURPUR_BRICK_STAIRS);

        addDrop(ModBlocks.ENDSLATE);
        addDrop(ModBlocks.CHORAL_ENDSLATE);
        addDrop(ModBlocks.YELLOWROOT);
        addDrop(ModBlocks.YELLOWROOT_LICHEN);
    }
    public LootTable.Builder tallPlant(Block block) {
        return this.dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER);
    }
}
