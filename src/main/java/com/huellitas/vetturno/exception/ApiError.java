package com.huellitas.vetturno.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiError {

    private int status;
    private String mensaje;
    private Map<String, String> errores;
    private LocalDateTime timestamp;

    public ApiError() {
    }

    public ApiError(int status, String mensaje, Map<String, String> errores, LocalDateTime timestamp) {
        this.status = status;
        this.mensaje = mensaje;
        this.errores = errores;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
