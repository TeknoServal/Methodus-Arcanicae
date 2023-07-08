package com.teknoserval.methodusarcanicae.datagen;

import com.teknoserval.methodusarcanicae.MethodusArcanicaeMod;
import com.teknoserval.methodusarcanicae.block.ModBlocks;
import com.teknoserval.methodusarcanicae.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MethodusArcanicaeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.WRENCHABLE)
                .add(ModBlocks.GLITTERSTEEL_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GLITTERSTEEL_BLOCK.get(),
                        ModBlocks.DEEPSLATE_GLITTERING_ORE.get(),
                        ModBlocks.GLITTERING_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GLITTERSTEEL_BLOCK.get(),
                        ModBlocks.DEEPSLATE_GLITTERING_ORE.get(),
                        ModBlocks.GLITTERING_ORE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
