package com.intercorp.challenge.service;

import com.intercorp.challenge.business.model.ClientDTO;
import com.intercorp.challenge.persistence.entity.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticService implements IStatisticService{

    /**
     * Estos 2 valores se podrian guardar en la base de datos para mayor seguridad pero dado que es un challenge los dejo como atributos de clase
     */
    private Integer numberOfClients = 0;

    private Double ageAverage = 0D;

    @Override
    public void calculateStatitstics(ClientDTO client) {
        ageAverage = (ageAverage * Double.valueOf(numberOfClients) + Double.valueOf(client.getAge()))/Double.valueOf(numberOfClients+1);
        numberOfClients++;
    }

    @Override
    public Double solveStandardDeviation(List<Client> clients) {
        Optional<Double> valuesSum = clients.stream().map(cl -> Math.pow(Math.abs((Double.valueOf(cl.getAge()) - ageAverage)), 2)).reduce(Double::sum);
        Double response = Math.sqrt( valuesSum.orElseGet(() -> 0D) /numberOfClients) ;
        return response;
    }

    @Override
    public Double getAgeAverage() {
        return ageAverage;
    }

    @Override
    public LocalDate getDateOfDeath(Client cl, List<Client> clients) {

        LocalDate clientLastYear = cl.getBirthDate().plusYears(cl.getAge());
        Double standardDesviation = solveStandardDeviation(clients);
        Long totalDays = Math.round(standardDesviation * 365);
        LocalDate response = clientLastYear.plusDays(totalDays);

        return response;
    }
}
