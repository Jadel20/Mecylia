package com.example.mecylia.Controller;

import com.example.mecylia.Service.SalesOrderService;
import com.example.mecylia.model.SalesOrder;
import jakarta.persistence.Id;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor

public class SalesOrderController {
private final SalesOrderService salesOrderService;

//To return all the sale orders
@GetMapping()
public List<SalesOrder> findAll() {
    return salesOrderService.findAll();
}

//To return sale orders by ID
@GetMapping ("/{id}")
public SalesOrder findById(@PathVariable Long id) {
return salesOrderService.findById(id);
}

// To update Sales Order by Id
@PostMapping ("/{id}")
public SalesOrder updateSalesOrder (@RequestBody SalesOrder salesOrder, @PathVariable Long id) {
 return salesOrderService.updateSalesOrder(salesOrder,id);
}

@DeleteMapping
@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSalesOrder (@PathVariable Long id) {
    salesOrderService.deleteSalesOrderById(id);
}
}

