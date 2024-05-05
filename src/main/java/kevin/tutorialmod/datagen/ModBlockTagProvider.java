package kevin.tutorialmod.datagen;

import kevin.tutorialmod.block.ModBlocks;
import kevin.tutorialmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private void addVanillaBlocksToTag(FabricTagProvider<Block>.FabricTagBuilder tagBuilder, TagKey<Block>... vanillaBlockTags) {
        for (TagKey<Block> vanillaBlockTag : vanillaBlockTags) {
            tagBuilder.forceAddTag(vanillaBlockTag);
        }
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // Add custom tag
        FabricTagProvider<Block>.FabricTagBuilder metalDetectorTagBuilder = getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_BLOCKS);
        metalDetectorTagBuilder.add(ModBlocks.RUBY_ORE);

        addVanillaBlocksToTag(metalDetectorTagBuilder, BlockTags.GOLD_ORES, BlockTags.EMERALD_ORES,
                BlockTags.REDSTONE_ORES, BlockTags.LAPIS_ORES, BlockTags.DIAMOND_ORES,
                BlockTags.GOLD_ORES, BlockTags.IRON_ORES, BlockTags.COAL_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_RUBY_BLOCK, ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_ORE,
                        ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.SOUND_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RUBY_BLOCK, ModBlocks.RUBY_ORE, ModBlocks.NETHER_RUBY_ORE,
                        ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_RUBY_BLOCK);

        // Make only mineable by netherite tools
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.END_STONE_RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE, ModBlocks.RUBY_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.RUBY_WALL);
    }
}
