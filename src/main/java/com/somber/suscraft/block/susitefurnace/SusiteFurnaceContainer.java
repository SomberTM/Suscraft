package com.somber.suscraft.block.susitefurnace;

import com.somber.suscraft.setup.SusBlocks;
import com.somber.suscraft.setup.SusContainerTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

public class SusiteFurnaceContainer extends Container {

    public final SusiteFurnaceTileEntity susiteFurnaceTileEntity;
    private final IWorldPosCallable worldPosCallable;

    public SusiteFurnaceContainer(final int winID, final PlayerInventory inventory, final SusiteFurnaceTileEntity susiteFurnaceTileEntity) {
        super(SusContainerTypes.SUSITE_FURNACE_CONTAINER_TYPE.get(), winID);
        this.susiteFurnaceTileEntity = susiteFurnaceTileEntity;
        this.worldPosCallable = IWorldPosCallable.create(susiteFurnaceTileEntity.getLevel(), susiteFurnaceTileEntity.getBlockPos());

        this.addSlot(new Slot(this.susiteFurnaceTileEntity, 0, 80, 35));

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 9; col++)
                this.addSlot(new Slot(inventory, col * row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));


        for (int col = 0; col < 9; col++)
            this.addSlot(new Slot(inventory, col, 8 + col * 18, 142));
    }

    public SusiteFurnaceContainer(final int winID, final PlayerInventory inventory, final PacketBuffer data) {
        this(winID, inventory, getTileEntity(inventory, data));
    }

    private static SusiteFurnaceTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "Player inventory cant be null");
        Objects.requireNonNull(data, "Packet buffer data cant be null");

        final TileEntity tileEntity = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileEntity instanceof SusiteFurnaceTileEntity)
            return (SusiteFurnaceTileEntity) tileEntity;

        throw new IllegalStateException();
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return this.worldPosCallable.evaluate((world, pos) -> {
            if (!world.getBlockState(pos).is(SusBlocks.SUSITE_FURNACE.get()))
                return false;
            else
                return (player.distanceToSqr((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D);
        }, true);
    }


//    protected SusiteFurnaceContainer(@Nullable ContainerType<?> type, int id) {
//        super(type, id);
//    }

}
