package escuelaing.arsw.tableromultiusuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import escuelaing.arsw.tableromultiusuario.service.IPointCache;


@RestController
public class PointController {
	
	@Autowired
	private IPointCache cache;

	@PostMapping("/poin")
	public String processPoints(@RequestBody String points){
			String valor = points;
			System.out.println("payloaded : "+points);
			cache.calculate(valor);
			return points;
	}
	
	@PostMapping("/dibujar")
	public String dibujar() {
		return cache.getValores();
	}

	@PostMapping("/borrar")
	public boolean borrar() {
		return true;
	}

}
