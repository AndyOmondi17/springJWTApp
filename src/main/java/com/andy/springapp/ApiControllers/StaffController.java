package com.andy.springapp.ApiControllers;

import com.andy.springapp.model.Role;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.andy.springapp.exception.ResourceNotFoundException;
import com.andy.springapp.model.User;
import com.andy.springapp.repo.UserRepo;
import com.andy.springapp.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StaffController {

    private final UserService userService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/staff")
    public ResponseEntity<List<User>>getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/staff/save")
    public ResponseEntity<User>saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/staff/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @DeleteMapping(value = "/staff/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteStaff(@PathVariable("id")Long id){
        User user= userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff not exist with id:" + id));
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/staff/delete/{id}").toUriString());
        userRepo.delete(user);
        return new  ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<?>saveRole(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

//    @PutMapping(value = "/api/staff/{id}")
////    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Staff> editStaff(@PathVariable("id") int id,@RequestBody() Staff staff){
//        return staffService.updateStaff(id,staff);
//    }

//    @DeleteMapping(value = "/api/staff/{id}")
////    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<HttpStatus> deleteStaff(@PathVariable("id")int id){
//        return staffService.removeStaff(id);
//    }


//        implement pages
//    @GetMapping(value = "/api/staff/pages")
//    public Page<Staff> getAllStaffs(@RequestParam(defaultValue = "0") Integer pageNo,
//                                    @RequestParam(defaultValue = "10") Integer pageSize){
//        Pageable pageable = PageRequest.of(pageNo, pageSize);
//        return staffService.getStaffs(pageable);
//    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Check the header
        String authorizationHeader = request.getHeader(AUTHORIZATION);
//        Check that the header is not null and starts with the word Bearer
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
//                Get the refresh token and remove Bearer
                String refresh_token = authorizationHeader.substring("Bearer ".length());
//                Get the algorithm
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//                Verify the algorithm
                JWTVerifier verifier = JWT.require(algorithm).build();
//                Decode the token
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
//                Get the username
                String username = decodedJWT.getSubject();
//                Find the user in the system
                User user = userService.getUser(username);
//                Use the user to create the token
                String access_token = JWT.create()
                        .withSubject(user.getUsername()) //Pass the username
                        .withExpiresAt(new Date(System.currentTimeMillis() +10 * 60 * 1000)) //Give the token an expiry date
                        .withIssuer(request.getRequestURL().toString()) //Make sure issuer is you
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
//                        Sign token with the same algorithm used above
                        .sign(algorithm);
//                Create the token
                Map<String, String> tokens = new HashMap<>();
//                Parse the access_token and refresh_token
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
//                Call the response
//                log.error("Error logging in: {}", exception.getMessage());
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
//                    response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh Token is missing");
        }
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
