package cl.usm.hdd.calculadorarest.demo.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class CalculoRequest {
    private int num1;
    private int num2;
    private String operacion;
}
