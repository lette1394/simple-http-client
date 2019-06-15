package org.ooptraining.model;

import java.io.File;
import java.io.InputStream;

public interface RequestChainWithBody extends RequestChain {
    RequestChainWithBody with(final Bodies bodies);
}
