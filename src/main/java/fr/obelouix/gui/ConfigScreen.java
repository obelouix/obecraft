package fr.obelouix.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.obelouix.config.Config;
import fr.obelouix.obecraft.Obecraft;
import net.minecraft.client.AbstractOption;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ToggleWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.widget.list.OptionsRowList;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.BooleanOption;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Objects;

public class ConfigScreen extends Screen {

    /** The parent screen of this screen */
    private final Screen parentScreen;
    /** Distance from top of the screen to this GUI's title */
    private static final int TITLE_HEIGHT = 8;
    /** Distance from top of the screen to the options row list's top */
    private static final int OPTIONS_LIST_TOP_HEIGHT = 24;
    /** Distance from bottom of the screen to the options row list's bottom */
    private static final int OPTIONS_LIST_BOTTOM_OFFSET = 32;
    /** Height of each item in the options row list */
    private static final int OPTIONS_LIST_ITEM_HEIGHT = 25;
    /** Width of a button */
    private static final int BUTTON_WIDTH = 200;
    /** Height of a button */
    private static final int BUTTON_HEIGHT = 20;
    /** Distance from bottom of the screen to the "Done" button's top */
    private static final int DONE_BUTTON_TOP_OFFSET = 26;
    private OptionsRowList optionsRowList;

    public ConfigScreen(Screen parentScreen) {
        super(new TranslationTextComponent("obecraft.configGUI.title", Obecraft.MODID));
        this.parentScreen = parentScreen;
    }

    @Override
    protected void init() {
        this.optionsRowList = new OptionsRowList(this.minecraft,
                this.width, this.height, OPTIONS_LIST_TOP_HEIGHT,
                OPTIONS_LIST_BOTTOM_OFFSET, OPTIONS_LIST_ITEM_HEIGHT);

        this.optionsRowList.addOption(new BooleanOption("obecraft.configGUI.flatbedrock.title",
        unused -> Config.isFlatBedrock(), (unused, newvalue) -> Config.setFlatBedrock(newvalue)));


        this.children.add(optionsRowList);
        this.addButton(new Button((this.width - BUTTON_WIDTH ) / 2,
                this.height - DONE_BUTTON_TOP_OFFSET,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                new TranslationTextComponent("gui.done"),
                button -> this.closeScreen()));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        drawCenteredString(matrixStack,this.font, this.title, this.width/2, TITLE_HEIGHT, 0xFFFFFF);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public void closeScreen() {
       // ModSettings.save();
        // Display the parent screen
        this.minecraft.displayGuiScreen(parentScreen);
    }
}
