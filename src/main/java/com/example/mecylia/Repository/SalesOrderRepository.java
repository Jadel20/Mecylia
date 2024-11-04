package com.example.mecylia.Repository;

import com.example.mecylia.model.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
}
