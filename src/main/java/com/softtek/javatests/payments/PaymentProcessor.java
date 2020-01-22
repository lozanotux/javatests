package com.softtek.javatests.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        PaymentResponse response = paymentGateway.requestPayment(new PaymentReqest(amount));
        if (response.getStatus() == PaymentResponse.PaymentStatus.OK) {
            return true;
        } else {
            return false;
        }
    }

}
