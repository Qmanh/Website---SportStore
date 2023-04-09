package tdtu.edu.vn.giuaki.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tdtu.edu.vn.giuaki.entity.Cart;

import tdtu.edu.vn.giuaki.repository.CartRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService {
    Map<Integer, Cart> maps = new HashMap<>();

    @Autowired
    private CartRepository cartRepository;

    public void save(Cart cartItem){cartRepository.save(cartItem);}
    public Cart findById(int id){return cartRepository.findById(id).get();}
    public void delete(int id){cartRepository.deleteById(id);}
    public List<Cart> listAll(){return cartRepository.findAll();}
    public void add(Cart item){
        Cart cartItem = maps.get(item.getIdProduct());
        if(cartItem == null)
        {
            maps.put(item.getIdProduct(),item);
        }else
        {
            cartItem.setQuantity(cartItem.getQuantity()+1);
        }
    }

    public void remove(int id){
        maps.remove(id);
    }
    public Cart update(int productID,int quantity,String name,String address,int size){
        Cart cartItem = maps.get(productID);
        cartItem.setQuantity(quantity);
        cartItem.setAddress(address);
        cartItem.setNameCustomer(name);
        cartItem.setSize(size);
        return cartItem;
    }

    public void clear(){
        maps.clear();
    }

    public Collection<Cart> getAllItem(){
        return maps.values();
    }
    public int getCount(){
        return maps.values().size();
    }
    public Long getAmount(){
        return maps.values().stream()
                .mapToLong(item ->   item.getQuantity() * item.getPrice())
                .sum();
    }

}
