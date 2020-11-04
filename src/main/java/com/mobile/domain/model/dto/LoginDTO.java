package com.mobile.domain.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @ApiModelProperty(required = true, value = "username", example = "admin")
    private String username;
    @ApiModelProperty(required = true, value = "password", example = "admin")
    private String password;
}
