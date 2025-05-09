package com.Yago.Examen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String homeLogin(){
        return "login_singUp/login";
    }
    @GetMapping("/login")
    public String Login(){
        return "login_singUp/login";
    }
    @GetMapping("/singup")
    public String singup(){
        return "login_singUp/singup";
    }
    @GetMapping("/forgot")
    public String forgot(){
        return "login_singUp/forgot";
    }
    @PostMapping("/login")
    public String home(){
        return "transaccion/tranbsacciones_list";
    }

}
