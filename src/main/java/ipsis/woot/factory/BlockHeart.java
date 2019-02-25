package ipsis.woot.factory;

import ipsis.woot.debug.IWootDebug;
import ipsis.woot.util.WootBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemUseContext;

import java.util.List;

public class BlockHeart extends WootBlock implements IWootDebug {

    public static final String BASENAME = "factory_heart";
    public BlockHeart() {
        super(Block.Properties.create(Material.ROCK), BASENAME);
    }

    /**
     * IWootDebug
     */
    @Override
    public List<String> getDebugText(List<String> debug, ItemUseContext itemUseContext) {
        debug.add("====> BlockHeart");
        return debug;
    }
}
