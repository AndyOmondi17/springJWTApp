//package io.getarrays.userservice.repo;
//
//
//import io.getarrays.userservice.model.Staff;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface StaffRepo extends JpaRepository<Staff,Integer> {
//
//    @Query("SELECT u FROM Staff u WHERE u.email = ?1") public Optional<Staff> findByEmail(String email);
//
////    find staff by username
//    @Query("SELECT u FROM Staff u WHERE u.username = ?1") public Optional <Staff> findByUsername(String username);
//
//    @Query("SELECT u FROM Staff u WHERE u.email=?1  OR u.username=?2") public  Optional <Staff> findByUsernameOrEmail(String username, String email);
//
//    @Query("SELECT u FROM Staff u WHERE u.email=?1 OR u.username=?2 AND u.password=?3") Optional<Staff> staffLogin(String email,String username,String password);
//
//
//
//    Boolean existsByUsername(String username);
//    Boolean existsByEmail(String email);
//}
