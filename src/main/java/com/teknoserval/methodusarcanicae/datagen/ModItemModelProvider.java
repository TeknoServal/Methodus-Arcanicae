package com.teknoserval.methodusarcanicae.datagen;

import com.teknoserval.methodusarcanicae.MethodusArcanicaeMod;
import com.teknoserval.methodusarcanicae.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MethodusArcanicaeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.GLITTERING_DUST.get());
        basicItem(ModItems.GLITTERSTEEL_INGOT.get());
        basicItem(ModItems.GLITTERING_WRENCH.get());
    }


}
