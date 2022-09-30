package vttp2022.assessment.csf.orderbackend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderRepository{
    
    private static final String SQL_POST_ORDER = "insert into orders (name, email, pizza_size, thick_crust, sauce, toppings, comments) VALUES('?', '?', '?', '?', '?', '?', '?')";
    private static final String SQL_GET_ORDER = "select order_id from orders where email='?' ";


    @Autowired
    private JdbcTemplate template;

}
