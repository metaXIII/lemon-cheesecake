package com.metaxiii.fr.demo.controller;

import com.metaxiii.fr.demo.assembler.ItemAssembler;
import com.metaxiii.fr.demo.model.ItemModel;
import com.metaxiii.fr.demo.service.ItemService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

  private final ItemService itemService;
  private final ItemAssembler assembler;

  @GetMapping
  public Mono<ResponseEntity<ItemModel>> findItems(ServerWebExchange serverWebExchange) {
    itemService.findAll()
            .flatMap(items -> assembler.toModel(items, serverWebExchange))
            .

            .flatMap(items -> assembler.toCollectionModel(Flux.just(items), serverWebExchange));
    collectionModelFlux
            .map(ResponseEntity::ok);
    return null;
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<ItemModel>> findItem(@PathVariable(name = "id") UUID id, ServerWebExchange serverWebExchange) {
    return itemService.findById(id)
            .map(item -> assembler.toModel(item, serverWebExchange))
            .map(ResponseEntity::ok);
  }


}
