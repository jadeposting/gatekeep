package dev.jadeposting.gatekeep.mixins;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin_MoveScrollbar {
    @Redirect(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIIII)V",
            ordinal = 0
        )
    )
    private void changePosition(GuiGraphics graphics, int x1, int y1, int x2, int y2, int z, int color) {
        graphics.pose().pushPose();
        graphics.pose().translate(-4.0f, 0, 0);
        graphics.fill(0, y1, 2, y2, z, color);
    }

    @Redirect(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIIII)V",
            ordinal = 1
        )
    )
    private void changePosition2(GuiGraphics graphics, int x1, int y1, int x2, int y2, int z, int color) {
        graphics.fill(2, y1, 1, y2, z, color);
        graphics.pose().popPose();
    }
}
