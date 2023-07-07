package com.teknoserval.methodusarcanicae.item;

import com.teknoserval.methodusarcanicae.MethodusArcanicaeMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MethodusArcanicaeMod.MOD_ID);

    public static final RegistryObject<Item> GLITTERING_DUST =
            ITEMS.register("glittering_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLITTERSTEEL_INGOT =
            ITEMS.register("glittersteel_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
