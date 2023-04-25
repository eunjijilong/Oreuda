package com.oreuda.oreuda_auth.domain.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Auth {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "auth_id", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    private UUID authId;

    @NotNull
    @Column(columnDefinition = "VARCHAR(10)", unique = true)
    private String code;

    @NotNull
    private LocalDateTime registrationDate;
}
