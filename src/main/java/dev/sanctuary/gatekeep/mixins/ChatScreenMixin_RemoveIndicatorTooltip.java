package dev.sanctuary.gatekeep.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(ChatScreen.class)
public class ChatScreenMixin_RemoveIndicatorTooltip {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/ChatScreen;renderTooltip(Lcom/mojang/blaze3d/vertex/PoseStack;Ljava/util/List;II)V"))
    private void removeIndicatorTooltip(ChatScreen instance, PoseStack poseStack, List<String> list, int x, int y) {
        // do nothing
    }
}
