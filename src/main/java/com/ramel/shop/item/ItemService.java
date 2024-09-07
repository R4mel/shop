package com.ramel.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(@ModelAttribute Item item) {
        itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public void modifyItem(Long id, String title, Integer price) throws Exception {
        Item item = new Item();
        if (!title.isEmpty() && title.length() < 100) {
            item.setId(id);
            item.setTitle(title);
            item.setPrice(price);
            itemRepository.save(item);
        } else throw new Exception();
    }
}
