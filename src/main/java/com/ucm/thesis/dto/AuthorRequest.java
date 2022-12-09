package com.ucm.thesis.dto;

import com.ucm.thesis.dto.TutorialUpdateRequest.TutorialUpdateRequestBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AuthorRequest {
    private String name;
}
