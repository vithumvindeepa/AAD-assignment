package lk.ijse.aad_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private String item_id;
    private String item_name;
    private Integer qty;
    private Double price;
}
