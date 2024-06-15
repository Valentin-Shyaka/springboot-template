package ne.osms.services;

import ne.osms.dtos.NewProductQuantityDTO;
import ne.osms.models.ProductQuantity;

import java.util.List;
import java.util.UUID;

public interface IProductQuantityService {

    Integer byProduct(String productCode);

    ProductQuantity newQuantity(NewProductQuantityDTO dto);
}
