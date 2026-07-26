package com.sl.bookingservice;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Passenger ID is required")
    @Column(nullable = false)
    private Long passengerId;

    @NotBlank(message = "Source location is required")
    @Column(nullable = false)
    private String source;

    @NotBlank(message = "Destination location is required")
    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    @NotNull(message = "Travel date is required")
    @FutureOrPresent(message = "Travel date must be in the present or future")
    @Column(nullable = false)
    private LocalDate travelDate;

    @NotBlank(message = "Status is required")
    @Column(nullable = false)
    private String status; // PENDING, CONFIRMED, CANCELLED

    @NotNull(message = "Fare is required")
    @Min(value = 0, message = "Fare must be non-negative")
    @Column(nullable = false)
    private Double fare;

    public Booking() {
    }

    public Booking(Long id, Long passengerId, String source, String destination, LocalDateTime bookingDate, LocalDate travelDate, String status, Double fare) {
        this.id = id;
        this.passengerId = passengerId;
        this.source = source;
        this.destination = destination;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.status = status;
        this.fare = fare;
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
}

