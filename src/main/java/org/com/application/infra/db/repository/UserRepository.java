package org.com.application.infra.db.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.com.application.infra.db.model.User;

public interface UserRepository extends PanacheRepositoryBase<User, Integer> {
}
