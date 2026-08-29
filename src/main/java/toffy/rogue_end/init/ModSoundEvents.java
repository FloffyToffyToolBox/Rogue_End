package toffy.rogue_end.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

public class ModSoundEvents {
    public static final SoundEvent BOUNCE_BLOOM_JUMP = registerSound("bounce_bloom_jump");
    public static final SoundEvent BOUNCE_BLOOM_LAND = registerSound("bounce_bloom_land");
    public static final SoundEvent ENTITY_ENDERSENT_ATTACK = registerSound("entity:endersent.attack");
    public static final SoundEvent ENTITY_ENDERSENT_ATTACK_ALT = registerSound("entity:endersent.attack_alt");
    public static final SoundEvent ENTITY_ENDERSENT_DEADLY_ESCAPE = registerSound("entity:endersent.deadly_escape");
    public static final SoundEvent ENTITY_ENDERSENT_DEATH = registerSound("entity:endersent.death");
    public static final SoundEvent ENTITY_ENDERSENT_HURT = registerSound("entity:endersent.hurt");
    public static final SoundEvent ENTITY_ENDERSENT_IDLE_SMASH = registerSound("entity:endersent.idle_smash");
    public static final SoundEvent ENTITY_ENDERSENT_IDLE_VOCAL = registerSound("entity:endersent.idle_vocal");
    public static final SoundEvent ENTITY_ENDERSENT_STEP = registerSound("entity:endersent.step");
    public static final SoundEvent ENTITY_ENDERSENT_TELEPORT_SMASH = registerSound("entity:endersent.teleport_smash");

    public static final BlockSoundGroup BOUNCE_BLOOM_SOUNDS = new BlockSoundGroup(1f,1f, SoundEvents.BLOCK_FROGLIGHT_BREAK,SoundEvents.BLOCK_FROGLIGHT_STEP,SoundEvents.BLOCK_FROGLIGHT_PLACE,SoundEvents.BLOCK_FROGLIGHT_HIT, BOUNCE_BLOOM_LAND);
    public static void register() {

        RogueEnd.LOGGER.debug("Registering soundEvents for " + RogueEnd.MOD_ID);
    }
    private static SoundEvent registerSound(String name) {
        Identifier id = Identifier.of(RogueEnd.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
