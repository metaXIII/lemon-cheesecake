package com.metaxiii.fr.demo.controller;

import com.metaxiii.fr.demo.assembler.ItemAssembler;
import com.metaxiii.fr.demo.entity.Item;
import com.metaxiii.fr.demo.model.ItemModel;
import com.metaxiii.fr.demo.service.ItemService;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
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
  public Flux<ResponseEntity<ItemModel>> findItems(ServerWebExchange serverWebExchange) {
    return Flux //      .findAll() //            itemService
      .just(
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
      )
      //    .flatMap(tuple -> stepService.list(tuple).collectList())
      //            .flatMap(list -> {
      //              Slice<Tuple3<Folder, Participant, FolderStep<?>>> slice = new SliceImpl<>(list);
      //              return slice.hasContent() ?
      //                      sliceAssembler.toModel(slice, this::assemble, exchange) :
      //                      sliceAssembler.toEmptyModel(slice, FolderStepModel.class, exchange);
      //            })
      //      .flatMap(
      //        items -> {
      //          Slice<List<Item>> slice = new SliceImpl<>(items);
      //        }
      //      )
      .flatMap(item -> assembler.toModel(item, serverWebExchange))
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
