package fr.obelouix.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {

    public static  final Item URANIUM  =  new UraniumItem(new Item.Settings().group(ItemGroup.MATERIALS));

    public static  void registerItems()
    {
        Registry.register(Registry.ITEM, new Identifier("obecraft", "uranium"), URANIUM);
    }

}
