package com.metaxiii.fr.demo.creator;

public interface DomainCreator<E, M> {
    E toDomain(final M m);
}
