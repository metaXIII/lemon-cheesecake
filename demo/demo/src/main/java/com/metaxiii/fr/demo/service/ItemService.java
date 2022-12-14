package com.metaxiii.fr.demo.service;

import com.metaxiii.fr.demo.entity.Item;
import java.util.List;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemService {
  Mono<List<Item>> findAll();

  Mono<Item> findById(UUID id);
}
