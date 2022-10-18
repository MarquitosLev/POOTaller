package Biblioteca;
import java.io.File;
import java.time.LocalDate;
import net.sourceforge.barbecue.*;
import net.sourceforge.barbecue.output.OutputException;


public class Ejemplar {
    private int idEjemplar;
    private String observaciones;
    private boolean disponible;
    private int cantPedidas;
    private LocalDate fechaAdquisicion;
    private FormaAdquirida formaAdquirida; 
    private LocalDate fechaDeBaja;
    private String motivoDeBaja;
    private String codUbicacion;
    private Obra obra;
    private Lector lector;
    
    //Constructor para registrar nuevo ejemplar
    public Ejemplar(int idEjemplar, String observaciones, boolean disponible, FormaAdquirida formaAdquirida, String codUbicacion, Obra obra) throws BarcodeException, OutputException {
		
    	//pasados por parametro
    	this.idEjemplar = idEjemplar;
		this.observaciones = observaciones;
		this.disponible = disponible;
		this.formaAdquirida = formaAdquirida;
		this.codUbicacion = codUbicacion;
		this.obra = obra;
		
		this.fechaDeBaja = LocalDate.of(1800, 01, 01);
		this.cantPedidas = 0;
		
		//Codigo de barra
		this.setCodBarr();
		
	}
    
    public Ejemplar(int idEjemplar, String observaciones, boolean disponible, int cantPedidas, LocalDate fechaAdquisicion,
			FormaAdquirida formaAdquirida, LocalDate fechaDeBaja, String motivoDeBaja, String codUbicacion, Obra obra, Lector lector) throws BarcodeException, OutputException {
		this.idEjemplar = idEjemplar;
		this.observaciones = observaciones;
		this.disponible = disponible;
		this.cantPedidas = cantPedidas;
		this.fechaAdquisicion = fechaAdquisicion;
		this.formaAdquirida = formaAdquirida;
		this.fechaDeBaja = fechaDeBaja;
		this.motivoDeBaja = motivoDeBaja;
		this.codUbicacion = codUbicacion;
		this.obra = obra;
		this.lector = lector;
		
		
		
		this.setCodBarr();
		
	}

	public Ejemplar() {
		this.idEjemplar = 0;
		this.observaciones = "";
		this.disponible = true;
		this.cantPedidas = 0;
		this.fechaAdquisicion = LocalDate.of(0000, 0, 0);
		//this.formaAdquirida = formaAdquirida.Otro; A esta todavía no la se hacer xd. Creo que hay que modificar algo en la enum. 
		this.fechaDeBaja = LocalDate.of(0000, 0, 0);
		this.motivoDeBaja = " ";
		this.codUbicacion = " ";
		this.obra = new Obra();
	}

	public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }
    
   private void setCodBarr() throws BarcodeException, OutputException{
    	String aux = Integer.toString(this.idEjemplar);
    	Barcode CodBarr = BarcodeFactory.createCode128(aux);
    	File file = new File("src/main/java/codigosBarra" + aux + ".png");
    	BarcodeImageHandler.savePNG(CodBarr, file);
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCantPedidas() {
        return cantPedidas;
    }

    public void setCantPedidas(int cantPedidas) {
        this.cantPedidas = cantPedidas;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public FormaAdquirida getFormaAdquirida() {
		return formaAdquirida;
	}

	public void setFormaAdquirida(FormaAdquirida formaAdquirida) {
		this.formaAdquirida = formaAdquirida;
	}

	public LocalDate getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(LocalDate fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String getMotivoDeBaja() {
        return motivoDeBaja;
    }

    public void setMotivoDeBaja(String motivoDeBaja) {
        this.motivoDeBaja = motivoDeBaja;
    }

    public String getCodUbicacion() {
        return codUbicacion;
    }

    public void setCodUbicacion(String codUbicacion) {
        this.codUbicacion = codUbicacion;
    }
    
    public Obra getObra() {
    	return this.obra;
    }
    
    public void setObra(Obra obra){
    	this.obra = obra;
    }

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}
    
}
