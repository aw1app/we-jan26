package com.sl.bookingservice;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingResponseDto {
    private Long id;
    private Long passengerId;
    private String source;
    private String destination;
    private LocalDateTime bookingDate;
    private LocalDate travelDate;
    private String status;
    private Double fare;
    private PassengerDto passenger;

    public BookingResponseDto() {
    }

    public BookingResponseDto(Long id, Long passengerId, String source, String destination, LocalDateTime bookingDate, LocalDate travelDate, String status, Double fare, PassengerDto passenger) {
        this.id = id;
        this.passengerId = passengerId;
        this.source = source;
        this.destination = destination;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.status = status;
        this.fare = fare;
        this.passenger = passenger;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public PassengerDto getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDto passenger) {
        this.passenger = passenger;
    }
}
