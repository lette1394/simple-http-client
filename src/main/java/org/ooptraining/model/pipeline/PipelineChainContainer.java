package org.ooptraining.model.pipeline;

public class PipelineChainContainer {
    public static PipelineChainContainer chain() {
        return new PipelineChainContainer();
    }

    public PipelineChainContainer add(PipelineChain<?,?> chain) {
        return this;
    }
}
