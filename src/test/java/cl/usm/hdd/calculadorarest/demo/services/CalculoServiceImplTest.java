package cl.usm.hdd.calculadorarest.demo.services;

import cl.usm.hdd.calculadorarest.demo.exceptions.OperacionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculoServiceImplTest {
    CalculoService cs;

    @BeforeEach
    void init(){
        cs = new CalculoServiceImpl();
    }

    @Test
    void calcularSuma() throws OperacionException {
        double resp = cs.calcular(1,2,"+");
        assertEquals(3.0,resp);
    }
    @Test
    void calcularResta() throws OperacionException {
        double resp = cs.calcular(3,2,"-");
        assertEquals(1.0,resp);
    }
    @Test
    void calcularMultiplicacion() throws OperacionException {
        double resp = cs.calcular(3,2,"*");
        assertEquals(6.0,resp);
    }
    @Test
    void calcularDivision() throws OperacionException {
        double resp = cs.calcular(4,2,"/");
        assertEquals(2.0,resp);
    }

    @Test
    void calcularDivisionByZero() throws OperacionException {
        double resp = cs.calcular(4,0,"/");
        assert(OperacionException(),resp);
    }

    @Test
    void calcularDefaultCase() throws OperacionException {
        double resp = cs.calcular(4,2,"**");
        assertEquals(2.0,resp);
    }

}