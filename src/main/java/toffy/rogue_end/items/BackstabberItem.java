package toffy.rogue_end.items;

import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.joml.Vector3f;

import java.util.List;
import java.util.Objects;

public class BackstabberItem extends Item {
    private static final int ATTACK_DAMAGE_MODIFIER_VALUE = 3;
    private static final float ATTACK_SPEED_MODIFIER_VALUE = 1.4F;
    public static final float MINING_SPEED_MULTIPLIER = 1.5F;
    private static final float field_50141 = 5.0F;
    public static final float KNOCKBACK_RANGE = 3.5F;
    private static final float KNOCKBACK_POWER = 0.7F;

    public BackstabberItem(Settings settings) {
        super(settings);
    }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 3.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, 0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
    }


    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 1.0F, 2);
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public int getEnchantability() {
        return 15;
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        for(int i=15; i>0;  i--) {
            target.getWorld().addParticle(ParticleTypes.WAX_OFF, (double) target.getBlockPos().getX() + attacker.getWorld().random.nextDouble(), (double) (target.getBlockPos().getY()) + target.getWorld().random.nextDouble(), (double) target.getBlockPos().getZ() + attacker.getWorld().random.nextDouble(),
                    0, 0.0, 0.0);
        }
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.BREEZE_ROD);
    }

    public boolean ShouldBackStab(Entity target, Entity attacker) {
        Vector3f bodyDir = new Vector3f((float) Math.cos(target.getBodyYaw()), (float) 0,(float)Math.sin(target.getBodyYaw())).normalize();
        Vector3f headDir = target.getHorizontalFacing().getUnitVector().normalize();
        Vector3f avgDir = new Vector3f(bodyDir.x+headDir.x,bodyDir.y+headDir.y,bodyDir.z+headDir.z);
        return (avgDir.normalize().dot(Objects.requireNonNull(attacker).getHorizontalFacing().getUnitVector().normalize())>0.25);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.fallfest.hoglin_dagger.tooltip").withColor(43520));
        super.appendTooltip(stack, context, tooltip, type);
    }

    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        return ShouldBackStab(target, damageSource.getAttacker())? 10000 : 0;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int var6 = this.getMaxUseTime(stack, user) - remainingUseTicks;
        if (var6 >= 10) {
            user.swingHand(user.getActiveHand());
        }
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    private HitResult getHitResult(PlayerEntity user) {
        return ProjectileUtil.getCollision(user, (entity) -> {
            return !entity.isSpectator() && entity.canHit();
        }, user.getBlockInteractionRange());
    }
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }
}
