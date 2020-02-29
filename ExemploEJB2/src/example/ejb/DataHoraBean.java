package example.ejb;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class DataHoraBean implements DataHora{
	
	public DataHoraBean() {
		System.out.println("Construiu o EJB");
	}

	@Override
	public String getServerTime() {
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	@PostConstruct
	public void inicio() {
		System.out.println("Executou o método início");
	}
	
	@PreDestroy
	public void fim() {
		System.out.println("Executou o método fim");
	}

}
