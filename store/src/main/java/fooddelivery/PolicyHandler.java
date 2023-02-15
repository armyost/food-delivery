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

    @Autowired OrderProcessingRepository orderProcessingRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_OrderProcessing(@Payload Paid paid){

        if(paid.isMe()){
            System.out.println("##### listener paid : " + paid.toJson());

            OrderProcessing orderProcessing = new OrderProcessing();
            orderProcessing.setOrderId(Long.valueOf(paid.getOrderId()));
            orderProcessingRepository.save(orderProcessing);
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCancelled_CancelOrder(@Payload PaymentCancelled paymentCancelled){

        if(paymentCancelled.isMe()){
            System.out.println("##### listener CancelOrder : " + paymentCancelled.toJson());

            orderProcessingRepository.findById(paymentCancelled.getOrderId()).ifPresent(orderProcessing->{
                orderProcessingRepository.delete(orderProcessing);
            });

        }
    }

}
