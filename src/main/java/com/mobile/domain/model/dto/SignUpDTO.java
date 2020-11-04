package com.mobile.domain.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    @ApiModelProperty(required = true, example = "John Smith", value = "name")
    private String name;
    @ApiModelProperty(required = true, example = "john", value = "username")
    private String username;
    @ApiModelProperty(required = true, example = "myPassword", value = "password")
    private String password;
    @ApiModelProperty(required = true, example = "[USER]", value = "authorities")
    private List<String> authorities;
}
