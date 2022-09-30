package vttp2022.assessment.csf.orderbackend.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.RowSet;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import vttp2022.assessment.csf.orderbackend.models.OrderSummary;
import vttp2022.assessment.csf.orderbackend.models.Order;

public class OrderRepository{
    
    private static final String SQL_POST_ORDER = "insert into orders (name, email, pizza_size, thick_crust, sauce, toppings, comments) VALUES('?', '?', '?', '?', '?', '?', '?')";
    private static final String SQL_GET_ORDER = "select order_id from orders where email='?' ";


    @Autowired
    private JdbcTemplate template;

    public Optional<Object> postOrder(String name, String email, String size, String sauce, String thickCrust, List<String> toppings, String comments)  {
        SqlRowSet rs = template.queryForRowSet(SQL_POST_ORDER, name, email, size, thickCrust, sauce, toppings, comments);
        if (rs.next())
            return Optional.of(Order.create(rs));
        return Optional.empty();
    }

   public List<OrderSummary> getBooks(String email) {

       List<OrderSummary> summaries = new LinkedList<>();
       

       SqlRowSet rs = template.queryForRowSet(SQL_GET_ORDER, email);
       while (rs.next()) {
           OrderSummary summary = OrderSummary.create(rs);
           summaries.add(summary);
       }
       return summaries;
   }
   

}
