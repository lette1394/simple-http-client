package org.ooptraining.client;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ooptraining.model.Response;
import org.ooptraining.model.pipeline.PipelineChain;
import org.ooptraining.model.pipeline.PipelineContext;

import static org.ooptraining.model.Bodies.bodies;
import static org.ooptraining.model.Configs.configs;
import static org.ooptraining.model.Headers.headers;
import static org.ooptraining.model.Params.params;
import static org.ooptraining.model.pipeline.Pipeline.pipe;
import static org.ooptraining.model.pipeline.PipelineChain.sout;

class SimpleHttpClientTest {
    private static final String DUMMY_URL = "http://localhost:8080/api/v1/test/resources";

    @Test
    @DisplayName("가장 단순한 형태의 http get call")
    void simpleCall() {
        final String res = SimpleHttpClient
                .get(DUMMY_URL)
                .parseAs(String.class);
    }

    @Test
    void withHeaderAndParams() {
        final Person res = SimpleHttpClient
                .post(DUMMY_URL)
                .with(headers()
                        .add("h1", "value1")
                        .add("h2", "value1")
                        .add("h3", "value1"))
                .with(params()
                        .add("p1", "value1")
                        .add("p2", "value1")
                        .add("p3", "value1"))
                .parseAs(Person.class);
    }

    @Test
    void streamTest() {
        final String res = SimpleHttpClient
                .post(DUMMY_URL)
                .with(bodies()
                        .add("hello world!")
                        .add("wow...")
                )
                .parseAs(String.class);
    }

    @Test
    void thenableTest() {
        final String res = SimpleHttpClient
                .get(DUMMY_URL)
                .execute()
                .then(pipe()
                        .add(new ResponseLogger())
                        .add(new StringReverser())
                        .tap(System.out::println)
                        .add(new StringCounter())
                        .add(sout())
                )
                .parseAs(String.class);


        final String res2 = SimpleHttpClient
                .get(DUMMY_URL)
                .execute()
                .then(pipe()
                        .add(new Adder(5))
                        .tap(r -> {
                            int i = r.parseAs(Integer.class);
                            System.out.println(String.format("int parse : %s", i));
                        })
                )
                .parseAs(String.class);
    }

    private static class ResponseLogger implements PipelineChain {
        @Override
        public Response handle(final PipelineContext context, final Response response) {
            return null;
        }
    }

    private static class StringReverser implements PipelineChain {
        @Override
        public Response handle(final PipelineContext context, final Response response) {
            return null;
        }
    }

    private static class StringCounter implements PipelineChain {
        @Override
        public Response handle(final PipelineContext context, final Response response) {
            return null;
        }
    }

    @RequiredArgsConstructor
    private static class Adder implements PipelineChain {
        private final int value;

        @Override
        public Response handle(final PipelineContext context, final Response response) {
            return null;
        }
    }

    @Test
    void configTest() {
        final String res = SimpleHttpClient
                .get(DUMMY_URL)
                .with(configs()
                        .timeout(10))
                .execute()
                .parseAs(String.class);


        final String res2 = SimpleHttpClient
                .get(DUMMY_URL)
                .execute()
                .then(pipe()
                        .add(new Adder(5))
                        .tap(r -> {
                            int i = r.parseAs(Integer.class);
                            System.out.println(String.format("int parse : %s", i));
                        })
                )
                .parseAs(String.class);
    }

    @Data
    private static class Person {
        private String name;
        private int age;
    }
}