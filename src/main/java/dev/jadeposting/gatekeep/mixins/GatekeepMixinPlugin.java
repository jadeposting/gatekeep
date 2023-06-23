package dev.jadeposting.gatekeep.mixins;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class GatekeepMixinPlugin implements IMixinConfigPlugin {

    private static final String PACKAGE = "dev.jadeposting.gatekeep.mixins.";
    private static final String SHIFT_TEXT_MIXIN = PACKAGE + "ChatComponentMixin_ShiftText";
    private static final String REMOVE_TOAST_MIXIN = PACKAGE + "ClientPacketListenerMixin_RemoveToast";
    private final Logger logger = LogManager.getLogger("Gatekeep");

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        FabricLoader fabricLoader = FabricLoader.getInstance();

        if (fabricLoader.isModLoaded("shutupmojang") && mixinClassName.equals(REMOVE_TOAST_MIXIN)) {
            this.logger.info("Disabling " + REMOVE_TOAST_MIXIN + " because ShutUpMojang is loaded.");
            return false;
        }

        if (fabricLoader.isModLoaded("chat_heads") && mixinClassName.equals(SHIFT_TEXT_MIXIN)) {
            this.logger.info("Disabling " + SHIFT_TEXT_MIXIN + " because Chat Heads is loaded.");
            return false;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
