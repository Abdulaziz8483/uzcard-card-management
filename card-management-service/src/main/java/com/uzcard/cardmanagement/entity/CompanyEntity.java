package com.uzcard.cardmanagement.entity;

import com.uzcard.cardmanagement.enams.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "comany")
public class CompanyEntity {
    @Id
    @UuidGenerator
    private String id;
    @Column(nullable = false)
    private String name;

    private String address;

    private String contact;

    @Column(name = "created_date", updatable = false)
    private LocalDate createdDate = LocalDate.now();

    private boolean visible = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Company role;

    private String code;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
}
