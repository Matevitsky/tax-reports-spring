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
    @GeneratedValue
    private long id;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(name = "tittle")
    private String tittle;

    @NotEmpty
    @NotNull
    @Column(name = "content")
    private String content;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    @NotEmpty
    @Column(name = "reasonToReject")
    private String reasonToReject;

    @NotEmpty
    @NotNull

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Client client;
}
