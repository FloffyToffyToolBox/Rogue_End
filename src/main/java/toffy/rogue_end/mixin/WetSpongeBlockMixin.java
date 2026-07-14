package toffy.rogue_end.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toffy.rogue_end.init.ModBlockTags;
import toffy.rogue_end.init.ModBlocks;

@Mixin(WetSpongeBlock.class)
public class WetSpongeBlockMixin extends BlockMixin {
    @Inject(method = "onBlockAdded", at = @At("HEAD"))
    void _onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify, CallbackInfo ci){
        if (world.getBlockState(pos.down()).isIn(ModBlockTags.DRIES_SPONGE)){
            world.setBlockState(pos, Blocks.SPONGE.getDefaultState(), 3);
            world.syncWorldEvent(2009, pos, 0);
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WET_SPONGE_DRIES, SoundCategory.BLOCKS, 1.0F, (1.0F + world.getRandom().nextFloat() * 0.2F) * 0.7F);
        }
    }

    @Override
    protected void neighborUpdateOverride(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify, CallbackInfo ci) {
        if (world.getBlockState(pos.down()).isIn(ModBlockTags.DRIES_SPONGE)){
            world.setBlockState(pos, Blocks.SPONGE.getDefaultState(), 3);
            world.syncWorldEvent(2009, pos, 0);
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WET_SPONGE_DRIES, SoundCategory.BLOCKS, 1.0F, (1.0F + world.getRandom().nextFloat() * 0.2F) * 0.7F);
        }
    }
}
