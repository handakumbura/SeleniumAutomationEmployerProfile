package com.dumiduh.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestData {

    private String Id;
    private int numberOfOptions;
    private List<String> listOfOptions;
    private String dropDownSelection;
}
