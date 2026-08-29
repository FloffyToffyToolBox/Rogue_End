package toffy.rogue_end.entity;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;
import toffy.rogue_end.RogueEnd;

@Environment(EnvType.CLIENT)
public class EndersentModel<T extends EndersentEntity> extends SinglePartEntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of(RogueEnd.MOD_ID, "endersent"), "main");
	private static final RenderLayer EYES = RenderLayer.getEyes(Identifier.of(RogueEnd.MOD_ID, "textures/entity/endersent/endersent_eyes.png"));
	private final ModelPart waist;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart upperarm_l;
	private final ModelPart forearm_l;
	private final ModelPart hand_l;
	private final ModelPart upperarm_r;
	private final ModelPart forearm_r;
	private final ModelPart hand_r;
	private final ModelPart leg_l;
	private final ModelPart leg_r;

	public static RenderLayer getEyesTexture() {
		return EYES;
	}

	public EndersentModel(ModelPart root) {
        this.waist = root.getChild("waist");
		this.body = this.waist.getChild("body");
		this.head = this.body.getChild("head");
		this.upperarm_l = this.body.getChild("upperarm_l");
		this.forearm_l = this.upperarm_l.getChild("forearm_l");
		this.hand_l = this.forearm_l.getChild("hand_l");
		this.upperarm_r = this.body.getChild("upperarm_r");
		this.forearm_r = this.upperarm_r.getChild("forearm_r");
		this.hand_r = this.forearm_r.getChild("hand_r");
		this.leg_l = this.waist.getChild("leg_l");
		this.leg_r = this.waist.getChild("leg_r");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData waist = modelPartData.addChild("waist", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -36, 0.0F));

		ModelPartData body = waist.addChild("body", ModelPartBuilder.create().uv(2, 8).cuboid(-7.5F, -29.0F, -4.0F, 15.0F, 29.0F, 8.0F), ModelTransform.pivot(0.0F, 0, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(1, 46).cuboid(-4.5F, -8.0F, -2.0F, 9.0F, 14.0F, 6.0F), ModelTransform.pivot(0.0F, -30.0F, -7.0F));

		ModelPartData upperarm_l = body.addChild("upperarm_l", ModelPartBuilder.create().uv(49, 3).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 30.0F, 4.0F), ModelTransform.pivot(8.75F, -27.0F, 0.0F));

		ModelPartData forearm_l = upperarm_l.addChild("forearm_l", ModelPartBuilder.create().uv(66, 8).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 42.0F, 4.0F), ModelTransform.pivot(1.0F, 28.0F, 0.0F));

		ModelPartData hand_l = forearm_l.addChild("hand_l", ModelPartBuilder.create().uv(32, 38).mirrored().cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 11.0F, 17.0F), ModelTransform.pivot(0.0F, 42.0F, 0.0F));

		ModelPartData upperarm_r = body.addChild("upperarm_r", ModelPartBuilder.create().uv(49, 3).mirrored().cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 30.0F, 4.0F), ModelTransform.pivot(-8.25F, -27.0F, 0.0F));

		ModelPartData forearm_r = upperarm_r.addChild("forearm_r", ModelPartBuilder.create().uv(66, 8).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 42.0F, 4.0F), ModelTransform.pivot(-1.0F, 28.0F, 0.0F));

		ModelPartData hand_r = forearm_r.addChild("hand_r", ModelPartBuilder.create().uv(32, 38).mirrored().cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 11.0F, 17.0F), ModelTransform.pivot(0.0F, 42.0F, 0.0F));

		ModelPartData leg_l = waist.addChild("leg_l", ModelPartBuilder.create().uv(83, 1).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 61.0F, 4.0F), ModelTransform.pivot(3.5F, 0, 0.0F));

		ModelPartData leg_r = waist.addChild("leg_r", ModelPartBuilder.create().uv(83, 1).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 61.0F, 4.0F), ModelTransform.pivot(-3.5F, 0, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	public void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int colour)	{
		waist.render(matrixStack, vertexConsumer, packedLight, packedOverlay, colour);
	}

	public ModelPart getPart() {
		return this.waist;
	}
	@Override
	public void setAngles(EndersentEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngle(headYaw, headPitch);
		this.animateMovement(EndersentRendererAnimations.walk, limbAngle, limbDistance, 1f, 2.5f);
		if (entity.isAttacking())AnimationHelper.animate(this,EndersentRendererAnimations.attack, (long) (entity.handSwingProgress* 2000),1,new Vector3f());
		this.updateAnimation(entity.idleAnimationState, EndersentRendererAnimations.walk, animationProgress);
		this.updateAnimation(entity.attackingAnimationState, EndersentRendererAnimations.attack, animationProgress);
	}
	private void setHeadAngle(float yaw, float pitch) {
		this.head.pitch = pitch * 0.017453292F;
		this.head.yaw = yaw * 0.017453292F;
	}
}