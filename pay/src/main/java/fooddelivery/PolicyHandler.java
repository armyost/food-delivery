package fooddelivery;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{


    @Autowired PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelled_CancelPayment(@Payload OrderCancelled orderCancelled){

        if(orderCancelled.isMe()){
            System.out.println("##### listener CancelPayment : " + orderCancelled.toJson());

            Payment payment = new Payment();

            payment.setAction("취소");

            paymentRepository.save(payment);
        }
    }

}
