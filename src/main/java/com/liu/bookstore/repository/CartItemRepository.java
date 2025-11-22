package com.liu.bookstore.repository;

import com.liu.bookstore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserUserId(Long userId);
    Optional<CartItem> findByUserUserIdAndBookBookId(Long userId, Long bookId);
    void deleteByUserUserId(Long userId);
}