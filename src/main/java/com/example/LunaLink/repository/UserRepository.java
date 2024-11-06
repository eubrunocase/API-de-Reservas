package com.example.LunaLink.repository;

import com.example.LunaLink.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
