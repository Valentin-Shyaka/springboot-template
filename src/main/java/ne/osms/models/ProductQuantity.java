package ne.osms.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import ne.osms.audits.TimestampAudit;
import ne.osms.dtos.NewProductQuantityDTO;
import ne.osms.enums.EProductQuantityOperation;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_quantity")
public class ProductQuantity extends TimestampAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BINARY(16)")
    @Type(type="uuid-binary")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_code")
    private Product product;

    @Column
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation")
    private EProductQuantityOperation operation;

    public ProductQuantity(NewProductQuantityDTO dto, Product product) {
        this.product = product;
        this.quantity = dto.getQuantity();
        this.operation = dto.getOperation();
    }
}
