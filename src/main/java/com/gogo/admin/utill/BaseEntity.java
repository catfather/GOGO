package com.gogo.admin.utill;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
@EntityListeners(value = AbstractMethodError.class)
public class BaseEntity {

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(updatable = false)
    private LocalDateTime updateTime;

    @ColumnDefault("0")
    private Integer isDeleted;
}
