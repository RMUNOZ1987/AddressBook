import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    //Atributo: almacena los contactos

    private Map<String, String> contactos = new HashMap<>();

    // Método load: carga los contactos desde el archivo
    public void load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("contactos.txt"));
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String numero = partes[0];
                String nombre = partes[1];
                contactos.put(numero, nombre);
            }

            reader.close();
            System.out.println("Contactos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo.");
        }
    }

    // Método save: guarda los contactos en el archivo
    public void save() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("contactos.csv"));

            for (Map.Entry<String, String> entry : contactos.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }

            writer.close();
            System.out.println("Contactos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    // Método list: muestra los contactos con el formato solicitado
    public void list() {
        System.out.println("Contactos:");

        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Método create: crea un nuevo contacto
    public void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número telefónico: ");
        String numero = scanner.nextLine();

        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();

        contactos.put(numero, nombre);
        System.out.println("Contacto agregado correctamente.");
    }

    // Método delete: elimina un contacto por número
    public void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número telefónico a eliminar: ");
        String numero = scanner.nextLine();

        if (contactos.containsKey(numero)) {
            contactos.remove(numero);
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("El contacto no existe.");
        }
    }
}





