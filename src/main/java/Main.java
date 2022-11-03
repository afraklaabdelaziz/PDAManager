
import com.example.pdamanager.Dao.UseDaoImpl;
import com.example.pdamanager.Entities.Responsable;
import com.example.pdamanager.Entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory test = Persistence.createEntityManagerFactory("PDAManager");
        EntityManager entityManager = test.createEntityManager();

       /* UseDaoImpl user=new UseDaoImpl();
        user.getAll();*/

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
//            entityManagerityManager.getTransaction().begin();
//            entityManager.createQuery("select r from Responsable r where r.email = 'afraklaabdelaziz@gmail.com'",Responsable.class).getResultList().stream().map(u->u.getNom()).forEach(System.out::println);
//            entityManager.getTransaction().commit();
      /*  String dateFromPar="2022-11-02T16:40";
        System.out.println("date from parametre "+dateFromPar);
        LocalDate dateDInsc = LocalDate.parse(dateFromPar);*/

        Role role=new Role();
        role.setNom("Admin");
        Role role1=new Role();
        role1.setNom("Responsable");
        Role role2=new Role();
        role2.setNom("partiipant");
        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.persist(role1);
        entityManager.persist(role2);
        entityManager.getTransaction().commit();

    }
}