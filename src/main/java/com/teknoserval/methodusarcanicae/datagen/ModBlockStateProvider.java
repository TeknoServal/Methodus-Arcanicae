package com.teknoserval.methodusarcanicae.datagen;

import com.teknoserval.methodusarcanicae.MethodusArcanicaeMod;
import com.teknoserval.methodusarcanicae.block.ModBlocks;
import com.teknoserval.methodusarcanicae.block.custom.RuneFrameBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MethodusArcanicaeMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GLITTERSTEEL_BLOCK);
        blockWithItem(ModBlocks.GLITTERING_DUST_BLOCK);
        blockWithItem(ModBlocks.GLITTERING_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_GLITTERING_ORE);
        runeFrame();
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void runeFrame() {
        getVariantBuilder(ModBlocks.RUNE_FRAME.get()).forAllStates(state -> {
            if (state.getValue(RuneFrameBlock.ACTIVE)) {
                return new ConfiguredModel[] {
                        new ConfiguredModel(models().cubeAll("rune_frame_active", new ResourceLocation(MethodusArcanicaeMod.MOD_ID, "block/rune_frame_active")).renderType("translucent"))
                };
            } else {
                return new ConfiguredModel[] {
                        new ConfiguredModel(models().cubeAll("rune_frame_inactive", new ResourceLocation(MethodusArcanicaeMod.MOD_ID, "block/rune_frame_inactive")).renderType("translucent"))
                };
            }
        });

        simpleBlockItem(ModBlocks.RUNE_FRAME.get(), models().cubeAll("rune_frame_active", new ResourceLocation(MethodusArcanicaeMod.MOD_ID, "block/rune_frame_active")));
    }
}
