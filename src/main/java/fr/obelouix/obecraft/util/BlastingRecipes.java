package fr.obelouix.obecraft.util;

import fr.obelouix.obecraft.blocks.Blocks;
import fr.obelouix.obecraft.items.Items;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

public class BlastingRecipes extends RecipeProvider {

    public BlastingRecipes(DataGenerator generator) {
        super(generator);
    }
    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(
                Blocks.URANIUM_ORE.get().asItem()), Items.URANIUM.get(), 1.0f, 300)
                .addCriterion("uranium_ore", InventoryChangeTrigger.Instance.forItems(Blocks.URANIUM_ORE.get()))
                .build(consumer);

        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(
                net.minecraft.block.Blocks.OBSIDIAN.asItem()), Items.OBSIDIAN_INGOT.get(), 1.0f, 900)
                .addCriterion("obsidian", InventoryChangeTrigger.Instance.forItems(net.minecraft.block.Blocks.OBSIDIAN))
                .build(consumer);

    }

}
