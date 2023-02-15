package fooddelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="OrderProcessing_table")
public class OrderProcessing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    Long orderId;
    String address;
    String item;

    @PostPersist
    public void onPostPersist(){
        DeliveryStarted deliveryStarted = new DeliveryStarted();
        deliveryStarted.setOrderId(String.valueOf(getOrderId()));
        BeanUtils.copyProperties(this, deliveryStarted);
        deliveryStarted.publish();


    }

    @PrePersist
    public void onPrePersist(){
        CouponGenerated couponGenerated = new CouponGenerated();
        BeanUtils.copyProperties(this, couponGenerated);

        //jpkim 추가
        // System.out.println("## OrderProcessing.java ## Long.valueOf(getId()"+Long.valueOf(getId()));
        // System.out.println("## OrderProcessing.java ## Long.valueOf(getOrderId())"+Long.valueOf(getOrderId()));
        System.out.println("## OrderProcessing.java ## String.valueOf(getItem()"+String.valueOf(getItem()));
        System.out.println("## OrderProcessing.java ## String.valueOf(getAddress())"+String.valueOf(getAddress()));
        //jpkim 추가


        couponGenerated.setItem(getItem());
        couponGenerated.setAddress(getAddress());
        //jpkim 추가
        
        couponGenerated.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
