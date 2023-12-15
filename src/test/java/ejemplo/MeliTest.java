package ejemplo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.charset.StandardCharsets;

public class MeliTest {

    private WebDriver driver;

    @BeforeEach
    public void preCondiciones(){


        String rutaDriver = "C:\\Users\\arramos\\Desktop\\Tsoft\\javaSelenium\\Automatiza\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",rutaDriver);
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().window().maximize();


    }

    @AfterEach
    public void postCondiciones(){


        driver.quit();


    }

    @Test
    public void CPErrorEnBusqueda(){
        By locatorCajaBusqueda = By.id("cb1-edit");
        WebElement cajaBusqueda = driver.findElement(locatorCajaBusqueda);
        cajaBusqueda.sendKeys("ASD123ASD");
        By locatorBtnBuscar = By.className("nav-icon-search");
        driver.findElement(locatorBtnBuscar).click();
        By locatorTxtResultado = By.className("ui-search-rescue__title");
        WebElement txtResultado = driver.findElement(locatorTxtResultado);
        String resultado = txtResultado.getText();
        String resultadoEsperadoCod = "No hay publicaciones que coincidan con tu búsqueda";
        // Convertir el texto codificado incorrectamente a UTF-8
        byte[] bytes = resultadoEsperadoCod.getBytes(StandardCharsets.ISO_8859_1);
        String textoDecodificado = new String(bytes, StandardCharsets.UTF_8);

        Assertions.assertEquals(resultado,textoDecodificado);

        if (resultado.equals(textoDecodificado)) {
            System.out.println("Comprobacion Exitosa");
        } else {
            System.out.println("Error en Comprobacion");
        }
    }

    @Test
    public void CPLampara() {
        By locatorCajaBusqueda = By.id("cb1-edit");
        WebElement cajaBusqueda = driver.findElement(locatorCajaBusqueda);
        cajaBusqueda.sendKeys("Lampara led");
        By locatorBtnBuscar = By.className("nav-icon-search");
        driver.findElement(locatorBtnBuscar).click();
        By locatorBtnManiana = By.xpath("//*[@id=\"root-app\"]/div/div[2]/aside/section/div[1]/ul/li/form/button");
        driver.findElement(locatorBtnManiana).click();
        By locatorDropOrdenar = By.id("react-aria-:Rlh9b9:-display-values");
        driver.findElement(locatorDropOrdenar).click();
        By locatorMenorPrecio = By.xpath("//*[@id=\"react-aria-:Rlh9b9:-menu-list-option-price_asc\"]/div/div/span");
        driver.findElement(locatorMenorPrecio).click();
        By locatorLampara = By.xpath("//*[@id=\"react-aria-:Rgl9b9:\"]/div[2]/div/div[1]/a");
        driver.findElement(locatorLampara).click();
        By locatorTxtUnidades = By.xpath("//*[@id=\"available_quantity\"]/div/p");
        WebElement txtUnidades = driver.findElement(locatorTxtUnidades);
        String unidades = txtUnidades.getText();
        System.out.println("Cuantas unidades quedan disponibles? " + unidades);
    }

    @Test
    public void CPJardineria() throws InterruptedException {
        By locatorCajaBusqueda = By.id("cb1-edit");
        driver.findElement(locatorCajaBusqueda).sendKeys("Servicio de jardineria");
        By locatorBtnBuscar = By.className("nav-icon-search");
        driver.findElement(locatorBtnBuscar).click();
        By locatorBtnCapFed = By.xpath("//*[@id=\"root-app\"]/div/div[2]/aside/section/div[1]/ul/li[1]/a/span[1]");
        driver.findElement(locatorBtnCapFed).click();
        By locatorCantidadResultados = By.xpath("//*[@id=\"root-app\"]/div/div[2]/aside/div[2]/span");
        String txtResultados = driver.findElement(locatorCantidadResultados).getText();
        String txtEsperado = "23 resultados";
        Assertions.assertEquals(txtResultados,txtEsperado);
    }

}

