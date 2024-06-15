package ne.osms.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ne.osms.dtos.PurchaseProductDTO;
import ne.osms.models.ProductPurchased;

import java.util.List;

public interface IProductPurchasedService {

    List<ProductPurchased> byLoggedInCustomer();

    List<ProductPurchased> all();

    Page<ProductPurchased> allPaginated(Pageable pageable);


    ProductPurchased purchase(PurchaseProductDTO dto);
}
