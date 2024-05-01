package com.aluracursos.desafioGutenberg.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

/* Se necesita importar y adicionar la dependencia de jsonDatabind en el archivo POM.
 para que no de error. Podemos encontrarla en MVN Repository,
 una vez agregado no olvidar ACTUALIZAR el POM para que descargue antes de
 intentar importar las librerías objectMapped
 e implementamos nuestra interfaz en esta clase*/