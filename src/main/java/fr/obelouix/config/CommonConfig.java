package fr.obelouix.config;

import fr.obelouix.obecraft.Obecraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class CommonConfig {

    private final BooleanValue flatBedrock;
    private final BooleanValue removeWorldTopBedrock;
//    private final BooleanValue removeSurfaceLavaLakes;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
        builder.push("World generation");
        flatBedrock = builder.comment("Generate bedrock only on one layer (Does not require a game restart)")
                .translation(Obecraft.MODID + ".config.common." + "flatBedrock")
                .define("flatBedrock", true);
        removeWorldTopBedrock = builder.comment("remove the bedrock on the top of the world (e.g nether world)\n" +
                "This only work with flatBedrock enabled (Does not require a game restart)")
                .translation(Obecraft.MODID + ".config.common." + "removeWorldTopBedrock")
                .define("removeWorldTopBedrock", false);
     /*   removeSurfaceLavaLakes = builder.comment("Remove surface lava lakes")
        .translation(Obecraft.MODID + "config.common" + "removeSurfaceLavaLake")
        .define("removeSurfaceLavaLake", true);*/

        builder.pop();
    }

    public BooleanValue getRemoveWorldTopBedrock() {
        return removeWorldTopBedrock;
    }

    public BooleanValue getFlatBedrock() {
        return flatBedrock;
    }

/*    public BooleanValue getRemoveSurfaceLavaLake() {
        return removeSurfaceLavaLakes;
    }*/
}
