package com.horustek.gda.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class PruebaResource {
    @GetMapping(value = "/hello")
    public String hello(){
        return "Nuevo";
    }
}
