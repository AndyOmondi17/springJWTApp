package com.andy.springapp.ApiControllers;;


import com.andy.springapp.model.Payment;
import com.andy.springapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // get all actors
    @GetMapping(value = "/payment")
    public List<Payment> getAllPayment(){
        return paymentService.getPayment();
    }

    //    I can't post an actor
    //create actor for api
    @PostMapping("/payment")
    public void createPayment(@RequestBody Payment country){
        paymentService.addNewPayment(country);
    }

    //    get actor by id
    @GetMapping(value = "/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id")Integer id){
        return paymentService.getPaymentById(id);
    }

    // update actor Rest API
    @PutMapping(value = "/payment/{id}")
    public ResponseEntity<Payment> editPayment(@PathVariable("id") int id,@RequestBody() Payment country){
        return paymentService.updatePayment(id,country);
    }

    // delete actor from rest API
    @DeleteMapping(value = "/payment/{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable("id")int id){
        return paymentService.removePayment(id);
    }
}
