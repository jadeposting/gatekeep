package dev.jadeposting.gatekeep.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.components.ChatComponent;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin_MoveScrollbar {
    @WrapOperation(
        method = "extractRenderState(Lnet/minecraft/client/gui/components/ChatComponent$ChatGraphicsAccess;IILnet/minecraft/client/gui/components/ChatComponent$DisplayMode;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/components/ChatComponent$ChatGraphicsAccess;fill(IIIII)V",
            ordinal = 0
        ),
        slice = @Slice(
            from = @At(
                value = "FIELD",
                target = "Lnet/minecraft/client/gui/components/ChatComponent;newMessageSinceScroll:Z",
                opcode = Opcodes.GETFIELD
            )
        )
    )
    private void changePosition(
        ChatComponent.ChatGraphicsAccess graphics, int x1, int y1, int x2, int y2, int color,
        Operation<Void> original
    ) {
        original.call(graphics, -4, y1, -2, y2, color);
    }

    @WrapOperation(
        method = "extractRenderState(Lnet/minecraft/client/gui/components/ChatComponent$ChatGraphicsAccess;IILnet/minecraft/client/gui/components/ChatComponent$DisplayMode;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/components/ChatComponent$ChatGraphicsAccess;fill(IIIII)V",
            ordinal = 1
        ),
        slice = @Slice(
            from = @At(
                value = "FIELD",
                target = "Lnet/minecraft/client/gui/components/ChatComponent;newMessageSinceScroll:Z",
                opcode = Opcodes.GETFIELD
            )
        )
    )
    private void changePosition2(
        ChatComponent.ChatGraphicsAccess graphics, int x1, int y1, int x2, int y2, int color,
        Operation<Void> original
    ) {
        original.call(graphics, -2, y1, -3, y2, color);
    }
}
