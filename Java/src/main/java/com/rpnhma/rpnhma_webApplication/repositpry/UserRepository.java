package com.rpnhma.rpnhma_webApplication.repositpry;

import com.rpnhma.rpnhma_webApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(final String username);
}
