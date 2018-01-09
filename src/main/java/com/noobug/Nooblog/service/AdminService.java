package com.noobug.Nooblog.service;

import com.noobug.Nooblog.Utils;
import com.noobug.Nooblog.constants.AdminStatus;
import com.noobug.Nooblog.domain.Admin;
import com.noobug.Nooblog.domain.AdminLog;
import com.noobug.Nooblog.domain.dto.BaseDTO;
import com.noobug.Nooblog.repository.AdminLogRepository;
import com.noobug.Nooblog.repository.AdminRepository;
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
public class AdminService {


    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminLogRepository adminLogRepository;

    /**
     * 登录处理逻辑
     *
     * @param account  账号
     * @param password 密码
     * @param ip       IP地址
     * @param session  用户session
     * @return 结果DTO
     */
    public BaseDTO login(String account, String password, String ip, HttpSession session) {

        Admin admin = adminRepository.findByAccount(account);

        if (admin == null)
            return new BaseDTO(1, false, "该账号不存在");

        String md5 = Utils.MD5(password);
        if (!admin.getPassword().equals(md5))
            return new BaseDTO(2, false, "密码不正确");

        if (admin.getStatus() == AdminStatus.BANNED.getKey())
            return new BaseDTO(3, false, "该账号为禁用状态");

        // 登录日志
        AdminLog adminLog = new AdminLog(null, admin, ZonedDateTime.now(), ip);
        adminLogRepository.save(adminLog);

        // 存session
        session.setAttribute(KEY_SESSION_ADMIN, admin);
        session.setMaxInactiveInterval(60 * 60);
        log.debug("[Admin] 管理员 {} - {} 登录系统", admin.getAccount(), admin.getName());
        return BaseDTO.OK;
    }

    /**
     * 注销登录逻辑
     *
     * @param session 用户Session
     * @return 结果DTO
     */
    public BaseDTO logout(HttpSession session) {
        Object obj = session.getAttribute(KEY_SESSION_ADMIN);
        if (obj == null)
            return new BaseDTO(1, false, "登录用户为空");

        session.removeAttribute(KEY_SESSION_ADMIN);
        return BaseDTO.OK;
    }

    /**
     * 获取所有的管理员
     *
     * @return
     */
    public List<Admin> getAllAdmins() {

        return adminRepository.findAll();
    }

    /**
     * 新增管理员
     *
     * @param admin 管理员obj
     * @return
     */
    public BaseDTO addNewAdmin(Admin admin) {
        if (adminRepository.findByAccount(admin.getAccount()) != null)
            return new BaseDTO(1, false, "该账号已存在");

        BaseDTO result = AdminValidate.validate(admin);

        if (!result.getSuccess()) return result;

        admin.setStatus(AdminStatus.NORMAL.getKey());
        admin.setPassword(Utils.MD5(admin.getPassword()));
        adminRepository.save(admin);

        return BaseDTO.OK;
    }
}
