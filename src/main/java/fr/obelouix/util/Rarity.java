package fr.obelouix.util;

import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

public enum  Rarity {

    GREEN(Formatting.GREEN);

    public final Formatting formatting;

    private Rarity(Formatting formatting) {
        this.formatting = formatting;
    }
}
