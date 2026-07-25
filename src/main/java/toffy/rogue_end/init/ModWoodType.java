package toffy.rogue_end.init;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;

import java.util.Map;
import java.util.stream.Stream;

public record ModWoodType(String name, BlockSetType setType, BlockSoundGroup soundType, BlockSoundGroup hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen) {
    private static final Map<String, WoodType> VALUES = new Object2ObjectArrayMap();
    public static final WoodType CHORUS = register(new WoodType("chorus", BlockSetType.CRIMSON));;
    public static final WoodType CORRUPTED = register(new WoodType("corrupted", BlockSetType.WARPED));;
    private static WoodType register(WoodType type) {
        VALUES.put(type.name(), type);
        return type;
    }
    public static Stream<WoodType> stream() {
        return VALUES.values().stream();
    }
}
