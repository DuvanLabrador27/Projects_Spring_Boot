package com.duvanlabrador.firstApi.Service;

public interface IOperacionesMatematicas {

    public String message();
    public Double addition(double numberOne, double numberTwo);
    public Double sub(double numberOne, double numberTwo);
    public Double mult(double numberOne, double numberTwo);
    public Double div(double numberOne, double numberTwo);
    public int mayorNumero(int numberOne, int numberTwo);
}
