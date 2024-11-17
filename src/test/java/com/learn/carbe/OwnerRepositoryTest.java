package com.learn.carbe;

import com.learn.carbe.domain.Owner;
import com.learn.carbe.domain.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    protected OwnerRepository ownerRepository;

    @Test
    void saveOwner() {
        ownerRepository.save(new Owner("Lucy", "Smith"));

        assertThat(ownerRepository.findByFirstname("Lucy").isPresent()).isTrue();

    }

    @Test
    void deleteAllOwners() {
        ownerRepository.save(new Owner("Lisa", "Morrison"));
        ownerRepository.deleteAll();

        assertThat(ownerRepository.count()).isEqualTo(0);

    }

}
