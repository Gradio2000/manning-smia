package com.optimagrowth.license.service.client;

import com.optimagrowth.license.model.Organization;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
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
                .retrieve()
                .bodyToMono(Organization.class)
                .block();

    }

}