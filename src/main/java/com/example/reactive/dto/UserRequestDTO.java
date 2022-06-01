package com.example.reactive.dto;

import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@With
@Jacksonized
@Builder
public record UserRequestDTO(String name, String email) {
}
