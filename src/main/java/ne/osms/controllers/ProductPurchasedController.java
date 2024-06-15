package ne.osms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ne.osms.dtos.PurchaseProductDTO;
import ne.osms.payload.ApiResponse;
import ne.osms.services.IProductPurchasedService;
import ne.osms.utils.Constants;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-purchased")
@CrossOrigin
public class ProductPurchasedController {
    private final IProductPurchasedService service;


    @Autowired
    public ProductPurchasedController(IProductPurchasedService service) {
        this.service = service;
    }

    @GetMapping("/logged-in-user")
    @PreAuthorize("hasAnyAuthority('CUSTOMER')")
    public ResponseEntity<ApiResponse> getAllByLoggedInCustomer() {
        return ResponseEntity.ok(ApiResponse.success(service.byLoggedInCustomer()));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(ApiResponse.success(service.all()));
    }


    @PostMapping
    @PreAuthorize("hasAnyAuthority('CUSTOMER')")
    public ResponseEntity<ApiResponse> purchase(@Valid @RequestBody PurchaseProductDTO dto) {
        return ResponseEntity.ok(ApiResponse.success(this.service.purchase(dto)));
    }
}
