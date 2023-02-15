package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Rejected extends AbstractEvent {

    private Long id;
    private String foodId;
    private Long orderId;
    private String status;
}
