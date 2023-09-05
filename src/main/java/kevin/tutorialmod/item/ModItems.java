package kevin.tutorialmod.item;

import kevin.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));

    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    public static void addItemsToItemGroup(FabricItemGroupEntries entries, Item... items){
        for(Item item:items){
            entries.add(item);
        }
    }

    public static Item registerItem(String itemId, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, itemId), item);
    }

    public static void registerModItems(){
        // Note - register() registers an event listener to the modify entries event
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((entries -> addItemsToItemGroup(entries, RUBY, RAW_RUBY)));
    }

}
