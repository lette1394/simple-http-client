package org.ooptraining.model.pipeline;

import org.ooptraining.model.Response;

@FunctionalInterface
public interface PipelineChain {
    Response handle(final PipelineContext context, final Response response);

    static PipelineChain sout() {
        return (context, response) -> {
            System.out.println(response.parseAs(String.class));
            return response;
        };
    }
}
