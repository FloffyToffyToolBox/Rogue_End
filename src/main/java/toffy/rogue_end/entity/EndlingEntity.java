//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package toffy.rogue_end.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import org.jetbrains.annotations.Nullable;
import toffy.rogue_end.init.ModSoundEvents;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;

public class EndlingEntity extends EndermanEntity implements Angerable {
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
        this.goalSelector.add(1, new EndlingAttack(this));
        this.goalSelector.add(2, new EndlingNavigateToTarget(this, (double).75f, true));
        this.goalSelector.add(3, new WanderAroundGoal(this,.75f));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[]{EndermanEntity.class,EndlingEntity.class})).setGroupRevenge(new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
        this.targetSelector.add(3, new UniversalAngerGoal<>(this, true));
    }


    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSoundEvents.ENTITY_ENDLING_HURT;
    }
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.ENTITY_ENDLING_DEATH;
    }
    @Override
    protected void mobTick() {
        super.mobTick();
    }

    public static class EndlingNavigateToTarget extends Goal {
        protected final EndlingEntity mob;
        private final double speed;
        private final boolean pauseWhenMobIdle;
        private Path path;
        private double targetX;
        private double targetY;
        private double targetZ;
        private int updateCountdownTicks;
        private int cooldown;
        private final int attackIntervalTicks = 20;
        private long lastUpdateTime;
        private static final long MAX_ATTACK_TIME = 20L;

        public EndlingNavigateToTarget(EndlingEntity mob, double speed, boolean pauseWhenMobIdle) {
            this.mob = mob;
            this.speed = speed;
            this.pauseWhenMobIdle = pauseWhenMobIdle;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            long l = this.mob.getWorld().getTime();
            if (l - this.lastUpdateTime < 20L) {
                return false;
            } else {
                this.lastUpdateTime = l;
                LivingEntity livingEntity = this.mob.getTarget();
                if (livingEntity == null) {
                    return false;
                } else if (!livingEntity.isAlive()) {
                    return false;
                } else {
                    this.path = this.mob.getNavigation().findPathTo(livingEntity, 0);
                    if (this.path != null) {
                        return true;
                    } else {
                        return this.mob.isInAttackRange(livingEntity);
                    }
                }
            }
        }

        public boolean shouldContinue() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            } else if (!livingEntity.isAlive()) {
                return false;
            } else if (!this.pauseWhenMobIdle) {
                return !this.mob.getNavigation().isIdle();
            } else if (!this.mob.isInWalkTargetRange(livingEntity.getBlockPos())) {
                return false;
            } else {
                return !(livingEntity instanceof PlayerEntity) || !livingEntity.isSpectator() && !((PlayerEntity)livingEntity).isCreative();
            }
        }

        public void start() {
            this.mob.getNavigation().startMovingAlong(this.path, this.speed);
            this.mob.idleAnimationState.start(mob.age);
            this.updateCountdownTicks = 0;
            this.cooldown = 0;
        }

        public void stop() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingEntity)) {
                this.mob.setTarget((LivingEntity)null);
            }
            this.mob.idleAnimationState.stop();
            this.mob.getNavigation().stop();
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity != null) {
                this.mob.getLookControl().lookAt(livingEntity, 30.0F, 30.0F);
                this.updateCountdownTicks = Math.max(this.updateCountdownTicks - 1, 0);
                if ((this.pauseWhenMobIdle || this.mob.getVisibilityCache().canSee(livingEntity)) && this.updateCountdownTicks <= 0 && (this.targetX == (double)0.0F && this.targetY == (double)0.0F && this.targetZ == (double)0.0F || livingEntity.squaredDistanceTo(this.targetX, this.targetY, this.targetZ) >= (double)1.0F || this.mob.getRandom().nextFloat() < 0.05F)) {
                    this.targetX = livingEntity.getX();
                    this.targetY = livingEntity.getY();
                    this.targetZ = livingEntity.getZ();
                    this.updateCountdownTicks = 4 + this.mob.getRandom().nextInt(7);
                    double d = this.mob.squaredDistanceTo(livingEntity);
                    if (d > (double)1024.0F) {
                        this.updateCountdownTicks += 10;
                    } else if (d > (double)256.0F) {
                        this.updateCountdownTicks += 5;
                    }

                    if (!this.mob.getNavigation().startMovingTo(livingEntity, this.speed)) {
                        this.updateCountdownTicks += 15;
                    }

                    this.updateCountdownTicks = this.getTickCount(this.updateCountdownTicks);
                }

                this.cooldown = Math.max(this.cooldown - 1, 0);
            }
        }
    }
    public static class EndlingAttack extends Goal {
        protected final EndlingEntity mob;
        private int progress;
        private long lastUpdateTime;
        private int updateCountdownTicks;
        private int cooldown;

        public EndlingAttack(EndlingEntity mob) {
            this.mob = mob;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            long l = this.mob.getWorld().getTime();
            if (l - this.lastUpdateTime < 10L) {
                return false;
            } else {
                this.lastUpdateTime = l;
                LivingEntity livingEntity = this.mob.getTarget();
                if (livingEntity == null) {
                    return false;
                } else if (!livingEntity.isAlive()) {
                    return false;
                } else {
                    return canAttack(livingEntity);
                }
            }
        }

        public boolean shouldContinue() {
            return (progress<=30);
        }

        public void start() {
            this.mob.setAttacking(true);
            this.mob.swingHand(this.mob.preferredHand);
            progress=0;
            this.cooldown = 0;
        }

        public void stop() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingEntity)) {
                this.mob.setTarget((LivingEntity)null);
            }
            this.mob.setAttacking(false);
            progress=0;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            if (mob.getTarget()!=null)this.mob.getLookControl().lookAt(mob.getTarget(), 30.0F, 30.0F);
            if (progress==5){
                this.attack(mob.getTarget());
            }
            progress++;
        }

        protected void attack(LivingEntity target) {
            if (this.canAttack(target)) {
                this.mob.tryAttack(target);
                this.mob.getWorld().playSound(this.mob,this.mob.getBlockPos(), ModSoundEvents.ENTITY_ENDLING_ATTACK, SoundCategory.HOSTILE,1,1);
            }
        }
        protected boolean canAttack(LivingEntity target) {
            return this.mob.isInAttackRange(target) && this.mob.getVisibilityCache().canSee(target);
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
}