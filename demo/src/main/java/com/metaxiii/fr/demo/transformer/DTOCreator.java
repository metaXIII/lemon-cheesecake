package com.metaxiii.fr.demo.transformer;

public interface DTOCreator<I, D> {
  public I toDomain(final D dto);
}
