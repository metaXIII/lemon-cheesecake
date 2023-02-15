package com.metaxiii.fr.demo.controller;

import com.metaxiii.fr.demo.assembler.ItemAssembler;
import com.metaxiii.fr.demo.model.ItemModel;
import com.metaxiii.fr.demo.service.ItemService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {
  private final ItemService itemService;
  private final ItemAssembler assembler;

  @GetMapping
  public Flux<ResponseEntity<CollectionModel<ItemModel>>> findItems(ServerWebExchange serverWebExchange) {
    return itemService
      .findAll()
      .flatMap(item -> assembler.toCollectionModel(Flux.just(item), serverWebExchange))
      .map(ResponseEntity::ok);
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<ItemModel>> findItem(
    @PathVariable(name = "id") UUID id,
    ServerWebExchange serverWebExchange
  ) {
    return itemService.findById(id).flatMap(item -> assembler.toModel(item, serverWebExchange)).map(ResponseEntity::ok);
  }
}
