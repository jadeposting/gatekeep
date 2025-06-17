package dev.jadeposting.gatekeep.mixins;

import net.minecraft.client.GuiMessage;
import net.minecraft.client.GuiMessageTag;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatComponent.class)
public class ChatComponentMixin_RemoveTag {
    @Redirect(
        method = "method_71992",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/GuiMessage$Line;tag()Lnet/minecraft/client/GuiMessageTag;"
        )
    )
    private GuiMessageTag removeTagIcon(GuiMessage.Line messageLine) {
        return null;
    }
}
