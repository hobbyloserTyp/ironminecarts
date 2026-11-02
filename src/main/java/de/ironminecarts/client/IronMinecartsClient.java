package de.ironminecarts.client;

import de.ironminecarts.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MinecartRenderer;

public class IronMinecartsClient implements ClientModInitializer {
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void onInitializeClient() {
        ModEntities.TYPES.values().forEach(type ->
                EntityRendererRegistry.register(type, ctx -> new MinecartRenderer(ctx, ModelLayers.CHEST_MINECART)));
    }
}
