package drinkup.spring.services.pub;


import drinkup.spring.domain.Pub;

public interface PubService {
    Iterable<Pub> listAllPubs();

    Pub getPubById(int id);

    Pub savePub(Pub pub);

    void deletePub(int id);
}
