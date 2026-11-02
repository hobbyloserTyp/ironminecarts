package de.ironminecarts;

import com.gathertocraft.ironchest.blocks.ChestTypes;
import com.gathertocraft.ironchest.screenhandlers.ChestScreenHandler;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecartContainer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Kistenlore mit der Slot-Anzahl der jeweiligen Iron-Chests-Kiste.
 * Das Inventar öffnet dasselbe Menü wie die Kiste, daher ist keine eigene GUI nötig.
 */
public class TierMinecart extends AbstractMinecartContainer {
    private final ChestTypes tier;
    private NonNullList<ItemStack> stacks;

    public TierMinecart(EntityType<? extends TierMinecart> type, Level level, ChestTypes tier) {
        super(type, level);
        this.tier = tier;
        this.stacks = NonNullList.withSize(tier.size(), ItemStack.EMPTY);
    }

    public ChestTypes tier() {
        return tier;
    }

    // --- Inventar: eigene Liste in Kistengröße statt der festen Vanilla-Liste ---

    public NonNullList<ItemStack> getItemStacks() {
        return stacks;
    }

    public void clearItemStacks() {
        this.stacks = NonNullList.withSize(tier.size(), ItemStack.EMPTY);
    }

    @Override
    public int getContainerSize() {
        return stacks == null ? 27 : stacks.size();
    }

    // --- Menü: gleiches Menü (und damit gleiche GUI) wie die Kiste ---

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new ChestScreenHandler(tier.getMenuType(), tier, containerId, inventory, this);
    }

    // --- Aussehen / Drop ---

    @Override
    protected Item getDropItem() {
        return ModEntities.ITEMS.get(tier);
    }

    public ItemStack getPickResult() {
        return new ItemStack(ModEntities.ITEMS.get(tier));
    }

    public BlockState getDefaultDisplayBlockState() {
        return Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH);
    }

    public int getDefaultDisplayOffset() {
        return 8;
    }
}
