package org.com.application.infra.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email",
                "active"
        })
})
public class User {

        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
        Integer id;

        @Column(name = "active", nullable = false)
        Boolean active;

        @Column(name = "username", nullable = false, length = 25)
        String username;

        @Column(name = "email", nullable = false, length = 100)
        String email;

        @Column(name = "password", nullable = false)
        String password;

        @Column(name = "full_name", length = 150)
        String fullName;

        @Column(name = "created_datetime")
        LocalDateTime createdDatetime;

        @Column(name = "updated_datetime")
        LocalDateTime updatedDatetime;

}
