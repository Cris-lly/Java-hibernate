import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.*;
import java.util.List;

public class ProductModel {
    private static final EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    public List<Product> findAll() {
        List<Product> products = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
            products = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            products = null;
            System.out.println("Erro");
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return products;
    }
}