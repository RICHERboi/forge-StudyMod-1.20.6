package net.RICHER.studymod.Item.Custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundblock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundblock = true;
                    break;
                }
            }
            if (!foundblock) {
                player.sendSystemMessage(Component.literal("No valuables found."));
            } else {
                pContext.getItemInHand().hurtAndBreak(3, pContext.getPlayer(),
                        LivingEntity.getSlotForHand(pContext.getHand()));
            }
        }
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                LivingEntity.getSlotForHand(pContext.getHand()));
        pContext.getPlayer().getCooldowns().addCooldown(this, 10);

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + "/ " + blockPos.getY() + "/ " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Tags.Blocks.ORES_DIAMOND) || state.is(Tags.Blocks.ORES_GOLD);
    }
}