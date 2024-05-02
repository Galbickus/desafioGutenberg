package com.aluracursos.desafioGutenberg.principal;

import com.aluracursos.desafioGutenberg.model.Datos;
import com.aluracursos.desafioGutenberg.model.DatosLibro;
import com.aluracursos.desafioGutenberg.service.ConsumoAPI;
import com.aluracursos.desafioGutenberg.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //top 10 libros más descargados
        System.out.println("Top 10 de libros más descargados ");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibro::numeroDeDescargas).reversed())
                .limit(10)
                .map(l->l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de libros por nombre
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloBuscado = teclado.nextLine();
        json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloBuscado.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloBuscado.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        }else{
            System.out.println("Libro no encontrado");
        }

        //Trabajando con estadisticas general del sitio( no del libro buscado sino hay que cambiar la busqueda)
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.numeroDeDescargas() >0 )
                .collect(Collectors.summarizingDouble(DatosLibro::numeroDeDescargas));
        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("Cantidad máxima de descargas: "+ est.getMax());
        System.out.println("Cantidad mínima de descargas: " + est.getMin());
        System.out.println("Cantidad de registros evaluados para calcular las estadisticas: " + est.getCount());

    }
}
