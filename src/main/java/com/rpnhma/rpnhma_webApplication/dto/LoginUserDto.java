package com.rpnhma.rpnhma_webApplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class LoginUserDto {

    @Data
    public class UserDto {

        @JsonProperty("firstName")
        private String firstName;

        @JsonProperty("lastName")
        private String lastName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("phone")
        private String phone;

    }

}
