package de.ironminecarts;

import com.gathertocraft.ironchest.blocks.ChestTypes;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MinecartItem;

public final class ModEntities {
    /** Stufen, für die es Loren gibt. */
    public static final ChestTypes[] TIERS = {
            ChestTypes.COPPER, ChestTypes.IRON, ChestTypes.GOLD, ChestTypes.DIAMOND, ChestTypes.EMERALD
    };

    public static final Map<ChestTypes, EntityType<TierMinecart>> TYPES = new EnumMap<>(ChestTypes.class);
    public static final Map<ChestTypes, Item> ITEMS = new EnumMap<>(ChestTypes.class);

    private ModEntities() {}

    public static void register() {
        for (ChestTypes tier : TIERS) {
            String name = tier.name().toLowerCase(Locale.ROOT) + "_chest_minecart";
            Identifier id = Identifier.fromNamespaceAndPath(IronMinecarts.MOD_ID, name);

            ResourceKey<EntityType<?>> entityKey = ResourceKey.create(Registries.ENTITY_TYPE, id);
            EntityType<TierMinecart> type = EntityType.Builder
                    .<TierMinecart>of((t, level) -> new TierMinecart(t, level, tier), MobCategory.MISC)
                    .noLootTable()
                    .sized(0.98F, 0.7F)
                    .clientTrackingRange(8)
                    .build(entityKey);
            Registry.register(BuiltInRegistries.ENTITY_TYPE, id, type);
            TYPES.put(tier, type);

            ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);
            Item item = new MinecartItem(type, new Item.Properties().setId(itemKey).stacksTo(1));
            Registry.register(BuiltInRegistries.ITEM, id, item);
            ITEMS.put(tier, item);
        }
    }
}
