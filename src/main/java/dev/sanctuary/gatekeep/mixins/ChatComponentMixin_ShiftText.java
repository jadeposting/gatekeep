package dev.sanctuary.gatekeep.mixins;

import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ChatComponent.class)
public class ChatComponentMixin_ShiftText {
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawShadow(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/util/FormattedCharSequence;FFI)I"), index = 2)
    public float shiftText(float original) {
        // todo: this removes the head from the chat heads mod,
        //  should be made compatible eventually
        return -1;
    }

    @ModifyConstant(method = "screenToChatX", constant = @Constant(doubleValue = 4.0))
    public double shiftChatX(double original) {
        return 0;
    }
}
