package com.duvanlabrador.firstApi.Service;

import org.springframework.stereotype.Service;

@Service
public class OpercaionesMatematicas implements IOperacionesMatematicas{

    @Override
    public String message() {
        return "Hola a todos, esta API realiza operaciones matematicas";
    }

    @Override
    public Double addition(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    @Override
    public Double sub(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    @Override
    public Double mult(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    @Override
    public Double div(double numberOne, double numberTwo) {
        if(numberOne == 0 || numberTwo == 0){
            System.out.println("No se puede dividir por 0");
        }
        return numberOne / numberTwo;
    }

    @Override
    public int mayorNumero(int numberOne, int numberTwo) {

        if(numberOne == numberTwo){
            System.out.println("The numbers are equals");
            return numberOne;
        }
        else if (numberOne > numberTwo){
            return numberOne;
        }else {
            return numberTwo;
        }
    }
}
