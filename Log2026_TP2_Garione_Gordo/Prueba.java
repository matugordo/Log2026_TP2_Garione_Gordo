import java.util.Scanner;

/**
 * Clase de prueba para verificar el funcionamiento del sistema de Agenda.
 * 
 * @Author Valentino Garione - Matias Gordo
 * @Version 1
 */

public class Prueba {

    public static void main(String[] args) {
        System.out.println("=== 1. CREACION DE 5 CONTACTOS ===");
        Contacto c1 = new Contacto("Juan Perez", "Santa Fe", "San Martin 1234", "0342-4567891");
        Contacto c2 = new Contacto("Maria Lopez", "Rosario", "Cordoba 543", "0341-4234567");
        Contacto c3 = new Contacto("Carlos Gomez", "Santo Tome", "7 de Marzo 890", "0342-4751234");
        Contacto c4 = new Contacto("Ana Martinez", "Parana", "Urquiza 321", "0343-4319876");
        Contacto c5 = new Contacto("Pedro Fernandez", "Santa Fe", "25 de Mayo 1111", "0342-4598765");
        System.out.println("Contactos creados exitosamente.\n");

        System.out.println("=== 2. AGREGAR 4 TELEFONOS A C1 Y LISTAR ===");
        c1.agregarTelefono("0342", 4567892);
        c1.agregarTelefono("0341", 4452222);
        c1.agregarTelefono("0343", 4987654);
        c1.agregarTelefono("011", 5432123);
        c1.listarTelefonos();
        System.out.println();

        System.out.println("=== 3. CREACION DE 4 NOTAS ASOCIADAS A CONTACTOS DISTINTOS ===");
        Nota n1 = new Nota();
        n1.setTitulo("Reunion de presupuesto");
        n1.setTexto("Revisar gastos del mes");
        n1.setMes(11);
        n1.setDia(10);
        n1.setContacto(c1);

        Nota n2 = new Nota();
        n2.setTitulo("Entrega de proyecto");
        n2.setTexto("Presentar TP en laboratorio");
        n2.setMes(11);
        n2.setDia(15);
        n2.setContacto(c2);

        Nota n3 = new Nota();
        n3.setTitulo("Llamar proveedor");
        n3.setTexto("Consultar stock de componentes");
        n3.setMes(11);
        n3.setDia(20);
        n3.setContacto(c3);

        Nota n4 = new Nota();
        n4.setTitulo("Reunion de equipo");
        n4.setTexto("Coordinar tareas de programacion");
        n4.setMes(11);
        n4.setDia(25);
        n4.setContacto(c4);
        
        System.out.println("4 notas creadas y asociadas a c1, c2, c3 y c4.\n");

        System.out.println("=== 4. REGISTRAR EN AGENDA Y LISTADOS ===");
        Agenda agenda = new Agenda("Agenda Personal 2026");

        agenda.agregarContacto(c1);
        agenda.agregarContacto(c2);
        agenda.agregarContacto(c3);
        agenda.agregarContacto(c4);
        agenda.agregarContacto(c5);

        agenda.agregarNota(n1);
        agenda.agregarNota(n2);
        agenda.agregarNota(n3);
        agenda.agregarNota(n4);

        System.out.println("\n--- LISTAR NOTAS ---");
        agenda.listarNotas();

        System.out.println("\n--- LISTAR TODOS LOS CONTACTOS ---");
        agenda.listarContactos();

        System.out.println("\n--- LISTAR CONTACTOS CON NOTAS ---");
        agenda.listarContactosConNotas();

        System.out.println("\n--- LISTAR CONTACTOS SIN NOTAS (debe aparecer solo c5) ---");
        agenda.listarContactosSinNotas();

        System.out.println("\n=== 5. PRUEBA DE ELIMINACION ===");
        System.out.println("Intentando eliminar contacto con notas (c1 / JUAN PEREZ):");
        agenda.eliminarContacto("Juan Perez");

        System.out.println("\nIntentando eliminar contacto sin notas (c5 / PEDRO FERNANDEZ):");
        agenda.eliminarContacto("Pedro Fernandez");

        System.out.println("\n--- CONTACTOS LUEGO DE LAS ELIMINACIONES ---");
        agenda.listarContactos();

        System.out.println("\n=== 6. PRUEBA DE METODOS DESAFIO ===");
        System.out.println("\n-- Desafio: buscarXcontacto --");
        agenda.buscarXcontacto("Juan Perez");
        agenda.buscarXcontacto("Pedro Fernandez"); 
        agenda.buscarXcontacto("Nombre Inexistente");

        System.out.println("\n-- Desafio: listarContactosAlfa --");
        agenda.listarContactosAlfa();

        System.out.println("\n-- Desafio: buscarXtitulos --");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese texto de inicio para buscar notas por titulo (ej: Reu): ");
        String inicio = teclado.nextLine();
        agenda.buscarXtitulos(inicio);
    }
}