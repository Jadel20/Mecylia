package com.example.mecylia.Controller;

import com.example.mecylia.Service.CartService;
import com.example.mecylia.Service.CustomerService;
import com.example.mecylia.Service.ItemService;
import com.example.mecylia.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor

public class CartController {
    private final CartService cartService;


    //Find all cart
    @GetMapping("/all")
    public List<Cart> findAll () {
    return cartService.findAll();
    }

//    //Find cart by Id
//    @GetMapping("/{id}")
//    public Cart findById(@PathVariable Long id) {
//        return cartService.findCartById(id);
//    }


    //Create a cart
    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cart create (@RequestBody Cart cart) {
        return cartService.create(cart.getId());
    }

    //Delete a cart
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart (@PathVariable Long id) {
        cartService.deleteCartById(id);
    }
  }
