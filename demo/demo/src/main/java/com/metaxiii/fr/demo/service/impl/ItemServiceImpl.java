package com.metaxiii.fr.demo.service.impl;

import com.metaxiii.fr.demo.entity.Item;
import com.metaxiii.fr.demo.repository.ItemRepository;
import com.metaxiii.fr.demo.service.ItemService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;

  @Override
  public Mono<List<Item>> findAll() {
    return Mono.just(itemRepository.findAll());
  }

  @Override
  public Mono<Item> findById(final UUID id) {
    return null;
  }
}
