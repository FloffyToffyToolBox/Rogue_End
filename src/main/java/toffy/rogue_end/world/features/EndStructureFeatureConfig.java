package toffy.rogue_end.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public class EndStructureFeatureConfig implements FeatureConfig {
    public static final Codec<EndStructureFeatureConfig> CODEC =
            RecordCodecBuilder.create((instance) -> instance.group(Identifier.CODEC.listOf().fieldOf("fossil_structures").forGetter((config) -> config.fossilStructures),
                    StructureProcessorType.REGISTRY_CODEC.fieldOf("processor").forGetter((config) -> config.processor)
            ).apply(instance, EndStructureFeatureConfig::new));
    public final List<Identifier> fossilStructures;
    public final RegistryEntry<StructureProcessorList> processor;
    public EndStructureFeatureConfig(List<Identifier> fossilStructures, RegistryEntry<StructureProcessorList> processor) {
        if (fossilStructures.isEmpty()) {
            throw new IllegalArgumentException("Fossil structure lists need at least one entry");
        } else {
            this.fossilStructures = fossilStructures;
            this.processor = processor;
        }
    }
}
