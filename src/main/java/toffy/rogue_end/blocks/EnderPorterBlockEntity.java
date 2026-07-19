package toffy.rogue_end.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.SingleStackInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;
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

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        if (!this.getStack().isEmpty()) {
            nbt.put("eyeStack", this.getStack().encode(registryLookup));
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
    }
}
