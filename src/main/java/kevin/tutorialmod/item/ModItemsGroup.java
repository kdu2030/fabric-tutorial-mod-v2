package kevin.tutorialmod.item;

import kevin.tutorialmod.TutorialMod;
import kevin.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {

    public static final ItemGroup RUBY_GROUP = registerItemGroup("ruby", new ItemStack(ModItems.RUBY), ModItems.RUBY, ModItems.RAW_RUBY, ModBlocks.RUBY_BLOCK, ModBlocks.RAW_RUBY_BLOCK, ModBlocks.RUBY_ORE,
            ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE, ModItems.METAL_DETECTOR, ModBlocks.SOUND_BLOCK, ModItems.TOMATO, ModItems.COAL_BRIQUETTE);

    public static ItemGroup registerItemGroup(String itemGroupId, ItemStack icon, ItemConvertible... items){
        Identifier id = new Identifier(TutorialMod.MOD_ID, itemGroupId);
        String translationKey = String.format("itemgroup.%s", itemGroupId);

        return Registry.register(Registries.ITEM_GROUP, id, FabricItemGroup.builder().displayName(Text.translatable(translationKey)).icon(() -> icon).entries(((displayContext, entries) -> {
            for(ItemConvertible item: items){
                entries.add(new ItemStack(item));
            }
        })).build());
    }

    public static void registerModItemGroups(){
        TutorialMod.LOGGER.info("Registering item groups for " + TutorialMod.MOD_ID);
    }

}
