package com.example.juniortest.palindrome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/palindrome")
public class PalindromeController {

    private final PalindromeService palindromeService;

    @Autowired
    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @GetMapping
    public List<Palindrome> getPalindromes(){
        return palindromeService.getPalindromes();
    }

    @PostMapping
    public void registerNewPalindrome(@RequestBody Palindrome palindrome){
        palindromeService.addNewPalindrome(palindrome);
    }

    @DeleteMapping(path = "{palindromeId}")
    public void deletePalindrome(@PathVariable("palindromeId") Long palindromeId){
        palindromeService.deletePalindrome(palindromeId);
    }

    @PutMapping(path = "{palindromeId}")
    public void updatePalindrome(
            @PathVariable("palindromeId") Long palindromeId,
            @RequestParam(required = false) String content){
        palindromeService.updatePalindrome(palindromeId, content);
    }

}
