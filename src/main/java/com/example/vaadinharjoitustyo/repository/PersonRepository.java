package com.example.vaadinharjoitustyo.repository;

import com.example.vaadinharjoitustyo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Voit lisätä tarvittaessa omia metodeja tähän
}
