package dev.jadeposting.gatekeep.mixins;

import net.minecraft.client.multiplayer.ClientPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin_RemoveToast {
    @Inject(
        method = "handleLogin",
        at = @At(
            value = "INVOKE", target = "Lnet/minecraft/client/gui/components/toasts/ToastComponent;addToast(Lnet/minecraft/client/gui/components/toasts/Toast;)V",
            shift = At.Shift.BEFORE
        ),
        cancellable = true)
    private void removeToast(CallbackInfo ci) {
        ci.cancel();
    }
}
