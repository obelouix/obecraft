package fr.obelouix.obecraft.util;

import fr.obelouix.obecraft.items.Items;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapedRecipeBuilder.shapedRecipe(Items.IRON_STICK.get())
                .patternLine(" S ")
                .patternLine(" S ")
                .key('S', Items.IRON_STICK.get())
                .addCriterion("iron_ingot",InventoryChangeTrigger.Instance.forItems(net.minecraft.item.Items.IRON_INGOT))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(Items.OBSIDIAN_PICKAGE.get())
                .patternLine("OOO")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('O', Items.OBSIDIAN_INGOT.get())
                .key('S', Items.IRON_STICK.get())
                .addCriterion("obsidian", InventoryChangeTrigger.Instance.forItems(net.minecraft.block.Blocks.OBSIDIAN))
                .build(consumer);

    }
}
