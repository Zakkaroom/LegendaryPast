package zakkaroom.legendarypast.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CamelEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import zakkaroom.legendarypast.animation.ModAnimations;
import zakkaroom.legendarypast.entity.custom.CobblestoneGolemEntity;

public class CobblestoneGolemModel<T extends CobblestoneGolemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart cobblestonegolem;
	public CobblestoneGolemModel(ModelPart root) {
		this.cobblestonegolem = root.getChild("cobblestonegolem");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData cobblestonegolem = modelPartData.addChild("cobblestonegolem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = cobblestonegolem.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -4.0F, -3.5F, 7.0F, 7.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0F, 0.0F, -4.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

		ModelPartData leftleg = cobblestonegolem.addChild("leftleg", ModelPartBuilder.create().uv(8, 14).cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -2.0F, 0.0F));

		ModelPartData rightleg = cobblestonegolem.addChild("rightleg", ModelPartBuilder.create().uv(20, 14).cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -2.0F, 0.0F));

		ModelPartData leftarm = cobblestonegolem.addChild("leftarm", ModelPartBuilder.create().uv(12, 14).cuboid(0.0F, 0.0F, -2.0F, 2.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, -8.5F, 0.0F));

		ModelPartData rightarm = cobblestonegolem.addChild("rightarm", ModelPartBuilder.create().uv(0, 14).cuboid(-2.0F, 0.0F, -2.0F, 2.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -8.5F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		cobblestonegolem.render(matrices, vertices, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return cobblestonegolem;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ModAnimations.COBBLESTONE_GOLEM_WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.COBBLESTONE_GOLEM_IDLE,animationProgress,1.0f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.COBBLESTONE_GOLEM_ATTACK,animationProgress,1.0f);
	}

}