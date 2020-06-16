package fr.obelouix.obecraft.util;

import fr.obelouix.obecraft.blocks.Blocks;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        //Will be removed later , only used it for exampler
        ShapedRecipeBuilder.shapedRecipe(Blocks.URANIUM_ORE.get())
                .patternLine("xxx")
                .patternLine("x#x")
                .patternLine("xxx")
                .key('x', net.minecraft.block.Blocks.COBBLESTONE)
                .key('#', Tags.Items.DYES_RED)
                .setGroup("obecraft")
                .addCriterion("cobblestone", InventoryChangeTrigger.Instance.forItems(net.minecraft.block.Blocks.COBBLESTONE))
                .build(consumer);
    }
}
