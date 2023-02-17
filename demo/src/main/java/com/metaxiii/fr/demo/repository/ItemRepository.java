package com.metaxiii.fr.demo.repository;

import com.metaxiii.fr.demo.entity.Item;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends R2dbcRepository<Item, UUID> {}
