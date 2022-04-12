package com.rpnhma.rpnhma_webApplication.repositpry;

import com.rpnhma.rpnhma_webApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
