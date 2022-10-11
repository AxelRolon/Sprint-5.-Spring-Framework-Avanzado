package cat.itacademy.barcelonactiva.apellidos.nom.s05.t01.n01.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import lombok.Data;
@Data
public class SucursalDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;
    private ArrayList<String> paises = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria",
            "Croatia", "Cyprus", "Czechia", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece",
            "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands",
            "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));

    public SucursalDTO() {
    }

    public SucursalDTO(Integer pk_SucursalID, String nomSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        if (paises.contains(paisSucursal)){
            this.tipusSucursal = "ES DE LA UE";
        }else{
            this.tipusSucursal = "FUERA UE";
        }
    }

    public long getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(long pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public String setIsCountryUE(String tipusSucursal) {
		for (String country : paises) {
			if(country.equalsIgnoreCase(tipusSucursal)){
				return "UE";
			}
		}
		return "Fuera de la UE";}

    @Override
    public String toString() {
        return "SucursalDTO{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                ", tipusSucursal='" + tipusSucursal + '\'' +
                '}';
    }

}