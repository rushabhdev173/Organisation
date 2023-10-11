package com.alphaware.service.mapper;

import com.alphaware.domain.Office;
import com.alphaware.service.dto.OfficeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Office} and its DTO {@link OfficeDTO}.
 */
@Mapper(componentModel = "spring")
public interface OfficeMapper extends EntityMapper<OfficeDTO, Office> {
    @Mapping(target = "parent", source = "parent", qualifiedByName = "officeId")
    OfficeDTO toDto(Office s);

    @Named("officeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OfficeDTO toDtoOfficeId(Office office);
}
