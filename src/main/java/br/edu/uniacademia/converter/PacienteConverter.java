
package br.edu.uniacademia.converter;

import br.edu.uniacademia.hospital.dao.PacienteDAO;
import br.edu.uniacademia.hospital.model.Pacientes;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = Pacientes.class, value = "pacienteConverter")
public class PacienteConverter implements Converter, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
        if (id != null && !id.isEmpty()) {
            return PacienteDAO.getInstance().buscarPorId(Long.valueOf(id));
        }
        return id;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
        if (objeto != null) {
            Pacientes paciente = (Pacientes) objeto;
            return paciente.getIdPaciente() != null && paciente.getIdPaciente() > 0 ? paciente.getIdPaciente().toString() : null;
        }
        return null;
    }
}