package com.matevytskyi.taxreports.dto;


import com.matevytskyi.taxreports.entity.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportWithClientName {

    private long id;
    private String tittle;
    private String clientFullName;

    private ReportStatus reportStatus;

}
