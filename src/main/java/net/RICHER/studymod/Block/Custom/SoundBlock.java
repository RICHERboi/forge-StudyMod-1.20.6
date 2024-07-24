package net.RICHER.studymod.Block.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Interaction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import java.util.List;

public class SoundBlock extends Block {
    public SoundBlock(Properties pProperties) {
        super(pProperties);
    }

    Integer musicnote = 2;
    boolean fix = false;

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {

        if (musicnote == 21) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_FLUTE.get(), SoundSource.BLOCKS, 1f, 0.01f);
        } else if (musicnote == 4 || musicnote == 12 || musicnote == 18 || musicnote == 24 || musicnote == 32 || musicnote == 40 || musicnote == 46) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_FLUTE.get(), SoundSource.BLOCKS, 1f, 0.7f);
        } else if (musicnote == 6 || musicnote == 10 || musicnote == 26 || musicnote == 30 || musicnote == 38 || musicnote == 44) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_FLUTE.get(), SoundSource.BLOCKS, 1f, 0.8f);
        } else if (musicnote == 8 || musicnote == 28 || musicnote == 34 || musicnote == 36 || musicnote == 42) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_FLUTE.get(), SoundSource.BLOCKS, 1f, 0.85f);
        } else if (musicnote == 16) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_FLUTE.get(), SoundSource.BLOCKS, 1f, 0.54f);
        } else if (musicnote == 2 || musicnote ==14 || musicnote == 20 || musicnote == 22 || musicnote == 48) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_FLUTE.get(), SoundSource.BLOCKS, 1f, 0.6f);
        }
            if (musicnote == 48) {
            musicnote = 0;
        }
        musicnote += 1;
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.studymod.sound_block"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}