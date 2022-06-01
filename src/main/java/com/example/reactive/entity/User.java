package com.example.reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "client")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
}