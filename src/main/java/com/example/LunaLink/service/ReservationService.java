package com.example.LunaLink.service;

import com.example.LunaLink.model.Reservation;
import com.example.LunaLink.model.Space;
import com.example.LunaLink.repository.ReservationRepository;
import com.example.LunaLink.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SpaceRepository spaceRepository;


    public Reservation createReservation(Reservation reservation) {

        Space space = spaceRepository.findById(reservation.getSpace().getId())
                .orElseThrow(() -> new IllegalArgumentException("Espaço não encontrado"));


        boolean isAvailable = checkSpaceAvailability (
                reservation.getSpace().getId(), reservation.getStartTime(), reservation.getEndTime()
        );

        if (!isAvailable) {
            throw new IllegalArgumentException("O espaço já está reservado para o horário solicitado.");
        }
        return reservationRepository.save(reservation);
    }

    private boolean checkSpaceAvailability(Long spaceId, LocalDateTime startTime, LocalDateTime endTime) {
        List<Reservation> conflictingReservations = reservationRepository
                .findBySpaceIdAndTimeRange(spaceId, startTime, endTime);

        return conflictingReservations.isEmpty();
    }

    public List<Reservation> getReservationsBySpaceId(long spaceId) {
        return reservationRepository.findBySpaceId(spaceId);
    }

}
