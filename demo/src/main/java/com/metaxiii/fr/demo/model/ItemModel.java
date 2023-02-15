package com.metaxiii.fr.demo.model;

import java.util.Date;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Builder
@Getter
public class ItemModel extends RepresentationModel<ItemModel> {
  private UUID id;
  private String name;
  private String description;
  private Date createdAt;
  private Date updateAt;
}
