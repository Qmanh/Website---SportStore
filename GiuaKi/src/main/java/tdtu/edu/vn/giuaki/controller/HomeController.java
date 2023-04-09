package tdtu.edu.vn.giuaki.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tdtu.edu.vn.giuaki.entity.BillAccept;
import tdtu.edu.vn.giuaki.entity.Cart;
import tdtu.edu.vn.giuaki.entity.Product;
import tdtu.edu.vn.giuaki.service.BillService;
import tdtu.edu.vn.giuaki.service.ProductService;
import tdtu.edu.vn.giuaki.service.ShoppingCartService;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    public ProductService service;
    @Autowired
    private ShoppingCartService cartService;
    @Autowired
    private BillService billService;



    private Cart cartItem;
    @RequestMapping("/")
    public String HomePage(Model model)
    {
        return "index";
    }

    @RequestMapping("/product/size")
    public String SizePage(Model model)
    {
        return "size";
    }

    @RequestMapping("/product/listProduct")
    public String viewHomePage(Model model)
    {
        List <Product> listProducts = service.listAll();
        model.addAttribute("listProducts",listProducts);
        return "product";
    }


    @PostMapping(value="/loginUser")
    public String viewLogin(Model model,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password)
    {
        if(username.equals("admin") && password.equals("admin"))
        {
            return "redirect:/Admin/home";
        }
        else if(username !="admin" || password != "admin") {
            model.addAttribute("message","Username Or Password is Incorrect,Please Again!");
        }
        return "login";
    }
    @RequestMapping ("/login")
    public String Login(Model model){
        return "login";
    }

    @RequestMapping("/product/search")
    public String SearchProduct(Model model,
                                @Param("keyword") String keyword)
    {
        List <Product> listProducts = service.listAll(keyword);
        model.addAttribute("listProducts",listProducts);
        model.addAttribute("keyword",keyword);

        return "product";
    }

    @RequestMapping("/Admin/home")
    public String viewHomePage1(Model model)
    {
        List <Product> listProducts = service.listAll();
        model.addAttribute("listProducts",listProducts);
        return "addproduct";
    }

    @GetMapping("/Admin/products/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("product",service.findById(id));
        return "editproduct";
    }
    @PostMapping ("/Admin/edit/{id}")
    public String editProduct(@PathVariable(name = "id") int id,
                              @ModelAttribute("product") Product product,Model model) {
        Product productExisting = service.findById(id);
        productExisting.setId(id);
        productExisting.setName(product.getName());
        productExisting.setPrice(product.getPrice());
        productExisting.setColor(product.getColor());
        productExisting.setBrand(product.getBrand());

        service.upadateProduct(productExisting);
        model.addAttribute("product",product);
        return "redirect:/Admin/home";
    }


    @RequestMapping("/new")
    public String showNewProductPage(Model model)
    {
        Product product = new Product();
        model.addAttribute("product",product);
        return "redirect:/product/listProduct";
    }


    @PostMapping("/Admin/saveProduct")
    public String addProduct(@ModelAttribute("product") Product product,
                             @RequestParam("file")MultipartFile file,
                             @RequestParam("imageName")String imgName, Model model)throws Exception
    {
        String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/image";
        Product newProduct = new Product();
        newProduct.setId(product.getId());
        newProduct.setName(product.getName());
        newProduct.setBrand(product.getBrand());
        newProduct.setPrice(product.getPrice());
        newProduct.setColor(product.getColor());
        String imageUUID = "";
        if(!file.isEmpty())
        {
            imageUUID = file.getOriginalFilename();
            Path fileNameandPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameandPath, file.getBytes());
        }else
        {
            imageUUID = imgName;
        }
        newProduct.setImage(imageUUID);
        service.save(newProduct);
        model.addAttribute("product",product);
        return "redirect:/Admin/home";
    }
    @RequestMapping("/Admin/delete/{id}")
    public String deleteCart(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/Admin/home";
    }

    @RequestMapping("/Admin/bill")
    public String viewBillOrder(Model model)
    {
        List<Cart> cartItems = cartService.listAll();
        model.addAttribute("cartItems",cartItems);
        return  "orderBill";
    }

    @RequestMapping("/product/filter")
    public String viewFilter(@RequestParam(required = false) String brand,
                             @RequestParam(required = false) String color,
                             @RequestParam(required = false) String price,
                             Model model)
    {
        List<Product> listProducts = service.listAll();
        if(brand !="" && color !="" && price !="")
        {
            listProducts = service.getProductsByPriceAndColorAndBrand(price,color,brand);

        } else if (brand!="" && color!="")
        {
            listProducts = service.getProductsByBrandAndColor(brand,color);
        } else if (brand!="" && price!="")
        {
            listProducts = service.getProductsByBrandAndPrice(brand,price);
        } else if (price!=""&&color!="")
        {
            listProducts = service.getProductsByPriceAndColor(price,color);
        }else if(color!="")
        {
            listProducts = service.getProductsByColor(color);
        }else if(price!="")
        {
            listProducts = service.getProductsByPrice(price);
        }
        else if (brand!="") {
            listProducts = service.getProductsByBrand(brand);
        } else
        {
            listProducts = service.listAll();
        }
        model.addAttribute("listProducts",listProducts);

        return "product";
    }


    /*-----------------Shopping Cart-------------------*/
    @RequestMapping("/product/shopping-cart")
    public String viewShoppingCart(Model model)
    {


        model.addAttribute("cartItems",cartService.getAllItem());
        model.addAttribute("totalPrice",cartService.getAmount());
        return "cart";
    }

    @GetMapping("/product/add/{id}")
    public String addCart(@PathVariable("id")int id){
        Product product = service.findById(id);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        if(product !=null)
        {
            cartItem = new Cart();
            cartItem.setIdProduct(product.getId());
            cartItem.setProductName(product.getName());
            cartItem.setPrice(Long.parseLong(product.getPrice()));
            cartItem.setBrand(product.getBrand());
            cartItem.setColor(product.getColor());
            cartItem.setQuantity(1);
            cartItem.setOrderDate(formatter.format(date));

            cartService.add(cartItem);
        }

        return "redirect:/product/shopping-cart";
    }

    @GetMapping("/product/details/{id}")
    public String DetailProduct(@PathVariable("id")int id,Model model)
    {
        Product product = service.findById(id);

        model.addAttribute("product",product);
        return "detailProduct";
    }


    @GetMapping("/product/deleteCart/{id}")
    public String deleteShoppingCart(@PathVariable(name = "id") int id) {
        cartService.remove(id);

        return "redirect:/product/shopping-cart";
    }

    @GetMapping("/product/deleteCartDB/{id}")
    public String deleteShoppingCartDB(@PathVariable(name = "id") int id) {
        cartService.delete(id);

        return "redirect:/Admin/bill";
    }

    @PostMapping("/product/update")
    public String updateQuantity(@RequestParam("id") int id, @RequestParam("quantity")int quantity,
                                 @RequestParam("name") String name, @RequestParam("address") String address,
                                 @RequestParam("size") int size)
    {
        cartService.update(id,quantity,name,address,size);
        return "redirect:/product/shopping-cart";
    }

    /*-----------------Bill Order-------------------*/
    @RequestMapping("/product/order")
    public String viewOrder(Model model)
    {

        cartItem.setPrice(cartService.getAmount());
        cartService.save(cartItem);
        cartService.remove(cartItem.getIdProduct());
        return "GoodBye";
    }

    @GetMapping("/Admin/successCartDB/{id}")
    public String viewBillAccept(Model model,@PathVariable("id") int id)
    {
        Cart cart = cartService.findById(id);
        BillAccept billAccept = new BillAccept();
        if(cart != null) {
            billAccept.setIdProduct(cart.getIdProduct());
            billAccept.setNameCustomer(cart.getNameCustomer());
            billAccept.setProductName(cart.getProductName());
            billAccept.setPrice(cart.getPrice());
            billAccept.setBrand(cart.getBrand());
            billAccept.setColor(cart.getColor());
            billAccept.setQuantity(cart.getQuantity());
            billAccept.setOrderDate(cart.getOrderDate());
            billAccept.setSize(cart.getSize());
            billAccept.setAddress(cart.getAddress());
            billAccept.setStatus("Accept");

            billService.save(billAccept);
            cartService.remove(cart.getId());
            cartService.delete(cart.getId());
            model.addAttribute("bill", billAccept);
        }
        return "redirect:/Admin/bill";
    }

    @GetMapping("/Admin/DenyCartDB/{id}")
    public String viewBillDeny(Model model,@PathVariable("id") int id)
    {
        Cart cartI = cartService.findById(id);
        BillAccept billDeny = new BillAccept();
        if(cartI != null) {
            billDeny.setBrand(cartI.getBrand());
            billDeny.setColor(cartI.getColor());
            billDeny.setQuantity(cartI.getQuantity());
            billDeny.setNameCustomer(cartI.getNameCustomer());
            billDeny.setProductName(cartI.getProductName());
            billDeny.setPrice(cartI.getPrice());
            billDeny.setOrderDate(cartI.getOrderDate());
            billDeny.setIdProduct(cartI.getIdProduct());
            billDeny.setSize(cartI.getSize());
            billDeny.setAddress(cartI.getAddress());
            billDeny.setStatus("Deny");

            billService.save(billDeny);
            cartService.remove(cartI.getId());
            cartService.delete(cartI.getId());
            model.addAttribute("bill", billDeny);
        }
        return "redirect:/Admin/bill";
    }

    @RequestMapping("/Admin/billAccept/save")
    public String viewBillAccept(Model model)
    {
        List<BillAccept> billItems = billService.listAll();
        model.addAttribute("bills",billItems);
        return  "BillAccept";
    }

    private void setDummyCookie(HttpServletResponse response)
    {
        Cookie cookie = new Cookie("dummyCookie","dummyCookie");
        cookie.setMaxAge(2592000);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
