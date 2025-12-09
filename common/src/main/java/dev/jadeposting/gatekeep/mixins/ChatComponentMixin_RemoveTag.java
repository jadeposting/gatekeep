package dev.jadeposting.gatekeep.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.GuiMessageTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = {"net/minecraft/client/gui/components/ChatComponent$1"})
public class ChatComponentMixin_RemoveTag {
    @ModifyExpressionValue(
        method = "accept",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/GuiMessage$Line;tag()Lnet/minecraft/client/GuiMessageTag;"
        )
    )
    private GuiMessageTag removeTagIcon(GuiMessageTag original) {
        return null;
    }
}
