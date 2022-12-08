package com.ucm.thesis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TutorialUpdateRequest {
    private String title;
    private String description;
    private boolean published;
    
    
}
