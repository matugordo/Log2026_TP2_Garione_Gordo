import java.util.Scanner;

/**
 * Clase Contacto para gestion de agenda de telefonos.
 * 
 * @Author Valentino Garione - Matias Gordo
 * @Version 1
 */

public class Contacto {
    private String nombre;
    private String localidad;
    private String direccion;
    private String[] telefono; 

    public Contacto(String nombre, String localidad, String direccion, String telefono) {
        this.telefono = new String[5];
        setNombre(nombre);
        setLocalidad(localidad);
        setDireccion(direccion);

        if (telefono == null || telefono.equals("") || telefono.equals(" ")) {
            agregarTelefono();
        } else {
            this.telefono[0] = telefono;
        }
    }
        
    public void agregarTelefono(String caracteristica, int numero) {
        int pos = elementoVacio();
        if (pos == -1) {
            System.out.println("No existe más lugar para agregar números telefónicos");
            return;
        }
        if (!validarCaracteristica(caracteristica) || !validarNumero(numero)) {
            System.out.println("El número ingresado es erróneo");
            return;
        }
        telefono[pos] = caracteristica + "-" + numero;
    }

    public void agregarTelefono() {
        int pos = elementoVacio();
        if (pos == -1) {
            System.out.println("No existe más lugar para agregar números telefónicos");
            return;
        }
        
        Scanner teclado = new Scanner(System.in);
        String caracteristica;
        while (true) {
            System.out.print("Ingrese la característica (debe iniciar con 0, 3 a 5 dígitos): ");
            caracteristica = teclado.nextLine();
            if (validarCaracteristica(caracteristica)) {
                break; 
            }
            System.out.println("Característica errónea. Intente nuevamente.");
        }
        int numero;
        while (true) {
            System.out.print("Ingrese el número (5 a 7 dígitos): ");
            if (teclado.hasNextInt()) {
                numero = teclado.nextInt();
                teclado.nextLine(); 
                if (validarNumero(numero)) {
                    break; 
                }
            } else {
                teclado.nextLine(); 
            }
            System.out.println("Número erróneo. Intente nuevamente.");
        }
        agregarTelefono(caracteristica, numero);
    }
        
    public void modificarTelefono() {
        boolean hayTelefonos = false;
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].equals("") && !telefono[i].equals(" ")) {
                hayTelefonos = true;
                break;
            }
        }
        if (!hayTelefonos) {
            System.out.println("No existen números de teléfonos en la lista para modificar");
            return;
        }
        listarTelefonos();
        Scanner teclado = new Scanner(System.in);
        int posicion;
        while (true) {
            System.out.print("Ingrese la posición del teléfono a modificar: ");
            if (teclado.hasNextInt()) {
                posicion = teclado.nextInt();
                teclado.nextLine(); 
                if (validarPosicion(posicion)) {
                    break; 
                }
            } else {
                teclado.nextLine(); 
            }
            System.out.println("Posición incorrecta o inexistente. Intente nuevamente.");
        }
        String nuevaCarac;
        while (true) {
            System.out.print("Ingrese la nueva característica (debe iniciar con 0, 3 a 5 dígitos): ");
            nuevaCarac = teclado.nextLine();
            if (validarCaracteristica(nuevaCarac)) {
                break;
            }
            System.out.println("Característica errónea. Intente nuevamente.");
        }
        int nuevoNum;
        while (true) {
            System.out.print("Ingrese el nuevo número (5 a 7 dígitos): ");
            if (teclado.hasNextInt()) {
                nuevoNum = teclado.nextInt();
                teclado.nextLine(); 
                if (validarNumero(nuevoNum)) {
                    break;
                }
            } else {
                teclado.nextLine(); 
            }
            System.out.println("Número erróneo. Intente nuevamente.");
        }
        telefono[posicion - 1] = nuevaCarac + "-" + nuevoNum;
        System.out.println("Teléfono modificado exitosamente.");
    }
    
   public void eliminarTelefono() {
        boolean hayTelefonos = false;
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].equals("") && !telefono[i].equals(" ")) {
                hayTelefonos = true;
                break;
            }
        }
        if (!hayTelefonos) {
            System.out.println("No existen números de teléfonos en la lista");
            return;
        }
        listarTelefonos();
        Scanner teclado = new Scanner(System.in);
        int posicion;
        while (true) {
            System.out.print("Ingrese la posición del teléfono a eliminar: ");
            if (teclado.hasNextInt()) {
                posicion = teclado.nextInt();
                teclado.nextLine(); 
                if (validarPosicion(posicion)) {
                    break;
                }
            } else {
                teclado.nextLine();
            }
            System.out.println("Posición incorrecta o inexistente. Intente nuevamente.");
        }
        telefono[posicion - 1] = ""; 
        System.out.println("Teléfono eliminado exitosamente.");
    }
    
    public void listarTelefonos() {
        boolean hayTelefonos = false;
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].equals("") && !telefono[i].equals(" ")) {
                System.out.println((i + 1) + ") " + telefono[i]);
                hayTelefonos = true;
            }
        }

        if (!hayTelefonos) {
            System.out.println("No existen números de teléfonos en la lista");
        }
    }

    public int elementoVacio() {
        for (int i = 0; i < telefono.length; i++) {     
            if (telefono[i] == null || telefono[i].equals("") || telefono[i].equals(" ")) {
                return i; 
            }
        }
        return -1; 
    }
    
    public boolean validarPosicion(int p) {
        if (p < 1 || p > 5) {
            return false;
        }
        int indice = p - 1;
        return telefono[indice] != null && !telefono[indice].equals("") && !telefono[indice].equals(" ");
    }

    public boolean validarCaracteristica(String c) {
        if (c == null) return false;
        if (c.length() < 3 || c.length() > 5) return false;
        if (!c.startsWith("0")) return false;
        for (int i = 0; i < c.length(); i++) {
            if (!Character.isDigit(c.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validarNumero(int n) {
        return n >= 10000 && n <= 9999999;
    }
        
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.equals("") || nombre.equals(" ")) {
            this.nombre = "S/D";
        } else {
            this.nombre = nombre.toUpperCase();
        }
    }
    
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        if (localidad == null || localidad.equals("") || localidad.equals(" ")) {
            this.localidad = "S/D";
        } else {
            this.localidad = localidad.toUpperCase();
        }
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.equals("") || direccion.equals(" ")) {
            this.direccion = "S/D";
        } else {
            this.direccion = direccion.toUpperCase();
        }
    }
    
    public String[] getTelefono() {
        return this.telefono;
    }
}
    
