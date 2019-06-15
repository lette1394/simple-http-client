package org.ooptraining.model.pipeline;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.ooptraining.model.Response;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "with")
public class PipelineContext<T> {
    private final Response<T> response;
}
