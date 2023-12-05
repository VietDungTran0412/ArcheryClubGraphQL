package com.techdes.archery.entity;

import com.techdes.archery.entity.enumeration.Gender;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "category")
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "age_range")
    private String ageRange;
    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Equipment> equipments;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<ArcherRound> archerRounds;
}
