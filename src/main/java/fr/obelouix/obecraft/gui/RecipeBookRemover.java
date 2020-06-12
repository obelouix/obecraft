package fr.obelouix.obecraft.gui;

import net.minecraft.client.gui.recipebook.RecipeBookGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;
import java.util.List;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class RecipeBookRemover {

    @SubscribeEvent
    public static void OnGuiScreenEvent(final GuiScreenEvent.InitGuiEvent.Post event)
    {
        final List<Widget> widgetList = event.getWidgetList();
        for(final Widget widget: widgetList)
        {
            if(widget instanceof ImageButton && widget.visible)
            {
                final ImageButton imageButton = (ImageButton)widget;
                if(!"minecraft:textures/gui/recipe_button.png".equals(imageButton.toString()))
                {
                    continue;
                }
                widget.visible = false;
            }
        }
        final Screen screen = event.getGui();
        if (screen instanceof ContainerScreen) {
            final ContainerScreen<?> containerScreen = (ContainerScreen<?>)screen;
            boolean widthTooNarrow = false;
            if (containerScreen instanceof InventoryScreen) {
                final InventoryScreen inventoryScreen = (InventoryScreen)containerScreen;
                widthTooNarrow = true;
            }
            else if (screen instanceof CraftingScreen) {
                final CraftingScreen craftingScreen = (CraftingScreen)containerScreen;
                widthTooNarrow = false;
            }
            else if (screen instanceof AbstractFurnaceScreen) {
                final AbstractFurnaceScreen<?> furnaceScreen = (AbstractFurnaceScreen<?>)containerScreen;
                widthTooNarrow = false;
            }
            for (Class<?> class_ = screen.getClass(); class_ != Screen.class; class_ = class_.getSuperclass()) {
                final Field[] declaredFields;
                final Field[] fields = declaredFields = class_.getDeclaredFields();
                for (final Field field : declaredFields) {
                    if (RecipeBookGui.class.isAssignableFrom(field.getType())) {
                        try {
                            field.setAccessible(true);
                            final RecipeBookGui gui = (RecipeBookGui)field.get(screen);
                           /* if (gui != null && gui. != null && gui.field_193022_s != null && gui.field_193022_s.field_194202_c != null && gui.func_191878_b()) {
                                gui.func_191866_a();
                                containerScreen.field_147003_i = gui.func_193011_a(widthTooNarrow, screen.width, containerScreen.field_146999_f);
                            }*/
                        }
                        catch (IllegalAccessException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
