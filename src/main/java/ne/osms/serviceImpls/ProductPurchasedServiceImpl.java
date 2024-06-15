package ne.osms.serviceImpls;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ne.osms.dtos.NewProductQuantityDTO;
import ne.osms.dtos.PurchaseProductDTO;
import ne.osms.enums.EProductQuantityOperation;
import ne.osms.models.ProductPurchased;
import ne.osms.models.ProductQuantity;
import ne.osms.models.User;
import ne.osms.repositories.IProductPurchasedRepository;
import ne.osms.services.IProductPurchasedService;
import ne.osms.services.IProductQuantityService;
import ne.osms.services.IUserService;

import java.util.List;

@Service
public class ProductPurchasedServiceImpl implements IProductPurchasedService {

    private final IProductPurchasedRepository repository;

    private final IUserService service;

    private final IProductQuantityService productQuantityService;

    public ProductPurchasedServiceImpl(IProductPurchasedRepository repository, IUserService service, IProductQuantityService productQuantityService) {
        this.repository = repository;
        this.service = service;
        this.productQuantityService = productQuantityService;
    }

    @Override
    public List<ProductPurchased> byLoggedInCustomer() {
        User customer = service.getLoggedInUser();
        return repository.findByCustomer(customer);
    }

    @Override
    public List<ProductPurchased> all() {
        return repository.findAll();
    }

    @Override
    public Page<ProductPurchased> allPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductPurchased purchase(PurchaseProductDTO dto) {
        User customer = service.getLoggedInUser();

        NewProductQuantityDTO newProductQuantityDTO = new NewProductQuantityDTO(dto.getCode(),dto.getQuantity(), EProductQuantityOperation.OUT);

        ProductQuantity productQuantity = productQuantityService.newQuantity(newProductQuantityDTO);

        ProductPurchased productPurchased = new ProductPurchased(productQuantity,customer);

        return repository.save(productPurchased);
    }
}
