package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.With;

@With
@Builder
public record Teacher(String id, String name, String subject) {
}
