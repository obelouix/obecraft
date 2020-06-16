package fr.obelouix.obecraft.util;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.obelouix.obecraft.blocks.Blocks;
import fr.obelouix.obecraft.items.Items;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.criterion.ImpossibleTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class BlastingRecipes extends RecipeProvider {

    public BlastingRecipes(DataGenerator generator) {
        super(generator);
    }
    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(
                Blocks.URANIUM_ORE.get().asItem()), Items.uranium.get(), 1.0f, 300)
                .addCriterion("uranium_ore", InventoryChangeTrigger.Instance.forItems(Blocks.URANIUM_ORE.get()))
                .build(consumer);
    }

}
