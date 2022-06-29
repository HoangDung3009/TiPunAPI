package com.example.tipunapi.services.bill;

import com.example.tipunapi.models.Bill;

public interface BillService {
    Bill createBill(Long user_id, Long room_id, Long payment_id);
}
