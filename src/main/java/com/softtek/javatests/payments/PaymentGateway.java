package com.softtek.javatests.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentReqest request);

}
