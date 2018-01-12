package com.noobug.Nooblog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 账号
     */
    @Column(length = 24, unique = true, nullable = false)
    private String account;

    /**
     * 密码
     */
    @Column(length = 32)
    private String password;

    /**
     * 昵称
     */
    @Column(length = 12)
    private String nickName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 真实姓名
     */
    @Column(length = 12)
    private String realName;

    /**
     * 电话
     */
    @Column(length = 16)
    private String phone;

    /**
     * 邮箱
     */
    @Column(length = 48)
    private String email;

    /**
     * 是否实名
     */
    private Integer isAuth;

    /**
     * 是否封禁
     */
    private Integer isBan;

    /**
     * 是否公开博客
     */
    private Integer isPublic;

    /**
     * 签名
     */
    @Column(length = 96)
    private String signature;

    /**
     * 头像路径
     */
    @Column(length = 72)
    private String iconPath;

    /**
     * 积分
     */
    private Integer score;

    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime registTime;

    /**
     * 所在城市
     */
    @ManyToOne
    private City city;


    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Set<UserLog> userLogs = new HashSet<>();
}
