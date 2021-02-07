package com.project.nuvu.repository;

import com.project.nuvu.model.*;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DataJpaTest
public class ClientRepositoryMockTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void whenSaveClient_whenReturnClientSavedTest() {

        Country country = new Country().builder()
                .code("CO")
                .name("COLOMBIA").build();

        City city = new City().builder()
                .idCity(1)
                .name("Bogota")
                .country(country).build();

        CardLevel cardLevel = new CardLevel().builder()
                .idCardLevel(1)
                .type(1)
                .description("Platino").build();

        Card card = new Card().builder()
                .idCard(1)
                .brand("Master card")
                .isCredit(true)
                .cardLevel(cardLevel)
                .securityCode("098")
                .price(100000d)
                .city(city).build();

        Set<Card> cardSet = new HashSet<>();
        cardSet.add(card);

        Client client = new Client().builder()
                .idClient(1)
                .name1("juan")
                .name2("david")
                .surname1("carrillo")
                .surname2("buitrago")
                .email("juan@gmail.com")
                .phone("3165879023")
                .year(30)
                .cards(cardSet).build();

        Client clientResponse = clientRepository.save(client);
        List<Client> clientList = clientRepository.findAll();

        Assertions.assertThat(clientResponse).isNotNull();
        Assertions.assertThat(clientResponse.getIdClient()).isEqualTo(client.getIdClient());
        Assertions.assertThat(clientList).isNotNull();
        Assertions.assertThat(clientList.size()).isEqualTo(1);
    }
}
