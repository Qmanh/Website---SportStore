package tdtu.edu.vn.giuaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tdtu.edu.vn.giuaki.entity.Product;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
            + " OR p.brand LIKE %?1%"
            + " OR p.color LIKE %?1%")
    List<Product> search(String keyword);
    List<Product> getProductsByColor(String color);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByPrice(String price);

    List<Product> getProductsByBrandAndColor(String brand,String color);
    List<Product> getProductsByBrandAndPrice(String brand,String price);
    List<Product> getProductsByPriceAndColor(String price,String color);
    List<Product> getProductsByPriceAndColorAndBrand(String price,String color,String brand);
}
