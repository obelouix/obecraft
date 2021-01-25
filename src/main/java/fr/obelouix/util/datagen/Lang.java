package fr.obelouix.util.datagen;

import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.data.LanguageProvider;

public class Lang extends LanguageProvider
{
    public Lang(DataGenerator gen)
    {
        super(gen, "obecraft", "en_us");
    }

    @Override
    protected void addTranslations()
    {
        add(Blocks.STONE, "Stone");
        add(Items.DIAMOND, "Diamond");
        //add(Biomes.BEACH, "Beach");
        add(Effects.POISON, "Poison");
        add(Enchantments.SHARPNESS, "Sharpness");
        add(EntityType.CAT, "Cat");
        add("obecraft" + ".test.unicode", "\u0287s\u01DD\u2534 \u01DDpo\u0254\u1D09u\u2229");
    }
}