package Server;

public class Methods {
    public Methods() {
    }

    private double result;

    public double Suma(double num1,double num2){
         result=num1+num2;
            return result;
    }

    public  double Resta(double num1,double num2){
        result=num1-num2;
        return result;
    }

    public  double Multiplicacion(double num1,double num2){
        result=num1*num2;
        return result;
    }

    public double Division(double num1,double num2){
        result=num1/num2;
        return result;
    }

    public  double Exponente(double num1,double num2){
        double r=num1;
        if(num2==1){
            return num1;
        } else if (num2==0) {
            return 1;
        }else {
            for (int i = 1; i <= (num2-1); i++) {
                r = num1 *  r;
            }
            return  r;
        }
    }

    public  double Raiz(double num1,double num2){
        return Math.sqrt(num1);
    }

    //llamadas a BD

    /*create table operations(
        id bigint primary key auto_increment
        created_at datetime not null default now()
        );
     */
}
