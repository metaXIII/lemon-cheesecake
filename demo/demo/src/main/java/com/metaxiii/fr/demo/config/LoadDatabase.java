package com.metaxiii.fr.demo.config;

import com.metaxiii.fr.demo.entity.Item;
import com.metaxiii.fr.demo.repository.ItemRepository;
import java.time.Instant;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Slf4j
public class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(ItemRepository itemRepository) {
    return args -> {
      final Item item = Item
        .builder()
        .id(UUID.randomUUID())
        .name("some name")
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .build();
      itemRepository.save(item);
      itemRepository
        .findAll()
        .forEach(orderEntity -> log.info("Preloaded " + orderEntity));
    };
  }
}
