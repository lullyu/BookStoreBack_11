package com.liu.bookstore.service;

import com.liu.bookstore.entity.CartItem;
import com.liu.bookstore.entity.User;
import com.liu.bookstore.entity.Book;
import com.liu.bookstore.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public List<CartItem> getCartItems(Long userId) {
        return cartItemRepository.findByUserUserId(userId);
    }

    public CartItem addToCart(Long userId, Long bookId, Integer quantity) {
        Optional<CartItem> existingCartItem = cartItemRepository.findByUserUserIdAndBookBookId(userId, bookId);

        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            return cartItemRepository.save(cartItem);
        } else {
            User user = userService.getUserById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            Book book = bookService.getBookById(bookId)
                    .orElseThrow(() -> new RuntimeException("Book not found"));

            CartItem newCartItem = new CartItem();
            newCartItem.setUser(user);
            newCartItem.setBook(book);
            newCartItem.setQuantity(quantity);

            return cartItemRepository.save(newCartItem);
        }
    }

    public void updateCartItemQuantity(Long cartItemId, Integer quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void clearCart(Long userId) {
        cartItemRepository.deleteByUserUserId(userId);
    }
}
