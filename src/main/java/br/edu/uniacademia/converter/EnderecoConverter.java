
package br.edu.uniacademia.converter;

import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = Enderecos.class, value = "enderecoConverter")
public class EnderecoConverter implements Converter, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
        if (id != null && !id.isEmpty()) {
            return EnderecoDAO.getInstance().buscar(Long.valueOf(id));
        }
        return id;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
        if (objeto != null) {
            Enderecos endereco = (Enderecos) objeto;
            return endereco.getIdEndereco() != null && endereco.getIdEndereco() > 0 ? endereco.getIdEndereco().toString() : null;
        }
        return null;
    }
}