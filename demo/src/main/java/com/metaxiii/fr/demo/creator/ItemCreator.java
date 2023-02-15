package com.metaxiii.fr.demo.creator;

import com.metaxiii.fr.demo.dto.input.ItemInput;
import com.metaxiii.fr.demo.entity.Item;
import java.time.Instant;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ItemCreator implements DomainCreator<Item, ItemInput> {

  @Override
  public Item toDomain(final ItemInput input) {
    return Item
      .builder()
      .id(UUID.randomUUID())
      .name(input.getName())
      .description(input.getDescription())
      .createdAt(Instant.now())
      .updatedAt(Instant.now())
      .build();
  }
}
