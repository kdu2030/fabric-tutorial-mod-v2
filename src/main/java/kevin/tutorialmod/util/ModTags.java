package kevin.tutorialmod.util;

import kevin.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_BLOCKS = createTag("detectable_blocks");

        private static TagKey<Block> createTag(String key){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TutorialMod.MOD_ID, key));
        }

    }

    public static class Items {
        public static final TagKey<Item> METAL_DETECTOR_ITEMS = createTag("detectable_items");

        private static TagKey<Item> createTag(String key){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(TutorialMod.MOD_ID, key));
        }

    }

}
