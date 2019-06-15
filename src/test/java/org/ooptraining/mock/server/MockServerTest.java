package org.ooptraining.mock.server;

import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class MockServerTest {
    @Test
    void test1() throws InterruptedException {
        final MockServerClient mockServerClient = startClientAndServer(8080);
        final HttpRequest request = request("/file1").withMethod("GET");
        final HttpResponse response = response("wow");

        mockServerClient
                .when(request)
                .respond(response);

        Thread.sleep(1000000);
    }
}
