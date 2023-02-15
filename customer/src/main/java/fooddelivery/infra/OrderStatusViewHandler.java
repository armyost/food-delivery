package fooddelivery.infra;

import fooddelivery.domain.*;
import fooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusViewHandler {


    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderStatus orderStatus = new OrderStatus();
            // view 객체에 이벤트의 Value 를 set 함
            orderStatus.setStatus("주문됨");
            orderStatus.setOrderId(orderPlaced.getId());
            // view 레파지 토리에 save
            orderStatusRepository.save(orderStatus);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(paid.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("결재됨");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_2(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(accepted.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("접수됨");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_3(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(deliveryStarted.getOrderId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("배달시작됨");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_4(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회
                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(Long.valueOf(delivered.getId()));
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("배달완료");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_5(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(orderCanceled.getId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("주문취소");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_6(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(Long.valueOf(rejected.getOrderId()));
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("가게취소");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCooked_then_UPDATE_7(@Payload Cooked cooked) {
        try {
            if (!cooked.validate()) return;
                // view 객체 조회

                List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(cooked.getId());
                for(OrderStatus orderStatus : orderStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderStatus.setStatus("조리중");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

