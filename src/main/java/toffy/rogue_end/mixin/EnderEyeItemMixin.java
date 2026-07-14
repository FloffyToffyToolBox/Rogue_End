package toffy.rogue_end.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LodestoneTrackerComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import toffy.rogue_end.blocks.EnderLinkBlock;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModComponentTypes;
import toffy.rogue_end.items.EnderEyeComponent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Mixin(EnderEyeItem.class)
public class EnderEyeItemMixin extends ItemMixin {
    @Inject(method = "useOnBlock", at = @At("RETURN"), cancellable = true)
    public void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
    BlockPos blockPos = context.getBlockPos();
    World world = context.getWorld();
    if (world.getBlockState(blockPos).isOf(ModBlocks.ENDER_LINK)) {
            if (!world.getBlockState(blockPos).get(EnderLinkBlock.EYE)&&!context.getStack().getComponents().contains(ModComponentTypes.ENDER_EYE)){
                world.playSound((PlayerEntity)null, blockPos, SoundEvents.ITEM_LODESTONE_COMPASS_LOCK, SoundCategory.PLAYERS, 1.0F, 1.0F);
                PlayerEntity playerEntity = context.getPlayer();
                ItemStack itemStack = context.getStack();
                boolean bl = !playerEntity.isInCreativeMode() && itemStack.getCount() == 1;
                EnderEyeComponent lodestoneTrackerComponent = new EnderEyeComponent(Optional.of(GlobalPos.create(world.getRegistryKey(), blockPos)), true);
                if (bl) {
                    itemStack.set(ModComponentTypes.ENDER_EYE, lodestoneTrackerComponent);
                } else {
                    ItemStack itemStack2 = itemStack.copyComponentsToNewStack(Items.ENDER_EYE, 1);
                    itemStack.decrementUnlessCreative(1, playerEntity);
                    itemStack2.set(ModComponentTypes.ENDER_EYE, lodestoneTrackerComponent);
                    if (!playerEntity.getInventory().insertStack(itemStack2)) {
                        playerEntity.dropItem(itemStack2, false);
                    }
                }
            cir.setReturnValue(ActionResult.success(world.isClient));
        }
    }
}
    @Override
    protected void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type, CallbackInfo ci) {
        EnderEyeComponent enderEyeComponent = (EnderEyeComponent)stack.get(ModComponentTypes.ENDER_EYE);
        if (enderEyeComponent!=null) {
                if (enderEyeComponent.target().isPresent()) {
                tooltip.add(Text.of(String.valueOf(enderEyeComponent.target().get().pos())));
                Objects.requireNonNull(tooltip);
            }
        }
    }
}
