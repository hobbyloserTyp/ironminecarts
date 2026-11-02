package de.ironminecarts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class IronMinecarts implements ModInitializer {
    public static final String MOD_ID = "ironminecarts";

    @Override
    public void onInitialize() {
        ModEntities.register();
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS)
                .register(output -> ModEntities.ITEMS.values().forEach(output::accept));
    }
}
