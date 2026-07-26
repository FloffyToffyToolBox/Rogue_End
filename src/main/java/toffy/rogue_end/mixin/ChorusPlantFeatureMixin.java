package toffy.rogue_end.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.ChorusPlantFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import toffy.rogue_end.init.ModBlockTags;

@Mixin(ChorusPlantFeature.class)
public class ChorusPlantFeatureMixin {
    @Inject(method = "generate", at = @At("RETURN"), cancellable = true)
    public void generate(FeatureContext<DefaultFeatureConfig> context, CallbackInfoReturnable<Boolean> cir){
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        if ((structureWorldAccess.isAir(blockPos)||structureWorldAccess.getBlockState(blockPos).isIn(ModBlockTags.CHORUS_PLANT_CAN_REPLACE)) && structureWorldAccess.getBlockState(blockPos.down()).isOf(Blocks.END_STONE)) {
            ChorusFlowerBlock.generate(structureWorldAccess, blockPos, random, 8);
            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }
    }
}
