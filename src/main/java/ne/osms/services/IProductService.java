package ne.osms.services;

import ne.osms.dtos.CreateOrUpdateProductDTO;
import ne.osms.models.Product;

import java.util.List;

public interface IProductService {

    Product findByCode(String code);

    List<Product> all();

    Product register(CreateOrUpdateProductDTO dto);
}
