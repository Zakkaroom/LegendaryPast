package zakkaroom.legendarypast.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import zakkaroom.legendarypast.LegendaryPast;
import zakkaroom.legendarypast.entity.custom.CobblestoneGolemEntity;

public class CobblestoneGolemRenderer extends MobEntityRenderer<CobblestoneGolemEntity, CobblestoneGolemModel<CobblestoneGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(LegendaryPast.MOD_ID, "textures/entity/cobblestone_golem.png");

    public CobblestoneGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new CobblestoneGolemModel<>(context.getPart(ModModelLayers.COBBLESTONE_GOLEM)), 0.2f);
    }

    @Override
    public Identifier getTexture(CobblestoneGolemEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CobblestoneGolemEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(2,2,2);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
