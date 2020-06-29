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

        ShapedRecipeBuilder.shapedRecipe(Items.OBSIDIAN_PICKAGE.get())
                .patternLine("OOO")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('O', net.minecraft.block.Blocks.OBSIDIAN)
                .key('S', net.minecraft.item.Items.STICK)
                .addCriterion("obsidian", InventoryChangeTrigger.Instance.forItems(net.minecraft.block.Blocks.OBSIDIAN))
                .build(consumer);

    }
}
