package toffy.rogue_end.init;

import net.minecraft.component.ComponentType;
import net.minecraft.component.type.LodestoneTrackerComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.items.EnderEyeComponent;

import java.util.function.UnaryOperator;

public class ModComponentTypes {
    public static void register() {
        RogueEnd.LOGGER.debug("Registering components for " + RogueEnd.MOD_ID);
    }
    public static final ComponentType<EnderEyeComponent> ENDER_EYE  =
            Registry.register(
                    Registries.DATA_COMPONENT_TYPE,
                    Identifier.of(RogueEnd.MOD_ID,"ender_eye"),
                    ComponentType.<EnderEyeComponent>builder().codec(EnderEyeComponent.CODEC).build()
            );
}
