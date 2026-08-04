package toffy.rogue_end.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModSoundEvents;

@Mixin({PlayerEntity.class})
public  class PlayerMixin {
    public PlayerMixin(){
    }
    @Inject(
            method = {"jump"},
            at = {@At("TAIL")}
    )
    public void jump(CallbackInfo callbackInfo){
        PlayerEntity player = (PlayerEntity)(Object)this;
        if(player.getWorld().getBlockState(player.supportingBlockPos.get()).isOf(ModBlocks.BOUNCE_BLOOM)){
            player.playSound(ModSoundEvents.BOUNCE_BLOOM_JUMP);
            player.getWorld().emitGameEvent(player, GameEvent.RESONATE_2, player.getPos());
        }
    }
}
