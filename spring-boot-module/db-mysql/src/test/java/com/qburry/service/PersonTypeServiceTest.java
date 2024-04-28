package com.qburry.service;

import com.qburry.model.PersonType;
import com.qburry.repository.PersonTypeRepository;
import com.qburry.web.model.PersonTypeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonTypeServiceTest {

    @Mock
    PersonTypeRepository personTypeRepository;

    @InjectMocks
    PersonTypeService personTypeService;

    @Test
    void shouldInsertPersonType() {
        PersonType personType = new PersonType();
        personType.setId(1L);
        when(personTypeRepository.save(any(PersonType.class))).thenReturn(personType);
        PersonTypeDTO customer = new PersonTypeDTO("CUSTOMER");

        Long save = personTypeService.save(customer);
        assertThat(save).isEqualTo(1);
    }

}