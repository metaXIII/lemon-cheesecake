package com.metaxiii.fr.demo.service.impl;

import com.metaxiii.fr.demo.entity.Item;
import com.metaxiii.fr.demo.repository.ItemRepository;
import com.metaxiii.fr.demo.service.ItemService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
  private final ItemRepository itemRepository;

  @Override
  public Flux<Item> findAll() {
    return itemRepository.findAll();
  }

  @Override
  public Mono<Item> findById(final UUID id) {
    return itemRepository.findById(id);
  }
}
