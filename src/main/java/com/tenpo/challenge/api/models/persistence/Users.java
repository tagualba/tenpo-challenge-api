package com.tenpo.challenge.api.models.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "users_login")
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", updatable = false,  nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "hash_password", nullable = false)
    private String hashPassword;

    @Column(name = "last_token_api", nullable = false)
    private String lastTokenApi;

    public Users(){
    }
}
