package fr.obelouix.mixin.container.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WorkbenchContainer.class)
public abstract class WorkbenchContainerMixin extends RecipeBookContainer<CraftingInventory> {

    public WorkbenchContainerMixin(ContainerType<?> type, int id) {
        super(type, id);
    }

    /**
     * @author
     */
    @Overwrite
    public boolean canInteractWith(PlayerEntity playerIn) {
        if((!playerIn.isSwimming() || !playerIn.isSprinting()) && playerIn.isAlive()) return true;
        return false;
    }
}
