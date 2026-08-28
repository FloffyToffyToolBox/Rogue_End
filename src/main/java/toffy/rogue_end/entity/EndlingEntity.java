//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package toffy.rogue_end.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;

import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Function;

public class EndlingEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackingAnimationState = new AnimationState();
    public EndlingEntity(EntityType<? extends EndlingEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }
    public static DefaultAttributeContainer.Builder createEndersentAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,0.95).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25).add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40.0).add(EntityAttributes.GENERIC_ARMOR, 4.0);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, (double)0.5, true));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal(this, WardenEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, IronGolemEntity.class, true));
    }
    @Override
    protected void mobTick() {
        super.mobTick();
    }
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
    }
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
    }
    boolean teleportTo(Entity entity) {
        Vec3d vec3d = new Vec3d(this.getX() - entity.getX(), this.getBodyY(0.5) - entity.getEyeY(), this.getZ() - entity.getZ());
        vec3d = vec3d.normalize();
        double d = 16.0;
        double e = this.getX() + (this.random.nextDouble() - 0.5) * 8.0 - vec3d.x * 16.0;
        double f = this.getY() + (double)(this.random.nextInt(16) - 8) - vec3d.y * 16.0;
        double g = this.getZ() + (this.random.nextDouble() - 0.5) * 8.0 - vec3d.z * 16.0;
        return this.teleportTo(e, f, g);
    }
    private boolean teleportTo(double x, double y, double z) {
        BlockPos.Mutable mutable = new BlockPos.Mutable(x, y, z);

        while(mutable.getY() > this.getWorld().getBottomY() && !this.getWorld().getBlockState(mutable).blocksMovement()) {
            mutable.move(Direction.DOWN);
        }

        BlockState blockState = this.getWorld().getBlockState(mutable);
        boolean bl = blockState.blocksMovement();
        boolean bl2 = blockState.getFluidState().isIn(FluidTags.WATER);
        if (bl && !bl2) {
            Vec3d vec3d = this.getPos();
            boolean bl3 = this.teleport(x, y, z, true);
            if (bl3) {
                this.getWorld().emitGameEvent(GameEvent.TELEPORT, vec3d, Emitter.of(this));
                if (!this.isSilent()) {
                    this.getWorld().playSound((PlayerEntity)null, this.prevX, this.prevY, this.prevZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
                    this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            }

            return bl3;
        } else {
            return false;
        }
    }
    @Override
    public void swingHand(Hand hand, boolean fromServerPlayer) {
        if (!this.handSwinging || this.handSwingTicks >= 40 / 2 || this.handSwingTicks < 0) {
        this.handSwingTicks = -1;
        this.handSwinging = true;
        this.preferredHand = hand;
        if (this.getWorld() instanceof ServerWorld) {
            EntityAnimationS2CPacket entityAnimationS2CPacket = new EntityAnimationS2CPacket(this, hand == Hand.MAIN_HAND ? 0 : 3);
            ServerChunkManager serverChunkManager = ((ServerWorld)this.getWorld()).getChunkManager();
            if (fromServerPlayer) {
                serverChunkManager.sendToNearbyPlayers(this, entityAnimationS2CPacket);
            } else {
                serverChunkManager.sendToOtherNearbyPlayers(this, entityAnimationS2CPacket);
            }
        }
    }
    }
    @Override
    protected void tickHandSwing() {
        int i = 40;
        if (this.handSwinging) {
            ++this.handSwingTicks;
            if (this.handSwingTicks >= i) {
                this.handSwingTicks = 0;
                this.handSwinging = false;
            }
        } else {
            this.handSwingTicks = 0;
        }

        this.handSwingProgress = (float)this.handSwingTicks / (float)i;
    }
}