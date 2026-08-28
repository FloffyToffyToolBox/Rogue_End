//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package toffy.rogue_end.world.features;

import com.mojang.serialization.Codec;
import java.util.List;
import java.util.Objects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.apache.commons.lang3.mutable.MutableInt;

public class EndFossilFeature extends Feature<EndFossilFeatureConfig> {
    public EndFossilFeature(Codec<EndFossilFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<EndFossilFeatureConfig> context) {
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockRotation blockRotation = BlockRotation.random(random);
        EndFossilFeatureConfig fossilFeatureConfig = (EndFossilFeatureConfig)context.getConfig();
        int i = random.nextInt(fossilFeatureConfig.fossilStructures.size());
        StructureTemplateManager structureTemplateManager = structureWorldAccess.toServerWorld().getServer().getStructureTemplateManager();
        StructureTemplate structureTemplate = structureTemplateManager.getTemplateOrBlank((Identifier)fossilFeatureConfig.fossilStructures.get(i));
        StructureTemplate structureTemplate2 = structureTemplateManager.getTemplateOrBlank((Identifier)fossilFeatureConfig.overlayStructures.get(i));
        ChunkPos chunkPos = new ChunkPos(blockPos);
        BlockBox blockBox = new BlockBox(chunkPos.getStartX() - 16, structureWorldAccess.getBottomY(), chunkPos.getStartZ() - 16, chunkPos.getEndX() + 16, structureWorldAccess.getTopY(), chunkPos.getEndZ() + 16);
        StructurePlacementData structurePlacementData = (new StructurePlacementData()).setRotation(blockRotation).setBoundingBox(blockBox).setRandom(random);
        Vec3i vec3i = structureTemplate.getRotatedSize(blockRotation);
        BlockPos blockPos2 = blockPos.add(-vec3i.getX() / 2, 0, -vec3i.getZ() / 2);
        int j = blockPos.getY();
        BlockPos blockPos3 = structureTemplate.offsetByTransformedSize(blockPos2.withY(j), BlockMirror.NONE, blockRotation);
        structurePlacementData.clearProcessors();
        List<StructureProcessor> var10000 = ((StructureProcessorList)fossilFeatureConfig.fossilProcessors.value()).getList();
        Objects.requireNonNull(structurePlacementData);
        var10000.forEach(structurePlacementData::addProcessor);
        structureTemplate.place(structureWorldAccess, blockPos, blockPos, structurePlacementData, random, 4);
        structurePlacementData.clearProcessors();
        var10000 = ((StructureProcessorList)fossilFeatureConfig.overlayProcessors.value()).getList();
        Objects.requireNonNull(structurePlacementData);
        var10000.forEach(structurePlacementData::addProcessor);
        structureTemplate2.place(structureWorldAccess, blockPos, blockPos, structurePlacementData, random, 4);
        return true;
    }
}
