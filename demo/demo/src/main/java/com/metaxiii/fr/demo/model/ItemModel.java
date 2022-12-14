package com.metaxiii.fr.demo.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.UUID;

@Builder
@Getter
public class ItemModel extends RepresentationModel<ItemModel> {

    private UUID id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updateAt;
}
