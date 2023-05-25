package ca.fxco.RailOptimization.forge.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import ca.fxco.RailOptimization.mixin.PoweredRailBlockInvoker;

import static ca.fxco.RailOptimization.RailLogic.customUpdateState;

@Mixin(value = PoweredRailBlock.class, priority = 990)
public abstract class PoweredRailBlockMixin implements PoweredRailBlockInvoker {

    @Shadow
    protected boolean findPoweredRailSignal(Level Level, BlockPos pos, BlockState state, boolean bl, int distance) {
        throw new UnsupportedOperationException();
    }

    /**
     * @author FX
     * @reason Required to implement faster alternative
     */
    @Overwrite
    protected void updateState(BlockState state, Level level, BlockPos pos, Block block) {
        customUpdateState((PoweredRailBlock)(Object)this, state, level, pos);
    }

    @Override
    public boolean invokeFindPoweredRailSignal(Level level, BlockPos pos, BlockState state, boolean bl, int distance) {
        return this.findPoweredRailSignal(level, pos, state, bl, distance);
    }
}
