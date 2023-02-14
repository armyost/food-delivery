package fooddelivery;


public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String foodId;
    private String address;
    private String orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getfoodId() {
        return foodId;
    }

    public void setfoodId(String foodId) {
        this.foodId = foodId;
    }
    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
