package lk.ijse.aad_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String cus_id;
    private String name;
    private String address;
    private String contact_no;
}
