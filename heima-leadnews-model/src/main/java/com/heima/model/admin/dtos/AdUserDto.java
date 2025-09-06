package com.heima.model.admin.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdUserDto {

    //实现注册类的定义
    @ApiModelProperty(value = "名字", required = true)
    private String name; // 手机号
    @ApiModelProperty(value = "密码", required = true)
    private String password; // 密码
}
