package com.techdes.archery.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "round_range")
@Table(name = "round_range")
public class Range {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "round_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private RoundType roundType;
    @JoinColumn(name = "face_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Face face;
    @JoinColumn(name = "distance_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Distance distance;
    @Column(name = "end_count")
    private Integer endCount;
}
