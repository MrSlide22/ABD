package abd.p1.controller;

import abd.p1.model.Busca;
import abd.p1.model.Genero;
import java.util.Date;
import java.util.List;

public interface UsuarioObserver extends Observer {

    public abstract void onNombreChange(String nombre);
    public abstract void onFechaDeNacimientoChange(Date fecha);
    public abstract void onAvatarChange(byte[] avatar);
    public abstract void onAficionesChange(List<String> aficiones);
    public abstract void onSexoChange(Genero sexo);
    public abstract void onPreferenciaChange(Busca busca);
    public abstract void onPassChange(String pass);
}
