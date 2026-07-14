package toffy.rogue_end.init;

import com.mojang.datafixers.types.Type;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.blocks.EnderLinkBlockEntity;
import toffy.rogue_end.blocks.RadiusEffectPillarBlockEntity;

public class ModBlockEntities {
    public static void register() {
        RogueEnd.LOGGER.debug("Registering block entities for " + RogueEnd.MOD_ID);
    }

    public static final BlockEntityType<RadiusEffectPillarBlockEntity> RADIUS_EFFECT_PILLAR = create("radius_effect_pillar",BlockEntityType.Builder.create(RadiusEffectPillarBlockEntity::new, ModBlocks.RADIUS_EFFECT_PILLAR_BLOCK));
    public static final BlockEntityType<EnderLinkBlockEntity> ENDER_LINK = create("ender_link",BlockEntityType.Builder.create(EnderLinkBlockEntity::new, ModBlocks.ENDER_LINK));

    private static <T extends BlockEntity> BlockEntityType create(String id, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, builder.build(type));
    }
}
