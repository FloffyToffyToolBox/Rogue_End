package toffy.rogue_end.mixin;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toffy.rogue_end.entity.EndlingEntity;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {
    @Inject(method = "mobTick", at = @At("HEAD"))
    private void mobTick(CallbackInfo ci) {
         EndermanEntity This = ((EndermanEntity) ((Object)this));
    if (This.isAngry()) {
        if (This.getVisibilityCache().canSee(This.getTarget())) {        double d = This.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
            Box box = Box.from(This.getPos()).expand(d, (double)16.0F, d);
            This.getWorld().getEntitiesByClass(EndlingEntity.class, box, EntityPredicates.EXCEPT_SPECTATOR).stream()
                    .filter((target) -> target != This).filter((target) -> target.getTarget() == null)
                    .filter((target) -> !target.isTeammate(This.getTarget())).forEach((target) -> target.setTarget(This.getTarget()));
            }
        }
    }
}
