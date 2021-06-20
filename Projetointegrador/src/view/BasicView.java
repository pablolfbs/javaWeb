package view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import domain.Car;
import service.CarService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Car> cars;

	@ManagedProperty("#{carService}")
	private CarService service;

	public BasicView() {
		service = new CarService();
		cars = service.getListCars();
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setService(CarService service) {
		this.service = service;
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		service.UpdateCar((Car) event.getObject());

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}