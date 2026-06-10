package com.track.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.track.entity.Attendance;
import com.track.enums.AttendanceStatus;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployeeId(Long employeeId);

    Optional<Attendance> findByEmployeeIdAndAttendanceDate(
            Long employeeId,
            LocalDate attendanceDate
    );
    
    long countByEmployeeId(Long employeeId);

    long countByEmployeeIdAndStatus(Long employeeId, AttendanceStatus status);
}




