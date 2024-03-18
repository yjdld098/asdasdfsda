package com.example.realadmin.repositroy;

import com.example.realadmin.system.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository <OrderDetail, Long> {


    Optional<OrderDetail> findByItemId(long l);
}