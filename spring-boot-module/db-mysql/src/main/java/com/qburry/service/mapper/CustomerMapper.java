package com.qburry.service.mapper;

import com.qburry.model.Customer;
import com.qburry.web.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface CustomerMapper {

    @Mappings({
            @Mapping(target = "person.gender", source = "gender"),
            @Mapping(target = "person.firstname", source = "firstname"),
            @Mapping(target = "person.lastname", source = "lastname"),
            @Mapping(target = "person.email", source = "email"),
            @Mapping(target = "person.phone", source = "phone"),
    })
    Customer toCustomer(CustomerDTO customerDTO);
}
