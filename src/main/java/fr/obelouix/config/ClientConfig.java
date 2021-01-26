package fr.obelouix.config;

import fr.obelouix.obecraft.Obecraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;

public class ClientConfig {

    private final BooleanValue removeRecipeButton;

    public ClientConfig(ForgeConfigSpec.Builder builder){
        removeRecipeButton = builder.comment("Hide the recipe button everywhere")
                .translation(Obecraft.MODID + ".config.client." + "removeRecipeButton")
                .define("removeRecipeButton", false);
    }

    public BooleanValue getRemoveRecipeButton() {
        return removeRecipeButton;
    }
}
