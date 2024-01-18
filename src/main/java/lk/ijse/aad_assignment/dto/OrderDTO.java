package lk.ijse.aad_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private String date;
    private String order_id;
    private String cus_name;
    private Double net_total;
}
