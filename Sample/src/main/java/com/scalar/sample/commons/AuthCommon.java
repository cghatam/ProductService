package com.scalar.sample.commons;

import com.scalar.sample.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommon {
    private RestTemplate restTemplate;

    public AuthCommon(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String tokenValue){
        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://localhost:8085/users/validate/"+tokenValue,UserDto.class);

        if(responseEntity.getBody() == null){
            return null;
        }
        return responseEntity.getBody();
    }
}
