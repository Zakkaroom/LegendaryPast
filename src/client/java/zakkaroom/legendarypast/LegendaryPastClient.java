package zakkaroom.legendarypast;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import zakkaroom.legendarypast.entity.CobblestoneGolemModel;
import zakkaroom.legendarypast.entity.CobblestoneGolemRenderer;
import zakkaroom.legendarypast.entity.ModEntities;
import zakkaroom.legendarypast.entity.ModModelLayers;

public class LegendaryPastClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		EntityRendererRegistry.register(ModEntities.COBBLESTONE_GOLEM, CobblestoneGolemRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.COBBLESTONE_GOLEM, CobblestoneGolemModel::getTexturedModelData);
	}
}