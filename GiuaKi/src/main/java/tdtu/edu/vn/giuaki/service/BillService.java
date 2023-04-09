package tdtu.edu.vn.giuaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.giuaki.entity.BillAccept;
import tdtu.edu.vn.giuaki.entity.Cart;
import tdtu.edu.vn.giuaki.repository.BillRepository;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    public void save(BillAccept billAccept){billRepository.save(billAccept);}
    public List<BillAccept> listAll(){return billRepository.findAll();}
}
