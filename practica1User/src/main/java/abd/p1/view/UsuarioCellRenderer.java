/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import abd.p1.model.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author slide22
 */
public class UsuarioCellRenderer extends UsuarioListItem implements ListCellRenderer<Usuario> {

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Usuario> jlist,
            Usuario value, int index,
            boolean isSelected, boolean cellHashFocus) {

        if (value.getAvatar() != null) {
            this.setAvatar(value.getAvatar());
        }
        
        this.setNombre(value.getNombre());

        Calendar cal = new GregorianCalendar();
        cal.setTime(value.getFechaDeNacimiento());
        this.setEdad(calcularEdad(cal));

        this.setOpaque(true);
        if (isSelected) {
            this.setBackground(Color.LIGHT_GRAY);
        } else {
            this.setBackground(Color.WHITE);
        }

        return this;
    }

    private int calcularEdad(Calendar fechaNac) {

        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1; // no aparecían los dos guiones del
        }

        return diffYear;

    }
}
