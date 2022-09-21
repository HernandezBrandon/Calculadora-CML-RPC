package Client;

import Server.Methods;
import controller.DaoCalculadora;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.SocketOption;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ClientRPC {

    public ClientRPC() {
    }

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws XmlRpcException, MalformedURLException, SQLException {
//Hernandez Ruiz Brandon Isai
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        DaoCalculadora dao =new DaoCalculadora();

        String opcion="",num1="",num2="",fecha=String.valueOf(LocalDateTime.now());
        int id=0;
        do {
            System.out.println("1.- Suma");
            System.out.println("2.-Resta");
            System.out.println("3.- Multiplicacion");
            System.out.println("4.-Division");
            System.out.println("5.-Exponente");
            System.out.println("6.- Raíz");
            System.out.println("7.- Salír");
            opcion =sc.next();
            if (isNumber(opcion)){
                double n1,n2;
                Object[] data= new Object[]{} ;
                double response;

                switch(Integer.parseInt(opcion)){
                    case 1:
                        do {
                            System.out.println("Ingresa el primer valor");
                            num1=sc.next();
                            if(!isNumber(num1)){
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));

                        do {
                            System.out.println("Ingresa el segundo valor");
                            num2=sc.next();
                            if(!isNumber(num2)){
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));
                        //llamado al servicio web
                        n1=Double.parseDouble(num1);
                        n2=Double.parseDouble(num2);
                        data= new Object[]{n1, n2};
                        response =(Double) client.execute("Methods.Suma", data);
                        System.out.println("El resultado es "+response);

                        dao.insertar(id,"Suma",n1,n2,response,fecha);
                        break;
                    case 2:
                        do {
                            System.out.println("Ingresa el primer valor");
                            num1=sc.next();
                            if(!isNumber(num1)){
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));

                        do {
                            System.out.println("Ingresa el segundo valor");
                            num2=sc.next();
                            if(!isNumber(num2)){
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));

                        //llamado al servicio
                        n1=Double.parseDouble(num1);
                        n2=Double.parseDouble(num2);
                        data= new Object[]{n1, n2};
                        response = (Double) client.execute("Methods.Resta",data);
                        System.out.println("El resultado es de : "+response);

                        dao.insertar(id,"Resta",n1,n2,response,fecha);
                        break;
                    case 3:
                        do {
                            System.out.println("Ingresa el primer valor");
                            num1=sc.next();
                            if(!isNumber(num1)){
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        }while(!isNumber(num1));

                        do {
                            System.out.println("Ingresa el segundo valor");
                            num2=sc.next();
                            if(!isNumber(num2)){
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        }while(!isNumber(num2));
                        //llamado al servicio
                        n1=Double.parseDouble(num1);
                        n2=Double.parseDouble(num2);
                        data= new Object[]{n1,n2};
                        response =(Double) client.execute("Methods.Multiplicacion",data);
                        System.out.println("El resultado es de : "+response);

                        dao.insertar(id,"Multiplicaion",n1,n2,response,fecha);

                        break;
                        case 4:
                            do {
                                do {
                                    System.out.println("Ingresa el primer valor");
                                    num1 = sc.next();
                                    if (!isNumber(num1)) {
                                        System.out.println("Error, ingrese un valor numerico");
                                    }
                                    if (isZero(num1)) {
                                        System.out.println("Error, ingresa un numero diferente a 0");
                                    }
                                }while(isZero(num1));
                            }while(!isNumber(num1) );


                            do {
                                do {
                                    System.out.println("Ingresa el segundo valor");
                                    num2 = sc.next();
                                    if (!isNumber(num2)) {
                                        System.out.println("Error, ingrese un valor numerico");
                                    }
                                    if (isZero(num2)) {
                                        System.out.println("Error, ingresa un numero diferente a 0");
                                    }
                                }while(isZero(num2));
                            }while(!isNumber(num2));

                            n1=Double.parseDouble(num1);
                            n2=Double.parseDouble(num2);
                            data=new Object[]{n1,n2};
                            response=(Double) client.execute("Methods.Division",data);
                            System.out.println("El resultado es de : "+response);

                            dao.insertar(id,"Division",n1,n2,response,fecha);
                        break;
                        case 5:
                            do {
                                System.out.println("Ingresa el primer valor");
                                num1=sc.next();
                                if(!isNumber(num1)){
                                    System.out.println("Error, ingrese un valor numerico");
                                }
                            }while(!isNumber(num1));

                            do {
                                System.out.println("Ingresa el exponente");
                                num2=sc.next();
                                if(!isNumber(num2)){
                                    System.out.println("Error, ingrese un valor numerico");
                                }
                            }while(!isNumber(num2));
                            n1=Double.parseDouble(num1);
                            n2=Double.parseDouble(num2);
                            data=new Object[]{n1,n2};
                            response=(Double) client.execute("Methods.Exponente",data);
                            System.out.println("El resultado es de : "+response);

                            dao.insertar(id,"Exponente",n1,n2,response,fecha);

                        break;
                        case 6:
                            do {
                                do {
                                    System.out.println("Ingresa un numero");
                                    num1 = sc.next();
                                    if (!isNumber(num1)) {
                                        System.out.println("Error, ingrese un valor numerico");
                                    }
                                    if (isZero(num1)) {
                                        System.out.println("Error, ingresa un numero diferente a 0");
                                    }
                                }while(isZero(num1));
                            }while(!isNumber(num1) );
                            n1=Double.parseDouble(num1);
                            n2=0.0;
                            data=new Object[]{n1,n2};
                            response=(Double)client.execute("Methods.Raiz",data);

                            System.out.println("La raiza de: "+n1+" Es igual a : "+response );

                            dao.insertar(id,"Raiz",n1,n2,response,fecha);

                        break;
                    case 7:
                        System.out.println("Cerrando...");
                        break;
                    default:
                        System.out.println("Ingrese una opción valida");
                }
            }else{
                System.out.println("Ingresa un valor valido");
            }
        }while (!opcion.equals("7"));
    }

    //Validacion de error para caracter, convierte la cadena a numero
    public static boolean isNumber(String number){
        try{
            double num= Double.parseDouble(number);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isZero(String number){

            double num=Double.parseDouble(number);
             if(num==0)
                 return true;
             else
                 return false;

    }


}
