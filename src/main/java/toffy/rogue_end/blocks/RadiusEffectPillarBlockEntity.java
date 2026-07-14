package toffy.rogue_end.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.tick.Tick;
import toffy.rogue_end.init.ModBlockEntities;

import java.util.List;

public class RadiusEffectPillarBlockEntity extends BlockEntity {
    public RadiusEffectPillarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RADIUS_EFFECT_PILLAR, pos, state);
    }
    public RadiusEffectPillarBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, RadiusEffectPillarBlockEntity blockEntity) {
        applyEffectToEntities(world, pos);
    }

    private static void applyEffectToEntities(World world, BlockPos pos) {
        List<LivingEntity> entities = world.getNonSpectatingEntities(LivingEntity.class, (new Box((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)pos.getX(), (double)(pos.getY() - 4), (double)pos.getZ())).expand(10.0, 5.0, 10.0));
        entities.stream().filter((entity) -> {
            return true;
        }).forEach(RadiusEffectPillarBlockEntity::applyEffectToEntity);
    }
    private static void applyEffectToEntity(LivingEntity entity) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 60, 0,true, false, false));
    }
}
