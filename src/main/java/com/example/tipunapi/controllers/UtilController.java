package com.example.tipunapi.controllers;

import com.example.tipunapi.models.Utilities;
import com.example.tipunapi.services.utilities.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/utils")
public class UtilController {
    @Autowired
    private UtilService utilService;
    @GetMapping("")
    public List<Utilities> getAllUtils(){
        return utilService.getAllUtils();
    };
}
