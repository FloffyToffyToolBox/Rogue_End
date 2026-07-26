package toffy.rogue_end.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

public class ModItemGroups {
    private static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(RogueEnd.MOD_ID, "fallfest_group"));

    public static void setup() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.tempGroup"))
                .icon(() -> new ItemStack(ModBlocks.ENDSLATE))
                .entries((displayContext, entries) -> {


                    entries.add(ModItems.BACK_STABBER);
                    entries.add(ModItems.ENDSTEEL_INGOT);
                    entries.add(ModItems.ENDERSENT_SPAWN_EGG);

                    entries.add(ModBlocks.ENDER_LINK);
                    entries.add(ModBlocks.ENDER_PORTER);
                    entries.add(ModBlocks.END_BULB);

                    entries.add(ModBlocks.STRIPPED_CHORUS_LOG);
                    entries.add(ModBlocks.CHORUS_LOG);

                    entries.add(ModBlocks.CHORUS_PLANKS);
                    entries.add(ModBlocks.CHORUS_FENCE);
                    entries.add(ModBlocks.CHORUS_FENCEGATE);
                    entries.add(ModBlocks.CHORUS_PLANK_SLAB);
                    entries.add(ModBlocks.CHORUS_PLANK_STAIRS);
                    entries.add(ModBlocks.CHORUS_BUTTON);
                    entries.add(ModBlocks.CHORUS_PRESSURE_PLATE);
                    entries.add(ModBlocks.CORRUPTED_PLANKS);
                    entries.add(ModBlocks.CORRUPTED_FENCE);
                    entries.add(ModBlocks.CORRUPTED_FENCEGATE);
                    entries.add(ModBlocks.CORRUPTED_PLANK_SLAB);
                    entries.add(ModBlocks.CORRUPTED_PLANK_STAIRS);
                    entries.add(ModBlocks.CORRUPTED_BUTTON);
                    entries.add(ModBlocks.CORRUPTED_PRESSURE_PLATE);

                    entries.add(ModBlocks.CHORUS_LEAVES);
                    entries.add(ModBlocks.YELLOW_LEAVES);
                    entries.add(ModBlocks.ENDER_ASH);
                    entries.add(ModBlocks.MAGMA_ROOTS);
                    entries.add(ModBlocks.END_MAGMA);


                    entries.add(ModBlocks.CORRUPTED_THORN);
                    entries.add(ModBlocks.END_BUSH);
                    entries.add(ModBlocks.END_SHRUB);
                    entries.add(ModBlocks.DRY_END_SHRUB);
                    entries.add(ModBlocks.END_GRASS);
                    entries.add(ModBlocks.DRY_END_GRASS);
                    entries.add(ModBlocks.CHORAL_BLOOM);

                    entries.add(ModBlocks.CORRUPTED_TUBES);
                    entries.add(ModBlocks.ENDER_TUBES);
                    entries.add(ModBlocks.SHORT_ENDER_TUBES);
                    entries.add(ModBlocks.TALL_END_FERN);
                    entries.add(ModBlocks.END_FERN);

                    entries.add(ModBlocks.ENDSLATE);
                    entries.add(ModBlocks.CHORAL_ENDSLATE);

                    entries.add(ModBlocks.DARK_PURPUR);
                    entries.add(ModBlocks.ENDSTONE_PILLAR);
                    entries.add(ModBlocks.CHISELLED_ENDSTONE_PILLAR);
                    entries.add(ModBlocks.SMOOTH_ENDSTONE);
                    entries.add(ModBlocks.SMOOTH_ENDSTONE_SLAB);
                    entries.add(ModBlocks.SMOOTH_ENDSTONE_STAIRS);
                    entries.add(ModBlocks.SMOOTH_ENDSTONE_WALL);
                    entries.add(ModBlocks.PURPUR_WALL);

                    entries.add(ModBlocks.END_BONE);
                    entries.add(ModBlocks.ENDSTEEL_ORE);
                    entries.add(ModBlocks.END_BONE_WALL);
                    entries.add(ModBlocks.END_BONE_SLAB);
                    entries.add(ModBlocks.END_BONE_STAIRS);

                    entries.add(ModBlocks.DARK_PURPUR_BRICKS);
                    entries.add(ModBlocks.DARK_PURPUR_BRICK_SLAB);
                    entries.add(ModBlocks.DARK_PURPUR_BRICK_WALL);
                    entries.add(ModBlocks.DARK_PURPUR_BRICK_STAIRS);

                    entries.add(ModBlocks.YELLOWROOT);
                    entries.add(ModBlocks.YELLOWROOT_LICHEN);
                    entries.add(ModBlocks.LICHENROOT);
                }).build());
    }
}
