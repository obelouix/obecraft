package fr.obelouix.obecraft.fix;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = "obecraft")
public class Anvil {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        // need this one too since MC doesn't fire AnvilRepairEvent when the
        // player shift-clicks apparently
        resetRepairValue(event.getLeft());
        resetRepairValue(event.getRight());
    }

    @SubscribeEvent
    public void onAnvilUpdate(AnvilRepairEvent event) {
        resetRepairValue(event.getItemResult());
    }

    private static void resetRepairValue(ItemStack stack) {
        if (!stack.isEmpty() && stack.hasTag()) {
            Objects.requireNonNull(stack.getTag()).remove("RepairCost");
        }
    }

}
