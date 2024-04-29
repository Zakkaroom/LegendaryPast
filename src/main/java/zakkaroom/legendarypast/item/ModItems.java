package zakkaroom.legendarypast.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import zakkaroom.legendarypast.LegendaryPast;
import zakkaroom.legendarypast.entity.ModEntities;

public class ModItems {

    public static final Item COBBLESTONE_GOLEM_SPAWN_EGG = registerItem("cobblestone_golem_spawn_egg",
            new SpawnEggItem(ModEntities.COBBLESTONE_GOLEM,0xa86518,0x3b260f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,new Identifier(LegendaryPast.MOD_ID, name), item);
    }

    public static void registerModItems(){
        LegendaryPast.LOGGER.info("Registering Mod Items for " + LegendaryPast.MOD_ID);
    }

}
