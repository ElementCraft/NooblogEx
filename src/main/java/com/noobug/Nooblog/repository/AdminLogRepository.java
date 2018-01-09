package com.noobug.Nooblog.repository;

import com.noobug.Nooblog.domain.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLogRepository extends JpaRepository<AdminLog, Long> {
}
