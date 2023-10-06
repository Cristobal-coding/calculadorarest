package cl.usm.hdd.calculadorarest.demo.controllers;

import cl.usm.hdd.calculadorarest.demo.entities.CalculoRequest;
import cl.usm.hdd.calculadorarest.demo.entities.CalculoResponse;
import cl.usm.hdd.calculadorarest.demo.exceptions.OperacionException;
import cl.usm.hdd.calculadorarest.demo.services.CalculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CalculoControllerTest {

    @Mock
    private CalculoService calculoService;
    private  CalculoController calculoController;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
        this.calculoController = new CalculoController(calculoService);
    };


    @Test
    void calcularOk() throws OperacionException {
        when(calculoService.calcular(anyInt(), anyInt(), anyString())).thenReturn(1.0);
        CalculoRequest requestTest = new CalculoRequest();
        requestTest.setNum1(5);
        requestTest.setNum2(7);
        requestTest.setOperacion("*");
        ResponseEntity<CalculoResponse> res = calculoController.calcular(requestTest);

        assertEquals(HttpStatus.OK, res.getStatusCode());
    }

    @Test
    void calcularOperacionExceptionFail() throws OperacionException{
        when(calculoService.calcular(anyInt(), anyInt(), anyString())).thenThrow(new OperacionException());
        CalculoRequest requestTest = new CalculoRequest();
        requestTest.setNum1(5);
        requestTest.setNum2(7);
        requestTest.setOperacion("*");
        ResponseEntity<CalculoResponse> res = calculoController.calcular(requestTest);

        assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());
    }

    @Test
    void calcularOtherExceptionsFail() throws OperacionException{
        when(calculoService.calcular(anyInt(), anyInt(), anyString())).thenThrow(new NullPointerException());
        CalculoRequest requestTest = new CalculoRequest();
        requestTest.setNum1(2);
        requestTest.setNum2(4);
        requestTest.setOperacion("+");
        ResponseEntity<CalculoResponse> res = calculoController.calcular(requestTest);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, res.getStatusCode());
    }
}