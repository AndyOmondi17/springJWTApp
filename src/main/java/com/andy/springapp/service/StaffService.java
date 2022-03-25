//package io.getarrays.userservice.service;;
//
//import io.getarrays.userservice.exception.ResourceNotFoundException;
//import io.getarrays.userservice.model.Staff;
//import io.getarrays.userservice.model.User;
//import io.getarrays.userservice.repo.FilmRepo;
//import io.getarrays.userservice.repo.StaffRepo;
//import com.movies.app.Controller.dto.StaffDto;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.transaction.Transactional;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//@Slf4j
//public class StaffService {
//
//    @Autowired
//    private StaffRepo staffRepo;
//
//    private PasswordEncoder passwordEncoder;
//
//
//    public StaffService(StaffRepo staffRepo) {
//        this.staffRepo = staffRepo;
//    }
//
//    public List<Staff> getStaff(){
//        return staffRepo.findAll();
//    }
//
//    public Page<Staff> getStaffs(Pageable pageable) {
//    return staffRepo.findAll(pageable);
//
//    }
//
//    public void addNewStaff(Staff staff) {
//        staffRepo.save(staff);
//    }
//
//    public void saveStaff(Staff staffDto){
//        staffRepo.save(staffDto);
//    }
//
//    public ResponseEntity<?> staffAuthenticate( @RequestBody StaffDto staff)  {
//        String username = staff.getUsername();
//        String password = staff.getPassword();
//        String email = staff.getEmail();
//        Staff staff1 = staffRepo.staffLogin(email,username,password)
//                .orElseThrow(()->new ResourceNotFoundException("Could not findUser with email = " + email + "or username "+ username));
//        staff.setUsername(staff1.getUsername());
//        staff.setEmail(staff1.getEmail());
//        staff.setPassword(staff1.getPassword());
//
//        return ResponseEntity.ok(staff1);
//    }
//
//
//
//
//    public ResponseEntity<Staff> getStaffByUsername(@PathVariable String username){
//        Staff staff= staffRepo.findByUsername(username)
//                .orElseThrow(()->new ResourceNotFoundException("Staff not exist with username:" + username));
//        return new ResponseEntity<>(staff, HttpStatus.OK);
//    }
//
//    public ResponseEntity<Staff> getStaffByUsernameOrEmail(@PathVariable String username,@PathVariable String email){
//        Staff staff= staffRepo.findByUsernameOrEmail(username,email)
//                .orElseThrow(()->new ResourceNotFoundException("Staff not exist with either username:" + username +" "+email));
//        return new ResponseEntity<>(staff, HttpStatus.OK);
//    }
//
//    public ResponseEntity<Staff> getStaffByEmail(@PathVariable String email){
//        Staff staff= staffRepo.findByEmail(email)
//                .orElseThrow(()->new ResourceNotFoundException("Staff not exist with email:" + email));
//        return new ResponseEntity<>(staff, HttpStatus.OK);
//    }
//
//    public ResponseEntity<Staff> getStaffById(@PathVariable int id){
//        Staff staff= staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff not exist with id:" + id));
//        return new ResponseEntity<>(staff, HttpStatus.OK);
//    }
//
//    public ResponseEntity<Staff> updateStaff(@PathVariable int id,@RequestBody Staff staffDetails){
////        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//        Staff staff= staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff not exist with id:" + id));
//        staffDetails.setUsername(staff.getUsername());
//        return ResponseEntity.ok(staff);
//    }
//
//    public  ResponseEntity<HttpStatus> removeStaff(@PathVariable int id){
//        Staff staff= staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff not exist with id:" + id));
//        staffRepo.delete(staff);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
