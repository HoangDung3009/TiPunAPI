package com.example.tipunapi.services.bill;

import com.example.tipunapi.models.Bill;
import com.example.tipunapi.models.Payment;
import com.example.tipunapi.models.Room;
import com.example.tipunapi.models.User;
import com.example.tipunapi.repositories.BillRepository;
import com.example.tipunapi.services.payment.PaymentService;
import com.example.tipunapi.services.room.RoomService;
import com.example.tipunapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private PaymentService paymentService;
    @Override
    public Bill createBill(Long user_id, Long room_id, Long payment_id) {

        User user = userService.findUserById(user_id);
        Room room = roomService.getRoomById(room_id);
        Payment payment = paymentService.getPaymentById(payment_id);

        Bill b = new Bill();
        b.setBillUser(user);
        b.setRoom(room);
        b.setPayment(payment);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        b.setCreateDate(formatter.format(date));

        Bill b1 = billRepository.saveAndFlush(b);
        if (b1.getId() != 0){
            room.setStatus(true);
            roomService.editRoom(room);
        }
        return b1;
    }
}
