package com.noobug.Nooblog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 测试类
 *
 * @author Daedalus
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted=2")
public class TestA {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private boolean deleted;
}
