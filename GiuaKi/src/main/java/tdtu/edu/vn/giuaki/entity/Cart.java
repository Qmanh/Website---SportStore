package tdtu.edu.vn.giuaki.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="cart")
public class Cart {
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private String orderDate;

}
