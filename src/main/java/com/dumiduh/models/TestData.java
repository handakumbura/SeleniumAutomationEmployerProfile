package com.dumiduh.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestData {
    private String id;
    private String searchTerm;
    private String language;
    private String category;
    private int quantity;
    private int productIndex;
    private String emptyCartSuccessMessage;
}
