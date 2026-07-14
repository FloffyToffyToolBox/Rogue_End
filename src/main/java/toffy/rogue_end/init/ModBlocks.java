package toffy.rogue_end.init;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.blocks.EnderLinkBlock;
import toffy.rogue_end.blocks.MagmaRootBlock;
import toffy.rogue_end.blocks.RadiusEffectPillarBlock;
import toffy.rogue_end.blocks.YellowLichenBlock;

public class ModBlocks {
    public static final Block RADIUS_EFFECT_PILLAR_BLOCK = registerBlock("radius_effect_pillar", new RadiusEffectPillarBlock(AbstractBlock.Settings.copy(Blocks.BEACON)));
    public static final Block ENDER_LINK = registerBlock("ender_link", new EnderLinkBlock(AbstractBlock.Settings.copy(Blocks.REPEATER)));
    public static final Block END_BULB = registerBlock("end_bulb",new BulbBlock(AbstractBlock.Settings.copy(Blocks.COPPER_BULB)));

    public static final Block ENDER_ASH = registerBlock("ender_ash",new ColoredFallingBlock(new ColorCode(-8356741),AbstractBlock.Settings.copy(Blocks.GRAVEL)));
    public static final Block MAGMA_ROOTS = registerBlock("magma_roots",new MagmaRootBlock(AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS)));
    public static final Block END_MAGMA = registerBlock("end_magma",new MagmaBlock(AbstractBlock.Settings.copy(Blocks.MAGMA_BLOCK).postProcess(Blocks::always).emissiveLighting(Blocks::always)));

    public static final Block ENDSLATE = registerBlock("endslate",new PillarBlock(AbstractBlock.Settings.copy(Blocks.TUFF)));
    public static final Block DARK_PURPUR = registerBlock("dark_purpur",new PillarBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)));

    public static final Block PURPUR_WALL= registerBlock("purpur_wall",new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF_WALL)));

    public static final Block ENDSTONE_PILLAR= registerBlock("endstone_pillar",new PillarBlock(AbstractBlock.Settings.copy(Blocks.TUFF)));

    public static final Block CHORUS_LEAVES = registerBlock("chorus_leaves",new LeavesBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)));
    public static final Block LICHENROOT = registerBlock("lichenroot",new Block(AbstractBlock.Settings.copy(Blocks.END_STONE)));

    public static final Block END_BONE = registerBlock("end_bone",new Block(AbstractBlock.Settings.copy(Blocks.TUFF)));
    public static final Block ENDSTEEL_ORE = registerBlock("endsteel_ore",new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));
    public static final Block END_BONE_WALL= registerBlock("end_bone_wall",new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF_WALL)));
    public static final Block END_BONE_SLAB = registerBlock("end_bone_slab",new SlabBlock(AbstractBlock.Settings.copy(Blocks.TUFF)));
    public static final Block END_BONE_STAIRS = registerBlock("end_bone_stairs",new StairsBlock(END_BONE.getDefaultState(),AbstractBlock.Settings.copy(Blocks.TUFF)));

    public static final Block DARK_PURPUR_BRICKS = registerBlock("dark_purpur_bricks",new Block(AbstractBlock.Settings.copy(Blocks.TUFF)));
    public static final Block DARK_PURPUR_BRICK_WALL= registerBlock("dark_purpur_brick_wall",new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF)));
    public static final Block DARK_PURPUR_BRICK_SLAB = registerBlock("dark_purpur_brick_slab",new SlabBlock(AbstractBlock.Settings.copy(Blocks.TUFF)));
    public static final Block DARK_PURPUR_BRICK_STAIRS = registerBlock("dark_purpur_brick_stairs",new StairsBlock(END_BONE.getDefaultState(),AbstractBlock.Settings.copy(Blocks.TUFF)));

    public static final Block YELLOWROOT = registerBlock("yellowroot",new Block(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK)));
    public static final Block YELLOWROOT_LICHEN = registerBlock("yellowroot_lichen",new YellowLichenBlock(AbstractBlock.Settings.copy(Blocks.VINE)));
    public static void register() {

        RogueEnd.LOGGER.debug("Registering blocks for " + RogueEnd.MOD_ID);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(RogueEnd.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static Block registerBlock(String id, net.minecraft.block.Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RogueEnd.MOD_ID, id), block);
    }
    public static Block registerHeadBlock(String id, net.minecraft.block.Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(RogueEnd.MOD_ID, id), block);
    }
}
