package com.metaxiii.fr.demo.repository;

import com.metaxiii.fr.demo.entity.Item;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, UUID> {}
