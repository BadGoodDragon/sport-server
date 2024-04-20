package org.sport.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "photo")
    private String photo;

    @Column(name = "password")
    private String password;

    @Column(name = "longtitude")
    private Double longtitude;

    @Column(name = "latitude")
    private Double latitude;
}
