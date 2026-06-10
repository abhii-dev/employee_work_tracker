package com.track.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.track.dto.EmployeeRequestDto;
import com.track.dto.EmployeeResponseDto;
import com.track.entity.Employee;
import com.track.entity.Manager;
import com.track.repository.EmployeeRepository;
import com.track.repository.ManagerRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;

    public EmployeeServiceImp(
            EmployeeRepository employeeRepository,
            ManagerRepository managerRepository) {

        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto) {

        if (employeeRepository.existsByEmployeeCode(requestDto.getEmployeeCode())) {
            throw new RuntimeException("Employee code already exists");
        }

        if (employeeRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Employee employee = new Employee();

        employee.setEmployeeCode(requestDto.getEmployeeCode());
        employee.setFirstName(requestDto.getFirstName());
        employee.setLastName(requestDto.getLastName());
        employee.setEmail(requestDto.getEmail());
        employee.setDepartment(requestDto.getDepartment());
        employee.setDesignation(requestDto.getDesignation());

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToResponseDto(savedEmployee);
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));

        return mapToResponseDto(employee);
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto updateEmployee(
            Long id,
            EmployeeRequestDto requestDto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));

        employee.setEmployeeCode(requestDto.getEmployeeCode());
        employee.setFirstName(requestDto.getFirstName());
        employee.setLastName(requestDto.getLastName());
        employee.setEmail(requestDto.getEmail());
        employee.setDepartment(requestDto.getDepartment());
        employee.setDesignation(requestDto.getDesignation());

        Employee updatedEmployee =
                employeeRepository.save(employee);

        return mapToResponseDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));

        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponseDto assignManager(
            Long employeeId,
            Long managerId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() ->
                        new RuntimeException("Manager not found"));

        employee.setManager(manager);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return mapToResponseDto(savedEmployee);
    }

    private EmployeeResponseDto mapToResponseDto(Employee employee) {

        Long managerId = null;
        String managerName = null;

        if (employee.getManager() != null) {

            managerId = employee.getManager().getId();

            managerName =
                    employee.getManager().getFirstName()
                            + " "
                            + employee.getManager().getLastName();
        }

        return new EmployeeResponseDto(
                employee.getId(),
                employee.getEmployeeCode(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getDesignation(),
                managerId,
                managerName
        );
    }
}