package com.rsm.alertaapi.controlers;


import com.rsm.alertaapi.model.Weather;
import com.rsm.alertaapi.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clima")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping("/{q}")
    public ResponseEntity<Weather> getClima(@PathVariable String q) {

        Weather weather = climaService.buscaClima(q);

        return weather != null ? ResponseEntity.ok().body(weather) : ResponseEntity.notFound().build();
    }
}
