package com.example.practiceconsumeapiwebclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    private Integer stdId;
    private String stName;
    private Integer stAge;
}
