package cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.domain.Sucursal;
//import cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.dto.SucursalDTO;

public interface ISucursalService {

	public Sucursal add(Sucursal sucursal);
	
	public List<Sucursal> getALL();
	
	public Sucursal getByID(long pk_SucursalID);
	
	public Sucursal update(long pk_SucursalID, Sucursal sucursal);
	
	public void delete(long pk_SucursalID);
	
	
}
