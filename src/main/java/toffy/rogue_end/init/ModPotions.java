package toffy.rogue_end.init;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

public class ModPotions {
    public static RegistryEntry<Potion> LEVITATION =
            registerPotion("levitation", new Potion( new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.LEVITATION, 150)})); //150?

    public static RegistryEntry<Potion> LONG_LEVITATION =
            registerPotion("long_levitation", new Potion("levitation", new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.LEVITATION, 500)}));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.ofVanilla(name), potion);
    }
    public static void register() {
        RogueEnd.LOGGER.debug("Registering potions for " + RogueEnd.MOD_ID);
    }
}
