package com.orkhans.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User Data Transfer Object")
public class UserDto {
    @ApiModelProperty(value = "User ID")
    private Long id;
    @ApiModelProperty(required = true, value = "Name and Surname of User")
    private String nameSurname;
}
