package Client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ClientRPC {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        teclado.useDelimiter("\n");
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        String nombre, apellidoP, apellidoM, sexo, estadoN, fechaN;
        int opc=0;
        while(opc !=3) {
            System.out.println("Ingresa la opción que desea realizar: ");
            System.out.println("1.- Ingresar persona");
            System.out.println("2.- Buscar persona");
            System.out.println("3.- Salir");
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    //Ingresar persona
                    System.out.println("Ingresa el nombre de la persona: ");
                    nombre = teclado.next();
                    System.out.println("Ingresa el primer apellido de la persona: ");
                    apellidoP = teclado.next();
                    System.out.println("Ingresa el segundo apellido de la persona: ");
                    apellidoM = teclado.next();
                    System.out.println("Ingresa el sexo de la persona (Mujer / Hombre): ");
                    sexo = teclado.next();
                    System.out.println("Ingresa la clave del estado de nacimiento: ");
                    System.out.println("***** LAS CLAVES SON LAS SIGUIENTES : *****");
                    System.out.println("AGUASCALIENTES AS\n" +
                            "BAJA CALIFORNIA BC\n" +
                            "BAJA CALIFORNIA SUR BS CAMPECHE CC\n" +
                            "COAHUILA CL COLIMA CM\n" +
                            "CHIAPAS CS CHIHUAHUA CH\n" +
                            "DISTRITO FEDERAL DF DURANGO DG\n" +
                            "GUANAJUATO GT GUERRERO GR\n" +
                            "HIDALGO HG JALISCO JC\n" +
                            "MÉXICO MC MICHOACÁN MN\n" +
                            "MORELOS MS NAYARIT NT\n" +
                            "NUEVO LEÓN NL OAXACA OC\n" +
                            "PUEBLA PL QUERÉTARO QT\n" +
                            "QUINTANA ROO QR SAN LUIS POTOSÍ SP\n" +
                            "SINALOA SL SONORA SR\n" +
                            "TABASCO TC TAMAULIPAS TS\n" +
                            "TLAXCALA TL VERACRUZ VZ\n" +
                            "YUCATÁN YN ZACATECAS ZS\n" +
                            "NACIDO EN EL EXTRANJERO NE");
                    estadoN = teclado.next();
                    System.out.println("Ingresa la fecha de nacimiento separado por - (ejemplo: 2003-05-03)");
                    fechaN = teclado.next();
                    Object[] data = {nombre, apellidoP, apellidoM, sexo, estadoN, fechaN};
                    String response = (String) client.execute("Methods.informacion",data);
                    System.out.println(response);
                    break;
                case 2:
                    //Buscar persona
                    System.out.println("Ingresa la CURP de la persona que deseas buscar: ");
                    Object[] data1= {teclado.next()};
                    Object response1 = client.execute("Methods.buscarP", data1);
                    System.out.println(response1);
                    break;
                case 3:
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Error");
            }
        }








    }
}
