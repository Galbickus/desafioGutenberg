package com.aluracursos.desafioGutenberg.principal;

import com.aluracursos.desafioGutenberg.service.ConsumoAPI;
import com.aluracursos.desafioGutenberg.service.ConvierteDatos;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu(){
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
    }
}
