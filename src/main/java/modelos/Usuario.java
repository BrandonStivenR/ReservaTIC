package modelos;

public class Usuario {

    private int idUsuario;
    private String nombreCompleto;
    private String documentoIdentidad;
    private String correoInstitucional;
    private String contrasena;
    private String rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreCompleto, String documentoIdentidad,
                   String correoInstitucional, String contrasena, String rol) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.correoInstitucional = correoInstitucional;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; }

    public String getCorreoInstitucional() { return correoInstitucional; }
    public void setCorreoInstitucional(String correoInstitucional) { this.correoInstitucional = correoInstitucional; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public String toString() {
        return "ID: " + idUsuario + " | Nombre: " + nombreCompleto
                + " | Documento: " + documentoIdentidad
                + " | Correo: " + correoInstitucional + " | Rol: " + rol;
    }
}