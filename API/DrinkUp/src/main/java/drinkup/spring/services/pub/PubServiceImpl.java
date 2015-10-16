package drinkup.spring.services.pub;

import drinkup.spring.domain.Pub;
import drinkup.spring.repositories.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubServiceImpl implements PubService {
    private PubRepository pubRepository;

    @Autowired
    public void setPubRepository(PubRepository pubRepository) {
        this.pubRepository = pubRepository;
    }

    @Override
    public Iterable<Pub> listAllPubs() {
        return pubRepository.findAll();
    }

    @Override
    public Pub getPubById(int id) {
        return pubRepository.findOne(id);
    }

    @Override
    public Pub savePub(Pub pub) {
        return pubRepository.save(pub);
    }

    @Override
    public void deletePub(int id) {
        pubRepository.delete(id);
    }
}
