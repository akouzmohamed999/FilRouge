package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.EquipeDaoImpl;
import fr.norsys.technomaker.model.Competition;
import fr.norsys.technomaker.model.Poule;

public class EquipeFindEquipesByPouleTest {

	EquipeDao equipeDao;
	Competition competition;

	@Before
	public void setup() throws Exception {
		DataSetUnit data = new DataSetUnit();
		this.equipeDao = new EquipeDaoImpl(data.getConnection());
		LocalDate localDebut = LocalDate.of(2017, 05, 12);
		LocalDate localFin = LocalDate.of(2017, 06, 15);
		Date dateDebut = Date.valueOf(localDebut);
		Date dateFin = Date.valueOf(localFin);
		this.competition = new Competition(1, dateDebut, dateFin);
	}

	@Test
	public void shouldReturnListFrancePortugal() throws SQLException {
		Poule pouleA = new Poule(1, this.competition, 'A');
		assertThat(this.equipeDao.findEquipesParPoule(pouleA).size()).isEqualTo(4);
	}

}
