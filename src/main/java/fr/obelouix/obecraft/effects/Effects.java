package fr.obelouix.obecraft.effects;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Effects {

    public static DeferredRegister<Effect> effects = DeferredRegister.create(ForgeRegistries.POTIONS, "obecraft");

    public static final RegistryObject<Effect> radiation = effects.register("radiation", () -> new RadiationEffect(EffectType.HARMFUL, net.minecraft.potion.Effects.POISON.getLiquidColor()));

}
