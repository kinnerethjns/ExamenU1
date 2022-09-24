package Server;

import Utils.BeanCurp;
import Utils.DaoCurp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

public class Methods {
    DaoCurp daoCurp = new DaoCurp();
    private String curp;
    public String informacion(String nombre, String apellidoP, String apellidoM, String sexo, String estadoN, String fechaN){

        //obtener letra random
        Random random = new Random();
        char letraR = (char) (random.nextInt(26) + 'a');
        //obtener número random
        int numAl = (int) (Math.random()*9+1);
        // consonantes
        char [] consonantes = {'b','c','d', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n',
        'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        String aleatorio="", aleatorioP ="", aleatorio2="", aleatorioM ="", aleatorio3="", aleatorioN="";

        // consontantes apellido paterno
        apellidoP = apellidoP.toLowerCase();
        for(int i=0; i<apellidoP.length(); i++){
            for(int j =0; j<consonantes.length; j++){
                if(apellidoP.charAt(i) == consonantes[j]){
                    aleatorio += apellidoP.charAt(i);
                }
            }
        }
        String[] cons = {aleatorio};
        for(int i=0; i<aleatorio.length(); i++){
            for (int j =0; j<cons.length; j++){
            if(aleatorio.charAt(i) != apellidoP.charAt(0) && aleatorio.charAt(i) != apellidoP.charAt(1) ) {
                aleatorioP += aleatorio.charAt(i);
            }
            }
        }

        // consonantes apellido materno
        apellidoM = apellidoM.toLowerCase();
        for(int i=0; i<apellidoM.length(); i++){
            for(int j =0; j<consonantes.length; j++){
                if(apellidoM.charAt(i) == consonantes[j]){
                    aleatorio2 += apellidoM.charAt(i);
                }
            }
        }
        String[] cons1 = {aleatorio2};
        for(int i=0; i<aleatorio2.length(); i++){
            for (int j =0; j<cons1.length; j++){
                if(aleatorio2.charAt(i) != apellidoM.charAt(0)) {
                    aleatorioM += aleatorio2.charAt(i);
                }
            }
        }

        // consonantes nombre
        nombre = nombre.toLowerCase();
        for(int i=0; i<nombre.length(); i++){
            for(int j =0; j<consonantes.length; j++){
                if(nombre.charAt(i) == consonantes[j]){
                    aleatorio3 += nombre.charAt(i);
                }
            }
        }
        String[] cons2 = {aleatorio3};
        for(int i=0; i<aleatorio3.length(); i++){
            for (int j =0; j<cons2.length; j++){
                if(aleatorio3.charAt(i) != nombre.charAt(0)) {
                    aleatorioN += aleatorio3.charAt(i);
                }
            }
        }

        this.curp = String.valueOf(apellidoP.charAt(0)+""+apellidoP.charAt(1)+""+
                apellidoM.charAt(0)+""+nombre.charAt(0)+""+fechaN.charAt(2)+""+fechaN.charAt(3)+""+
                fechaN.charAt(5)+""+fechaN.charAt(6)+""+fechaN.charAt(8)+""+fechaN.charAt(9)+sexo.charAt(0)+
                ""+estadoN.charAt(0)+estadoN.charAt(1)+aleatorioP.charAt(0)+aleatorioM.charAt(0)+aleatorioN.charAt(0)+letraR+numAl);
        callDao(nombre, apellidoP, apellidoM, sexo, estadoN, Date.valueOf(fechaN), curp);
        return "La curp es: " + curp.toUpperCase();
    }
    public String buscarP(String curp){

        ArrayList<BeanCurp> aux = daoCurp.showInformacion(curp);
        String response = "";
        for (BeanCurp informacion: aux){
            response+=  "Nombre: " + informacion.getNombre() + "\n"
                    + "Primer apellido: " + informacion.getApellido_P() + "\n"
                    + "Segundo apellido: " + informacion.getApellido_M() + "\n"
                    + "Sexo: " + informacion.getSexo() + "\n"
                    + "Estado de nacimiento: " + informacion.getEstado() + "\n"
                    + "Fecha de nacimiento: " + informacion.getFechaN() + "\n"
                    + "Curp: " + informacion.getCurp() + "\n";
        }

        return response;
    }

    public void callDao(String nombre, String apellido_P, String apellido_M, String sexo, String estado, Date fechaN, String curp){
        daoCurp.saveInformacion(nombre, apellido_P, apellido_M, sexo, estado, fechaN, curp);
    }
}
