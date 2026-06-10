package com.track.service;

import com.track.dto.ManagerRequestDto;
import com.track.dto.ManagerResponseDto;
import com.track.entity.Manager;
import com.track.repository.ManagerRepository;
import com.track.service.ManagerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public ManagerResponseDto createManager(ManagerRequestDto requestDto) {

        if (managerRepository.existsByManagerCode(requestDto.getManagerCode())) {
            throw new RuntimeException("Manager code already exists");
        }

        if (managerRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Manager manager = new Manager();

        manager.setManagerCode(requestDto.getManagerCode());
        manager.setFirstName(requestDto.getFirstName());
        manager.setLastName(requestDto.getLastName());
        manager.setEmail(requestDto.getEmail());
        manager.setDepartment(requestDto.getDepartment());

        Manager savedManager = managerRepository.save(manager);

        return mapToResponseDto(savedManager);
    }

    @Override
    public List<ManagerResponseDto> getAllManagers() {

        return managerRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ManagerResponseDto getManagerById(Long id) {

        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        return mapToResponseDto(manager);
    }

    @Override
    public ManagerResponseDto updateManager(Long id,
                                            ManagerRequestDto requestDto) {

        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        manager.setManagerCode(requestDto.getManagerCode());
        manager.setFirstName(requestDto.getFirstName());
        manager.setLastName(requestDto.getLastName());
        manager.setEmail(requestDto.getEmail());
        manager.setDepartment(requestDto.getDepartment());

        Manager updatedManager = managerRepository.save(manager);

        return mapToResponseDto(updatedManager);
    }

    @Override
    public void deleteManager(Long id) {

        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        managerRepository.delete(manager);
    }

    private ManagerResponseDto mapToResponseDto(Manager manager) {

        ManagerResponseDto responseDto = new ManagerResponseDto();

        responseDto.setId(manager.getId());
        responseDto.setManagerCode(manager.getManagerCode());
        responseDto.setFirstName(manager.getFirstName());
        responseDto.setLastName(manager.getLastName());
        responseDto.setEmail(manager.getEmail());
        responseDto.setDepartment(manager.getDepartment());

        return responseDto;
    }
}