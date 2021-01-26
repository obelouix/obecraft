package fr.obelouix.mixin.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.obelouix.config.Config;
import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraft.client.gui.recipebook.RecipeBookGui;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(InventoryScreen.class)
@OnlyIn(Dist.CLIENT)
public class InventoryScreenMixin extends DisplayEffectsScreen<PlayerContainer> implements IRecipeShownListener {

    @Shadow
    private static final ResourceLocation RECIPE_BUTTON_TEXTURE = new ResourceLocation("textures/gui/recipe_button.png");
    @Shadow
    @Final
    private final RecipeBookGui recipeBookGui = new RecipeBookGui();
    @Shadow
    private boolean removeRecipeBookGui;
    @Shadow
    private boolean widthTooNarrow;
    @Shadow
    private boolean buttonClicked;

    public InventoryScreenMixin(PlayerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Shadow
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {

    }

    @Shadow
    public void recipesUpdated() {

    }

    @Shadow
    public RecipeBookGui getRecipeGui() {
        return this.recipeBookGui;
    }

    @Overwrite
    protected void init() {
        if (this.minecraft.playerController.isInCreativeMode()) {
            this.minecraft.displayGuiScreen(new CreativeScreen(this.minecraft.player));
        } else {
            super.init();
            this.widthTooNarrow = this.width < 379;
            this.recipeBookGui.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.container);
            this.removeRecipeBookGui = true;
            this.guiLeft = this.recipeBookGui.updateScreenPosition(this.widthTooNarrow, this.width, this.xSize);
            if(!Config.isRemoveRecipeButton()) {
                this.children.add(this.recipeBookGui);
                this.setFocusedDefault(this.recipeBookGui);
                this.addButton(new ImageButton(this.guiLeft + 104, this.height / 2 - 22, 20, 18, 0, 0, 19, RECIPE_BUTTON_TEXTURE, (button) -> {
                    this.recipeBookGui.initSearchBar(this.widthTooNarrow);
                    this.recipeBookGui.toggleVisibility();
                    this.guiLeft = this.recipeBookGui.updateScreenPosition(this.widthTooNarrow, this.width, this.xSize);
                    ((ImageButton)button).setPosition(this.guiLeft + 104, this.height / 2 - 22);
                    this.buttonClicked = true;
                }));
            }

        }
    }

}
