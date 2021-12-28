package me.sangjin.loginlog.api;

import lombok.RequiredArgsConstructor;
import me.sangjin.loginlog.common.UserInfoUtils;
import me.sangjin.loginlog.dto.LoginDTO;
import me.sangjin.loginlog.service.LoginLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final LoginLogService loginLogService;

    @GetMapping()
    public String home(HttpServletRequest request, Long userId) {
        // 로그인 로직
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setUserId(123L);                                        // 사용자 PK (테스트 : 123)
        loginDTO.setLoginIp(UserInfoUtils.getClientIP(request));         // IP
        loginDTO.setUserAgent(request.getHeader("User-Agent"));    // 접속 브라우저

        loginLogService.login(loginDTO);

        return "1";
    }
}
