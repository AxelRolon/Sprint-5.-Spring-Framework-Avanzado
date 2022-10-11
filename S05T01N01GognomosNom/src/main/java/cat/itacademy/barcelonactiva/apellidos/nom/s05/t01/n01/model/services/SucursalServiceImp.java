package cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.repository.SucursalRepository;
@Service

public class SucursalServiceImp implements ISucursalService{

	@Autowired
	private SucursalRepository repositorio;
	
	
	@Override
	public Sucursal add(Sucursal sucursal) {
		
		return repositorio.save(sucursal);
		
	}

	@Override
	public List<Sucursal> getALL() {
		return repositorio.findAll();
	}

	@Override
	public Sucursal getByID(long pk_SucursalID) {
		return repositorio.findById(pk_SucursalID).get();
		
	}

	@Override
	public Sucursal update(long pk_SucursalID, Sucursal sucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long pk_SucursalID) {
		repositorio.deleteById(pk_SucursalID);
	}

}
