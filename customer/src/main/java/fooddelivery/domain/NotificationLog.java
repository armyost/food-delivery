package fooddelivery.domain;

import fooddelivery.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="NotificationLog_table")
@Data

public class NotificationLog  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String message;


    public static NotificationLogRepository repository(){
        NotificationLogRepository notificationLogRepository = CustomerApplication.applicationContext.getBean(NotificationLogRepository.class);
        return notificationLogRepository;
    }




    public static void noticeKakao(Accepted accepted){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setOrderId(accepted.getOrderId());
        notificationLog.setMessage("접수됨");
        repository().save(notificationLog);

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void noticeKakao(Rejected rejected){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setOrderId(rejected.getOrderId());
        notificationLog.setMessage("취소됨");
        repository().save(notificationLog);

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void noticeKakao(Cooked cooked){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setOrderId(cooked.getOrderId());
        if (cooked.getStatus().equals("start-cook")) {
            notificationLog.setMessage("조리시작");
        } else {
            notificationLog.setMessage("조리완료");
        }
        repository().save(notificationLog);

        /** Example 2:  finding and process
        
        repository().findById(cooked.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void noticeKakao(Paid paid){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setOrderId(paid.getOrderId());
        notificationLog.setMessage("결제완료");
        repository().save(notificationLog);

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void noticeKakao(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setOrderId(orderPlaced.getId());
        notificationLog.setMessage("주문완료");
        repository().save(notificationLog);

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void noticeKakao(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setOrderId(deliveryStarted.getOrderId());
        notificationLog.setMessage("배달시작");
        repository().save(notificationLog);

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }

    public static void noticeKakao(Delivered delivered){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setOrderId(delivered.getId());
        notificationLog.setMessage("배달완료");
        repository().save(notificationLog);

        /** Example 2:  finding and process
        
        repository().findById(delivered.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }

}
