package ne.osms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ne.osms.dtos.CreateOrUpdateProductDTO;
import ne.osms.payload.ApiResponse;
import ne.osms.services.IProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductController {
    private final IProductService service;


    @Autowired
    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(ApiResponse.success(service.all()));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody CreateOrUpdateProductDTO dto) {
        return ResponseEntity.ok(ApiResponse.success(this.service.register(dto)));
    }
}
