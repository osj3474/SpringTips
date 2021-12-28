package me.sangjin.loginlog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LoginLog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private LocalDateTime loginDt;
    private String loginIp;
    private String userAgent;

    @Builder
    public LoginLog(Long userId, LocalDateTime loginDt, String loginIp, String userAgent) {
        this.userId = userId;
        this.loginDt = loginDt;
        this.loginIp = loginIp;
        this.userAgent = userAgent;
    }

}
