package ipsis.woot.tileentity;

import cofh.api.energy.IEnergyReceiver;
import ipsis.woot.block.BlockMobFactoryProxy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityMobFactoryProxy extends TileEntity implements IEnergyReceiver {

    TileEntityMobFactory master = null;

    public boolean hasMaster() { return master != null; }
    public void clearMaster() { master = null; }

    public void setMaster(TileEntityMobFactory master) { this.master = master; }

    TileEntityMobFactory findMaster() {

        TileEntityMobFactory tmpMaster = null;

        TileEntity te = getWorld().getTileEntity(pos.offset(EnumFacing.UP, 1));
        while (te != null && te instanceof TileEntityMobFactoryExtender) {
            pos = pos.up(1);
            te = getWorld().getTileEntity(pos);
        }

        if (te instanceof TileEntityMobFactory)
            tmpMaster = (TileEntityMobFactory)te;

        return tmpMaster;
    }

    public void blockAdded() {

        TileEntityMobFactory tmpMaster = findMaster();
        if (tmpMaster != null)
            tmpMaster.interruptProxy();
    }

    @Override
    public void invalidate() {

        // Master will be set by the farm when it finds the block
        if (hasMaster())
            master.interruptProxy();
    }

    public TileEntityMobFactoryProxy() {

    }

    public boolean canConnectEnergy(EnumFacing from) {

        if (!hasMaster())
            return false;

        return master.powerManager.canConnectEnergy(from, false);
    }

    @Override
    public int getEnergyStored(EnumFacing from) {

        if (!hasMaster())
            return 0;

        return master.powerManager.getEnergyStored(from, false);
    }

    @Override
    public int getMaxEnergyStored(EnumFacing from) {

        if (!hasMaster())
            return 0;

        return master.powerManager.getMaxEnergyStored(from, false);
    }

    @Override
    public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) {

        if (!hasMaster())
            return 0;

        return master.powerManager.receiveEnergy(from, maxReceive, simulate, false);
    }
}
