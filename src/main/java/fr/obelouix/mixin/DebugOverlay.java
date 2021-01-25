package fr.obelouix.mixin;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.datafixers.DataFixUtils;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.overlay.DebugOverlayGui;
import net.minecraft.client.settings.CloudOption;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.network.NetworkManager;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.util.Direction;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.lighting.WorldLightManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.WorldEntitySpawner;
import org.apache.commons.math3.util.Precision;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mixin(DebugOverlayGui.class)
public abstract class DebugOverlay extends AbstractGui {

    @Shadow
    @Final
    private Minecraft mc;

    @Shadow
    protected abstract void func_238509_a_(MatrixStack matrixStack, FrameTimer frameTimer, int p_238509_3_, int p_238509_4_, boolean p_238509_5_);


    /**
     * @author obelouix
     */
    @Overwrite
    public void render(MatrixStack matrixStack) {
        this.mc.getProfiler().startSection("debug");
        this.renderDebugInfoLeft(matrixStack);
        int i = this.mc.getMainWindow().getScaledWidth();
        this.func_238509_a_(matrixStack, this.mc.getFrameTimer(), 0, i / 2, true);
        this.mc.getProfiler().endSection();
    }


    /**
     * @author obelouix
     */
    @Overwrite
    protected void renderDebugInfoLeft(MatrixStack matrixStack) {
        List<String> list = this.getDebugInfoLeft();

    }

