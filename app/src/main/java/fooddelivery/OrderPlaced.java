package fooddelivery;

public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String foodId;
    private Integer qty;

    public OrderPlaced(){
        super();
    }

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
    public Integer getqty() {
        return qty;
    }

    public void setqty(Integer qty) {
        this.qty = qty;
    }
}
