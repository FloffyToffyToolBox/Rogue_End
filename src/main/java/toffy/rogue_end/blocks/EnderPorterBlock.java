package toffy.rogue_end.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import toffy.rogue_end.init.ModBlocks;
import toffy.rogue_end.init.ModComponentTypes;

import java.util.Objects;

public class EnderPorterBlock extends BlockWithEntity {
    public static final MapCodec<EnderPorterBlock> CODEC = createCodec(EnderPorterBlock::new);
    public static final BooleanProperty POWERED;
    public static final BooleanProperty EYE;
    protected MapCodec<? extends EnderPorterBlock> getCodec() {
        return CODEC;
    }
    public EnderPorterBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false).with(EYE,false));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        NbtComponent nbtComponent = (NbtComponent)itemStack.getOrDefault(DataComponentTypes.BLOCK_ENTITY_DATA, NbtComponent.DEFAULT);
        if (nbtComponent.contains("eyeStack")) {
            world.setBlockState(pos, (BlockState)state.with(EYE, true), 2);
        }
    }
    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.ENDER_EYE)){
            if (stack.contains(ModComponentTypes.ENDER_EYE)){
                if (Objects.requireNonNull(stack.get(ModComponentTypes.ENDER_EYE)).tracked()) {
                    if (!(Boolean)state.get(EYE)) {
                        ItemStack itemStack = player.getStackInHand(hand);
                        if (!world.isClient) {
                            ItemStack itemStack1 = itemStack.splitUnlessCreative(1, player);
                            BlockEntity blockEntity = world.getBlockEntity(pos);
                            if (blockEntity instanceof EnderPorterBlockEntity) {
                                ((EnderPorterBlockEntity) blockEntity).setStack(itemStack1);
                                world.setBlockState(pos, state.with(EYE, true));
                                return ItemActionResult.CONSUME;
                            }
                        }
                    }
                }
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockEntity var7 = world.getBlockEntity(pos);
        if (var7 instanceof EnderPorterBlockEntity) {
            if (state.get(EYE)) {
                ((EnderPorterBlockEntity)var7).dropEye();
                world.setBlockState(pos,state.with(EYE,false));
                return ActionResult.success(world.isClient);
            }
        }
        return ActionResult.PASS;
    }
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    protected boolean hasSidedTransparency(BlockState state) {
        return true;
    }
    void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean)state.get(POWERED)) {
            world.setBlockState(pos, (BlockState)state.with(POWERED, bl), 3);
            if (state.get(EYE)&&bl){
                GlobalPos receiverPos = ((EnderPorterBlockEntity) Objects.requireNonNull(world.getBlockEntity(pos))).getReceiverPos().target().get();;
                if (receiverPos.dimension() == world.getRegistryKey()) {
                    if (world.getBlockState(receiverPos.pos()).isOf(ModBlocks.ENDER_PORTER)) {
                        ServerPlayerEntity player = (ServerPlayerEntity) world.getClosestPlayer(pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, 2, false);
                        if (player != null){
                            Vec3d offset = new Vec3d(player.getPos().getX() - pos.getX(),player.getPos().getY() - pos.getY(),player.getPos().getZ() - pos.getZ());
                            player.teleport(world, receiverPos.pos().getX()+offset.x, receiverPos.pos().getY()+offset.y, receiverPos.pos().getZ()+offset.z, player.getYaw(), player.getPitch());
                            player.setPos(receiverPos.pos().getX()+offset.x, receiverPos.pos().getY()+offset.y, receiverPos.pos().getZ()+offset.z);
                            world.emitGameEvent(GameEvent.TELEPORT, player.getPos(), GameEvent.Emitter.of(player));
                            player.onLanding();
                        }
                    }
                }
            }
        }
    }
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    static {
        POWERED = Properties.POWERED;
        EYE = Properties.EYE;
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{POWERED});
        builder.add(new Property[]{EYE});
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EnderPorterBlockEntity(pos, state);
    }
}
