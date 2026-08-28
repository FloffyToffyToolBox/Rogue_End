//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package toffy.rogue_end.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.FossilFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.apache.commons.lang3.mutable.MutableInt;

import java.util.List;
import java.util.Objects;

public class EndFossilFeatureConfig implements FeatureConfig {
    public static final Codec<EndFossilFeatureConfig> CODEC =
            RecordCodecBuilder.create((instance) -> instance.group(Identifier.CODEC.listOf().fieldOf("fossil_structures").forGetter((config) -> config.fossilStructures),
                    Identifier.CODEC.listOf().fieldOf("overlay_structures").forGetter((config) -> config.overlayStructures),
                    StructureProcessorType.REGISTRY_CODEC.fieldOf("fossil_processors").forGetter((config) -> config.fossilProcessors),
                    StructureProcessorType.REGISTRY_CODEC.fieldOf("overlay_processors").forGetter((config) -> config.overlayProcessors)
            ).apply(instance, EndFossilFeatureConfig::new));
    public final List<Identifier> fossilStructures;
    public final List<Identifier> overlayStructures;
    public final RegistryEntry<StructureProcessorList> fossilProcessors;
    public final RegistryEntry<StructureProcessorList> overlayProcessors;

    public EndFossilFeatureConfig(List<Identifier> fossilStructures, List<Identifier> overlayStructures, RegistryEntry<StructureProcessorList> fossilProcessors, RegistryEntry<StructureProcessorList> overlayProcessors) {
        if (fossilStructures.isEmpty()) {
            throw new IllegalArgumentException("Fossil structure lists need at least one entry");
        } else if (fossilStructures.size() != overlayStructures.size()) {
            throw new IllegalArgumentException("Fossil structure lists must be equal lengths");
        } else {
            this.fossilStructures = fossilStructures;
            this.overlayStructures = overlayStructures;
            this.fossilProcessors = fossilProcessors;
            this.overlayProcessors = overlayProcessors;
        }
    }
}
