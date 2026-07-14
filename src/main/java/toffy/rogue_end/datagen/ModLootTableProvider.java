package toffy.rogue_end.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import toffy.rogue_end.init.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ENDER_ASH);
        addDrop(ModBlocks.MAGMA_ROOTS);
        addDrop(ModBlocks.END_MAGMA);
        addDrop(ModBlocks.ENDSLATE);
        addDrop(ModBlocks.DARK_PURPUR);
        addDrop(ModBlocks.PURPUR_WALL);
        addDrop(ModBlocks.ENDSTONE_PILLAR);
        addDrop(ModBlocks.CHORUS_LEAVES);

        addDrop(ModBlocks.LICHENROOT);

        addDropWithSilkTouch(ModBlocks.ENDSTEEL_ORE);

        addDrop(ModBlocks.END_BONE);
        addDrop(ModBlocks.END_BONE_WALL);
        addDrop(ModBlocks.END_BONE_SLAB);
        addDrop(ModBlocks.END_BONE_STAIRS);

        addDrop(ModBlocks.DARK_PURPUR_BRICKS);
        addDrop(ModBlocks.DARK_PURPUR_BRICK_WALL);
        addDrop(ModBlocks.DARK_PURPUR_BRICK_SLAB);
        addDrop(ModBlocks.DARK_PURPUR_BRICK_STAIRS);

        addDrop(ModBlocks.YELLOWROOT);
        addDrop(ModBlocks.YELLOWROOT_LICHEN);
    }
}
