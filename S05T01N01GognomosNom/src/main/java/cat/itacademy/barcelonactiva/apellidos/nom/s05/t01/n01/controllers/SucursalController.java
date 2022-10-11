package cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.services.ISucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
	
	@Autowired
	private ISucursalService service;
	
	@Autowired
	private ModelMapper modelMapper; /*ModelMapper es una librería Java para copiar o mapear propiedades de un 
	tipo de objeto a otro tipo de objeto, permitiendo copiar también los datos 
	de las referencias a los objetos que contengan.*/

	@GetMapping("/getALL")
	public ResponseEntity<?> getOne(){
		
		Map<String, Object> response = new LinkedHashMap<String,Object>();
		
		List<Sucursal> listado = service.getALL();
		
		List<SucursalDTO> listadoDTO = new ArrayList<SucursalDTO>();
		
		if(!listado.isEmpty()) {
			
			for (Sucursal sucursal : listado) {//conversion
				
				listadoDTO.add(modelMapper.map(sucursal, SucursalDTO.class));
			}
			response.put("status", 1);
			response.put("data", listadoDTO);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {
			
			response.clear();//borrado de mapeo
			response.put("status", 0);
			response.put("mensaje", "DATO NO ENCONTRADO, BASE DE DATOS VACIO");
			
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody SucursalDTO sucursalDTO){
		Map<String, Object> response = new LinkedHashMap<String,Object>();
		
		//conversion DTO A una entidad
		Sucursal sucursal= modelMapper.map(sucursalDTO, Sucursal.class);
		
		service.add(sucursal);
		
		response.put("status", 1);
		response.put("mensaje", "Se ha guardado los datos correctamente");
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	
	}
	
	@GetMapping("getOne/{id}")
	public ResponseEntity<?> getById(@PathVariable Long pk_SucursalID){
		
		Map<String, Object> response = new LinkedHashMap<String,Object>();
		
		try {
			Sucursal sucursal = service.getByID(pk_SucursalID);
			
			//convertir entity a dto 
			
			SucursalDTO sucursalDTO = modelMapper.map(sucursal, SucursalDTO.class);
			
			response.put("status", 1);
			response.put("Mensaje", sucursalDTO);
			
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			response.clear();
			response.put("status", 0);
			response.put("Mensaje", "Id no encontrado, o nullo");
			
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody SucursalDTO sucursalDTO){
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		
		Sucursal sucursal= modelMapper.map(sucursalDTO, Sucursal.class);
		
		try {
			
			service.add(sucursal);
			 response.put("Mensaje", "Se actualizo correctamente".concat(sucursal.getNomSucursal()));
			return new ResponseEntity<> (response, HttpStatus.OK);
			
		} catch (Exception e) {
			
			response.clear();
			response.put("status", 0);
			response.put("Mensaje", "No se pudo actualizar correctamente");
			
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteByID(@PathVariable long id){
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		
		try {
			Sucursal sucursal = service.getByID(id);
			service.delete(id);
			
			response.put("status", 1);
			response.put("mensaje", "Se ha borrado correctamente la sucursal : ");
			
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			 response.clear();

		     response.put("status", 0);

		     response.put("Mensaje", "No encontrado, no borrado");

		      return new ResponseEntity < > (response, HttpStatus.NOT_FOUND);
			
		}
	}
	
}










