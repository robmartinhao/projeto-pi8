package com.rsm.alertaapi.service;

import com.rsm.alertaapi.model.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://api.weatherapi.com/v1/current.json", name = "clima")
public interface ClimaService {

    @GetMapping("?q={q}&key=9643b4b92d4d4eb4b78211146210911&chance_of_rain")
    Weather buscaClima(@PathVariable("q") String q);
}
