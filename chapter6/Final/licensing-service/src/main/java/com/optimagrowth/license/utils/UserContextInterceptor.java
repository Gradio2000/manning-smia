package com.optimagrowth.license.utils;

import laskin.UserContext;
import laskin.UserContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;


import java.io.IOException;


public class UserContextInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                        ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpHeaders headers = httpRequest.getHeaders();
        headers.add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId());
        headers.add(UserContext.AUTH_TOKEN, UserContextHolder.getContext().getAuthToken());
        headers.add(UserContext.USER_ID, UserContextHolder.getContext().getUserId());
        headers.add(UserContext.ORGANIZATION_ID, UserContextHolder.getContext().getOrganizationId());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
