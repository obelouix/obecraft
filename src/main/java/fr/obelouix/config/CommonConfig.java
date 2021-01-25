package fr.obelouix.config;

import fr.obelouix.obecraft.Obecraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class CommonConfig {

    private final BooleanValue flatBedrock;
    private final BooleanValue removeWorldTopBedrock;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
        builder.push("World generation");
        flatBedrock = builder.comment("Generate bedrock only on one layer")
                .translation(Obecraft.MODID + ".config.common." + "flatBedrock")
                .define("flatBedrock", true);
        removeWorldTopBedrock = builder.comment("remove the bedrock on the top of the world (e.g nether world)\n" +
                "This only work with flatBedrock enabled")
                .translation(Obecraft.MODID + ".config.common." + "removeWorldTopBedrock")
                .define("removeWorldTopBedrock", true);

        builder.pop();
    }

    public BooleanValue getRemoveWorldTopBedrock() {
        return removeWorldTopBedrock;
    }

    public BooleanValue getFlatBedrock() {
        return flatBedrock;
    }
}
