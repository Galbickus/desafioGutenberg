package com.aluracursos.desafioGutenberg.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        @JsonAlias("results") List<DatosLibro> resultados
) {

}
/* record representación de los datos generales que vamos a querer traer
una lista de los datos de libros (que todavía no estaba creado)

Recordando que estamos trabajando con Jackson.
 Entonces necesitamos indicar ese JSON alias (copiando tal cual aparecen en la API)
añadir también el JSON Ignore Properties.
@JsonIgnoreProperties(ignoreUnknown = true)*/