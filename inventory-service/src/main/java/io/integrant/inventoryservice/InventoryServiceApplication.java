package io.integrant.inventoryservice;

import io.integrant.inventoryservice.model.Inventory;
import io.integrant.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {
@Bean
public CommandLineRunner commandLineRunner(InventoryRepository inventoryRepository) {
	return args -> {
	Inventory inventory = new Inventory();
	inventory.setSkuCode("iPhone13");
	inventory.setQuantity(100);

	Inventory inventory1 = new Inventory();
	inventory1.setSkuCode("iPhone13_red");
	inventory1.setQuantity(0);

	inventoryRepository.save(inventory);
	inventoryRepository.save(inventory1);
	};
}
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
