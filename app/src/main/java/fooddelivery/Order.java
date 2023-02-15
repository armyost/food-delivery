package fooddelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;



@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String item;
    private Integer qty;
    private String status;
    private String storeId;
    private Long price;
    private String address;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        fooddelivery.external.Payment payment = new fooddelivery.external.Payment();

        
        //jpkim 추가
        System.out.println("## Order.java ## String.valueOf(getId()"+String.valueOf(getId()));
        System.out.println("## Order.java ## Double.valueOf(getPrice()"+Double.valueOf(getPrice()));
        System.out.println("## Order.java ## String.valueOf(getItem())"+String.valueOf(getItem()));
        System.out.println("## Order.java ## Integer.valueOf(getQty())"+Integer.valueOf(getQty()));
        System.out.println("## Order.java ## String.valueOf(getAddress())"+String.valueOf(getAddress()));
   
        //jpkim 추가


        // this is Context Mapping (Anti-corruption Layer)
        payment.setOrderId(String.valueOf(getId()));
        if(getPrice()!=null)
            payment.setPrice(Double.valueOf(getPrice()));
            

        // jpkim 추가
        
        if(getItem()!=null)
            payment.setItem(String.valueOf(getItem()));

        if(getAddress()!=null)
            payment.setAddress(String.valueOf(getAddress()));

        // jpkim 추가

        Application.applicationContext.getBean(fooddelivery.external.PaymentService.class)
                .pay(payment);


        
    }
    //jpkim 추가
    @PostRemove
    public void onPostUpdate(){
        OrderCancelled orderCancelled = new OrderCancelled();
        orderCancelled.setOrderId(String.valueOf(getId()));
        orderCancelled.publish();
   
    }

    @PreUpdate
    public void onPreUpdate(){
    }


    //jpkim 추가


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    

    //jpkim 추가
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //jpkim 추가
}
