package com.noobug.Nooblog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private User user;

    /**
     * 登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime loginTime;

    /**
     * 登录IP
     */
    @Column(length = 20)
    private String loginIp;
}
