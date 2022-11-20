package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.ActiveteDaoImpl;
import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Dao.UseDaoImpl;
import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Etat;
import com.example.pdamanager.Entities.Responsable;
import com.example.pdamanager.Entities.TypeActivité;
import com.example.pdamanager.Repositories.UserRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ActiveteServiceImplTest {
    @Mock
  InterfaceDao activeteDao;
    @InjectMocks
  ActiveteServiceImpl activeteService =  new ActiveteServiceImpl();;

 UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Test
    void add() {
  Activité activite = new Activité();
  activite.setTitle("AAAAA");
  activite.setEtatActivité(Etat.Active);
  Responsable responsable = (Responsable) userRepository.findByEmail("afraklaabdelaziz@gmail.com");
  activite.setResponsable(responsable);
  activite.setDate_fin_participation(LocalDate.now());
  activite.setTypeActivité(TypeActivité.Formation);
  activite.setDate_debut(LocalDate.of(2022,12,13));
  activite.setDate_fin(LocalDate.of(2022,12,25));
  activite.setDate_de_participation(LocalDate.of(2022,11,25));
  activite.setDescription("DDDDDDD");
   activeteService.Add(activite);
   verify(activeteDao).add(activite);

    }

    @Test
    @Disabled
    void update() {
        Activité activité = activeteService.findByID(3L);
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

}