package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.*;
import com.example.pdamanager.Repositories.UserRepositoryImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExerciceServiceImplTest {

    @Mock
    InterfaceDao ExerciceDaoImpl;
    @InjectMocks
    ExerciceServiceImpl exerciceService =  new ExerciceServiceImpl();;



    @Test
    void add() {
        Exercice exercice = new Exercice();
        exercice.setNom("Exercice1");
        exercice.setAnnée(LocalDate.of(2022,11,20));
        exercice.setDate_fin(LocalDate.of(2022,11,30));
        exercice.setDate_debut(LocalDate.of(2022,11,25));
        exercice.setEtatExercice(EtatExercice.EnCours);
        exerciceService.Add(exercice);
        verify(ExerciceDaoImpl).add(exercice);
    }

    @Test
    void update() {
        Exercice exercice = exerciceService.findByID(3L);
        activité.setTitle("CCCCC");
        activeteService.update(activité);
        assertEquals("CCCCC",activité.getTitle());
    }

    @Test
    void getAll() {

        List<Activité> activites = new ArrayList<>();
        Activité activite = new Activité();
        activite.setTitle("ZZZ");

        Activité activite1 = new Activité();
        activite1.setTitle("ZZZ");

        activites.add(activite);
        activites.add(activite1);

        doReturn(activites).when(activeteDao).getAll();
        List<Activité> activites1 = activeteService.getAll();
        assertThat(activites1).isNotEmpty();
        verify(activeteDao,times(1)).getAll();
        // assertTrue(activites.size() > 0);
    }
*/

}