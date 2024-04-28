package com.qburry.service.mapper;

import com.qburry.model.CustomerEntity;
import com.qburry.web.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface CustomerMapper {

    @Mappings({
            @Mapping(target = "person.personType", source = "personType"),
            @Mapping(target = "person.gender", source = "gender"),
            @Mapping(target = "person.firstname", source = "firstname"),
            @Mapping(target = "person.lastname", source = "lastname"),
            @Mapping(target = "person.email", source = "email"),
            @Mapping(target = "person.phone", source = "phone"),
    })
    CustomerEntity toEntity(Customer customer);

    @Mappings({
            @Mapping(target = "personType", source = "person.personType"),
            @Mapping(target = "gender", source = "person.gender"),
            @Mapping(target = "firstname", source = "person.firstname"),
            @Mapping(target = "lastname", source = "person.lastname"),
            @Mapping(target = "email", source = "person.email"),
            @Mapping(target = "phone", source = "person.phone"),
    })
    Customer toCustomer(CustomerEntity entity);


}
