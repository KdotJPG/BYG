package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;import java.util.Random;

public class ErodedSierraSB extends SierraSB {
    private static final BlockState WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA.getDefaultState();
    private static final BlockState ORANGE_TERRACOTTA = Blocks.ORANGE_TERRACOTTA.getDefaultState();
    private static final BlockState TERRACOTTA = Blocks.TERRACOTTA.getDefaultState();

    public ErodedSierraSB(Codec<TernarySurfaceConfig> p_i51314_1_) {
        super(p_i51314_1_);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        double d0 = 0.0D;
        double d1 = Math.min(Math.abs(noise), this.field_215435_c.sample((double) x * 0.25D, (double) z * 0.25D, false) * 15.0D);
        if (d1 > 0.0D) {
            double d2 = 0.001953125D;
            double d3 = Math.abs(this.field_215437_d.sample((double) x * 0.001953125D, (double) z * 0.001953125D, false));
            d0 = d1 * d1 * 2.5D;
            double d4 = Math.ceil(d3 * 50.0D) + 14.0D;
            if (d0 > d4) {
                d0 = d4;
            }

            d0 = d0 + 64.0D;
        }

        int l = x & 15;
        int i = z & 15;
        BlockState blockstate2 = TERRACOTTA;
        BlockState blockstate = biomeIn.getGenerationSettings().getSurfaceConfig().getUnderMaterial();
        int i1 = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        int j = -1;
        boolean flag1 = false;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (int k = Math.max(startHeight, (int) d0 + 1); k >= 0; --k) {
            blockpos$mutable.set(l, k, i);
            if (chunkIn.getBlockState(blockpos$mutable).isAir() && k < (int) d0) {
                chunkIn.setBlockState(blockpos$mutable, defaultBlock, false);
            }

            BlockState blockstate1 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate1.isAir()) {
                j = -1;
            } else if (blockstate1.getBlock() == defaultBlock.getBlock()) {
                if (j == -1) {
                    flag1 = false;
                    if (i1 <= 0) {
                        blockstate2 = Blocks.AIR.getDefaultState();
                        blockstate = defaultBlock;
                    } else if (k >= seaLevel - 4 && k <= seaLevel + 1) {
                        blockstate2 = TERRACOTTA;
                        blockstate = biomeIn.getGenerationSettings().getSurfaceConfig().getUnderMaterial();
                    }

                    if (k < seaLevel && (blockstate2 == null || blockstate2.isAir())) {
                        blockstate2 = defaultFluid;
                    }

                    j = i1 + Math.max(0, k - seaLevel);
                    if (k >= seaLevel - 1) {
                        if (k <= seaLevel + 3 + i1) {
                            chunkIn.setBlockState(blockpos$mutable, biomeIn.getGenerationSettings().getSurfaceConfig().getTopMaterial(), false);
                            flag1 = true;
                        } else {
                            BlockState blockstate3;
                            if (k >= 64 && k <= 127) {
                                if (flag) {
                                    blockstate3 = TERRACOTTA;
                                } else {
                                    blockstate3 = this.func_215431_a(x, k, z);
                                }
                            } else {
                                blockstate3 = TERRACOTTA;
                            }

                            chunkIn.setBlockState(blockpos$mutable, blockstate3, false);
                        }
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                        Block block = blockstate.getBlock();
                        if (block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA) {
                            chunkIn.setBlockState(blockpos$mutable, TERRACOTTA, false);
                        }
                    }
                } else if (j > 0) {
                    --j;
                    if (flag1) {
                        chunkIn.setBlockState(blockpos$mutable, TERRACOTTA, false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, this.func_215431_a(x, k, z), false);
                    }
                }
            }
        }

    }
}