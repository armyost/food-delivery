package fooddelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String foodId;
    private Integer qty;
    private String status;
    private String storeId;
    private Long price;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        fooddelivery.external.Payment payment = new fooddelivery.external.Payment();

        // this is Context Mapping (Anti-corruption Layer)
        payment.setOrderId(String.valueOf(getId()));
        if(getPrice()!=null)
            payment.setPrice(Double.valueOf(getPrice()));

        Application.applicationContext.getBean(fooddelivery.external.PaymentService.class)
                .pay(payment);


    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getItem() {
        return foodId;
    }

    public void setItem(String foodId) {
        this.foodId = foodId;
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
}
