package Utils;

import java.sql.Date;

public class BeanCurp {
    private String nombre;
    private String apellido_P;
    private String apellido_M;
    private String sexo;
    private String estado;
    private Date fechaN;
    private String curp;

    public BeanCurp(){

    }

    public BeanCurp(String nombre, String apellido_P, String apellido_M, String sexo, String estado, Date fechaN, String curp){
        this.nombre = nombre;
        this.apellido_P = apellido_P;
        this.apellido_M = apellido_M;
        this.sexo = sexo;
        this.estado = estado;
        this.fechaN = fechaN;
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_P() {
        return apellido_P;
    }

    public void setApellido_P(String apellido_P) {
        this.apellido_P = apellido_P;
    }

    public String getApellido_M() {
        return apellido_M;
    }

    public void setApellido_M(String apellido_M) {
        this.apellido_M = apellido_M;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
