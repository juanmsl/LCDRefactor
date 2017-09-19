package resources;

import java.util.StringTokenizer;

public enum Strings {
    FINAL_INPUT("0,0"),
    ASK_SPACE_BETWEEN("Espacio entre Digitos (0 a 5): "),
    ERROR_NOT_A_NUMBER("Error: No es un entero valido"),
    ERROR_SPACE_BETWEEN("Error: El espacio entre digitos debe estar entre 0 y 5"),
    ERROR_INVALD_LINE_FORMAT("Error: La linea es invalida"),
    ERROR_INVALID_SIZE("Error: El tamaño debe estar entre 1 y 10"),
    ERROR_INVALID_SIZE_FORMAT("Error: El tamaño debe ser un numero entero");

    private String message;

    Strings(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
