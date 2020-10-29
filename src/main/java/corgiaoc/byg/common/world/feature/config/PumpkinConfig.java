package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class PumpkinConfig implements FeatureConfig {

    public static final Codec<PumpkinConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.TYPE_CODEC.fieldOf("pumpkin_provider").forGetter((config) -> {
            return config.pumpkinProvider;
        }), BlockStateProvider.TYPE_CODEC.fieldOf("stem_provider").forGetter((config) -> {
            return config.stemProvider;
        }), BlockStateProvider.TYPE_CODEC.fieldOf("leaves_provider").forGetter((config) -> {
            return config.leavesProvider;
        })).apply(codecRecorder, PumpkinConfig::new);
    });


    private final BlockStateProvider pumpkinProvider;
    private final BlockStateProvider stemProvider;
    private final BlockStateProvider leavesProvider;

    PumpkinConfig(BlockStateProvider pumpkinProvider, BlockStateProvider stemProvider, BlockStateProvider leavesProvider) {
        this.pumpkinProvider = pumpkinProvider;
        this.stemProvider = stemProvider;
        this.leavesProvider = leavesProvider;
    }

    public BlockStateProvider getPumpkinProvider() {
        return this.pumpkinProvider;
    }

    public BlockStateProvider getStemProvider() {
        return this.stemProvider;
    }

    public BlockStateProvider getLeavesProvider() {
        return leavesProvider;
    }

    public static class Builder {
        private BlockStateProvider pumpkinProvider = new SimpleBlockStateProvider(Blocks.PUMPKIN.getDefaultState());
        private BlockStateProvider stemProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());
        private BlockStateProvider leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

        public Builder setPumpkinBlock(Block block) {
            this.pumpkinProvider = new SimpleBlockStateProvider(block.getDefaultState());
            return this;
        }

        public Builder setPumpkinBlock(BlockState state) {
            this.pumpkinProvider = new SimpleBlockStateProvider(state);
            return this;
        }

        public Builder setStemBlock(Block block) {
            this.stemProvider = new SimpleBlockStateProvider(block.getDefaultState());
            return this;
        }

        public Builder setStemBlock(BlockState state) {
            this.stemProvider = new SimpleBlockStateProvider(state);
            return this;
        }

        public Builder setLeavesBlock(Block block) {
            this.leavesProvider = new SimpleBlockStateProvider(block.getDefaultState());
            return this;
        }

        public Builder setLeavesBlock(BlockState state) {
            this.leavesProvider = new SimpleBlockStateProvider(state);
            return this;
        }

        public PumpkinConfig build() {
            return new PumpkinConfig(this.pumpkinProvider, this.stemProvider, this.leavesProvider);
        }
    }
}
