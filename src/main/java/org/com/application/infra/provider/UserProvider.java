package org.com.application.infra.provider;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.com.application.cross.exception.BusinessException;
import org.com.application.cross.mapper.UserMapper;
import org.com.application.domain.entity.EUser;
import org.com.application.domain.gateway.UserGateway;
import org.com.application.infra.db.model.User;
import org.com.application.infra.db.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Transactional
@ApplicationScoped
public class UserProvider implements UserGateway {

    @Inject
    UserRepository repository;

    @Inject
    UserMapper mapper;

    @Override
    public EUser getUserById(Integer id) {
        try {
            Optional<User> userOptional = repository.findByIdOptional(id);
            if (userOptional.isPresent()) return mapper.toEntity(userOptional.get());
        } catch (Exception ex) {
            log.error("[PROVIDER] Error when finding user. Exception: {}", ex.getMessage(), ex);
            throw new BusinessException("[PROVIDER] Error when finding user. Exception: " + ex.getMessage());
        }

        throw new BusinessException("[PROVIDER] Cannot find user with id: " + id);
    }

    @Override
    public EUser saveUser(EUser eUser) {
        try {
            eUser.setActive(true);
            eUser.setCreatedDatetime(LocalDateTime.now());
            eUser.setUpdatedDatetime(LocalDateTime.now());
            repository.persistAndFlush(mapper.toModel(eUser));
            return eUser;
        } catch (Exception ex) {
            log.error("[PROVIDER] Error when save User. Exception: {}", ex.getMessage(), ex);
            throw new BusinessException("Error when save User. Exception: " + ex.getMessage());
        }
    }

    @Override
    public EUser updateUser(Integer id, EUser eUser) {
        return null;
    }

    @Override
    public EUser deleteUser(Integer id) {
        return null;
    }

}
