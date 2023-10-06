package cl.usm.hdd.calculadorarest.demo.controllers;


import cl.usm.hdd.calculadorarest.demo.entities.CalculoRequest;
import cl.usm.hdd.calculadorarest.demo.entities.CalculoResponse;
import cl.usm.hdd.calculadorarest.demo.exceptions.OperacionException;
import cl.usm.hdd.calculadorarest.demo.services.CalculoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CalculoController {

    private CalculoService calculoService;
    @Autowired
    public CalculoController(CalculoService calculoService){
        this.calculoService = calculoService;
    }
    @PostMapping("/calcular")
    public ResponseEntity<CalculoResponse> calcular(@RequestBody CalculoRequest calculoRequest){

        try {
            double resultado = calculoService.calcular(calculoRequest.getNum1(),
                    calculoRequest.getNum2(),
                    calculoRequest.getOperacion());
            CalculoResponse calculoResponse= new CalculoResponse();
            calculoResponse.setResultado(resultado);
            return ResponseEntity.ok(calculoResponse);
        }catch (OperacionException err){
            return ResponseEntity.badRequest().body(null);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
