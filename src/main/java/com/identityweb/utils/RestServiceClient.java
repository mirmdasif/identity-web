package com.identityweb.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class RestServiceClient {
    RestTemplate restTemplate = new RestTemplate();
    public static final String BASE_URL = "http://192.168.0.64:8080";

    public Object getObject(String path, MultiValueMap<String, String> params,Object object){
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(BASE_URL).path(path).queryParams(params).build();
        System.out.println("The Request is as follows :  " + uriComponents.toUri().toString() );
        ResponseEntity response =  restTemplate.getForEntity(uriComponents.toUri(), object.getClass());
        if(response.getStatusCode().value() == 200) {
            Object obj = (Object) response.getBody();
            return obj;
        }
        return false;
    }

    public ResponseEntity postObject(String path, MultiValueMap<String,String> params, Object object) {

        //todo
       // UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://192.168.0.64:8080/v1/accounts");//.path(path).build();
        ResponseEntity responseEntity = (ResponseEntity) restTemplate.postForEntity("http://192.168.0.64:8080/v1/accounts", object, object.getClass());
        System.out.println(responseEntity.getStatusCode());
        return responseEntity;
    }
}
