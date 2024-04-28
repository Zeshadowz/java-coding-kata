package com.qburry.service.mapper;

import com.qburry.model.PersonEntity;
import com.qburry.web.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity customerDTOToPerson(Customer dto);
}
