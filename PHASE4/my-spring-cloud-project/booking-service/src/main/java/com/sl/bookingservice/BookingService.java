package com.sl.bookingservice;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PassengerClient passengerClient;

    @Autowired
    public BookingService(BookingRepository bookingRepository, PassengerClient passengerClient) {
        this.bookingRepository = bookingRepository;
        this.passengerClient = passengerClient;
    }

    @Transactional
    public BookingResponseDto createBooking(Booking booking) {
        // Validate passenger exists via microservice communication
        Optional<PassengerDto> passengerOpt = passengerClient.getPassengerById(booking.getPassengerId());
        if (passengerOpt.isEmpty()) {
            throw new PassengerNotFoundException("Cannot create booking. Passenger not found with id: " + booking.getPassengerId());
        }

        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus("PENDING");
        Booking savedBooking = bookingRepository.save(booking);

        return convertToResponseDto(savedBooking, passengerOpt.get());
    }

    @Transactional
    public List<BookingResponseDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(this::enrichBookingDetails)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookingResponseDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
        return enrichBookingDetails(booking);
    }

    @Transactional
    public List<BookingResponseDto> getBookingsByPassengerId(Long passengerId) {
        List<Booking> bookings = bookingRepository.findByPassengerId(passengerId);
        return bookings.stream()
                .map(this::enrichBookingDetails)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookingResponseDto updateBookingStatus(Long id, String status) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));

        String cleanStatus = status.trim().toUpperCase();
        if (!cleanStatus.equals("PENDING") && !cleanStatus.equals("CONFIRMED") && !cleanStatus.equals("CANCELLED")) {
            throw new IllegalArgumentException("Invalid booking status. Must be PENDING, CONFIRMED, or CANCELLED");
        }

        booking.setStatus(cleanStatus);
        Booking updated = bookingRepository.save(booking);
        return enrichBookingDetails(updated);
    }

    @Transactional
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
        bookingRepository.delete(booking);
    }

    private BookingResponseDto enrichBookingDetails(Booking booking) {
        Optional<PassengerDto> passengerOpt = passengerClient.getPassengerById(booking.getPassengerId());
        PassengerDto passenger = passengerOpt.orElseGet(() -> {
            PassengerDto fallback = new PassengerDto();
            fallback.setId(booking.getPassengerId());
            fallback.setName("Unknown Passenger (API Unreachable)");
            return fallback;
        });
        return convertToResponseDto(booking, passenger);
    }

    private BookingResponseDto convertToResponseDto(Booking booking, PassengerDto passenger) {
        return new BookingResponseDto(
                booking.getId(),
                booking.getPassengerId(),
                booking.getSource(),
                booking.getDestination(),
                booking.getBookingDate(),
                booking.getTravelDate(),
                booking.getStatus(),
                booking.getFare(),
                passenger
        );
    }
}
