package org.ooptraining.model;

import org.ooptraining.model.pipeline.Pipeline;

public interface Thenable {
    Response then(Pipeline pipeline);
}
