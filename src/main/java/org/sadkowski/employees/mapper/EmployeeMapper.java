package org.sadkowski.employees.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sadkowski.employees.DTO.EmployeeDto;
import org.sadkowski.employees.Model.Employee;
import java.util.List;
@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee employeDtoToEmploye(EmployeeDto employee);
    EmployeeDto employeToEmployeDto(Employee employee);

    List<EmployeeDto> map(List<Employee> employees);

}
