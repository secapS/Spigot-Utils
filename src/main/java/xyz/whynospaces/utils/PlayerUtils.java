package xyz.whynospaces.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerUtils {

    /**
     *  Adds item to inventory but checks if inventory is full and whether it can be added to a stack of items, drops items on ground if both checks fail
     * @param player
     * @param itemStack itemstack to add to player inventory.
     */
    public static void addItem(Player player, ItemStack itemStack) {
        Inventory inventory = player.getInventory();
        if (inventory.firstEmpty() == -1)
        {
            int openSlots = 0;
            for (ItemStack itemStacks : player.getInventory().getContents())
            {
                int amount = itemStacks.getAmount();
                openSlots++;
                if ((itemStacks.getType().equals(itemStack.getType())) && (itemStacks.getAmount() < itemStack.getMaxStackSize()))
                {
                    inventory.addItem(itemStack);
                    break;
                }
                if (openSlots == 36)
                {
                    player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
                    break;
                }
            }
        }
        else
        {
            inventory.addItem(itemStack);
        }
    }

    /**
     *
     * @param action
     * @return true if action is left click.
     */
    public static boolean isLeftClick(Action action) {
        return action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK;
    }

    /**
     *
     * @param action
     * @return true if action is right click.
     */
    public static boolean isRightClick(Action action) {
        return action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK;
    }
}
