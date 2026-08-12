package toffy.rogue_end.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toffy.rogue_end.init.ModPotions;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
    @Inject(method = "registerDefaults", at = @At("Tail"))
    public static void registerDefaults(BrewingRecipeRegistry.Builder builder, CallbackInfo callbackInfo){
        builder.registerPotionRecipe(Potions.AWKWARD, Items.SHULKER_SHELL, ModPotions.LEVITATION);
        builder.registerPotionRecipe(ModPotions.LEVITATION, Items.REDSTONE, ModPotions.LONG_LEVITATION);
    }
}
