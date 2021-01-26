package fr.obelouix.mixin.gui;

import fr.obelouix.config.Config;
import net.minecraft.client.gui.recipebook.AbstractRecipeBookGui;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AbstractFurnaceScreen.class)
@OnlyIn(Dist.CLIENT)
public abstract class AbstractFurnaceScreenMixin<T extends AbstractFurnaceContainer> extends ContainerScreen<T> implements IRecipeShownListener {

    @Shadow @Final
    private static final ResourceLocation BUTTON_TEXTURE = new ResourceLocation("textures/gui/recipe_button.png");
    @Shadow @Final
    public AbstractRecipeBookGui recipeGui;
    private boolean widthTooNarrowIn;
    @Shadow @Final
    private ResourceLocation guiTexture;

    public AbstractFurnaceScreenMixin(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Overwrite
    public void init() {
        super.init();
        this.widthTooNarrowIn = this.width < 379;
        this.recipeGui.init(this.width, this.height, this.minecraft, this.widthTooNarrowIn, this.container);
        this.guiLeft = this.recipeGui.updateScreenPosition(this.widthTooNarrowIn, this.width, this.xSize);
        if(!Config.isRemoveRecipeButton()){
            this.addButton(new ImageButton(this.guiLeft + 20, this.height / 2 - 49, 20, 18, 0, 0, 19, BUTTON_TEXTURE, (button) -> {
                this.recipeGui.initSearchBar(this.widthTooNarrowIn);
                this.recipeGui.toggleVisibility();
                this.guiLeft = this.recipeGui.updateScreenPosition(this.widthTooNarrowIn, this.width, this.xSize);
                ((ImageButton)button).setPosition(this.guiLeft + 20, this.height / 2 - 49);
            }));
        }

        this.titleX = (this.xSize - this.font.getStringPropertyWidth(this.title)) / 2;
    }

}
