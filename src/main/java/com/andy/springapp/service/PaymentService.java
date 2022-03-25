package com.andy.springapp.service;;

import com.andy.springapp.model.Payment;
import com.andy.springapp.repo.PaymentRepo;
import com.andy.springapp.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;


    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public List<Payment> getPayment(){
        return paymentRepo.findAll();
    }

    public void addNewPayment(Payment payment) {
        paymentRepo.save(payment);
    }

    public ResponseEntity<Payment> getPaymentById(@PathVariable int id){
        Payment payment= paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment not exist with id:" + id));
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> updatePayment(@PathVariable int id,@RequestBody Payment paymentDetails){
        Payment payment= paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment not exist with id:" + id));


        paymentDetails.setPaymentDate(payment.getPaymentDate());
        payment.setAmount(payment.getAmount());


        return ResponseEntity.ok(payment);
    }

    public  ResponseEntity<HttpStatus> removePayment(@PathVariable int id){
        Payment payment= paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment not exist with id:" + id));
        paymentRepo.delete(payment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
