package com.qburry.service;

import com.qburry.model.PersonType;
import com.qburry.repository.PersonTypeRepository;
import com.qburry.web.model.PersonTypeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonTypeService {

    public final PersonTypeRepository repository;

    public PersonTypeService(PersonTypeRepository repository) {
        this.repository = repository;
    }

    public Long save(PersonTypeDTO dto) {
        PersonType personType = new PersonType();
        personType.setName(dto.getName());
        log.info("Saving personType {}, {}", personType.getName(), personType.getId());
        return repository.save(personType).getId();
    }

    public List<PersonTypeDTO> getPersonTypes() {
        return repository.findAll().stream()
                .map(pt -> new PersonTypeDTO(pt.getName()))
                .toList();
    }

    public PersonType getPersonTypeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PersonType getPersonTypeByName(String name) {
        return repository.findByName(name);
    }


}
