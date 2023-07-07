package com.teknoserval.methodusarcanicae.item.custom;

import com.teknoserval.methodusarcanicae.block.ModBlocks;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class GlitteringWrenchItem extends Item {
    public GlitteringWrenchItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            BlockState blockState = pContext.getLevel().getBlockState(positionClicked);

            if (isWrenchableBlock(blockState)) {
                wrenchBlock(blockState, player);
            }

            return InteractionResult.SUCCESS;
        }

        return super.useOn(pContext);
    }

    private void wrenchBlock(BlockState blockState, Player player) {
        // TODO: 7/7/2023 actually make a wrench thing

        player.sendSystemMessage(Component.literal(I18n.get(blockState.getBlock().getDescriptionId()) + Component.translatable("item.methodusarcanicae.glittering_wrench.wrenched").getString()));
    }

    private boolean isWrenchableBlock(BlockState blockState) {
        return blockState.is(ModBlocks.GLITTERSTEEL_BLOCK.get());
    }
}
