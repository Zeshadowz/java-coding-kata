package com.qburry.service.mapper;

import com.qburry.model.Person;
import com.qburry.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person customerDTOToPerson(CustomerDTO dto);
}
