package com.mct.recipe.Management.System.controlller;

import com.mct.recipe.Management.System.entity.Admin;
import com.mct.recipe.Management.System.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    //-------------- admin SignUp------------------------
    @PostMapping("/admin")
    public ResponseEntity<String> adminSignUp(@RequestBody Admin admin) throws NoSuchAlgorithmException {
        return adminService.adminSignup(admin);
    }

    //-------------- admin SignIn------------------------
    @PostMapping("/admin/signIn")
    public ResponseEntity<String> adminSignIn(@RequestParam String adminEmail,@RequestParam String adminPassword) {
        return adminService.adminSignIn(adminEmail,adminPassword);
    }

    //-------------- admin SignOut------------------------
    @DeleteMapping("/admin/signOut")
    public ResponseEntity<String> adminSignOut(@RequestParam String adminEmail,@RequestParam String tokenValue) {
        return adminService.adminSignOut(adminEmail,tokenValue);
    }



}
