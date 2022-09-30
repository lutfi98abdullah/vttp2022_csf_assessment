package vttp2022.assessment.csf.orderbackend.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp2022.assessment.csf.orderbackend.models.OrderSummary;
import vttp2022.assessment.csf.orderbackend.services.OrderService;
import vttp2022.assessment.csf.orderbackend.services.PricingService;

@RestController
@RequestMapping(path="/api/order", produces=MediaType.APPLICATION_JSON_VALUE)
public class OrderRestController {
    
    @Autowired
        private OrderService orderSvc;
        private PricingService pricingSvc;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postOrder(@RequestBody String payload) {
    
    }


    @GetMapping(path="{email}")
    public ResponseEntity<String> getOrderSummary(@RequestParam String email) {

        List<OrderSummary> summaries = orderSvc.getOrdersByEmail(email);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (OrderSummary summary: summaries)
            arrBuilder.add(summary.toJson());

        return ResponseEntity.ok(arrBuilder.build().toString());
        }
	}
        

       


}
