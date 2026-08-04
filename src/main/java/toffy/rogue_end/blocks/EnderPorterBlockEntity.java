package toffy.rogue_end.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.SingleStackInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import toffy.rogue_end.init.ModBlockEntities;
import toffy.rogue_end.init.ModComponentTypes;
import toffy.rogue_end.items.EnderEyeComponent;

public class EnderPorterBlockEntity extends BlockEntity implements Clearable, SingleStackInventory.SingleStackBlockEntityInventory {
    public static final String EYESTACK_NBT_KEY = "eyeStack";
    private ItemStack eyeStack;
    public EnderPorterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ENDER_PORTER, pos, state);
        this.eyeStack = ItemStack.EMPTY;
    }

    private void onStackChanged(boolean hasEye) {
        if (this.world != null && this.world.getBlockState(this.getPos()) == this.getCachedState()) {
            this.world.setBlockState(this.getPos(), (BlockState)this.getCachedState().with(EnderPorterBlock.EYE, hasEye), 2);
            this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(this.getCachedState()));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        if (!this.getStack().isEmpty()) {
            nbt.put("eyeStack", this.getStack().encode(registryLookup));
        }
    }
    public ItemStack decreaseStack(int count) {
        ItemStack itemStack = this.eyeStack;
        this.setStack(ItemStack.EMPTY);
        return itemStack;
    }
    public void dropEye() {
        if (this.world != null && !this.world.isClient) {
            BlockPos blockPos = this.getPos();
            ItemStack itemStack = this.getStack();
            if (!itemStack.isEmpty()) {
                Vec3d vec3d = Vec3d.add(blockPos, 0.5, 1.01, 0.5).addRandom(this.world.random, 0.7F);
                ItemStack itemStack2 = itemStack.copy();
                ItemEntity itemEntity = new ItemEntity(this.world, vec3d.getX(), vec3d.getY(), vec3d.getZ(), itemStack2);
                itemEntity.setToDefaultPickupDelay();
                this.decreaseStack(1);
                this.world.spawnEntity(itemEntity);
            }
        }
    }
    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        if (nbt.contains("eyeStack", 10)) {
            this.eyeStack = (ItemStack)ItemStack.fromNbt(registryLookup, nbt.getCompound("eyeStack")).orElse(ItemStack.EMPTY);
        } else {
            this.eyeStack = ItemStack.EMPTY;
        }
    }
    public EnderEyeComponent getReceiverPos(){
        return (eyeStack.get(ModComponentTypes.ENDER_EYE));
    }
    @Override
    public BlockEntity asBlockEntity() {
        return this;
    }

    @Override
    public ItemStack getStack() {
        return eyeStack;
    }
    public boolean isEmpty() {
        return eyeStack.isEmpty();
    }
    @Override
    public void setStack(ItemStack stack) {
        eyeStack=stack;
        boolean bl = !this.eyeStack.isEmpty();
        this.onStackChanged(bl);
    }
}
