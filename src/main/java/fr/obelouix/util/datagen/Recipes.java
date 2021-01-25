package fr.obelouix.util.datagen;

import fr.obelouix.registries.ItemRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.crafting.ConditionalAdvancement;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider implements IConditionBuilder
{
    public Recipes(DataGenerator gen)
    {
        super(gen);
    }

    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ResourceLocation ID = new ResourceLocation("obecraft", "conditional");

        ConditionalRecipe.builder()
                .addCondition(
                        and(
                                not(modLoaded("minecraft")),
                                itemExists("minecraft", "dirt"),
                                FALSE()
                        )
                )
                .addRecipe(
                        ShapedRecipeBuilder.shapedRecipe(Blocks.DIAMOND_BLOCK, 64)
                                .patternLine("XXX")
                                .patternLine("XXX")
                                .patternLine("XXX")
                                .key('X', Blocks.DIRT)
                                .setGroup("")
                                .addCriterion("has_dirt", hasItem(Blocks.DIRT)) // DUMMY: Necessary, but not used when a custom advancement is provided through setAdvancement
                                ::build
                )
                .setAdvancement(ID,
                        ConditionalAdvancement.builder()
                                .addCondition(
                                        and(
                                                not(modLoaded("minecraft")),
                                                itemExists("minecraft", "dirt"),
                                                FALSE()
                                        )
                                )
                                .addAdvancement(
                                        Advancement.Builder.builder()
                                                .withParentId(new ResourceLocation("minecraft", "root"))
                                                .withDisplay(Blocks.DIAMOND_BLOCK,
                                                        new StringTextComponent("Dirt2Diamonds"),
                                                        new StringTextComponent("The BEST crafting recipe in the game!"),
                                                        null, FrameType.TASK, false, false, false
                                                )
                                                .withRewards(AdvancementRewards.Builder.recipe(ID))
                                                .withCriterion("has_dirt", hasItem(Blocks.DIRT))
                                )
                )
                .build(consumer, ID);

        ConditionalRecipe.builder()
                .addCondition(
                        not(
                                and(
                                        not(modLoaded("minecraft")),
                                        itemExists("minecraft", "dirt"),
                                        FALSE()
                                )
                        )
                )
                .addRecipe(
                        ShapedRecipeBuilder.shapedRecipe(Blocks.DIAMOND_BLOCK, 64)
                                .patternLine("XXX")
                                .patternLine("XXX")
                                .patternLine("XXX")
                                .key('X', Blocks.DIRT)
                                .setGroup("")
                                .addCriterion("has_dirt", hasItem(Blocks.DIRT))
                                ::build
                )
                .generateAdvancement()
                .build(consumer, new ResourceLocation("obecraft", "conditional2"));
    }
}
