package com.noobug.Nooblog.web.rest;

import com.noobug.Nooblog.domain.Admin;
import com.noobug.Nooblog.domain.dto.BaseDTO;
import com.noobug.Nooblog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@Slf4j
public class AdminResource {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     *
     * @return BaseDTO
     */
    @PostMapping("/login")
    public ResponseEntity<BaseDTO> login(String account, String password, HttpSession session, HttpServletRequest request) {
        BaseDTO result = adminService.login(account, password, request.getRemoteAddr(), session);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 管理员注销登录
     *
     * @param session
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<BaseDTO> regist(HttpSession session) {
        BaseDTO result = adminService.logout(session);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 新增管理员
     *
     * @param admin
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<BaseDTO> add(Admin admin) {
        BaseDTO result = adminService.addNewAdmin(admin);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 所有管理员
     *
     * @return
     */
    @GetMapping("/all")
    public List<Admin> all() {
        return adminService.getAllAdmins();
    }
}
