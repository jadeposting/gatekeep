package dev.jadeposting.gatekeep.mixins;

import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ChatComponent.class)
public class ChatComponentMixin_ShiftText {
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/util/FormattedCharSequence;III)I"), index = 2)
    public int shiftText(int original) {
        return -1;
    }

    @ModifyConstant(method = "screenToChatX", constant = @Constant(doubleValue = 4.0))
    public double shiftChatX(double original) {
        return 0;
    }
}
