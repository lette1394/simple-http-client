package org.ooptraining.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ooptraining.model.*;
import org.ooptraining.util.test.extendwith.Person;

import java.io.File;
import java.util.Optional;

import static org.ooptraining.model.Bodies.bodies;
import static org.ooptraining.model.Headers.headers;
import static org.ooptraining.model.Params.params;

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
    void stream() {
        final String res = SimpleHttpClient
                .post(DUMMY_URL)
                .with(bodies()
                        .add("hello world!")
                        .add("wow...")
                )
                .parseAs(String.class);
    }

//    @Test
//    @DisplayName("")
//    void pipeline() {
//        Response<Integer> response = SimpleHttpClient.get(DUMMY_URL)
//                .runAs(String.class)
//                .pipe(chain()
//                        .add(new ResponseLogger())
//                        .add(new StringReverser())
//                        .add(new StringCounter())
//                )
//
//
//    }
//
//    private static class ResponseLogger implements PipelineChain<String, String> {
//        @Override
//        public String handle(final PipelineContext<String> context, final String body) {
//            final Response<String> response = context.response();
//            System.out.println(response.body());
//            return body;
//        }
//    }
//
//    private static class StringReverser implements PipelineChain<String, String> {
//        @Override
//        public String handle(final PipelineContext<String> context, final String body) {
//            return new StringBuilder(body).reverse().toString();
//        }
//    }
//
//    private static class StringCounter implements PipelineChain<String, Integer> {
//        @Override
//        public Integer handle(final PipelineContext<String> context, final String body) {
//            return body.length();
//        }
//    }
//
//    @RequiredArgsConstructor
//    private static class Adder implements PipelineChain<Integer, Integer> {
//        private final int value;
//
//        @Override
//        public Integer handle(final PipelineContext<Integer> context, final Integer body) {
//            return body + value;
//        }
//    }
//
//    @Data
//    private static class Person {
//        private final String name;
//        private final int age;
//    }
}