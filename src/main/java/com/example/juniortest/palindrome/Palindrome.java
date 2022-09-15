package com.example.juniortest.palindrome;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Palindrome {
    @Id
    @SequenceGenerator(
            name = "palindrome_sequence",
            sequenceName = "palindrome_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "palindrome_sequence"
    )

    private Long id;
    private String content;
    private Timestamp timestamp;
    private long longest_palindrome_size;

    public Palindrome(Long id,
                      String content,
                      Timestamp timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.longest_palindrome_size = 0L;
    }

    public Palindrome(String content,
                      Timestamp timestamp) {
        this.content = content;
        this.timestamp = timestamp;
        this.longest_palindrome_size = 0L;
    }


    public Palindrome() {

    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLongest_palindrome_size() {
        return longest_palindrome_size;
    }

    public void setLongest_palindrome_size(Long longest_palindrome_size) {
        this.longest_palindrome_size = longest_palindrome_size;
    }

    @Override
    public String toString() {
        return "Palindrome{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", longest_palindrome_size=" + longest_palindrome_size +
                '}';
    }

}
