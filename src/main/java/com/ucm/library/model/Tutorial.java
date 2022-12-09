package com.ucm.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tutorial {
    private long id;
    private String title;
    private String description;
    private boolean published;
    private String author;
}
