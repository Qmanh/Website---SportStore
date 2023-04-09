package tdtu.edu.vn.giuaki.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String price;
    private String brand;

    private String color;

    private String image;

    public Product(String name,String price,String brand,String color,String image)
    {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.color = color;
        this.image = image;
    }
}
