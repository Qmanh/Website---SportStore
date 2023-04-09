package tdtu.edu.vn.giuaki.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tdtu.edu.vn.giuaki.entity.Product;
import tdtu.edu.vn.giuaki.repository.ProductRepository;


import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class ProductService {
@Autowired
    private ProductRepository repository;

    public List<Product> listAll(){return repository.findAll();}
    public Product upadateProduct(Product product){return repository.save(product);}

    public void save(Product product){repository.save(product);}

    public Product findById(int id){return repository.findById(id).get();}

    public void delete(int id){repository.deleteById(id);}
    public void deleteAll(){repository.deleteAll();}


    public List<Product> listAll(String keyword)
    {
        if(keyword != null)
        {
            return repository.search(keyword);
        }
        return repository.findAll();
    }


    public List<Product> getProductsByPrice(String price) {
        return repository.getProductsByPrice(price);
    }
    public List<Product> getProductsByColor(String color) {
        return repository.getProductsByColor(color);
    }
    public List<Product> getProductsByBrand(String brand) {
        return repository.getProductsByBrand(brand);
    }

    public List<Product> getProductsByBrandAndColor(String brand,String color){return repository.getProductsByBrandAndColor(brand,color);}
    public List<Product> getProductsByBrandAndPrice(String brand,String price){return repository.getProductsByBrandAndPrice(brand,price);}
    public List<Product> getProductsByPriceAndColor(String price,String color){return repository.getProductsByPriceAndColor(price,color);}
    public List<Product> getProductsByPriceAndColorAndBrand(String price,String color,String brand){return repository.getProductsByPriceAndColorAndBrand(price,color,brand);}
}
