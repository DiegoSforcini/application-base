package org.com.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EUser {
    Integer id;
    Boolean active;
    String username;
    String email;
    String password;
    String fullName;
    LocalDateTime createdDatetime;
    LocalDateTime updatedDatetime;
}
