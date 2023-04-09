package tdtu.edu.vn.giuaki.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="billaccept")
public class BillAccept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idProduct;
    private String productName;
    private String color;
    private String brand;

    private Long price;

    private int quantity;
    private int size;
    private String NameCustomer;
    private String address;

    private String Status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private String orderDate;

}
