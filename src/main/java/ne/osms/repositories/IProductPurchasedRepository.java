package ne.osms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ne.osms.models.ProductPurchased;
import ne.osms.models.User;

import java.util.List;
import java.util.UUID;

public interface IProductPurchasedRepository extends JpaRepository<ProductPurchased, UUID> {
    List<ProductPurchased> findByCustomer(User customer);
}
