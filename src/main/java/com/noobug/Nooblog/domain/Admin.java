package com.noobug.Nooblog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String name;

    /**
     * 账号状态
     */
    private Integer status;

    @OneToMany
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Set<AdminLog> adminLogs;
}
