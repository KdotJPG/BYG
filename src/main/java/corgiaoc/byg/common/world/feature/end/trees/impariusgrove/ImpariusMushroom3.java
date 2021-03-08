package corgiaoc.byg.common.world.feature.end.trees.impariusgrove;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.properties.blocks.end.impariusgrove.ImpariusMushroomBranchBlock;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class ImpariusMushroom3 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public ImpariusMushroom3(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);
        int randTreeHeight = 8 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwEndTags(config, worldIn, pos.down(), BYGBlocks.IMPARIUS_PHYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 7, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 9, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 10, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 11, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 12, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-3, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-3, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 0, -3));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 0, 3));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(3, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(3, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-3, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 1, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 1, 2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(3, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 2, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 2, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 2, 2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(2, 2, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 3, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(2, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-1, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-3, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-1, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 9, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 9, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 9, 2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(2, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(3, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-4, 10, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 10, -3));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 10, 3));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(4, 10, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 12, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-1, 12, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-1, 12, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 12, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 12, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-4, 13, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-3, 13, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 13, -3));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 13, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 13, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-1, 13, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 13, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 13, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-5, 14, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 14, -4));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 14, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 14, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 14, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 14, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 15, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 15, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 15, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 15, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 15, 2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 15, 3));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(2, 15, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-1, 16, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 16, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 16, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 16, 4));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(3, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-5, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-5, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-5, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-4, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-4, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-4, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-4, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(4, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(4, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(4, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(4, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(5, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(5, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(5, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-4, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(4, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-6, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-6, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-6, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-5, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-5, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-4, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-4, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 14, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 14, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-5, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-4, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-3, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 15, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-2, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 16, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 16, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 16, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 16, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 16, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(4, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(4, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(4, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 17, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(2, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(3, 17, 1));
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 1, -1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 2, 1), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(1, 2, 0), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-1, 3, 0), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-2, 9, 1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(1, 9, -1), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(2, 9, 1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-1, 10, 0), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 10, -2), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-5, 11, 0), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-4, 11, -1), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-4, 11, 1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-1, 11, -3), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-1, 11, 3), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 11, -4), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 11, 4), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(1, 11, -3), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(1, 11, 3), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(4, 11, -1), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(4, 11, 1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(5, 11, 0), Direction.EAST);
                this.vine(worldIn, mainmutable.setPos(pos).move(0, 12, -2));
                this.vine(worldIn, mainmutable.setPos(pos).move(-5, 13, -2));
                this.vine(worldIn, mainmutable.setPos(pos).move(-1, 13, -4));
                this.vine(worldIn, mainmutable.setPos(pos).move(2, 13, -1));
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-6, 15, -2), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-5, 15, -3), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-5, 15, -1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-4, 15, -3), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-4, 15, -1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-3, 15, -4), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-3, 15, 0), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-2, 15, -5), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-2, 15, 1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-1, 15, -4), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-1, 15, 0), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 15, -3), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 15, -1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(1, 15, -3), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(2, 15, -2), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(2, 15, 2), Direction.EAST);
                this.vine(worldIn, mainmutable.setPos(pos).move(4, 15, 1));
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 16, 2), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(1, 16, -1), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-2, 17, 1), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-1, 17, 0), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(-1, 17, 2), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 17, -2), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(0, 17, 4), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(1, 17, -3), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(1, 17, 5), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(2, 17, -2), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(2, 17, 4), Direction.EAST);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(3, 17, 0), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(3, 17, 2), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.setPos(pos).move(4, 17, 1), Direction.EAST);
            }
        }
        return true;
    }
    private void imparius_mushroom_branch(ISeedReader reader, BlockPos pos, Direction direction) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.IMPARIUS_MUSHROOM_BRANCH.getDefaultState().with(ImpariusMushroomBranchBlock.FACING, direction));
        }
    }

    private void vine(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.IMPARIUS_VINE.getDefaultState());
        }
    }

    private void vineplant(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.IMPARIUS_VINE_PLANT.getDefaultState());
        }
    }
}