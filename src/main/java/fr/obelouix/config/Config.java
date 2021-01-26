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
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    private static boolean flatBedrock;
    private static boolean removeWorldTopBedrock;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPairCommon = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_SPEC = specPairCommon.getRight();
        COMMON = specPairCommon.getLeft();

        final Pair<ClientConfig, ForgeConfigSpec> specPairClient = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPairClient.getRight();
        CLIENT = specPairClient.getLeft();
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
        if(configEvent.getConfig().getSpec() == Config.CLIENT_SPEC){
            bakeClientConfig();
        }
    }

    public static void bakeCommonConfig() {
        flatBedrock = COMMON.getFlatBedrock().get();
        removeWorldTopBedrock = COMMON.getRemoveWorldTopBedrock().get();
    }

    public static void bakeClientConfig(){

    }

}
