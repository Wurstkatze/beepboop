package net.wurstkatze.wkbeepboop.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class RemoteControllItem extends Item {
    public RemoteControllItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();
            if (player == null) return InteractionResult.FAIL;

            BlockPos blockPos = pContext.getClickedPos();
            Block block = pContext.getLevel().getBlockState(blockPos).getBlock();
            ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(block);

            if (blockId.toString().equals("wkbeepboop:siren")) {
                player.sendSystemMessage(Component.literal("Clicked on a siren!"));
            }

        }
        return InteractionResult.SUCCESS;
    }
}
