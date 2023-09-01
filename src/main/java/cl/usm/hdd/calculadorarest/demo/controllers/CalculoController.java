package cl.usm.hdd.calculadorarest.demo.controllers;


import cl.usm.hdd.calculadorarest.demo.entities.CalculoRequest;
import cl.usm.hdd.calculadorarest.demo.services.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CalculoController {
    @Autowired
    private CalculoService calculoService;
    @PostMapping("/calcular")
    public double calcular(@RequestBody CalculoRequest calculoRequest){

        double resultado = calculoService.calcular(calculoRequest.getNum1(),
                calculoRequest.getNum2(),
                calculoRequest.getOperacion());
        return  resultado;
    }

}
