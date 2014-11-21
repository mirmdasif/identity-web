package com.identityweb.utils;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class RestServiceClient<T> {
    RestTemplate restTemplate = new RestTemplate();
    public static final String BASE_URL = "http://192.168.0.64:8080";

    public T getObject(String path, MultiValueMap<String, String> params,T object){
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(BASE_URL).path(path).queryParams(params).build();
        System.out.println("The Request is as follows :  " + uriComponents.toUri().toString() );
        Object reponseObject =  restTemplate.getForObject(uriComponents.toUri(), object.getClass() );
        T obj = (T)reponseObject;
        return  obj;
    }
}
