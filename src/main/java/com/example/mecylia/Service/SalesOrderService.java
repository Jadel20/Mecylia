package com.example.mecylia.Service;


import com.example.mecylia.Repository.CartRepository;
import com.example.mecylia.Repository.CustomerRepository;
import com.example.mecylia.Repository.ItemRepository;
import com.example.mecylia.Repository.SalesOrderRepository;
import com.example.mecylia.model.Cart;
import com.example.mecylia.model.Item;
import com.example.mecylia.model.SalesOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SalesOrderService extends SalesOrder {

    private final SalesOrderRepository salesOrderRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    // Create an order
    public SalesOrder createSalesOrder (SalesOrder salesOrder) {
      return salesOrderRepository.save(salesOrder);
    }

    //Find order by ID
    public List<SalesOrder> findAll () {
    return salesOrderRepository.findAll();
    }

    //Find sales order by ID
    public SalesOrder findById (Long id) {
    return salesOrderRepository.findById(id).orElse(null);
    }

    //to update sales order
    public SalesOrder updateSalesOrder (SalesOrder salesOrder, Long id) {
        var salesOrderToUpdate = salesOrderRepository.findById(id);
        if (salesOrderToUpdate.isEmpty()) {
            return null;
        } else {
            salesOrder.setId(id);
            return salesOrderRepository.save(salesOrder);
        }
    }

    //Add an item to an order
    public void addItemToCart (Item item) {
    this.itemRepository.save(item);
    item.getSalesOrders().add(this);
    }

    //Remove an item to the order
    public void removeItemFromCart (Item item) {
        this.itemRepository.delete(item);
        item.getSalesOrders().remove(this);
    }

    //Delete order
    public void deleteSalesOrderById (Long id) {
        salesOrderRepository.deleteById(id);
    }
}
