package com.aluracursos.desafioGutenberg.principal;

import com.aluracursos.desafioGutenberg.model.Datos;
import com.aluracursos.desafioGutenberg.model.DatosLibro;
import com.aluracursos.desafioGutenberg.service.ConsumoAPI;
import com.aluracursos.desafioGutenberg.service.ConvierteDatos;

import java.util.Comparator;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //top 10 libros más descargados
        System.out.println("top 10 libros más descargados ");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibro::numeroDeDescargas).reversed())
                .limit(10)
                .forEach(System.out::println);

    }
}
