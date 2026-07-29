package toffy.rogue_end.init;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.blocks.*;

public class ModBlocks {

    public static final Block END_MIASMA = registerMiasmaBlock("end_miasma",new Block(AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL)));
    public static Block CORRUPTED_THORN = registerBlock("corrupted_thorn", new EndPlantBlock(AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static Block END_BUSH = registerBlock("end_bush", new EndPlantBlock(AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static Block END_SHRUB = registerBlock("end_shrub", new EndPlantBlock(AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static Block DRY_END_SHRUB = registerBlock("dry_end_shrub", new EndPlantBlock(AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static Block END_GRASS = registerBlock("end_grass", new EndPlantBlock(AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static Block DRY_END_GRASS = registerBlock("dry_end_grass", new EndPlantBlock(AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static Block CHORAL_BLOOM = registerBlock("choral_bloom",new ChoralBloomBlock(AbstractBlock.Settings.copy(Blocks.PITCHER_PLANT).luminance((state) -> {
        return 3;
    })));
    public static Block CORRUPTED_TUBES = registerBlock("corrupted_tubes",new TallEndPlantBlock(AbstractBlock.Settings.copy(Blocks.LARGE_FERN).luminance((state) -> {
        return 5;
    })));
    //add Corrupted Tubes

    public static Block ENDER_TUBES = registerBlock("ender_tubes",new TallEndPlantBlock(AbstractBlock.Settings.copy(Blocks.LARGE_FERN).luminance((state) -> {
        return 6;
    })));
    public static Block SHORT_ENDER_TUBES = registerBlock("short_ender_tubes",new ShortEndPlantBlock(AbstractBlock.Settings.copy(Blocks.FERN).luminance((state) -> {
        return 4;
    })));

    public static Block TALL_END_FERN = registerBlock("tall_end_fern",new TallEndPlantBlock(AbstractBlock.Settings.copy(Blocks.LARGE_FERN)));
    public static Block END_FERN = registerBlock("end_fern",new ShortEndPlantBlock(AbstractBlock.Settings.copy(Blocks.FERN)));

    public static final Block  CORRUPTED_BUTTON = registerBlock("corrupted_button",new ButtonBlock(ModWoodType.CORRUPTED.setType(),30, AbstractBlock.Settings.copy(Blocks.CHERRY_BUTTON).mapColor(MapColor.OAK_TAN)));
    public static final Block  CORRUPTED_PRESSURE_PLATE = registerBlock("corrupted_pressure_plate",new PressurePlateBlock(ModWoodType.CORRUPTED.setType(), AbstractBlock.Settings.copy(Blocks.CHERRY_BUTTON).mapColor(MapColor.OAK_TAN)));
    public static Block CORRUPTED_PLANKS = registerBlock("corrupted_planks",new PillarBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block  CORRUPTED_FENCE = registerBlock("corrupted_fence",new FenceBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE).mapColor(MapColor.OAK_TAN)));
    public static final Block  CORRUPTED_FENCEGATE = registerBlock("corrupted_fence_gate",new FenceGateBlock(ModWoodType.CORRUPTED, Block.Settings.copy(Blocks.CHERRY_FENCE_GATE).mapColor(MapColor.OAK_TAN)));
    public static final Block  CORRUPTED_PLANK_SLAB = registerBlock("corrupted_plank_slab",new SlabBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).mapColor(MapColor.OAK_TAN)));
    public static final Block  CORRUPTED_PLANK_STAIRS = registerBlock("corrupted_plank_stairs",new StairsBlock( CORRUPTED_PLANKS.getDefaultState(),AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).mapColor(MapColor.OAK_TAN)));

    public static final Block CHORUS_BUTTON = registerBlock("chorus_button",new ButtonBlock(ModWoodType.CHORUS.setType(),30, AbstractBlock.Settings.copy(Blocks.CHERRY_BUTTON).mapColor(MapColor.OAK_TAN)));
    public static final Block CHORUS_PRESSURE_PLATE = registerBlock("chorus_pressure_plate",new PressurePlateBlock(ModWoodType.CHORUS.setType(), AbstractBlock.Settings.copy(Blocks.CHERRY_BUTTON).mapColor(MapColor.OAK_TAN)));
    public static Block CHORUS_PLANKS = registerBlock("chorus_planks",new PillarBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CHORUS_FENCE = registerBlock("chorus_fence",new FenceBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE).mapColor(MapColor.OAK_TAN)));
    public static final Block CHORUS_FENCEGATE = registerBlock("chorus_fence_gate",new FenceGateBlock(ModWoodType.CHORUS, Block.Settings.copy(Blocks.CHERRY_FENCE_GATE).mapColor(MapColor.OAK_TAN)));
    public static final Block CHORUS_PLANK_SLAB = registerBlock("chorus_plank_slab",new SlabBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).mapColor(MapColor.OAK_TAN)));
    public static final Block CHORUS_PLANK_STAIRS = registerBlock("chorus_plank_stairs",new StairsBlock(CHORUS_PLANKS.getDefaultState(),AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).mapColor(MapColor.OAK_TAN)));


    public static Block CHORUS_LOG = registerBlock("chorus_log",new PillarBlock(AbstractBlock.Settings.copy(Blocks.WARPED_STEM)));
    public static Block STRIPPED_CHORUS_LOG = registerBlock("stripped_chorus_log",new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_WARPED_STEM)));

    public static final Block RADIUS_EFFECT_PILLAR_BLOCK = registerBlock("radius_effect_pillar", new RadiusEffectPillarBlock(AbstractBlock.Settings.copy(Blocks.BEACON)));
    public static final Block ENDER_LINK = registerBlock("ender_link", new EnderLinkBlock(AbstractBlock.Settings.copy(Blocks.REPEATER)));
    public static final Block ENDER_PORTER = registerBlock("ender_porter", new EnderPorterBlock(AbstractBlock.Settings.copy(Blocks.REPEATER)));
    public static final Block END_BULB = registerBlock("end_bulb",new BulbBlock(AbstractBlock.Settings.copy(Blocks.COPPER_BULB)));

    public static final Block ENDER_ASH = registerBlock("ender_ash",new ColoredFallingBlock(new ColorCode(-8356741),AbstractBlock.Settings.copy(Blocks.GRAVEL)));
    public static final Block MAGMA_ROOTS = registerBlock("magma_roots",new EndPlantBlock(AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).luminance((state) -> {
        return 2;
    })));
    public static final Block END_MAGMA = registerBlock("end_magma",new MagmaBlock(AbstractBlock.Settings.copy(Blocks.MAGMA_BLOCK).postProcess(Blocks::always).emissiveLighting(Blocks::always)));

    public static final Block ENDSLATE = registerBlock("endslate",new PillarBlock(AbstractBlock.Settings.copy(Blocks.TUFF)));

    public static final Block CHORAL_ENDSLATE = registerBlock("choral_endslate",new Block(AbstractBlock.Settings.copy(Blocks.TUFF)));
    public static final Block DARK_PURPUR = registerBlock("dark_purpur",new PillarBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)));

    public static final Block PURPUR_WALL= registerBlock("purpur_wall",new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF_WALL)));

    public static final Block ENDSTONE_PILLAR= registerBlock("endstone_pillar",new PillarBlock(AbstractBlock.Settings.copy(Blocks.END_STONE)));
    public static final Block CHISELLED_ENDSTONE_PILLAR= registerBlock("chiselled_endstone_pillar",new PillarBlock(AbstractBlock.Settings.copy(Blocks.END_STONE)));
    public static final Block SMOOTH_ENDSTONE= registerBlock("smooth_endstone",new Block(AbstractBlock.Settings.copy(Blocks.END_STONE)));
    public static final Block SMOOTH_ENDSTONE_WALL= registerBlock("smooth_endstone_wall",new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF_WALL)));
    public static final Block SMOOTH_ENDSTONE_SLAB = registerBlock("smooth_endstone_slab",new SlabBlock(AbstractBlock.Settings.copy(Blocks.TUFF)));
    public static final Block SMOOTH_ENDSTONE_STAIRS = registerBlock("smooth_endstone_stairs",new StairsBlock(SMOOTH_ENDSTONE.getDefaultState(),AbstractBlock.Settings.copy(Blocks.TUFF)));

    public static final Block CHORUS_LEAVES = registerBlock("chorus_leaves",new LeavesBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)));
    public static final Block YELLOW_LEAVES = registerBlock("yellow_leaves",new LeavesBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)));
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
    private static Item registerMiasmaBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(RogueEnd.MOD_ID, name),
                new MiasmaBlockItem(block, new Item.Settings()));
    }
    public static Block registerMiasmaBlock(String id, net.minecraft.block.Block block) {
        registerMiasmaBlockItem(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RogueEnd.MOD_ID, id), block);
    }
    public static Block registerHeadBlock(String id, net.minecraft.block.Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(RogueEnd.MOD_ID, id), block);
    }
}
