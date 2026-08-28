package toffy.rogue_end.entity;// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;
import toffy.rogue_end.RogueEnd;
import toffy.rogue_end.entity.EndersentEntity;

public class EndlingModel<T extends LivingEntity> extends SinglePartEntityModel<EndlingEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(Identifier.of(RogueEnd.MOD_ID, "endling"), "main");
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public EndlingModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 26).mirrored().cuboid(-5.5F, -3.0F, -3.0F, 11.0F, 15.0F, 6.0F), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(-4.5F, -8.0F, -4.0F, 9.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(48, 33).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 27.0F, 4.0F), ModelTransform.pivot(-7.5F, -8.0F, 0.0F));

		ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(48, 33).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 27.0F, 4.0F), ModelTransform.pivot(7.5F, -8.0F, 0.0F));

		ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(39, 45).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 17.0F, 2.0F), ModelTransform.pivot(-2.5F, 7.0F, 0.0F));

		ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(39, 45).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 17.0F, 2.0F), ModelTransform.pivot(2.5F, 7.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	public ModelPart getPart() {
		return root;
	}
	@Override
	public void setAngles(EndlingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngle(headYaw, headPitch);
		this.animateMovement(EndlingRendererAnimations.walk, limbAngle, limbDistance, 1f, 2.5f);
		if (entity.isAttacking())AnimationHelper.animate(this,EndlingRendererAnimations.attack, (long) (entity.handSwingProgress* 2000),1,new Vector3f());
		AnimationHelper.animate(this,EndlingRendererAnimations.walk, entity.idleAnimationState.getTimeRunning(),1,new Vector3f());
		entity.idleAnimationState.setRunning(true, (int) (entity.idleAnimationState.getTimeRunning()+1));
		this.updateAnimation(entity.attackingAnimationState, EndlingRendererAnimations.attack, animationProgress);
	}
	private void setHeadAngle(float yaw, float pitch) {
		this.head.pitch = pitch * 0.017453292F;
		this.head.yaw = yaw * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int colour)	{
		body.render(matrixStack, vertexConsumer, packedLight, packedOverlay, colour);
		head.render(matrixStack, vertexConsumer, packedLight, packedOverlay, colour);
		right_arm.render(matrixStack, vertexConsumer, packedLight, packedOverlay, colour);
		left_arm.render(matrixStack, vertexConsumer, packedLight, packedOverlay, colour);
		right_leg.render(matrixStack, vertexConsumer, packedLight, packedOverlay, colour);
		left_leg.render(matrixStack, vertexConsumer, packedLight, packedOverlay, colour);
	}
}