package toffy.rogue_end.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.entity.EndersentEntity;
import toffy.rogue_end.entity.EndlingEntity;

public class ModEntities {
    public static final EntityType<EndersentEntity> ENDERSENT = Registry.register(Registries.ENTITY_TYPE, Identifier.of(RogueEnd.MOD_ID,"endersent"),
            EntityType.Builder.create(EndersentEntity::new, SpawnGroup.MISC)
                    .dimensions(1.25f, 6).eyeHeight(5.75f).passengerAttachments(5.75f).vehicleAttachment(-0.125F).maxTrackingRange(8).build());
    public static final EntityType<EndlingEntity> ENDLING = Registry.register(Registries.ENTITY_TYPE, Identifier.of(RogueEnd.MOD_ID,"endling"),
            EntityType.Builder.create(EndlingEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.25f, 2.5f).eyeHeight(2.35f).passengerAttachments(2.5f).vehicleAttachment(-0.125F).maxTrackingRange(8).build());
    public static void registerModEntities() {
        RogueEnd.LOGGER.info("Registering Mod Entities for " + RogueEnd.MOD_ID);
    }
}
