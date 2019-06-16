package org.ooptraining.model.pipeline;

import org.ooptraining.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Pipeline {
    private final List<PipelineChain> chains = new ArrayList<>();

    public static Pipeline pipe() {
        return new Pipeline();
    }

    public Pipeline add(final PipelineChain chain) {
        chains.add(chain);
        return this;
    }

    public Pipeline tap(final Consumer<Response> consumer) {
        chains.add((context, response) -> {
            consumer.accept(response);
            return response;
        });
        return this;
    }
}
