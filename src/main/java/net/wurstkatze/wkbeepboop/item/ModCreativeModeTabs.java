package net.wurstkatze.wkbeepboop.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.wurstkatze.wkbeepboop.WkBeepBoop;
import net.wurstkatze.wkbeepboop.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WkBeepBoop.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WKBEEPBOOP_TAB = CREATIVE_MODE_TABS.register("wkbeepboop_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.REMOTE_CONTROLL.get()))
                    .title(Component.translatable("creativetab.wkbeepboop_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                        // output.accept(ModBlocks.SIREN_BLOCK.get());
                        for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                            output.accept(block.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
