package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationLogRepository notificationLogRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_NoticeKakao(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener NoticeKakao : " + accepted + "\n\n");


        

        // Sample Logic //
        NotificationLog.noticeKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_NoticeKakao(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener NoticeKakao : " + rejected + "\n\n");


        

        // Sample Logic //
        NotificationLog.noticeKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_NoticeKakao(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener NoticeKakao : " + cooked + "\n\n");


        

        // Sample Logic //
        NotificationLog.noticeKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_NoticeKakao(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener NoticeKakao : " + paid + "\n\n");


        

        // Sample Logic //
        NotificationLog.noticeKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_NoticeKakao(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener NoticeKakao : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        NotificationLog.noticeKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_NoticeKakao(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener NoticeKakao : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        NotificationLog.noticeKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_NoticeKakao(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener NoticeKakao : " + delivered + "\n\n");


        

        // Sample Logic //
        NotificationLog.noticeKakao(event);
        

        

    }

}


