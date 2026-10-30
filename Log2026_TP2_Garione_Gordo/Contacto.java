import java.util.Scanner;
/**
 * Write a description of class Contacto here.
 * 
 * @Author Valentino Garione - Matias Gordo
 * @Version 1
 */
public class Contacto
{
   private String nombre;
   private String localidad;
   private String direccion;
   private String[] telefono; 
   
    public Contacto (String nombre, String localidad, String direccion, String telefono){
    this.telefono = new String[5];
    setNombre(nombre);
    setLocalidad(localidad);
    setDireccion(direccion);
    }
    
    public void agregarTelefono(String caracteristica, int numero) {
    for (int i = 0; i < telefono.length; i++) {
        if (telefono[i] == null) {
            telefono[i] = caracteristica + numero;
            break;
        }
    }
    }

    public void agregarTelefono(){
    Scanner teclado = new Scanner(System.in);
    System.out.println("Ingrese la característica:");
    String caracteristica = teclado.nextLine();
    System.out.println("Ingrese el número:");
    int numero = teclado.nextInt();
    agregarTelefono(caracteristica, numero);
    }
    
    public void modificarTelefono() {
    Scanner teclado = new Scanner(System.in);
    System.out.println("Telefonos cargados:");
    for (int i = 0; i < telefono.length; i++) {
        if (telefono[i] != null) {
            System.out.println((i + 1) + ". " + telefono[i]);
        }
    }
    System.out.println("Ingrese la posicion del telefono que desea modificar:");
    int posicion = teclado.nextInt();
    teclado.nextLine();
    if (posicion >= 1 && posicion <= telefono.length && telefono[posicion - 1] != null) {
        System.out.println("Ingrese la nueva caracteristica:");
        String caracteristica = teclado.nextLine();
        System.out.println("Ingrese el nuevo numero:");
        int numero = teclado.nextInt();
        telefono[posicion - 1] = caracteristica + numero;
        System.out.println("Telefono modificado correctamente.");
    } else {
        System.out.println("Posicion incorrecta o telefono inexistente.");
    }
    }
    
    public void eliminarTelefono(){
        
    }
    
    public void listarTelefono(){
        
    }

    public void elementoVacio(){
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre.toUpperCase();
    }
    public String getLocalidad(){
        return this.localidad;
    }
    public void setLocalidad(String localidad){
        this.localidad = localidad.toUpperCase();
    }
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion.toUpperCase();
    }
    public String[] getTelefono() {
    return this.telefono;
    }
    public void setTelefono(String[] telefono) {
    this.telefono = telefono;
    }
}
