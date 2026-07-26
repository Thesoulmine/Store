package com.store.product.image;

import com.store.base.file.File;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "images")
public class Image extends File {
}
