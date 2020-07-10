package fr.obelouix.obecraft.groups;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class ItemGroup extends net.minecraft.item.ItemGroup {
    public ItemGroup(int i, String label) {
        super(label);
    }

    public  static net.minecraft.item.ItemGroup[] GROUPS = new net.minecraft.item.ItemGroup[2000];
    public  static  final  ItemGroup LAMPS = (new ItemGroup(0, "lamps") {
        @Override @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Blocks.PUMPKIN);
        }
    });
}
