package com.springbootwebtutorial.springbootwebtutorial.services;

import com.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepositories;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepositories employeeRepositories;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepositories employeeRepositories, ModelMapper modelMapper) {
        this.employeeRepositories = employeeRepositories;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepositories.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepositories.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEmployeeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepositories.save(toSaveEmployeeEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepositories.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    public boolean isExistEmployeeById(Long id){
        return employeeRepositories.existsById(id);
    }

    public boolean deleteEmployeeById(Long id) {
        if(!isExistEmployeeById(id)) return false;
        employeeRepositories.deleteById(id);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long id, Map<String, Object> updates) {
        if(!isExistEmployeeById(id)) return null;
        EmployeeEntity employeeEntity = employeeRepositories.findById(id).get();
        updates.forEach((field, value) -> {
            Field keyToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            keyToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(keyToBeUpdated,employeeEntity, value);
        });
        return modelMapper.map(employeeRepositories.save(employeeEntity),EmployeeDTO.class);
    }
}
