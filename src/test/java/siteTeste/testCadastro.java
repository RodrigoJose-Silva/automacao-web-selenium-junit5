package siteTeste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testCadastro {

    @Test
    public void cadsatroDeNovoUsuarioComSucesso () {

        String mensagemEsperada;

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver98\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String link = "https://inm-test-app.herokuapp.com/accounts/login/";
        driver.get(link);
        driver.manage().window().maximize();
//
//        //link novo cadastro
//        driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[7]/a")).click();

//        //formulário do novo cadastro
//        driver.findElement(By.name("username")).sendKeys("Marcelo-QA");
//        driver.findElement(By.name("pass")).sendKeys("test@123");
//        driver.findElement(By.name("confirmpass")).sendKeys("test@123");
//
//        driver.findElement(By.xpath("/html/body/div/div/div/form/div[7]/button")).click();

        //fazendo login com sucesso
        driver.findElement(By.name("username")).sendKeys("Marcelo-QA");
        driver.findElement(By.name("pass")).sendKeys("test@123");

        driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[6]/button")).click();

        //link cadastrar funcionário
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).click();

        //formulário de cadastro de novo funcionário
        driver.findElement(By.id("inputNome")).sendKeys("Mariana");
        driver.findElement(By.id("cpf")).sendKeys("602.458.460-18");

        //informando o sexo
        WebElement selectSexo = driver.findElement(By.id("slctSexo"));
        Select selectObject = new Select(selectSexo);
        selectObject.selectByVisibleText("Feminino");

        driver.findElement(By.id("inputAdmissao")).sendKeys("02/01/2022");
        driver.findElement(By.id("inputCargo")).sendKeys("QA");
        driver.findElement((By.id("dinheiro"))).sendKeys("569100");
        driver.findElement(By.id("pj")).click();

        driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/input")).click();

//        String alertCadastro = driver.findElement((By.cssSelector("body > div > div.container-message > div"))).getText();
//        Assertions.assertEquals("SUCESSO! Usuário cadastrado com sucesso\n" +
//                "×", alertCadastro);

        //alterando funcionário
        driver.findElement(By.xpath("//*[@id=\"tabela_filter\"]/label/input")).sendKeys("Mariana");
        driver.findElement(By.xpath("//*[@id=\"tabela\"]/tbody/tr/td[6]/a[2]/button/span")).click();
        driver.findElement(By.id("inputNome")).clear();
        driver.findElement(By.id("inputNome")).sendKeys("Joana");
        driver.findElement(By.id("inputCargo")).clear();
        driver.findElement(By.id("inputCargo")).sendKeys("QA Pleno");

        driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/input")).click();

//        String alertAlterado = driver.findElement((By.cssSelector("body > div > div.container-message > div"))).getText();
//        mensagemEsperada = "SUCESSO! Informações atualizadas com sucesso";
//        Assertions.assertEquals(mensagemEsperada, alertAlterado);


        driver.findElement(By.xpath("//*[@id=\"tabela_filter\"]/label/input")).sendKeys("Joana");
        driver.findElement(By.xpath("//*[@id=\"delete-btn\"]/span")).click();

//        String alertExcluido = driver.findElement((By.cssSelector("body > div > div.container-message > div"))).getText();
//        Assertions.assertEquals("SUCESSO! Funcionário removido com sucesso\n" +
//                "×", alertExcluido);

        driver.quit();
    }
}
