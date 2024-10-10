package com.francisco.micambio.herramientas;

import com.francisco.micambio.principal.Solicitud;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Historial {
    //Variables necesarias
    List<Solicitud> listaDeSolicitudes= new ArrayList<>();
    Gson gson =new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new Serializador())
            .setPrettyPrinting()
            .create();
    //Añade una solicitud a la lista
    static void registra(Solicitud solicitud){
        listaDeSolicitudes.add(solicitud);

    }
    //Crea un json con las multiples solicitudes en cada sesion
    static void archiva(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String fechaActual = LocalDateTime.now().format(formatter);
        String nombreArchivo = "Historial_" + fechaActual + ".json";

        try {
            // Guardar el archivo JSON con el nuevo nombre
            FileWriter archivo = new FileWriter(nombreArchivo);
            archivo.write(gson.toJson(listaDeSolicitudes));
            archivo.close();
            System.out.println("Historial guardado como: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error en la creación del historial.");
        }

    }
    //Muestra cada solicitud apartir de los Json
    static void muestra(){
        File directorio = new File(".");  // Directorio actual

        // Filtrar los archivos que comienzan con "Historial_" y terminan en ".json"
        File[] archivos = directorio.listFiles((dir, name) -> name.startsWith("Historial_") && name.endsWith(".json"));

        if (archivos != null && archivos.length > 0) {
            Arrays.stream(archivos).forEach(archivo -> {
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    // Deserializar el archivo JSON en un arreglo de Solicitud
                    Solicitud[] solicitudes = gson.fromJson(reader, Solicitud[].class);

                    // Mostrar el contenido del archivo
                    System.out.println("Mostrando " + archivo.getName());
                    for (Solicitud solicitud : solicitudes) {
                        System.out.println(solicitud);
                    }
                    System.out.println();  // Espacio entre archivos
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + archivo.getName());
                }
            });
        } else {
            System.out.println("No se encontraron archivos de historial.");
        }
    }
    //Analiza los Json y borra los que fueron creados hace mas de 5 dias.
    static void borra() {
        File directorio = new File("."); // El directorio actual donde están los archivos JSON

        // Filtrar los archivos que comienzan con "Historial_" y terminan en ".json"
        File[] archivos = directorio.listFiles((dir, name) -> name.startsWith("Historial_") && name.endsWith(".json"));

        if (archivos != null) {
            Arrays.stream(archivos).forEach(archivo -> {
                try {
                    // Obtener las propiedades del archivo (fecha de creación)
                    BasicFileAttributes attrs = Files.readAttributes(archivo.toPath(), BasicFileAttributes.class);
                    LocalDateTime fechaCreacion = LocalDateTime.ofInstant(attrs.creationTime().toInstant(), ZoneId.systemDefault());

                    // Comparar si el archivo tiene más de 5 días
                    if (fechaCreacion.isBefore(LocalDateTime.now().minusDays(5))) {
                        // Eliminar el archivo
                        if (archivo.delete()) {
                            System.out.println("Archivo eliminado: " + archivo.getName());
                        } else {
                            System.out.println("No se pudo eliminar el archivo: " + archivo.getName());
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al acceder al archivo: " + archivo.getName());
                }
            });
        }
    }
}
