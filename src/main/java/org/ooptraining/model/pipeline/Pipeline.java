package org.ooptraining.model.pipeline;

import org.ooptraining.model.Response;

public interface Pipeline {
    Response pipe(PipelineChainContainer chainContainer);
}
