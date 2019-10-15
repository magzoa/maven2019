package py.edu.facitec.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//Funciona similar a una Servlet
@Controller
public class HomeController {
	
	//Similar al UrlPatern
//Que permite enlazar una url con una pagina o respuesta
	@RequestMapping("/") //req
	public String index() {
		
	System.out.println("Cargando página de bienvenida");	
		
	
			//carpeta  pagina
		return "view/templates/index"; //resp
	}
	
	@RequestMapping("/menu") //req
	public String menu() {
		
	System.out.println("Cargando el menu");	
		
	
			    //carpeta  pagina
		return "view/templates/menu"; //resp
	}
	

}
