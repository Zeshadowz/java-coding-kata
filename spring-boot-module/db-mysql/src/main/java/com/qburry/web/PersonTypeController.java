package com.qburry.web;

import com.qburry.service.PersonTypeService;
import com.qburry.web.model.PersonTypeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/person-type")
public class PersonTypeController {

    private final PersonTypeService personTypeService;

    public PersonTypeController(PersonTypeService personTypeService) {
        this.personTypeService = personTypeService;
    }

    @PostMapping
    public Long postPersonType(@RequestBody PersonTypeDTO personType) {
        log.info("postPersonType: {}", personType.getName());
        return personTypeService.save(personType);
    }

    @GetMapping
    public List<PersonTypeDTO> getPersonTypes() {
        return personTypeService.getPersonTypes();
    }
}
