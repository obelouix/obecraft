package fr.obelouix.obecraft.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

public class ItemPickaxe extends PickaxeItem {
    public ItemPickaxe(IItemTier material, float v, float speed, Properties properties) {
        super(material, 1, speed, new Properties().group(ItemGroup.TOOLS).addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }
}
