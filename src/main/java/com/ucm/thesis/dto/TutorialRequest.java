package com.ucm.thesis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TutorialRequest {
    private String title;
    private String description;
    private boolean published;
    private Long author_id;
}
