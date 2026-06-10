package com.track.service;

import com.track.dto.ManagerRequestDto;
import com.track.dto.ManagerResponseDto;

import java.util.List;

public interface ManagerService {

    ManagerResponseDto createManager(ManagerRequestDto requestDto);

    List<ManagerResponseDto> getAllManagers();

    ManagerResponseDto getManagerById(Long id);

    ManagerResponseDto updateManager(Long id, ManagerRequestDto requestDto);

    void deleteManager(Long id);
}