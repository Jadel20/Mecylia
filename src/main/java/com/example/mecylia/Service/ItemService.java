package com.example.mecylia.Service;

import com.example.mecylia.Repository.ItemRepository;
import com.example.mecylia.Repository.SalesOrderRepository;
import com.example.mecylia.model.Item;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final SalesOrderRepository salesOrderRepository;

    @Transactional
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    @Transactional
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }


    public Item updateItem(Long id, Item updateItemData) {
        Optional<Item> itemToUpdateOptional = itemRepository.findById(id);
        if (itemToUpdateOptional.isEmpty()){
            return null;
        }
        Item itemToUpdate = itemToUpdateOptional.get();

        itemToUpdate.setTitle(updateItemData.getTitle());
        itemToUpdate.setDescription(updateItemData.getDescription());
        itemToUpdate.getItemSize();
        itemToUpdate.getColor();
        itemToUpdate.setPrice(updateItemData.getPrice());
        itemToUpdate.getQuantityAvailable();

        return itemRepository.save(itemToUpdate);
    }

    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

}