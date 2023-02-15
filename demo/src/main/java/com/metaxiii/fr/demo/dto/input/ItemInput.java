package com.metaxiii.fr.demo.dto.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ItemInput {
  @NotNull
  @NotEmpty
  private String name;

  private String description;
}
