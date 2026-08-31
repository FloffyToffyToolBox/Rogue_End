package toffy.rogue_end.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.List;
import java.util.Objects;

public class EndStructureFeature extends Feature<EndStructureFeatureConfig> {
    public EndStructureFeature(Codec<EndStructureFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<EndStructureFeatureConfig> context) {
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin().down(2);
        BlockRotation blockRotation = BlockRotation.random(random);
        EndStructureFeatureConfig fossilFeatureConfig = (EndStructureFeatureConfig)context.getConfig();
        int i = random.nextInt(fossilFeatureConfig.fossilStructures.size());
        StructureTemplateManager structureTemplateManager = structureWorldAccess.toServerWorld().getServer().getStructureTemplateManager();
        StructureTemplate structureTemplate = structureTemplateManager.getTemplateOrBlank((Identifier)fossilFeatureConfig.fossilStructures.get(i));
        StructurePlacementData structurePlacementData = (new StructurePlacementData()).setRotation(blockRotation).setRandom(random);
        structurePlacementData.setBoundingBox(structureTemplate.calculateBoundingBox(structurePlacementData,blockPos));
        structurePlacementData.clearProcessors();
        List<StructureProcessor> var10000 = (fossilFeatureConfig.processor.value()).getList();
        Objects.requireNonNull(structurePlacementData);
        var10000.forEach(structurePlacementData::addProcessor);
        structureTemplate.place(structureWorldAccess, blockPos, blockPos, structurePlacementData, random, 4);
        return true;
    }
}
