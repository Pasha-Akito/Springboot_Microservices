package guru.springframework.mssc_brewery_client.web.client;

import guru.springframework.mssc_brewery_client.web.model.BeerDto;
import guru.springframework.mssc_brewery_client.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        //Brewery has to be running for this to pass
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder()
                .beerName("New Beer")
                .build();

        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void updateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder()
                .beerName("New Beer")
                .build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .customerName("Pasha")
                .build();

        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .customerName("Pasha")
                .build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }

}