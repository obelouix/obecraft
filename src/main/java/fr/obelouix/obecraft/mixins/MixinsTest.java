package fr.obelouix.obecraft.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinsTest {
    @Inject(method = "runTick", at = @At(value = "HEAD"))
    private void startClient(CallbackInfo ci) {
        //System.out.println("TemplateClient Working!");
    }
}
