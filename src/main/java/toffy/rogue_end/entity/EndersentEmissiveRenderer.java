package toffy.rogue_end.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.render.entity.model.PhantomEntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

@Environment(EnvType.CLIENT)
public class EndersentEmissiveRenderer<T extends EndersentEntity> extends EyesFeatureRenderer<T, EndersentModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(RogueEnd.MOD_ID, "textures/entity/endersent/endersent_eyes.png"));

    public EndersentEmissiveRenderer(FeatureRendererContext<T, EndersentModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
