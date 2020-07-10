package fr.obelouix.obecraft.mixins;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.overlay.DebugOverlayGui;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Objects;

@Mixin(DebugOverlayGui.class)
public abstract class DebugOverlay extends AbstractGui {

    @Shadow @Final private Minecraft mc;

    @Shadow protected abstract void func_238509_a_(MatrixStack matrixStack, FrameTimer frameTimer, int p_238509_3_, int p_238509_4_, boolean p_238509_5_);


    /**
     * @author obelouix
     */
    @Overwrite
    public void render(MatrixStack matrixStack)
    {
        this.mc.getProfiler().startSection("debug");
        this.renderDebugInfoLeft(matrixStack);
        int i = this.mc.getMainWindow().getScaledWidth();
        this.func_238509_a_(matrixStack, this.mc.getFrameTimer(), 0,  i/2, true);
        this.mc.getProfiler().endSection();
    }


    /**
     * @author obelouix
     */
    @Overwrite
    protected void renderDebugInfoLeft(MatrixStack matrixStack)
    {
        List<String> list  = this.getDebugInfoLeft();

    }

    /**
     * @author obelouix
     * -Dforge.logging.console.level=debug -Dforge.logging.markers=SCAN,REGISTRIES,REGISTRYDUMP
     */
    @Overwrite
    protected List<String> getDebugInfoLeft() {

        List<String> list = Lists.newArrayList("Minecraft " + TextFormatting.GREEN + SharedConstants.getVersion().getName()
                + TextFormatting.DARK_GREEN + " (" + ClientBrandRetriever.getClientModName() + ")");

        BlockPos blockpos = Objects.requireNonNull(this.mc.getRenderViewEntity()).func_233580_cy_();

        int fps = Integer.parseInt(this.mc.debug.substring(0, 2).replaceAll("\\s+",""));
        String stringFPS = fps + " fps" + TextFormatting.RESET + this.mc.debug.substring(7).replaceFirst("T:", "graphics: ");
        if(fps < 30)
        {
            stringFPS = TextFormatting.RED + stringFPS;
        }
        else
        {
            stringFPS = TextFormatting.GREEN + stringFPS;
        }

        list.add(stringFPS);
        String coords = TextFormatting.RED + "X" + TextFormatting.GREEN + "Y" + TextFormatting.DARK_AQUA + "Z"
                + TextFormatting.RESET + ": "
                + TextFormatting.RED + "%.3f"
                + TextFormatting.RESET + " / "
                + TextFormatting.GREEN + "%.3f"
                + TextFormatting.RESET + " / "
                + TextFormatting.DARK_AQUA + "%.3f";

        list.add("");

        list.add(String.format(coords, Objects.requireNonNull(this.mc.getRenderViewEntity()). getPosX(), this.mc.getRenderViewEntity().getPosY(), this.mc.getRenderViewEntity().getPosZ()));
        list.add(String.format(TextFormatting.GOLD + "Block: " +TextFormatting.RED + "%d " + TextFormatting.GREEN + "%d " + TextFormatting.DARK_AQUA + "%d",
                blockpos.getX(), blockpos.getY(), blockpos.getZ() ));


        return list;
    }
}
