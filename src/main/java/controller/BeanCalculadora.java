package controller;

public class BeanCalculadora {

    private String operacion,fecha;
    private double numero1,numero2,resultado;
    private int id;
    public BeanCalculadora(int id,String operacion,double numero1,double numero2,double resultado,String fecha){
        this.id=id;
        this.operacion=operacion;
        this.numero1=numero1;
        this.numero2=numero2;
        this.resultado=resultado;
        this.fecha=fecha;
    }

    public BeanCalculadora() {

    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
