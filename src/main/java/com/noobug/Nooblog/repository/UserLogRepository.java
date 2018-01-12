package com.noobug.Nooblog.repository;

import com.noobug.Nooblog.domain.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}
