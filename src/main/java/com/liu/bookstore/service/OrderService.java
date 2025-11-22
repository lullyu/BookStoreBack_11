package com.liu.bookstore.service;

import com.liu.bookstore.entity.*;
import com.liu.bookstore.repository.OrderRepository;
import com.liu.bookstore.repository.OrderItemRepository;
import com.liu.bookstore.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserUserId(userId);
    }

    public List<Order> getOrdersByStatus(Order.OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Transactional
    public Order createOrderFromCart(Long userId, String shippingAddress) {
        // 获取用户购物车商品
        List<CartItem> cartItems = cartItemRepository.findByUserUserId(userId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("购物车为空");
        }

        // 计算总金额并检查库存
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            Book book = cartItem.getBook();
            if (book.getStockQuantity() < cartItem.getQuantity()) {
                throw new RuntimeException("商品 " + book.getTitle() + " 库存不足");
            }
            totalAmount = totalAmount.add(book.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
        }

        // 创建订单
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("用户不存在"));

        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(totalAmount);
        order.setShippingAddress(shippingAddress);
        order.setStatus(Order.OrderStatus.PENDING);

        Order savedOrder = orderRepository.save(order);

        // 创建订单项并更新库存
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            Book book = cartItem.getBook();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setBook(book);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(book.getPrice());

            orderItems.add(orderItem);

            // 更新库存
            book.setStockQuantity(book.getStockQuantity() - cartItem.getQuantity());
            bookService.saveBook(book);
        }

        orderItemRepository.saveAll(orderItems);
        savedOrder.setOrderItems(orderItems);

        // 清空购物车
        cartItemRepository.deleteByUserUserId(userId);

        return savedOrder;
    }

    public Order updateOrderStatus(Long orderId, Order.OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("订单不存在"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("订单不存在"));

        // 恢复库存
        for (OrderItem orderItem : order.getOrderItems()) {
            Book book = orderItem.getBook();
            book.setStockQuantity(book.getStockQuantity() + orderItem.getQuantity());
            bookService.saveBook(book);
        }

        order.setStatus(Order.OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}
