package toffy.rogue_end.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;
import toffy.rogue_end.RogueEnd;

@Environment(EnvType.CLIENT)
public class EndlingEmissiveRenderer<T extends EndlingEntity> extends EyesFeatureRenderer<T, EndlingModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(RogueEnd.MOD_ID, "textures/entity/endling/endling_eyes.png"));

    public EndlingEmissiveRenderer(FeatureRendererContext<T, EndlingModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}
