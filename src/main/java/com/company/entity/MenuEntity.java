package com.company.entity;

import com.company.enums.CategoryStatus;
import com.company.enums.MenuStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "menu")
public class MenuEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @Column(nullable = false, unique = true)
    private String nameUz;

    @Column(nullable = false, unique = true)
    private String nameRu;

    @Column(nullable = false, unique = true)
    private String nameEn;

    @Column(nullable = false)
    private Boolean visible = Boolean.TRUE;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MenuStatus status = MenuStatus.ACTIVE;

    @Column(nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

}
