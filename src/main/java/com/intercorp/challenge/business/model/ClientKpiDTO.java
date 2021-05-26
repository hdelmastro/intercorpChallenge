package com.intercorp.challenge.business.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClientKpiDTO {



    private Double ageAverage;
    private Double ageStandardDeviation;

}
