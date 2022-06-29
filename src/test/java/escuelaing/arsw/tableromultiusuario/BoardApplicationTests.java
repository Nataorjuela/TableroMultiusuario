package escuelaing.arsw.tableromultiusuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import escuelaing.arsw.tableromultiusuario.service.IPointCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {
	@Autowired
	IPointCache service;

	@Test
	/**
	 * Verifica que el Json numero 1 que le ingresa se guarde en cache
	 */
	void deberiaRetornarElJsonConElCache() {
		service.calculate("{\"pointsarr\":[[521,219],[521,219],[519,220],[519,239],[519,254],[523,287],[528,319],[530,347],[530,360]]}");
		String a = service.getValores();
		assertEquals(a,"{\"pointsarr\":[[521,219],[521,219],[519,220],[519,239],[519,254],[523,287],[528,319],[530,347],[530,360]]}");
	}
	
	@Test
	/**
	 * Verifica que el Json numero 2 que le ingresa se guarde en cache
	 */
	void deberiaRetornarElJsonConElCacheNumero2() {
		service.calculate("{\"pointsarr\":[[519,254],[523,287],[528,319],[530,347],[530,360]]}");
		String a = service.getValores();
		assertEquals(a,"{\"pointsarr\":[[519,254],[523,287],[528,319],[530,347],[530,360]]}");
	}
	
	@Test
	/**
	 * Verifica que el Json numero 3 que le ingresa se guarde en cache
	 */
	void deberiaRetornarElJsonConElCacheNumero3() {
		service.calculate("{\"pointsarr\":[[519,254],[523,287],[528,319]]}");
		String a = service.getValores();
		assertEquals(a,"{\"pointsarr\":[[519,254],[523,287],[528,319]]}");
	}
	
	@Test
	/**
	 * Verifica que el Json numero 4 que le ingresa se guarde en cache
	 */
	void deberiaRetornarElJsonConElCacheNumero4() {
		service.calculate("{\"pointsarr\":[[519,254],[523,287]]}");
		String a = service.getValores();
		assertEquals(a,"{\"pointsarr\":[[519,254],[523,287]]}");
	}
	
	@Test
	/**
	 * Verifica que un Json vacio se guarde en  cache
	 */
	void deberiaRetornarElJsonVacio() {
		service.calculate("{\"pointsarr\":[]}");
		String a = service.getValores();
		assertEquals(a,"{\"pointsarr\":[]}");
	}

}
