package toffy.rogue_end.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

@Environment(EnvType.CLIENT)
public class EndlingRenderer extends MobEntityRenderer<EndlingEntity, EndlingModel<EndlingEntity>> {
    public EndlingRenderer(EntityRendererFactory.Context context) {
        super(context, new EndlingModel<>(context.getPart(EndlingModel.LAYER_LOCATION)), 0.75F);
    }

    @Override
    public Identifier getTexture(EndlingEntity entity) {
        return Identifier.of(RogueEnd.MOD_ID, "textures/entity/endling/endling.png");
    }

    @Override
    public void render(EndlingEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
