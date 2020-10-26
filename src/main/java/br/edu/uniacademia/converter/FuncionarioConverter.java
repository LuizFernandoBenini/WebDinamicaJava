
package br.edu.uniacademia.converter;

import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = Funcionarios.class, value = "funcionarioConverter")
public class FuncionarioConverter implements Converter, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
        if (id != null && !id.isEmpty()) {
            return FuncionarioDAO.getInstance().buscarPorId(Long.valueOf(id));
        }
        return id;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
        if (objeto != null) {
            Funcionarios funcionario = (Funcionarios) objeto;
            return funcionario.getIdFuncionario() != null && funcionario.getIdFuncionario() > 0 ? funcionario.getIdFuncionario().toString() : null;
        }
        return null;
    }
}