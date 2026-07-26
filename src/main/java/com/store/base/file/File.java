package com.store.base.file;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String url;
}
