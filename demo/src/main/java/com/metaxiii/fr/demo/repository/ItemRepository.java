package com.metaxiii.fr.demo.repository;

import com.metaxiii.fr.demo.entity.Item;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item, UUID> {}
