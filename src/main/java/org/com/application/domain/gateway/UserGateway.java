package org.com.application.domain.gateway;

import org.com.application.domain.entity.EUser;

public interface UserGateway {
    EUser getUserById(Integer id);
    EUser saveUser(EUser eUser);
    EUser updateUser(Integer id, EUser eUser);
    EUser deleteUser(Integer id);
}
