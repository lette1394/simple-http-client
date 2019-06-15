package org.ooptraining.model.pipeline;

public interface PipelineChain<FROM, TO> {
    TO handle(final PipelineContext<FROM> context, final FROM body);
}
