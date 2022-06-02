package com.rpnhma.rpnhma_webApplication.repositpry;

import com.rpnhma.rpnhma_webApplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(final String name);
}

