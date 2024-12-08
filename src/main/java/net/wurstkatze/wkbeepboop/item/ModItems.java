package net.wurstkatze.wkbeepboop.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wurstkatze.wkbeepboop.WkBeepBoop;
import net.wurstkatze.wkbeepboop.item.custom.RemoteControllItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WkBeepBoop.MOD_ID);

    public static final RegistryObject<Item> REMOTE_CONTROLL = ITEMS.register("remote_controll", () -> new RemoteControllItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
