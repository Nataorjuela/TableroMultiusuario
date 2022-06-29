package escuelaing.arsw.tableromultiusuario.service;

import org.springframework.stereotype.Service;

@Service
public class IPointCache implements PointsCache{
	
	public String valor= "";

	@Override
	public void calculate(String valor) {
		this.valor = valor;
	}

	public String getValores() {
		return valor;
	}

	public void setValores(String valor) {
		this.valor = valor;
	}

}
