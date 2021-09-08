package com.api.model.request;

import com.api.annotation.DateTimeNotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "PETS")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NotNull(message = "Pet name could not be null or blank")
    @NotBlank(message = "Pet name could not be null or blank")
    @Column(name = "NAME")
    private String name;

    @DateTimeNotNull
    @Column(name = "MISSINGSINCE")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime missingSince;

    @NotNull(message = "Pet type could not be null or blank")
    @NotBlank(message = "Pet type could not be null or blank")
    @Column(name = "PETTYPE")
    private String petType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public LocalDateTime getMissingSince() {
        return missingSince;
    }

    public void setMissingSince(LocalDateTime missingSince) {
        this.missingSince = missingSince;
    }

}
