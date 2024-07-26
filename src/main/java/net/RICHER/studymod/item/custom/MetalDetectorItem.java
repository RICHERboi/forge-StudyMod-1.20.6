package net.RICHER.studymod.item.custom;

import net.RICHER.studymod.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    boolean detector_switch_all = false;

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide() && !pContext.isSecondaryUseActive()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundblock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(state)) {
                    if (detector_switch_all){
                        outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                        pContext.getItemInHand().hurtAndBreak(2, pContext.getPlayer(),
                                LivingEntity.getSlotForHand(pContext.getHand()));
                        i+=1;
                        foundblock = true;
                    } else {
                        outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                        foundblock = true;
                        break;
                    }

                }
            }
            if (!foundblock) {
                player.sendSystemMessage(Component.literal("No valuables found."));
            }
        } else if (!pContext.getLevel().isClientSide()) {
            if (detector_switch_all) {
                detector_switch_all = false;
                pContext.getPlayer().sendSystemMessage(Component.literal("First Mode (Loose ores under each-other)"));
            } else {
                detector_switch_all = true;
                pContext.getPlayer().sendSystemMessage(Component.literal("All Mode (Heavier usage)"));
            }
        }
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                LivingEntity.getSlotForHand(pContext.getHand()));
        pContext.getPlayer().getCooldowns().addCooldown(this, 10);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.studymod.metal_detector"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + "/ " + blockPos.getY() + "/ " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }
}
