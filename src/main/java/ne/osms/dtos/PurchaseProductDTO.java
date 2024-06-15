package ne.osms.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PurchaseProductDTO {

    @NotBlank
    private String code;

    @NotNull
    private Integer quantity;
}