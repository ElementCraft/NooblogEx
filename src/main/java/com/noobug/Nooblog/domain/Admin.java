package com.noobug.Nooblog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 账号
     */
    @Column(length = 20)
    private String account;

    /**
     * 密码
     */
    @Column(length = 20)
    private String password;

    /**
     * 昵称
     */
    @Column(length = 20)
    private String name;

    /**
     * 账号状态
     */
    private Integer status;

    @OneToMany
    @JoinColumn(name = "admin_id")
    private Set<AdminLog> adminLogs;
}
