package lk.ijse.aad_assignment.db;

import lk.ijse.aad_assignment.dto.OrderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDB {
    public List<OrderDTO> getAllOrders(Connection connection) {
        ArrayList<OrderDTO> orderDTOS = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders");
            ResultSet rst = preparedStatement.executeQuery();
            while (rst.next()){
                orderDTOS.add(new OrderDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getDouble(4)
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orderDTOS;
    }

    public boolean placeOrder(OrderDTO orderDTO, Connection connection) {
        String saveOrder = "INSERT INTO orders(date,order_id,cus_name,net_total) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveOrder);
            preparedStatement.setString(1,orderDTO.getDate());
            preparedStatement.setString(2,orderDTO.getOrder_id());
            preparedStatement.setString(2,orderDTO.getCus_name());
            preparedStatement.setString(2, String.valueOf(orderDTO.getNet_total()));


            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
