package com.pocketvccn.pocketvaccine.repository;

import com.pocketvccn.pocketvaccine.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
    Optional<User> findByUserId(Long userId);

//    List<User> findAll();
//    @Query("select u from user u where u.userID=:userID and u.password=:password")
//    User selectUserInfo(@Param("userID")String userID,@Param("password")String password);
}
