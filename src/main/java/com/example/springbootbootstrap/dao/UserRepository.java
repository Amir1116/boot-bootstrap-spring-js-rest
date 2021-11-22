package com.example.springbootbootstrap.dao;

import com.example.springbootbootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
//    public User findByName(String name);

    @Query("SELECT u FROM User u JOIN FETCH u.roleList WHERE u.email = (:email)")
    public User findByName(@Param("email") String email);
}
