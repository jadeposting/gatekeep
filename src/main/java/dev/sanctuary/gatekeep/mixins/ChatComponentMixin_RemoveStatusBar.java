package dev.sanctuary.gatekeep.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatComponent.class)
public class ChatComponentMixin_RemoveStatusBar {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/ChatComponent;fill(Lcom/mojang/blaze3d/vertex/PoseStack;IIIII)V", ordinal = 1))
    private void removeRender(PoseStack poseStack, int i, int j, int k, int l, int m) {
        // do nothing
    }
}
