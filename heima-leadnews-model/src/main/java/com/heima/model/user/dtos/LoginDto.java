package com.heima.model.user.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginDto {
    //实现注册类的定义
    @ApiModelProperty(value = "手机号", required = true)
    private String phone; // 手机号
    @ApiModelProperty(value = "密码", required = true)
    private String password; // 密码
}
