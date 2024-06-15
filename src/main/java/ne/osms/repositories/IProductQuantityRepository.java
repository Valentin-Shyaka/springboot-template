package ne.osms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ne.osms.models.Product;
import ne.osms.models.ProductQuantity;

import java.util.List;
import java.util.UUID;

public interface IProductQuantityRepository extends JpaRepository<ProductQuantity, UUID> {

    List<ProductQuantity> findByProduct(Product product);
}
