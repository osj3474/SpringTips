package me.sangjin.loginlog.service;

import lombok.RequiredArgsConstructor;
import me.sangjin.loginlog.domain.LoginLog;
import me.sangjin.loginlog.dto.LoginDTO;
import me.sangjin.loginlog.repository.LoginLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoginLogService {

    private final LoginLogRepository loginLogRepository;

    public void login(LoginDTO loginDTO) {
        LoginLog loginLog = LoginLog.builder()
                .userId(loginDTO.getUserId())
                .loginDt(LocalDateTime.now())
                .loginIp(loginDTO.getLoginIp())
                .userAgent(loginDTO.getUserAgent())
                .build();

        loginLogRepository.save(loginLog);
    }
}
