package lk.ijse.aad_assignment.db;

import lk.ijse.aad_assignment.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB {

    public boolean saveCustomer(CustomerDTO customerDTO, Connection connection){
        String saveCustomer = "INSERT INTO customer(cus_id,name,nic,address) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveCustomer);
            preparedStatement.setString(1,customerDTO.getCus_id());
            preparedStatement.setString(2,customerDTO.getName());
            preparedStatement.setString(3,customerDTO.getNic());
            preparedStatement.setString(4,customerDTO.getAddress());

            return preparedStatement.executeUpdate()!=0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<CustomerDTO> getAllCustomer(Connection connection) {
        ArrayList<CustomerDTO> customerDTOS  = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");
            ResultSet rst = preparedStatement.executeQuery();
            while (rst.next()){
                customerDTOS.add(new CustomerDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4)
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customerDTOS;
    }

    public boolean updateCustomer(CustomerDTO customerDTO, Connection connection) {
        try {
            var preparedStatement = connection.prepareStatement("UPDATE customer set name=?, nic=?, address=? where cus_id=?");
            preparedStatement.setString(1, customerDTO.getName());
            preparedStatement.setString(2, customerDTO.getNic());
            preparedStatement.setString(3, customerDTO.getAddress());
            preparedStatement.setString(4, customerDTO.getCus_id());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCustomer(String cusId, Connection connection) {
        try {
            var preparedStatement = connection.prepareStatement("DELETE from customer WHERE cus_id=?");
            preparedStatement.setString(1,cusId);

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
