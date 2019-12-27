package com.matevytskyi.taxreports.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank
    @Column(name = "tittle")
    private String tittle;

    @NotEmpty
    @NotNull
    @Column(name = "content")
    private String content;


    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ReportStatus status;


    @Column(name = "reasonToReject")
    private String reasonToReject;


    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Client client;
}
