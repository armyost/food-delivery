package fooddelivery;

public class OrderCancelled extends AbstractEvent {

    private Long id;

    public OrderCancelled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
