package tdtu.edu.vn.giuaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.vn.giuaki.entity.BillAccept;
import tdtu.edu.vn.giuaki.entity.Cart;

public interface BillRepository extends JpaRepository<BillAccept,Integer> {
}
