package me.sangjin.loginlog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private Long userId;
    private String loginIp;
    private String userAgent;
}
