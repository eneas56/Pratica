package Beans;

import dao.MarcaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Marca;

@Named(value = "marcaBean")
@SessionScoped
public class MarcaBean implements Serializable {

    public MarcaBean() {
    }

                public void mensagens(String mensagem, int tipo) {
        if (tipo == 0) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", mensagem);
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", mensagem);
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, msg);
        }
    }
    
    public void insertAction() {
        marcaDAO.insert(marca);
        mensagens("Cadastrado com sucesso", 1);
        this.marca = new Marca();
        this.marcas = marcaDAO.findAll();
    }

    public void atualizarAction() {
        this.marcas = marcaDAO.findAll();
    }

    public void removeAction(Marca mc) {
        marcaDAO.delete(mc);
        this.marcas = marcaDAO.findAll();
    }

    private MarcaDAO marcaDAO = new MarcaDAO();
    private Marca marca = new Marca();
    private List<Marca> marcas = new ArrayList<>();

    public List<Marca> getMarcas() {
        if (this.marcas == null) {
            this.marcas = marcaDAO.findAll();
        }
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

}
