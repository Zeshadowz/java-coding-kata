package com.qburry.repository;

import com.qburry.model.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonTypeRepository extends JpaRepository<PersonType, Long> {

    PersonType findByName(String name);
}
