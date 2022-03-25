package com.andy.springapp.repo;

import com.andy.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

//    @Query("SELECT u FROM Staff u WHERE u.email = ?1") public Optional<Staff> findByEmail(String email);
//
////    find staff by username
//    @Query("SELECT u FROM Staff u WHERE u.username = ?1") public Optional <Staff> findByUsername(String username);
//
//    @Query("SELECT u FROM Staff u WHERE u.email=?1  OR u.username=?2") public  Optional <Staff> findByUsernameOrEmail(String username, String email);
//
//    @Query("SELECT u FROM Staff u WHERE u.email=?1 OR u.username=?2 AND u.password=?3") Optional<Staff> staffLogin(String email,String username,String password);
}
