package com.qburry.service.mapper;

import com.qburry.model.UserEntity;
import com.qburry.web.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "personType", target = "person.personType"),
            @Mapping(source = "gender", target = "person.gender"),
            @Mapping(source = "firstname", target = "person.firstname"),
            @Mapping(source = "lastname", target = "person.lastname"),
            @Mapping(source = "email", target = "person.email"),
            @Mapping(source = "phone", target = "person.phone"),
            @Mapping(target = "salt", ignore = true)
    })
    UserEntity toEntity(User user);

    @Mappings({
            @Mapping(source = "person.personType", target = "personType"),
            @Mapping(source = "person.gender", target = "gender"),
            @Mapping(source = "person.firstname", target = "firstname"),
            @Mapping(source = "person.lastname", target = "lastname"),
            @Mapping(source = "person.email", target = "email"),
            @Mapping(source = "person.phone", target = "phone"),
            @Mapping(target = "person.salt", ignore = true)
    })
    User toUser(UserEntity entity);

    Collection<UserEntity> toEntities(Collection<User> users);

    Collection<User> toUsers(Collection<UserEntity> entities);
}
