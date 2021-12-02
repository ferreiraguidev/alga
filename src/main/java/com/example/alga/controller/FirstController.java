package com.example.alga.controller;

import com.example.alga.model.Customer;
import com.example.alga.service.AtivationCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    private AtivationCustomerService ativationCustomerService;

    public FirstController(AtivationCustomerService ativationCustomerService) {
        this.ativationCustomerService = ativationCustomerService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Customer guilherme = new Customer("Guilherme", "gfamorim@hot.com","981449329");
        ativationCustomerService.ativar(guilherme);
        return "Holly fucking DataBase i knew it was you";

    }
}
