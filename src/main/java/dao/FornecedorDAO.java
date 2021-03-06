package dao;

import config.HibernateUtil;
import java.util.List;
import model.Fornecedor;
import org.hibernate.Session;

public class FornecedorDAO {

    private Session session;

    public FornecedorDAO() {

        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void insert(Fornecedor fornecedor) {
        session.getTransaction().begin();
        session.save(fornecedor);
        session.getTransaction().commit();
    }

    public void delete(Fornecedor fornecedor) {
        session.getTransaction().begin();
        session.remove(fornecedor);
        session.getTransaction().commit();
    }

    public List<Fornecedor> findAll() {
        return session.createQuery("select f from Fornecedor f").list();
    }
    public Fornecedor find (int id){
        return session.get(Fornecedor.class, id);
    }
}
