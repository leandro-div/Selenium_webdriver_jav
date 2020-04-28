package br.mg.lavieira.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.mg.lavieira.core.BaseTest;
import br.mg.lavieira.pages.MenuPage;
import br.mg.lavieira.pages.MovementPage;
import br.mg.lavieira.utils.DateUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestMovement extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovementPage movPage = new MovementPage();

	@Test
	public void test1InsertMovement() {
		menuPage.accesssCreatMovement();
		
		movPage.setDateMoviment(DateUtils.formatedDate(new Date()));
		movPage.setDatePayment(DateUtils.formatedDate(new Date()));
		movPage.setDescription("Nota de aula");
		movPage.setInterested("Qualquer");
		movPage.setValue("500");
		movPage.setAccout("Conta para movimentacoes");
		movPage.setStatusPaid();
		movPage.save();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.getMessegeSuccess());
		
	}
	
	@Test
	public void test2MandatoryFields () {
		menuPage.accesssCreatMovement();
		
		movPage.save();
		List<String> errors = movPage.getErrors();
//		Assert.assertEquals("Data da Movimentação é obrigatório", errors.get(0));
//		Assert.assertTrue(errors.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número")));
		Assert.assertEquals(6, errors.size());
		
	}
	
	@Test
	public void test3FutureDate() {
		menuPage.accesssCreatMovement();
		
		Date futureDate = DateUtils.getDateWithDifferenceDays(5);
		
		
		movPage.setDateMoviment(DateUtils.formatedDate(futureDate));
		movPage.setDatePayment(DateUtils.formatedDate(futureDate));
		movPage.setDescription("Nota de aula data futura");
		movPage.setInterested("Qualquer");
		movPage.setValue("500");
		movPage.setAccout("Conta para movimentacoes");
		movPage.setStatusPaid();
		movPage.save();
		List<String> errors = movPage.getErrors();
		Assert.assertTrue(errors.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, errors.size());
		
	}

}
