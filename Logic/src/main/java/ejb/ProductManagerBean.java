package ejb;

import domain.Product;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ProductManagerBean {
    @PersistenceContext(unitName = "example")
    private EntityManager entityManager;

    public Product createProduct(String name, int price, int quantity){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setPrice(quantity);
        entityManager.persist(product);
        return product;
    }
    public List<Product> getProducts(){
        TypedQuery<Product> query = entityManager.createQuery("Select с from Product с", Product.class);
        return query.getResultList();
    }
}
