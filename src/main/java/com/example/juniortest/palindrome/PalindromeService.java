package com.example.juniortest.palindrome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PalindromeService {

    private final PalindromeRepository palindromeRepository;

    @Autowired
    public PalindromeService(PalindromeRepository palindromeRepository) {
        this.palindromeRepository = palindromeRepository;
    }


    public List<Palindrome> getPalindromes(){
        List<Palindrome> allPalindrome = palindromeRepository.findAll();
        if(allPalindrome.size() != 0) {
            for (Palindrome palindrome : allPalindrome) {
                updatePalindromeLenght(palindrome.getContent());
            }
        }
        return allPalindrome;
    }

    public void addNewPalindrome(Palindrome palindrome) {
        Optional<Palindrome> palindromeOptional = palindromeRepository
                .findPalindromeByContent(palindrome.getContent());
        if(palindromeOptional.isPresent()) {
            throw new IllegalStateException("content taken");
        }
        palindromeRepository.save(palindrome);
    }

    public void deletePalindrome(Long palindromeId){
        boolean exists = palindromeRepository.existsById(palindromeId);
        if(!exists){
            throw new IllegalStateException("palindrome with id " + palindromeId + " does not exists");
        }
        palindromeRepository.deleteById(palindromeId);
    }

    @Transactional
    public void updatePalindrome(Long palindromeId,
                                 String content) {
        Palindrome palindrome = palindromeRepository.findById(palindromeId)
                .orElseThrow(() -> new IllegalStateException(
                   "palindrome with id " + palindromeId + " does not exists"
                ));
        if(content != null &&
                content.length() > 0 && !Objects.equals(palindrome.getContent(), content)){
            palindrome.setContent(content);
            palindrome.setTimestamp(new Timestamp(System.currentTimeMillis()));
        }
    }

    @Transactional
    public void updatePalindromeLenght(String content) {
            long count = 1;
            Palindrome palindrome = palindromeRepository.findPalindromeByContent(content)
                    .orElseThrow(() -> new IllegalStateException(
                            "palindrome with content " + content + " does not exists"));
            if (content.length() < 2 && content.matches("[a-zA-Z]")) {
                palindrome.setLongest_palindrome_size((long) content.length());
            } else {
                String withoutAccent = Normalizer.normalize(content, Normalizer.Form.NFD);
                String output = withoutAccent.replaceAll("[^a-zA-Z]", "");
                int left, right;
                for (int i = 0; i < output.length(); i++) {
                    left = i - 1;
                    right = i + 1;
                    //checking right side of the "i" position, if the next element matches, +1 to the right
                    while (right < output.length() && output.charAt(right) == output.charAt(i)) {
                        right++;
                    }
                    //checking left side of the "i" position, if the last element matches, -1 to the left
                    while (left >= 0 && output.charAt(left) == output.charAt(i)) {
                        left--;
                    }
                    //checking left and right side of the "i" position, if the next and last element matches, +1 to the right
                    //-1 to the left
                    while (left >= 0 && right < output.length() && output.charAt(left) == output.charAt(right)) {
                        left--;
                        right++;
                    }
                    //calculating the length of the palindrome
                    int length = right - left - 1;
                    if (count < length) {
                        count = length;
                    }
                    palindrome.setLongest_palindrome_size(count);
                }

            }
    }
}
