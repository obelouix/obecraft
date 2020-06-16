package fr.obelouix.obecraft.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class RadiationEffect extends Effect {
    protected RadiationEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
        new EffectInstance(net.minecraft.potion.Effects.POISON, 20, 1);
    }
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if(this == Effects.radiation.get())
        {
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 2.0F);
        }
    }

}
