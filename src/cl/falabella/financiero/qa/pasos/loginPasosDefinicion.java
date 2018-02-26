package cl.falabella.financiero.qa.pasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginPasosDefinicion {	
	WebDriver controlador;

	@Given("^Abrir el navegador e ir al sitio web linkedin$")
	public void abrir_el_navegador_e_ir_al_sitio_web_linkedin() throws Exception { 
	   controlador = new ChromeDriver();
		//controlador = new InternetExplorerDriver();
		controlador.manage().window().maximize();
		controlador.get("https://www.linkedin.com");
	}

	@When("^ingresar el username \"([^\"]*)\" el password \"([^\"]*)\"$")
	public void ingresar_el_username_el_password(String loginEmail, String loginPassword) throws Exception {
	    controlador.findElement(By.id("login-email")).sendKeys(loginEmail);
	    controlador.findElement(By.id("login-password")).sendKeys(loginPassword);
	    
	}
	
    @When("^presionar click en el boton entrar para ver perfil$")
    public void presionar_click_en_el_boton_entrar_para_ver_perfil() throws Exception {
	    controlador.findElement(By.id("login-submit")).click();
		Thread.sleep(4000);
	}


    @When("^presionar click en boton MiRed$")
    public void presionar_click_en_boton_MiRed() throws Exception {
		//INGRESAR A LA OPCION MI RED
		controlador.findElement(By.id("mynetwork-tab-icon")).click();
    }
	    
    @When("^buscar primer contacto de la lista$")
    public void buscar_primer_contacto_de_la_lista() throws Exception {
		//OPCION VER TODOS LOS CONTACTOS DE MI RED
		Thread.sleep(2000);
		controlador.findElement(By.cssSelector("a.mn-connections-summary__see-all")).click();
		//SELECCIONA EL PRIMER PERFIL DE LA LISTA 
		Thread.sleep(4000);
		controlador.findElement(By.cssSelector("a.mn-person-info__link")).click();

		//CLICK PARA DESPLEGAR LA OPCION CERRAR SESION
		Thread.sleep(4000);
		controlador.findElement(By.id("nav-settings__dropdown-trigger")).click();
    }
	
	@Then("^presiona cerrar sesión$")
	public void presiona_cerrar_seción() throws Exception {
		//controlador.findElement(By.cssSelector("a[href='/m/logout/']"));
		//controlador.findElement(By.id("ember4330")).click();
		Thread.sleep(2000);
		controlador.findElement(By.linkText("Cerrar sesión")).click();
	}
}