    /**
     * @author obelouix
     * -Dforge.logging.console.level=debug -Dforge.logging.markers=SCAN,REGISTRIES,REGISTRYDUMP
     */
    @Overwrite
    protected List<String> getDebugInfoLeft() {

        IntegratedServer integratedserver = this.mc.getIntegratedServer();
        NetworkManager networkmanager = this.mc.getConnection().getNetworkManager();
        float packetsSent = networkmanager.getPacketsSent();
        float packetsReceived = networkmanager.getPacketsReceived();

        List<String> list = Lists.newArrayList("Minecraft " + TextFormatting.GREEN + SharedConstants.getVersion().getName()
                + TextFormatting.DARK_GREEN + " (" + ClientBrandRetriever.getClientModName() + ")");

        int fps = Integer.parseInt(this.mc.debug.substring(0, 2).replaceAll("\\s+", ""));
        String stringFPS = this.mc.debug.replace("fps", "FPS").replace("T:", TextFormatting.RESET + "Target: ");

        if (fps < 10) stringFPS = stringFPS.substring(0, 6);
        if (fps > 9 && fps < 100) stringFPS = stringFPS.substring(0, 7);
        if (fps > 99) stringFPS = stringFPS.substring(0, 8);
        if (fps < 30) {
            stringFPS = TextFormatting.RED + stringFPS;
        } else if (fps >= 30) {
            stringFPS = TextFormatting.GREEN + stringFPS;
        }

        if (this.mc.gameSettings.framerateLimit == 260) {
            stringFPS += TextFormatting.GOLD + " Target: unlimited";
        } else {
            stringFPS += TextFormatting.GOLD + " Target: " + this.mc.gameSettings.framerateLimit;
        }

        stringFPS += TextFormatting.RESET + (this.mc.gameSettings.vsync ? " vsync " : " ")
                + this.mc.gameSettings.graphicFanciness
                + (this.mc.gameSettings.cloudOption == CloudOption.OFF ? "" : (this.mc.gameSettings.cloudOption == CloudOption.FAST ? " fast-clouds" : " fancy-clouds ")
                + "Biome blend radius: " + this.mc.gameSettings.biomeBlendRadius);
        list.add(stringFPS);

        if (integratedserver != null) {
            list.set(0, list.get(0) + TextFormatting.RESET + " | (integrated server) " + TextFormatting.AQUA + integratedserver.getServerModName() + " " + integratedserver.getMinecraftVersion());
            list.add("Tick time: " + Precision.round(integratedserver.getTickTime(), 3) + " ms");
        } else {
            list.set(0, list.get(0) + TextFormatting.RESET + " | (server) " + TextFormatting.AQUA + this.mc.player.getServerBrand() + " " + this.mc.player.getServer().getMinecraftVersion());
        }
        list.add("Packets (Sent/Received): " + Math.round(packetsSent) + "/" + Math.round(packetsReceived));

        BlockPos blockpos = Objects.requireNonNull(this.mc.getRenderViewEntity().getPosition());
        World world = this.getWorld();

        String coords = TextFormatting.RED + "X" + TextFormatting.GREEN + "Y" + TextFormatting.DARK_AQUA + "Z"
                + TextFormatting.RESET + ": "
                + TextFormatting.RED + "%.3f"
                + TextFormatting.RESET + " / "
                + TextFormatting.GREEN + "%.3f"
                + TextFormatting.RESET + " / "
                + TextFormatting.DARK_AQUA + "%.3f";

        list.add(String.format(coords, Objects.requireNonNull(this.mc.getRenderViewEntity()).getPosX(), this.mc.getRenderViewEntity().getPosY(), this.mc.getRenderViewEntity().getPosZ()));
        list.add(String.format(TextFormatting.GOLD + "Block: " + TextFormatting.RED + "%d " + TextFormatting.GREEN + "%d " + TextFormatting.DARK_AQUA + "%d",
                blockpos.getX(), blockpos.getY(), blockpos.getZ()));

        int skyLight = Objects.requireNonNull(this.mc.world).getLightFor(LightType.SKY, blockpos);
        int blockLight = this.mc.world.getLightFor(LightType.BLOCK, blockpos);
        String stringSkylight = String.valueOf((skyLight < 8) ? TextFormatting.RED : TextFormatting.GREEN) + skyLight;
        String stringBlockLight = String.valueOf((blockLight < 8) ? TextFormatting.RED : TextFormatting.GREEN) + blockLight;

        list.add("Client Light:" + " (sky: " + stringSkylight + TextFormatting.RESET + ", block: " + stringBlockLight + TextFormatting.RESET + ")");

        WorldLightManager worldlightmanager = world.getChunkProvider().getLightManager();
        list.add("Server Light: (" + "sky: " + ((worldlightmanager.getLightEngine(LightType.SKY).getLightFor(blockpos) < 8) ? TextFormatting.RED : TextFormatting.GREEN)
                + worldlightmanager.getLightEngine(LightType.SKY).getLightFor(blockpos)
                + TextFormatting.RESET + ", block: "
                + (worldlightmanager.getLightEngine(LightType.BLOCK).getLightFor(blockpos) < 8 ? TextFormatting.RED : TextFormatting.GREEN)
                + worldlightmanager.getLightEngine(LightType.BLOCK).getLightFor(blockpos)
                + TextFormatting.RESET + ")");

        Entity entity = this.mc.getRenderViewEntity();
        Direction direction = entity.getHorizontalFacing();
        String stringFacingDirection = "Looking towards ";

        switch (direction) {
            case NORTH:
                stringFacingDirection += TextFormatting.DARK_RED + "Negative " + TextFormatting.DARK_AQUA + "Z";
                break;
            case SOUTH:
                stringFacingDirection += TextFormatting.DARK_GREEN + "Positive " + TextFormatting.DARK_AQUA + "Z";
                break;
            case WEST:
                stringFacingDirection += TextFormatting.DARK_RED + "Negative " + TextFormatting.RED + "X";
                break;
            case EAST:
                stringFacingDirection += TextFormatting.DARK_GREEN + "Positive " + TextFormatting.RED + "X";
                break;
        }
        list.add(stringFacingDirection);

        World playerEntityWorld = this.mc.player.getEntityWorld();
        String biome = playerEntityWorld.getBiome(this.mc.player.getPosition()).getRegistryName().toString();
        String biomeMod = "(" + biome.substring(0, biome.indexOf(":")) + ")";
        biome = biome.substring(biome.indexOf(":") + 1);
        list.add(TextFormatting.DARK_PURPLE + "Biome: " + biome.substring(0, 1).toUpperCase() + biome.substring(1)  + " "+ biomeMod);
        list.add("World difficulty: " + playerEntityWorld.getWorldInfo().getDifficulty().toString().toLowerCase());
        ServerWorld serverworld = integratedserver.getWorld(this.mc.world.getDimensionKey());
        WorldEntitySpawner.EntityDensityManager worldentityspawner$entitydensitymanager = serverworld.getChunkProvider().func_241101_k_();
        if (worldentityspawner$entitydensitymanager != null) {
            Object2IntMap<EntityClassification> object2intmap = worldentityspawner$entitydensitymanager.func_234995_b_();
            int l = worldentityspawner$entitydensitymanager.func_234988_a_();
            list.add("SC: " + l + ", " + Stream.of(EntityClassification.values()).map((p_238511_1_)
                    -> Character.toUpperCase(p_238511_1_.getName().charAt(0)) + ": " + object2intmap.getInt(p_238511_1_)).collect(Collectors.joining(", ")));

        }
        return list;
    }

    protected World getWorld() {
        return DataFixUtils.orElse(Optional.ofNullable(this.mc.getIntegratedServer()).flatMap((p_212917_1_)
                -> Optional.ofNullable(p_212917_1_.getWorld(Objects.requireNonNull(this.mc.world).getDimensionKey()))), this.mc.world);
    }
}