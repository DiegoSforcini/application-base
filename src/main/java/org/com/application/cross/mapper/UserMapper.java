package org.com.application.cross.mapper;

import org.com.application.domain.entity.EUser;
import org.com.application.infra.db.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    EUser toEntity(User user);
    User toModel(EUser eUser);
}
