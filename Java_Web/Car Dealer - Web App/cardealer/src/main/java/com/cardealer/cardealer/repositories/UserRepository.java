package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u from User u order by u.id ASC")
    List<User> findAllByOrOrderByIdAsc();

    @Query(value = "SELECT u from User u order by u.id DESC")
    List<User> findAllByOrOrderByIdDesc();

}
