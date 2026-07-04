package lk.kvrp.creatorstore.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer's name is required")
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @NotBlank(message = "Customer's email is required")
    @Column(name = "customer_email")
    private String customerEmail;

    @NotBlank(message = "Status is required")
    @Column(nullable = false)
    private String status;

    @NotNull(message = "Total price is required")
    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
    }
}
