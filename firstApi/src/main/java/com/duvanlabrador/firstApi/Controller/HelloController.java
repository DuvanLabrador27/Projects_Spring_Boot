package com.duvanlabrador.firstApi.Controller;

import com.duvanlabrador.firstApi.Service.OpercaionesMatematicas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {
    private final OpercaionesMatematicas opercaionesMatematicas;
    @Autowired
    public HelloController(OpercaionesMatematicas opercaionesMatematicas){
        this.opercaionesMatematicas = opercaionesMatematicas;
    }
    @GetMapping("/message")
    public String message(){
        return opercaionesMatematicas.message();
    }
    @GetMapping("/add")
    public Double addition(int numberOne, int numberTwo){
        return opercaionesMatematicas.addition(numberOne,numberTwo);
    }
    @GetMapping("/sub")
    public Double sub(int numberOne, int numberTwo){
        return opercaionesMatematicas.sub(numberOne,numberTwo);
    }
    @GetMapping("/mult")
    public Double mult(int numberOne, int numberTwo){
        return opercaionesMatematicas.mult(numberOne,numberTwo);
    }
    @GetMapping("/div")
    public Double div(int numberOne, int numberTwo){
        return opercaionesMatematicas.div(numberOne,numberTwo);
    }
    @GetMapping("/numMayor")
    public int numMayor(int numberOne, int numberTwo){
        return opercaionesMatematicas.mayorNumero(numberOne,numberTwo);
    }


}
