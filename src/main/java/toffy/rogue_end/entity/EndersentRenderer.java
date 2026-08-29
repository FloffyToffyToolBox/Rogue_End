package toffy.rogue_end.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.PhantomEyesFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

@Environment(EnvType.CLIENT)
public class EndersentRenderer extends MobEntityRenderer<EndersentEntity, EndersentModel<EndersentEntity>> {
    public EndersentRenderer(EntityRendererFactory.Context context) {
        super(context, new EndersentModel<>(context.getPart(EndersentModel.LAYER_LOCATION)), 0.75F);
        this.addFeature(new EndersentEmissiveRenderer<>(this));
    }

    @Override
    public Identifier getTexture(EndersentEntity entity) {
        return Identifier.of(RogueEnd.MOD_ID, "textures/entity/endersent/endersent.png");
    }

    @Override
    public void render(EndersentEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
