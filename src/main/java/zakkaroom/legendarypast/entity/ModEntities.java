package zakkaroom.legendarypast.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import zakkaroom.legendarypast.LegendaryPast;
import zakkaroom.legendarypast.entity.custom.CobblestoneGolemEntity;

public class ModEntities {

    public static final EntityType<CobblestoneGolemEntity> COBBLESTONE_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(LegendaryPast.MOD_ID, "cobblestone_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, CobblestoneGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f,0.6f)).build());

    public static void registerModEntities() {
        LegendaryPast.LOGGER.info("Registering Entities for " + LegendaryPast.MOD_ID);
    }

}
