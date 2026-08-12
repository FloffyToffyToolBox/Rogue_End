package toffy.rogue_end.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Environment(EnvType.CLIENT)
    @Inject(method = "renderArmor", at = @At("HEAD"))
    private static void renderArmor(DrawContext context, PlayerEntity player, int i, int j, int k, int x, CallbackInfo ci) {
        int armor = player.getArmor();
        if (armor > 20) {
            RenderSystem.enableBlend();
            int yLineArmor = i - (j) * k - 10;
            for(int n = 0; n < 10; ++n) {
                int o = x + n * 8;
                if ((n+10) * 2 + 1 < armor) {
                    context.drawGuiTexture(Identifier.ofVanilla("hud/armor_full"), o, yLineArmor, 9, 9);
                }

                if ((n+10) * 2 + 1 == armor) {
                    context.drawGuiTexture(Identifier.ofVanilla("hud/armor_half"), o, yLineArmor, 9, 9);
                }

                if ((n+10) * 2 + 1 > armor) {
                    context.drawGuiTexture(Identifier.ofVanilla("hud/armor_empty"), o, yLineArmor, 9, 9);
                }
            }
            RenderSystem.disableBlend();
        }
    }
}
