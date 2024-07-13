package com.jtsp.springbootcookie.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> hello(HttpServletResponse response) {
        // Create a new cookie
        Cookie cookie = new Cookie("username", "JohnDoe");

        // Set the maximum age of the cookie in seconds (e.g., 7 days)
        cookie.setMaxAge(7 * 24 * 60 * 60);

        // Set the path for the cookie
        cookie.setPath("/");
        cookie.setDomain("localhost");

        // Optional: Set HttpOnly and Secure flags
        cookie.setHttpOnly(true);
        cookie.setSecure(true);

        // Add the cookie to the response
        response.addCookie(cookie);

        // Return a response entity with a message
        return ResponseEntity.ok("successfully");
    }
}
