package com.example.LunaLink.repository;

import com.example.LunaLink.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
