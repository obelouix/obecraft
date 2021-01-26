package fr.obelouix.config;

import fr.obelouix.obecraft.Obecraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import net.minecraftforge.fml.ModList;

public class ClientConfig {

    private final BooleanValue removeRecipeButton;

    public ClientConfig(ForgeConfigSpec.Builder builder){
        removeRecipeButton = builder.comment("Hide the recipe button everywhere  (Does not require a game restart)")
                .translation(Obecraft.MODID + ".config.client." + "removeRecipeButton")
                //set default value to true if jei is loaded else set it to false
                .define("removeRecipeButton", ModList.get().isLoaded("jei"));
    }

    public BooleanValue getRemoveRecipeButton() {
        return removeRecipeButton;
    }
}
