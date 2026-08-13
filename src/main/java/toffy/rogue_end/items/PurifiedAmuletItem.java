package toffy.rogue_end.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.EndPlatformFeature;

public class PurifiedAmuletItem extends Item {
    public PurifiedAmuletItem(Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity player)    {
            if (!world.isClient){
                int i = this.getMaxUseTime(stack, player) - remainingUseTicks;
                if (i>20){
                    player.teleportTo(createTeleportTarget((ServerWorld) world, player));
                    player.getItemCooldownManager().set(this, 200);
                }
            }
        }
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }
    public TeleportTarget createTeleportTarget(ServerWorld world, Entity entity) {
        boolean inEnd = world.getRegistryKey() == World.END;
        ServerWorld serverWorld = world.getServer().getWorld(World.END);
        if (serverWorld == null) {
            return null;
        } else if (inEnd){
            BlockPos blockPos =  ServerWorld.END_SPAWN_POS;
            Vec3d vec3d = blockPos.toBottomCenterPos();
            float f = entity.getYaw();
                EndPlatformFeature.generate(serverWorld, BlockPos.ofFloored(vec3d).down(), true);
                f = Direction.WEST.asRotation();
                if (entity instanceof ServerPlayerEntity) {
                    vec3d = vec3d.subtract(0.0, 1.0, 0.0);
                }
            return new TeleportTarget(serverWorld, vec3d, entity.getVelocity(), f, entity.getPitch(), TeleportTarget.SEND_TRAVEL_THROUGH_PORTAL_PACKET.then(TeleportTarget.ADD_PORTAL_CHUNK_TICKET));
        }
        else    {
            return((ServerPlayerEntity)entity).getRespawnTarget(true, TeleportTarget.NO_OP);
        }
    }
}
