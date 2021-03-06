/*******************************************************************************
 * Copyright 2014-2016, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package biomesoplenty.common.util.inventory;

import biomesoplenty.api.item.BOPItems;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabBOP extends CreativeTabs
{
    public static final CreativeTabs instance = new CreativeTabBOP(CreativeTabs.getNextID(), "tabBiomesOPlenty");

    private CreativeTabBOP(int index, String label)
    {
        super(index, label);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(BOPItems.earth);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(NonNullList<ItemStack> itemList)
    {
        super.displayAllRelevantItems(itemList);
        for (EntityList.EntityEggInfo eggInfo : EntityList.ENTITY_EGGS.values())
        {
            if (eggInfo.spawnedID.getResourceDomain().equals(BiomesOPlenty.MOD_ID))
            {
                ItemStack itemstack = new ItemStack(Items.SPAWN_EGG, 1);
                ItemMonsterPlacer.applyEntityIdToItemStack(itemstack, eggInfo.spawnedID);
                itemList.add(itemstack);
            }
        }
    }
}
