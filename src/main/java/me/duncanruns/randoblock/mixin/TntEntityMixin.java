package me.duncanruns.randoblock.mixin;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TntEntity.class)
public abstract class TntEntityMixin extends Entity {
    public TntEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void tickMixin(CallbackInfo info) {
        if (!(world.isClient() || isCloseToPlayer())) {
            remove();
            Block.dropStack(world, getBlockPos(), new ItemStack(Items.TNT, 1));
        }
    }

    private boolean isCloseToPlayer() {
        for (PlayerEntity player : getEntityWorld().getPlayers()) {
            if (player.squaredDistanceTo(this) < 400) {
                return true;
            }
        }
        return false;
    }
}
