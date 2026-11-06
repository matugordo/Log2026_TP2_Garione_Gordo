import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase agenda del sistema.
 * 
 * @Author Valentino Garione - Matias Gordo
 * @Version 1
 */

public class Agenda
{
    private String nombre;
    private ArrayList<Nota> notas;
    private HashMap<String, Contacto> contactos;
    
    public Agenda(String nombre) {
    this.nombre = nombre;
    this.notas = new ArrayList<Nota>();
    this.contactos = new HashMap<String, Contacto>();
    }
    
    public void agregarNota(Nota nota) {
        if (nota == null) {
            return;
        }
        this.notas.add(nota);
        Contacto c = nota.getContacto();
        if (c != null && !this.contactos.containsKey(c.getNombre().toUpperCase())) {
        agregarContacto(c);
        }
    }

    public void agregarContacto(Contacto contacto) {
        if (contacto == null) {
            return;
        }
        String clave = contacto.getNombre().toUpperCase();
        if (this.contactos.containsKey(clave)) {
            System.out.println("El contacto " + contacto.getNombre() + " ya existe en la agenda");
        } else {
            this.contactos.put(clave, contacto);
        }
    }
    
    public void listarNotas() {
        if (this.notas.isEmpty()) {
            System.out.println("La agenda no tiene notas");
            return;
        }
        System.out.println("*************************");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("*************************");
        for (Nota nota : this.notas) {
            System.out.println("Título: " + nota.getTitulo() + " Texto: " + nota.getTexto() + " Mes: " + nota.getMes() + " Día: " + nota.getDia());
            Contacto c = nota.getContacto();
            if (c != null) {
                System.out.println("Contacto: " + c.getNombre() + " Localidad: " + c.getLocalidad() + " Dirección: " + c.getDireccion());
                System.out.println("Teléfonos:");
                c.listarTelefonos();
            } else {
                System.out.println("Contacto: S/D");
            }
            System.out.println("*************************");
        }
    }

    public void eliminarContacto(String nombre) {
        if (nombre == null) {
            return;
        }
        String clave = nombre.toUpperCase();
        if (!this.contactos.containsKey(clave)) {
            System.out.println("El contacto " + nombre + " no se encuentra");
            return;
        }
        Contacto contacto = this.contactos.get(clave);
        if (tieneNotas(contacto)) {
            System.out.println("El contacto " + contacto.getNombre() + " tiene notas asociadas y no se puede eliminar");
            return;
        }
        this.contactos.remove(clave);
    }
    
    public void listarContactos() {
        if (this.contactos.isEmpty()) {
            System.out.println("La agenda no tiene contactos");
            return;
        }
        for (Contacto c : this.contactos.values()) {
            System.out.println("Contacto: " + c.getNombre() + " Localidad: " + c.getLocalidad() + " Dirección: " + c.getDireccion());
            System.out.println("Teléfonos:");
            c.listarTelefonos();
        }
    }

    public void listarContactosConNotas() {
        boolean hayAlguno = false;
        for (Contacto c : this.contactos.values()) {
            if (tieneNotas(c)) {
                System.out.println("Contacto: " + c.getNombre() + " Localidad: " + c.getLocalidad() + " Dirección: " + c.getDireccion());
                System.out.println("Teléfonos:");
                c.listarTelefonos();
                hayAlguno = true;
            }
        }
        if (!hayAlguno) {
            System.out.println("No hay contactos con notas");
        }
    }

    public void listarContactosSinNotas() {
        boolean hayAlguno = false;
        for (Contacto c : this.contactos.values()) {
            if (!tieneNotas(c)) {
                System.out.println("Contacto: " + c.getNombre() + " Localidad: " + c.getLocalidad() + " Dirección: " + c.getDireccion());
                System.out.println("Teléfonos:");
                c.listarTelefonos();
                hayAlguno = true;
            }
        }
        if (!hayAlguno) {
            System.out.println("No hay contactos sin notas");
        }
    }
    
    private boolean tieneNotas(Contacto contacto) {
        if (contacto == null) {
            return false;
        }
        for (Nota nota : this.notas) {
            if (nota.getContacto() != null && nota.getContacto().equals(contacto)) {
                return true;
            }
        }
        return false;
    }
    
    public void buscarXcontacto(String nombre) {
        if (nombre == null) {
            return;
        }
        String clave = nombre.toUpperCase();
        if (!this.contactos.containsKey(clave)) {
            System.out.println("El contacto " + nombre + " no se encuentra");
            return;
        }
        Contacto contacto = this.contactos.get(clave);
        if (!tieneNotas(contacto)) {
            System.out.println("El contacto " + contacto.getNombre() + " no tiene notas");
            return;
        }
        int totalNotas = 0;
        System.out.println("********************************************************");
        for (Nota nota : this.notas) {
            if (nota.getContacto() != null && nota.getContacto().equals(contacto)) {
                System.out.println("Título: " + nota.getTitulo() + " Texto: " + nota.getTexto());
                totalNotas++;
            }
        }
        System.out.println("Total de notas: " + totalNotas);
        System.out.println("********************************************************");
    }
    
    public void listarContactosAlfa() {
        if (this.contactos.isEmpty()) {
            System.out.println("La agenda no tiene contactos");
            return;
        }
        java.util.ArrayList<String> nombresOrdenados = new java.util.ArrayList<String>(this.contactos.keySet());
        java.util.Collections.sort(nombresOrdenados);
        for (String nombreContacto : nombresOrdenados) {
            System.out.println(nombreContacto);
        }
    }

    public void buscarXtitulos(String inicio) {
        if (inicio == null) {
            return;
        }
        boolean encontro = false;
        String busqueda = inicio.toLowerCase();
        for (Nota nota : this.notas) {
            if (nota.getTitulo() != null && nota.getTitulo().toLowerCase().startsWith(busqueda)) {
                Contacto c = nota.getContacto();
                String nombreC = (c != null) ? c.getNombre() : "S/D";
                String localidadC = (c != null) ? c.getLocalidad() : "S/D";
                System.out.print(nota.getTitulo() + " " + nota.getTexto() + " " + nombreC + " " + localidadC + " ");
                if (c != null) {
                    String[] tels = c.getTelefono();
                    for (int i = 0; i < tels.length; i++) {
                        if (tels[i] != null && !tels[i].isEmpty() && !tels[i].equals(" ")) {
                            System.out.print("[" + tels[i] + "] ");
                        }
                    }
                }
                System.out.println();
                encontro = true;
            }
        }
        if (!encontro) {
            System.out.println("No hay notas cuyo título comience con " + inicio);
        }
    }
}