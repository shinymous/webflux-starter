package com.example.reactive.dto;

import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@With
@Jacksonized
@Builder
public record UserDTO(String id, String name, String email) {
}
