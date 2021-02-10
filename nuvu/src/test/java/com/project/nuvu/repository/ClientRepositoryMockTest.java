package com.project.nuvu.repository;

import com.project.nuvu.model.*;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

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

        CardBrand cardBrand = new CardBrand().builder()
                .idCardBrand(1)
                .description("Mastercard").build();

        Card card = new Card().builder()
                .idCard(1)
                .brand(cardBrand)
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

    @Test
    public void whenUpdateClient_whenReturnClientUpdatedTest() {

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

        CardBrand cardBrand = new CardBrand().builder()
                .idCardBrand(1)
                .description("Mastercard").build();

        Card card = new Card().builder()
                .idCard(1)
                .brand(cardBrand)
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

    @Test
    public void whenDeleteClient_whenDeleteClientTest() {

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

        CardBrand cardBrand = new CardBrand().builder()
                .idCardBrand(1)
                .description("Mastercard").build();

        Card card = new Card().builder()
                .idCard(1)
                .brand(cardBrand)
                .isCredit(true)
                .cardLevel(cardLevel)
                .securityCode("098")
                .price(100000d)
                .city(city).build();

        Set<Card> cardSet = new HashSet<>();
        cardSet.add(card);

        List<Client> clientList = new ArrayList<>();
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
        Client clientOld1 = new Client().builder()
                .idClient(1)
                .name1("juan")
                .name2("david")
                .surname1("carrillo")
                .surname2("buitrago")
                .email("juan@gmail.com")
                .phone("3165879023")
                .year(30)
                .cards(cardSet).build();
        Client clientOld2 = new Client().builder()
                .idClient(1)
                .name1("juan")
                .name2("david")
                .surname1("carrillo")
                .surname2("buitrago")
                .email("juan@gmail.com")
                .phone("3165879023")
                .year(30)
                .cards(cardSet).build();
        clientList.add(clientOld1);
        clientList.add(clientOld2);
        clientRepository.save(client);
        clientRepository.delete(client);
        List<Client> clientAll = clientRepository.findAll();

        Assertions.assertThat(clientAll).isNotNull();
        Assertions.assertThat(clientAll.size()).isEqualTo(0);
    }
}
