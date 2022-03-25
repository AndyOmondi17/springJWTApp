//package io.getarrays.userservice.ApiControllers;
//
//
//import com.movies.app.Controller.dto.StaffDto;
//
//import io.getarrays.userservice.model.Staff;
//import io.getarrays.userservice.service.StaffService;
//import jdk.internal.util.Preconditions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//
//@RestController
//@RequestMapping(path = "/")
//public class StaffController {
//
//    @Autowired
//    private StaffService staffService;
//
//    public StaffController(StaffService staffService) {
//        this.staffService = staffService;
//    }
//
//    // get all actors
//    @GetMapping(value = "/api/staff")
//    public List<Staff> getAllStaff(){
//        return staffService.getStaff();
//    }
//
//    @GetMapping(value = "/api/staff/pages")
//    public Page<Staff> getAllStaffs(@RequestParam(defaultValue = "0") Integer pageNo,
//                                    @RequestParam(defaultValue = "10") Integer pageSize){
//        Pageable pageable = PageRequest.of(pageNo, pageSize);
//        return staffService.getStaffs(pageable);
//    }
//
//    //    I can't post an actor
//    //create actor for api
//    @PostMapping("/api/staff")
//    public void createCountry(@RequestBody Staff country){
//        staffService.addNewStaff(country);
//    }
//
//    @PostMapping("/api/staff/staffLogin")
//    public ResponseEntity<?> staffLogin(@RequestBody StaffDto staff){
//        return staffService.staffAuthenticate(staff);
//    }
//
//    @GetMapping("/api/staff/username/{username}")
//    public ResponseEntity<Staff> findStaffByUsername(@PathVariable("username")String username){
//        return staffService.getStaffByUsername(username);
//    }
//
//    @GetMapping("/api/staff/email/{email}")
//    public ResponseEntity<Staff> findStaffByEmail(@PathVariable("email")String email){
//        return staffService.getStaffByEmail(email);
//    }
//
//    @GetMapping("/api/staff/usermail/{usermail}")
//    public ResponseEntity<Staff> findStaffByEmailOrUsername(@PathVariable("usermail")String email,@PathVariable("usermail")String username){
//        return staffService.getStaffByUsernameOrEmail(email,username);
//    }
//
//    //    get actor by id
//    @GetMapping(value = "/api/staff/{id}")
//    public ResponseEntity<Staff> getStaffById(@PathVariable("id")Integer id){
//        return staffService.getStaffById(id);
//    }
//
//    // update actor Rest API
//    @PutMapping(value = "/api/staff/{id}")
////    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Staff> editStaff(@PathVariable("id") int id,@RequestBody() Staff staff){
//        return staffService.updateStaff(id,staff);
//    }
//
//    // delete actor from rest API
//    @DeleteMapping(value = "/api/staff/{id}")
////    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<HttpStatus> deleteStaff(@PathVariable("id")int id){
//        return staffService.removeStaff(id);
//    }
//
//}
