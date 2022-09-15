package com.example.juniortest.palindrome;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PalindromeRepository
        extends JpaRepository<Palindrome, Long> {

    @Query("SELECT p FROM Palindrome p WHERE p.content = ?1")
    Optional<Palindrome> findPalindromeByContent(String content);


}
