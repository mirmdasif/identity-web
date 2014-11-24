package com.identityweb.utils;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class RestServiceClient {
    RestTemplate restTemplate = new RestTemplate();
    public static final String BASE_URL = "http://192.168.0.64:8080";
    public static final String API_VERSION = "/v1";

    public Object getObjectWithQueryParameters(String path, MultiValueMap<String, String> params,Object object){
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(BASE_URL+API_VERSION).path(path).queryParams(params).build();
        System.out.println("The Request is as follows :  " + uriComponents.toUri().toString() );
        try {
            object = restTemplate.getForEntity(uriComponents.toUri(), object.getClass() ).getBody();
            if(object==null)
                return new Object();
            else
                return object;
        } catch (RestClientException e) {
            return null;
        }
    }
}
