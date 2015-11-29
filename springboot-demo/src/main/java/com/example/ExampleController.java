package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kapil_shrivastava on 11/29/15.
 */
@RestController
public class ExampleController {

    @RequestMapping("/")
    public String hello(){
       return "Hi There !!!";
    }
}
