package com.teknoserval.methodusarcanicae.datagen;

import com.teknoserval.methodusarcanicae.block.ModBlocks;
import com.teknoserval.methodusarcanicae.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLITTERING_WRENCH.get())
                .pattern("A A")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', ModItems.GLITTERSTEEL_INGOT.get())
                .unlockedBy("has_glittersteel",
                        inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GLITTERSTEEL_INGOT.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GLITTERSTEEL_INGOT.get())
                .requires(ModItems.GLITTERING_DUST.get())
                .requires(Items.IRON_INGOT)
                .unlockedBy("has_glittering_dust",
                        inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GLITTERING_DUST.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.GLITTERING_DUST.get(), RecipeCategory.MISC, ModBlocks.GLITTERING_DUST_BLOCK.get(),
                "methodusarcanicae:glittering_dust_block", null, "methodusarcanicae:glittering_dust", null);
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.GLITTERSTEEL_INGOT.get(), RecipeCategory.MISC, ModBlocks.GLITTERSTEEL_BLOCK.get(),
                "methodusarcanicae:glittersteel_block", null, "methodusarcanicae:glittersteel_ingot_from_block", null);
    }
}
