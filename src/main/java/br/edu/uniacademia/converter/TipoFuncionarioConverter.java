
package br.edu.uniacademia.converter;

import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import br.edu.uniacademia.hospital.model.TipoFuncionario;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = TipoFuncionario.class, value = "tipoFuncionarioConverter")
public class TipoFuncionarioConverter implements Converter, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
        if (id != null && !id.isEmpty()) {
            return TipoFuncionarioDAO.getInstance().buscarPorId(Long.valueOf(id));
        }
        return id;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
        if (objeto != null) {
            TipoFuncionario tipoFuncionario = (TipoFuncionario) objeto;
            return tipoFuncionario.getIdtipoFuncionario() != null && tipoFuncionario.getIdtipoFuncionario() > 0 ? tipoFuncionario.getIdtipoFuncionario().toString() : null;
        }
        return null;
    }
}