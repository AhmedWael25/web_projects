package org.playground.util;

import jakarta.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import org.playground.resources.models.*;
import org.playground.domain.Employee;


public class DBEmpToEmpDto extends EntityToDtoMapper<EmpDto, Employee>{

    @Override
    public EmpDto convertEntityToDto(Employee entity){
        EmpDto dto = new EmpDto();

        dto.setId( entity.getId() );
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setSsn(entity.getSsn());

        return dto;
    }

}