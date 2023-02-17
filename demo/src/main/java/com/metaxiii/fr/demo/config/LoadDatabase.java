package com.metaxiii.fr.demo.config;

import com.metaxiii.fr.demo.entity.Item;
import com.metaxiii.fr.demo.repository.ItemRepository;
import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import java.time.Instant;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Slf4j
@Configuration
@EnableR2dbcRepositories(basePackages = "com.metaxiii.fr.demo.repository")
public class LoadDatabase extends AbstractR2dbcConfiguration {

  //  @Bean
  //  ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
  //    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
  //    initializer.setConnectionFactory(connectionFactory);
  //    initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
  //
  //    return initializer;
  //  }

  //  @Bean
  //  CommandLineRunner initDatabase(ItemRepository itemRepository) {
  //    System.out.println("ok j'y arrive");
  //    return args -> {
  //      final Item item = Item
  //        .builder()
  //        .id(UUID.randomUUID())
  //        .name("some name")
  //        .description("some description")
  //        .createdAt(Instant.now())
  //        .updatedAt(Instant.now())
  //        .build();
  //      itemRepository.save(item);
  //      itemRepository.findAll().doOnEach(orderEntity -> log.info("Preloaded " + orderEntity));
  //    };
  //  }

  @Bean
  public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
    initializer.setConnectionFactory(connectionFactory);
    CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
    populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
    initializer.setDatabasePopulator(populator);
    return initializer;
  }

  @Override
  public ConnectionFactory connectionFactory() {
    return new H2ConnectionFactory(
      H2ConnectionConfiguration
        .builder()
        .inMemory("lemon")
        .username("sa")
        .option("DB_CLOSE_DELAY=-1")
        .password("")
        .build()
    );
  }
}
