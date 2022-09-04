package me.jarva.revert_brain_change.mixin;

import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.Memory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Map;

@Mixin(Brain.class)
public class BrainMixin {
    @Inject(method = "tickMemories", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/brain/Memory;isExpired()Z", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void mixinInject(CallbackInfo ci, Iterator<?> var1, Map.Entry<?, ?> entry, Memory<?> memory) {
        memory.tick();
    }

    @Redirect(method = "tickMemories", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/brain/Memory;tick()V"))
    private void mixinTick(Memory<?> instance) {
    }
}
