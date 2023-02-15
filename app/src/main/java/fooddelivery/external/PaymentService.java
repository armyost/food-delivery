
package fooddelivery.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */

// @FeignClient(name="pay", url="http://localhost:8082")//, fallback = 결제이력ServiceFallback.class)
@FeignClient(name="pay", url="http://pay:8080")//, fallback = 결제이력ServiceFallback.class)
public interface PaymentService {

    @RequestMapping(method= RequestMethod.POST, path="/payments")
    public void pay(@RequestBody Payment Payment);

}