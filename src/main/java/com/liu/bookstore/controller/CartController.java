package com.liu.bookstore.controller;

import com.liu.bookstore.entity.CartItem;
import com.liu.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public List<CartItem> getCartItems(@PathVariable Long userId) {
        return cartService.getCartItems(userId);
    }

    @PostMapping("/{userId}/add")
    public CartItem addToCart(@PathVariable Long userId,
                              @RequestParam Long bookId,
                              @RequestParam(defaultValue = "1") Integer quantity) {
        return cartService.addToCart(userId, bookId, quantity);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<Void> updateCartItem(@PathVariable Long cartItemId,
                                               @RequestParam Integer quantity) {
        cartService.updateCartItemQuantity(cartItemId, quantity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok().build();
    }
}
