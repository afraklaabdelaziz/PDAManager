
import com.example.pdamanager.Entities.Responsable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory test = Persistence.createEntityManagerFactory("PDAManager");
        EntityManager entityManager = test.createEntityManager();

//        Responsable responsable = new Responsable();
//        responsable.setNom("afrakla");
//        responsable.setPrenom("ahhhhhhhhhhhz");
//        responsable.setEmail("afraklaabdelaziz@gmail.com");
//        responsable.setPassword("afraklaab99");
//        responsable.setPhone("1234657778");
//        responsable.setDomaine("kjgsjdgsd");
//         entityManager.getTransaction().begin();
//         try {
//             entityManager.persist(responsable);
//             entityManager.getTransaction().commit();
//         }catch (Exception e){
//             entityManager.getTransaction().rollback();
//         }
        entityManager.getTransaction().begin();
        entityManager.createQuery("select r from Responsable r where r.email = 'afraklaabdelaziz@gmail.com'",Responsable.class).getResultList().stream().map(u->u.getNom()).forEach(System.out::println);
         entityManager.getTransaction().commit();
    }
}