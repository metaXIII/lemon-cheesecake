package com.metaxiii.fr.demo.service.impl;

import com.metaxiii.fr.demo.entity.Item;
import com.metaxiii.fr.demo.repository.ItemRepository;
import com.metaxiii.fr.demo.service.ItemService;
import java.time.Instant;
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
    //    Flux<Item> all = itemRepository.findAll().switchIfEmpty(e -> System.out.println(e.toString()));
    return Flux.just(
      Item
        .builder()
        .id(UUID.randomUUID())
        .description("some desc")
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .build(),
      Item
        .builder()
        .id(UUID.randomUUID())
        .description("some desc")
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .build(),
      Item
        .builder()
        .id(UUID.randomUUID())
        .description("some desc")
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .build()
    );
  }

  @Override
  public Mono<Item> findById(final UUID id) {
    return Mono.just(
      Item
        .builder()
        .id(UUID.randomUUID())
        .description("some desc")
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .build()
    );
    //    return itemRepository.findById(id);
  }
}
