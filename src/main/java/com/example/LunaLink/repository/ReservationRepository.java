package com.example.LunaLink.repository;

import com.example.LunaLink.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findBySpaceId(Long spaceId);

    @Query("SELECT r FROM Reservation r WHERE r.space.id = :spaceId " +
            "AND (r.startTime < :endTime AND r.endTime > :startTime)")
    List<Reservation> findBySpaceIdAndTimeRange(@Param("spaceId") Long spaceId,
                                                @Param("startTime") LocalDateTime startTime,
                                                @Param("endTime") LocalDateTime endTime);
}
