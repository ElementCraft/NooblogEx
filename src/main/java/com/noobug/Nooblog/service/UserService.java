package com.noobug.Nooblog.service;

import com.noobug.Nooblog.Utils;
import com.noobug.Nooblog.constants.AdminStatus;
import com.noobug.Nooblog.domain.Admin;
import com.noobug.Nooblog.domain.AdminLog;
import com.noobug.Nooblog.domain.User;
import com.noobug.Nooblog.domain.dto.BaseDTO;
import com.noobug.Nooblog.repository.AdminLogRepository;
import com.noobug.Nooblog.repository.AdminRepository;
import com.noobug.Nooblog.repository.UserLogRepository;
import com.noobug.Nooblog.repository.UserRepository;
import com.noobug.Nooblog.validate.AdminValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.time.ZonedDateTime;
import java.util.List;

import static com.noobug.Nooblog.constants.Consts.KEY_SESSION_ADMIN;

@Service
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLogRepository userLogRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public BaseDTO addNewUser(User user) {
        return null;
    }
}
