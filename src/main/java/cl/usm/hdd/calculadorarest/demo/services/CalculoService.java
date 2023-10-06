package cl.usm.hdd.calculadorarest.demo.services;

import cl.usm.hdd.calculadorarest.demo.exceptions.OperacionException;

public interface CalculoService {
     double calcular(int num1, int num2, String operacion) throws OperacionException;


}
