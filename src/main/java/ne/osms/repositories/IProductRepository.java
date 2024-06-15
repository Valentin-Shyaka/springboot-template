package ne.osms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ne.osms.models.Product;

public interface IProductRepository extends JpaRepository<Product,String> {
}
