package com.metaxiii.fr.demo.assembler;

import com.metaxiii.fr.demo.controller.ItemController;
import com.metaxiii.fr.demo.entity.Item;
import com.metaxiii.fr.demo.model.ItemModel;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ItemAssembler implements ReactiveRepresentationModelAssembler<Item, ItemModel> {

    @Override
    public Mono<ItemModel> toModel(final Item entity, final ServerWebExchange exchange) {
        return Mono.just(ItemModel.builder().id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdAt(Date.from(entity.getCreatedAt()))
                .updateAt(Date.from(entity.getUpdatedAt()))
                .build()
                .add(linkTo(methodOn(ItemController.class).findItem(entity.getId(), exchange)).withSelfRel())
                .add(linkTo(methodOn(ItemController.class).findItems(exchange)).withRel("List of items")));
    }
}
