package com.macalicestore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "content", columnDefinition="LONGBLOB")
    private byte[] content;

    private String name;

    private String type;

    public Image() {

    }

    public Image(byte[] content, String name, String type) {
        this.content = content;
        this.name = name;
        this.type = type;
    }

    public Image(String name) {
        this.name = name;
    }

    public Image(byte[] content) {
        this.content = content;
    }
}
