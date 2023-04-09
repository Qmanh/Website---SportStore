package tdtu.edu.vn.giuaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.vn.giuaki.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
