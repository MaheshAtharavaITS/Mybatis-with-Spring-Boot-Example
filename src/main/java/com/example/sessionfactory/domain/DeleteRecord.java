package com.example.sessionfactory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRecord {

    private long id;
    private int originalId;
    private String entityName;
    private LocalDateTime deleteAt;
}
