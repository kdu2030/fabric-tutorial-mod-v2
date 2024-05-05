package kevin.tutorialmod.datagen;

import kevin.tutorialmod.block.ModBlocks;
import kevin.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public void createSelfDropLootTables(Block... blocks) {
        for (Block block : blocks) {
            addDrop(block);
        }
    }

    public LootTable.Builder createOreDrop(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)
                this.applyExplosionDecay(drop, ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    @Override
    public void generate() {
        createSelfDropLootTables(ModBlocks.RUBY_BLOCK, ModBlocks.RAW_RUBY_BLOCK,
                ModBlocks.SOUND_BLOCK, ModBlocks.RUBY_STAIRS, ModBlocks.RUBY_TRAPDOOR, ModBlocks.RUBY_WALL,
                ModBlocks.RUBY_FENCE, ModBlocks.RUBY_FENCE_GATE, ModBlocks.RUBY_BUTTON, ModBlocks.RUBY_PRESSURE_PLATE);

        addDrop(ModBlocks.RUBY_ORE, createOreDrop(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY));
        addDrop(ModBlocks.NETHER_RUBY_ORE, createOreDrop(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY));
        addDrop(ModBlocks.END_STONE_RUBY_ORE, createOreDrop(ModBlocks.END_STONE_RUBY_ORE, ModItems.RAW_RUBY));

        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));
    }


}
