package com.project.nuvu.service;

import com.project.nuvu.model.*;
import com.project.nuvu.repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class ClientServiceMockTest {


    @Mock
    private ClientRepository clientRepository;

    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.initMocks(this);
        clientService = new ClientServiceImpl(clientRepository);
    }

    @Test
    public void whenFindClientById_thenReturnClientTest() {
        Integer idClient = 1;

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

        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        Client clientOld = clientRepository.findById(idClient).orElse(null);

        Assertions.assertThat(clientOld).isNotNull();
        Assertions.assertThat(clientOld.getIdClient()).isEqualTo(idClient);
    }

    @Test
    public void whenSaveClient_thenReturnClientSavedTest() {
        Country country = new Country().builder()
                .code("US")
                .name("USA").build();

        City city = new City().builder()
                .idCity(1)
                .name("New york")
                .country(country).build();

        CardLevel cardLevel = new CardLevel().builder()
                .idCardLevel(1)
                .type(1)
                .description("Maestro").build();

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
        Client clientOld = new Client().builder()
                .idClient(1)
                .name1("juan")
                .name2("david")
                .surname1("carrillo")
                .surname2("buitrago")
                .email("juan@gmail.com")
                .phone("3165879023")
                .year(30)
                .cards(cardSet).build();
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
        List<Client> clientList = new ArrayList<>();
        clientList.add(clientOld);
        clientList.add(client);

        Mockito.when(clientRepository.save(client)).thenReturn(client);
        Client clientNew = clientService.saveClient(client);

        Assertions.assertThat(clientNew).isNotNull();
        Assertions.assertThat(clientNew.getIdClient()).isEqualTo(client.getIdClient());
        Mockito.verify(clientRepository, Mockito.times(1)).save(client);
    }

    @Test
    public void whenDeleteClient_thenDeleteClientTest() {
        Country country = new Country().builder()
                .code("US")
                .name("USA").build();

        City city = new City().builder()
                .idCity(1)
                .name("New york")
                .country(country).build();

        CardLevel cardLevel = new CardLevel().builder()
                .idCardLevel(1)
                .type(1)
                .description("Maestro").build();

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
        Client clientOld = new Client().builder()
                .idClient(1)
                .name1("juan")
                .name2("david")
                .surname1("carrillo")
                .surname2("buitrago")
                .email("juan@gmail.com")
                .phone("3165879023")
                .year(30)
                .cards(cardSet).build();
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
        List<Client> clientList = new ArrayList<>();
        clientList.add(clientOld);

        Mockito.when(clientRepository.findById(client.getIdClient())).thenReturn(Optional.of(client));
        clientService.deleteClient(client.getIdClient());

        Mockito.verify(clientRepository, Mockito.times(1)).delete(client);
    }

    @Test
    public void givenDeleteClient_whenClientNotExist_thenErrorTest() {
        Country country = new Country().builder()
                .code("US")
                .name("USA").build();

        City city = new City().builder()
                .idCity(1)
                .name("New york")
                .country(country).build();

        CardLevel cardLevel = new CardLevel().builder()
                .idCardLevel(1)
                .type(1)
                .description("Maestro").build();

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
        Client clientOld = new Client().builder()
                .idClient(1)
                .name1("juan")
                .name2("david")
                .surname1("carrillo")
                .surname2("buitrago")
                .email("juan@gmail.com")
                .phone("3165879023")
                .year(30)
                .cards(cardSet).build();
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
        List<Client> clientList = new ArrayList<>();
        clientList.add(clientOld);

        Mockito.when(clientRepository.findById(client.getIdClient())).thenReturn(Optional.empty());
        boolean isDelete = clientService.deleteClient(client.getIdClient());

        Assertions.assertThat(isDelete).isFalse();
        Mockito.verify(clientRepository, Mockito.times(0)).delete(client);
    }

    @Test
    public void whenUpdateClient_thenReturnClientUpdateTest() {
        Country country = new Country().builder()
                .code("US")
                .name("USA").build();

        City city = new City().builder()
                .idCity(1)
                .name("New york")
                .country(country).build();

        CardLevel cardLevel = new CardLevel().builder()
                .idCardLevel(1)
                .type(1)
                .description("Maestro").build();

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
        Client clientOld = new Client().builder()
                .idClient(1)
                .name1("juan old")
                .name2("david old")
                .surname1("carrillo old")
                .surname2("buitrago old")
                .email("juan@gmail.com")
                .phone("3165879023")
                .year(29)
                .cards(cardSet).build();
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

        Mockito.when(clientRepository.save(client)).thenReturn(client);
        Mockito.when(clientRepository.findById(clientOld.getIdClient())).thenReturn(Optional.of(clientOld));
        Client clientNew = clientService.updateClient(client);
        Assertions.assertThat(clientNew).isNotNull();
        Assertions.assertThat(clientNew.getIdClient()).isEqualTo(client.getIdClient());
        Mockito.verify(clientRepository, Mockito.times(1)).save(client);
    }

    @Test
    public void whenUpdateClientAndNotExist_thenReturnClientUpdateTest() {
        Country country = new Country().builder()
                .code("US")
                .name("USA").build();

        City city = new City().builder()
                .idCity(1)
                .name("New york")
                .country(country).build();

        CardLevel cardLevel = new CardLevel().builder()
                .idCardLevel(1)
                .type(1)
                .description("Maestro").build();

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
        Client clientOld = new Client().builder()
                .idClient(1)
                .name1("juan old")
                .name2("david old")
                .surname1("carrillo old")
                .surname2("buitrago old")
                .email("juan@gmail.com")
                .phone("3165879023")
                .year(29)
                .cards(cardSet).build();
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

        Mockito.when(clientRepository.findById(client.getIdClient())).thenReturn(Optional.empty());
        Client clientNew = clientService.updateClient(client);

        Assertions.assertThat(clientNew).isNull();
        Mockito.verify(clientRepository, Mockito.times(0)).save(client);
    }

}
