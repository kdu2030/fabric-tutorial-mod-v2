package kevin.tutorialmod.datagen;

import kevin.tutorialmod.block.ModBlocks;
import kevin.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void registerSimpleCubeAllModels(BlockStateModelGenerator blockStateModelGenerator, Block... blocks) {
        for (Block block : blocks) {
            // Note that this also creates the Item JSON files for you
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool rubyBlockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);

        registerSimpleCubeAllModels(blockStateModelGenerator, ModBlocks.RUBY_ORE, ModBlocks.SOUND_BLOCK,
                ModBlocks.RAW_RUBY_BLOCK, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE,
                ModBlocks.END_STONE_RUBY_ORE);

        rubyBlockTexturePool.stairs(ModBlocks.RUBY_STAIRS);
        rubyBlockTexturePool.button(ModBlocks.RUBY_BUTTON);
        rubyBlockTexturePool.slab(ModBlocks.RUBY_SLAB);
        rubyBlockTexturePool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        rubyBlockTexturePool.fence(ModBlocks.RUBY_FENCE);
        rubyBlockTexturePool.wall(ModBlocks.RUBY_WALL);
        rubyBlockTexturePool.fenceGate(ModBlocks.RUBY_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);
    }

    public void registerItemGeneratedModels(ItemModelGenerator itemModelGenerator, Item... items) {
        for (Item item : items) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerItemGeneratedModels(itemModelGenerator, ModItems.RUBY, ModItems.RAW_RUBY,
                ModItems.TOMATO, ModItems.COAL_BRIQUETTE, ModItems.METAL_DETECTOR);
    }
}
