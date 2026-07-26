package com.sl.passengerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Transactional(readOnly = true)
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger not found with id: " + id));
    }

    @Transactional
    public Passenger createPassenger(Passenger passenger) {
        if (passengerRepository.existsByEmail(passenger.getEmail())) {
            throw new EmailAlreadyExistsException("Passenger with email " + passenger.getEmail() + " already exists");
        }
        return passengerRepository.save(passenger);
    }

    @Transactional
    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Passenger existingPassenger = getPassengerById(id);

        if (passengerRepository.existsByEmailAndIdNot(passengerDetails.getEmail(), id)) {
            throw new EmailAlreadyExistsException("Email " + passengerDetails.getEmail() + " is already in use by another passenger");
        }

        existingPassenger.setName(passengerDetails.getName());
        existingPassenger.setEmail(passengerDetails.getEmail());
        existingPassenger.setPhone(passengerDetails.getPhone());
        existingPassenger.setAge(passengerDetails.getAge());
        existingPassenger.setGender(passengerDetails.getGender());

        return passengerRepository.save(existingPassenger);
    }

    @Transactional
    public void deletePassenger(Long id) {
        Passenger existingPassenger = getPassengerById(id);
        passengerRepository.delete(existingPassenger);
    }
}
