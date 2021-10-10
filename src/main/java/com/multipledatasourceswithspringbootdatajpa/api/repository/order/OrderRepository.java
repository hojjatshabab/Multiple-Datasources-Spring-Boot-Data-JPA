package com.multipledatasourceswithspringbootdatajpa.api.repository.order;

import com.multipledatasourceswithspringbootdatajpa.api.model.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
