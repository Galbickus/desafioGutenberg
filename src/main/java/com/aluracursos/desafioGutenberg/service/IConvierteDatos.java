package com.aluracursos.desafioGutenberg.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
/*Nuestra INTERFAZ con el método de obtener datos del tipo genérico que
 va a recibir ese JSON y después va a
 convertir eso a la clase que deseemos*/