package kevin.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    private boolean isValuableBlock(BlockState state){
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block){
        String message = String.format("Found %s at (%d, %d, %d)", block.getName().getString(), blockPos.getX(),
                blockPos.getY(), blockPos.getZ());
        player.sendMessage(Text.literal(message), false);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i < positionClicked.getY() + 64; i++){
                BlockState blockState = context.getWorld().getBlockState(positionClicked.down(i));
                if(isValuableBlock(blockState)){
                    foundBlock = true;
                    outputValuableCoordinates(positionClicked.down(i), player, blockState.getBlock());
                    break;
                }
            }

            if(!foundBlock){
                player.sendMessage(Text.literal("Unable to find valuables"));
            }
        }
        context.getStack().damage(1,context.getPlayer(), playerEntity -> playerEntity.getActiveHand());
        return ActionResult.SUCCESS;
    }
}
