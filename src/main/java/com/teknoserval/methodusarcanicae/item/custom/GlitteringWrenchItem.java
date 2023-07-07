package com.teknoserval.methodusarcanicae.item.custom;

import com.teknoserval.methodusarcanicae.block.attributes.Wrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
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
            BlockPos pos = pContext.getClickedPos();

            BlockState blockState = pContext.getLevel().getBlockState(pos);

            if (isWrenchableBlock(blockState) && pContext.getPlayer().isCrouching()) {
                wrenchBlock(pos, pContext.getLevel());

                return InteractionResult.SUCCESS;
            }
        }

        return super.useOn(pContext);
    }

    private void wrenchBlock(BlockPos pos, Level world) {
        world.destroyBlock(pos, true);
    }

    private boolean isWrenchableBlock(BlockState blockState) {
        return blockState.getBlock().getClass().isAnnotationPresent(Wrenchable.class);
    }
}
