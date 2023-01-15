package com.optimagrowth.license.service.client;

import com.optimagrowth.license.model.Organization;
import laskin.UserContext;
import laskin.UserContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MyWebClient {


    private final WebClient webClient;

    public MyWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Organization getOrganization(String organizationId){
        return webClient.get()
                .uri("http://organization-service/v1/organization/" + organizationId)
                .header(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId())
                .header(UserContext.ORGANIZATION_ID, UserContextHolder.getContext().getOrganizationId())
                .header(UserContext.USER_ID, UserContextHolder.getContext().getUserId())
                .header("Authorization", UserContextHolder.getContext().getAuthToken())
                .retrieve()
                .bodyToMono(Organization.class)
                .block();

    }

}