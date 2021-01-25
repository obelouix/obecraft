package fr.obelouix.config;

import fr.obelouix.obecraft.Obecraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = Obecraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;
    private static boolean flatBedrock;
    private static boolean removeWorldTopBedrock;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static boolean isRemoveWorldTopBedrock() {
        return removeWorldTopBedrock;
    }

    public static boolean isFlatBedrock() {
        return flatBedrock;
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == Config.COMMON_SPEC) {
            bakeCommonConfig();
        }
    }

    public static void bakeCommonConfig() {
        flatBedrock = COMMON.getFlatBedrock().get();
        removeWorldTopBedrock = COMMON.getRemoveWorldTopBedrock().get();
    }

}
