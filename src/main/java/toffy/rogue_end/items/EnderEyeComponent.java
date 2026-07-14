//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package toffy.rogue_end.items;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.util.Optional;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.world.poi.PointOfInterestTypes;

public record EnderEyeComponent(Optional<GlobalPos> target, boolean tracked) {
    public static final Codec<EnderEyeComponent> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(GlobalPos.CODEC.optionalFieldOf("target").forGetter(EnderEyeComponent::target), Codec.BOOL.optionalFieldOf("tracked", true).forGetter(EnderEyeComponent::tracked)).apply(instance, EnderEyeComponent::new);
    });
    public static final PacketCodec<ByteBuf, EnderEyeComponent> PACKET_CODEC;

    public EnderEyeComponent(Optional<GlobalPos> target, boolean tracked) {
        this.target = target;
        this.tracked = tracked;
    }

    public EnderEyeComponent forWorld(ServerWorld world) {
        if (this.tracked && !this.target.isEmpty()) {
            if (((GlobalPos)this.target.get()).dimension() != world.getRegistryKey()) {
                return this;
            } else {
                BlockPos blockPos = ((GlobalPos)this.target.get()).pos();
                return world.isInBuildLimit(blockPos) && world.getPointOfInterestStorage().hasTypeAt(PointOfInterestTypes.LODESTONE, blockPos) ? this : new EnderEyeComponent(Optional.empty(), true);
            }
        } else {
            return this;
        }
    }

    public Optional<GlobalPos> target() {
        return this.target;
    }

    public boolean tracked() {
        return this.tracked;
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(GlobalPos.PACKET_CODEC.collect(PacketCodecs::optional), EnderEyeComponent::target, PacketCodecs.BOOL, EnderEyeComponent::tracked, EnderEyeComponent::new);
    }
}
