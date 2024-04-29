package zakkaroom.legendarypast;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zakkaroom.legendarypast.entity.ModEntities;
import zakkaroom.legendarypast.entity.custom.CobblestoneGolemEntity;
import zakkaroom.legendarypast.item.ModItems;

public class LegendaryPast implements ModInitializer {
	public static final String MOD_ID = "legendarypast";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.COBBLESTONE_GOLEM, CobblestoneGolemEntity.createCobblestoneGolemAttributes());

	}
}