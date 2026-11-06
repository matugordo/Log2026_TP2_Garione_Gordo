/**
 * Clase Nota del sistema de Agenda.
 * 
 * @Author Valentino Garione - Matias Gordo
 * @Version 1
 */

public class Nota {
    private String titulo;
    private String texto;
    private int mes;
    private int dia;
    private Contacto contacto;

    public Nota() {
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Contacto getContacto() {
        return this.contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
}