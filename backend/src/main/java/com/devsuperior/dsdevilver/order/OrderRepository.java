package com.devsuperior.dsdevilver.order;

import com.devsuperior.dsdevilver.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {
}
