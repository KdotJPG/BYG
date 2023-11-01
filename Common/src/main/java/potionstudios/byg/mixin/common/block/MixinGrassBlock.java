package potionstudios.byg.mixin.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomes;

/**
 * GrassBlockMixin to allow us to have Prairie Grass spawn when bonemealing grass in the Prairie Biome.
 * @see GrassBlock
 * @see Mixin
 * @author Joseph T. McQuigg
 */
@Mixin(GrassBlock.class)
public abstract class MixinGrassBlock {

    @Inject(at = @At("HEAD"), method = "performBonemeal", cancellable = true)
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos blockPos, BlockState blockState, CallbackInfo ci) {
        if (level.getBiome(blockPos).is(BYGBiomes.PRAIRIE)) {
            ci.cancel();
            level.setBlock(blockPos.above(), bYG$getType(randomSource), 2);

            BlockPos north = blockPos.north();
            BlockPos south = blockPos.south();

            //North
            if (bYG$checkBlock(level, north) && bYG$shouldSpawn(randomSource))
                level.setBlock(north.above(), bYG$getType(randomSource), 2);

            //NorthWest
            if (bYG$checkBlock(level, north.west()) && bYG$shouldSpawn(randomSource))
                level.setBlock(north.west().above(), bYG$getType(randomSource), 2);

            //NorthEast
            if (bYG$checkBlock(level, north.east()) && bYG$shouldSpawn(randomSource))
                level.setBlock(north.east().above(), bYG$getType(randomSource), 2);

            //South
            if (bYG$checkBlock(level, south) && bYG$shouldSpawn(randomSource))
                level.setBlock(south.above(), bYG$getType(randomSource), 2);

            //SouthWest
            if (bYG$checkBlock(level, south.west()) && bYG$shouldSpawn(randomSource))
                level.setBlock(south.west().above(), bYG$getType(randomSource), 2);

            //SouthEast
            if (bYG$checkBlock(level, south.east()) && bYG$shouldSpawn(randomSource))
                level.setBlock(south.east().above(), bYG$getType(randomSource), 2);

            //East
            if (bYG$checkBlock(level, blockPos.east()) && bYG$shouldSpawn(randomSource))
                level.setBlock(blockPos.east().above(), bYG$getType(randomSource), 2);

            //West
            if (bYG$checkBlock(level, blockPos.west()) && bYG$shouldSpawn(randomSource))
                level.setBlock(blockPos.west().above(), bYG$getType(randomSource), 2);
        }
    }

    @Unique
    private static boolean bYG$checkBlock(ServerLevel level, BlockPos blockPos){
        return level.getBlockState(blockPos).getBlock() == Blocks.GRASS_BLOCK && level.getBiome(blockPos).is(BYGBiomes.PRAIRIE)  && level.getBlockState(blockPos.above()).isAir();
    }

    @Unique
    private static boolean bYG$shouldSpawn(RandomSource source) {
        return source.nextInt(0, 4) <= 1;
    }

    @Unique
    private static BlockState bYG$getType(RandomSource source) {
        return source.nextBoolean() ? BYGBlocks.PRAIRIE_GRASS.defaultBlockState() : BYGBlocks.TALL_PRAIRIE_GRASS.defaultBlockState();
    }
}
