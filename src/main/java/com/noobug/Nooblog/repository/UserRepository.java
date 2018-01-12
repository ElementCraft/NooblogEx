package com.noobug.Nooblog.repository;

import com.noobug.Nooblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
