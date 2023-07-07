package com.teknoserval.methodusarcanicae.item;

import com.teknoserval.methodusarcanicae.MethodusArcanicaeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MethodusArcanicaeMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> METHODUS_ARACNICAE_TAB = CREATIVE_MODE_TABS.register("methodus_arcanicae_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.GLITTERSTEEL_INGOT.get()))
            .title(Component.translatable("creativetab.methodus_arcanicae_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.GLITTERING_DUST.get());
                pOutput.accept(ModItems.GLITTERSTEEL_INGOT.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
