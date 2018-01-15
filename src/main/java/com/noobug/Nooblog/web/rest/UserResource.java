package com.noobug.Nooblog.web.rest;

import com.noobug.Nooblog.domain.User;
import com.noobug.Nooblog.domain.dto.BaseDTO;
import com.noobug.Nooblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserResource {

    @Autowired
    private UserService userService;


    /**
     * 新增用户
     *
     * @param user 用户实体
     * @return
     */
    public ResponseEntity<BaseDTO> add(User user) {
        BaseDTO result = userService.addNewUser(user);

        return ResponseEntity.ok(result);
    }


    /**
     * 所有用户
     *
     * @return
     */
    @GetMapping("/all")
    public List<User> all() {

        return userService.getAllUsers();
    }

    /**
     * 用户列表
     *
     * @param page 第几页
     * @param size 页面大小
     * @return
     */
    @GetMapping("/list")
    public Page<User> list(int page, int size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return userService.getUsersPage(pageRequest);
    }
}
