package escuelaing.arsw.tableromultiusuario.service;

import org.springframework.stereotype.Component;


@Component
public interface PointsCache  {

	void calculate(String valor);
	

}
