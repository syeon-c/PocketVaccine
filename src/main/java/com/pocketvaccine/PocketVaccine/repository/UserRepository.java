package com.pocketvaccine.PocketVaccine.repository;

import com.pocketvaccine.PocketVaccine.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
