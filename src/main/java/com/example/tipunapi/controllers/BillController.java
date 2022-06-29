package com.example.tipunapi.controllers;

import com.example.tipunapi.models.Bill;
import com.example.tipunapi.services.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bills")
public class BillController {
    @Autowired
    private BillService billService;
    @PostMapping("/create")
    public Bill createBill(@RequestParam Long user_id,
                           @RequestParam Long room_id,
                           @RequestParam Long payment_id){
        return billService.createBill(user_id, room_id, payment_id);
    }
}
