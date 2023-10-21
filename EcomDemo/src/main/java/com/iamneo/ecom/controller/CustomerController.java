package com.iamneo.ecom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.iamneo.ecom.constant.Api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@Tag(name = "Customer")
public class CustomerController {

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok().body("Hello Customer");
    }
}
