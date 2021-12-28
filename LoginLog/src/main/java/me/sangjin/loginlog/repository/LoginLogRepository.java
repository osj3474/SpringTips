package me.sangjin.loginlog.repository;

import me.sangjin.loginlog.domain.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {
}
