package kevin.tutorialmod.block;

import kevin.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // If you want to override a setting using a builder pattern, you can just call the method to change it
    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    private static Block registerBlock(String blockId, Block block){
        registerBlockItem(blockId, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, blockId), block);
    }

    private static Item registerBlockItem(String blockId, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, blockId), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering mod blocks for" + TutorialMod.MOD_ID);
    }

}
