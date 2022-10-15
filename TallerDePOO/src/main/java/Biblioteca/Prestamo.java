package Biblioteca;
//import java.util.Date;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
public class Prestamo {
	private LocalDateTime fechaHoraPrestada;
	private String funcionarioPrestador;
	private LocalDateTime fechaHoraADevolver;
	private LocalDateTime fechaDevuelta;
	private String funcionarioDevuelta;
	private Lector lector;
	private Boolean aDomicilio;
	//Asociacion Multa y Prestamo
	private ArrayList<Multa> multas;
	private ArrayList<Funcionario> funcionarios;
	private Ejemplar ejemplar;
	
	public Prestamo(String funcionarioPrestador, LocalDateTime fechaHoraADevolver, LocalDateTime fechaDevuelta,
			String funcionarioDevuelta, Lector lector, Boolean aDomicilio, ArrayList<Multa> multas, ArrayList<Funcionario> funcionarios, Ejemplar ejemplar) {
		this.fechaHoraPrestada = LocalDateTime.now();
		this.funcionarioPrestador = funcionarioPrestador;
		this.fechaHoraADevolver = fechaHoraADevolver;
		this.fechaDevuelta = fechaDevuelta;
		this.funcionarioDevuelta = funcionarioDevuelta;
		this.lector = lector;
		this.aDomicilio = aDomicilio;
		this.multas = multas;
		this.funcionarios = funcionarios;
		this.ejemplar = ejemplar;
	}

	public Prestamo(){
		this.fechaHoraPrestada = LocalDateTime.now();
		this.funcionarioPrestador = "";
		this.fechaHoraADevolver = this.fechaHoraPrestada.plusDays(4);
		this.fechaDevuelta = LocalDateTime.of(2000, 1, 1, 1, 1, 1);
		this.funcionarioDevuelta = "";
		this.multas = new ArrayList<Multa>();
		this.funcionarios = new ArrayList<Funcionario>();
		this.lector = new Lector();
		this.ejemplar = new Ejemplar();

	}


	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<Multa> getMultas() {
		return multas;
	}

	public void setMultas(ArrayList<Multa> multas) {
		this.multas = multas;
	}

	public LocalDateTime getFechaHoraPrestada() {
		return fechaHoraPrestada;
	}

	public String getFuncionarioPrestador() {
		return funcionarioPrestador;
	}

	public void setFuncionarioPrestador(String funcionarioPrestador) {
		this.funcionarioPrestador = funcionarioPrestador;
	}

	public LocalDateTime getFechaHoraADevolver() {
		return fechaHoraADevolver;
	}

	public void setFechaHoraADevolver() {
		this.fechaHoraADevolver = this.fechaHoraPrestada.plusDays(4);
	}

	public LocalDateTime getFechaDevuelta() {
		return fechaDevuelta;
	}

	public void setFechaDevuelta(LocalDateTime fechaDevuelta) {
		this.fechaDevuelta = fechaDevuelta;
	}

	public String getFuncionarioDevuelta() {
		return funcionarioDevuelta;
	}

	public void setFuncionarioDevuelta(String funcionarioDevuelta) {
		this.funcionarioDevuelta = funcionarioDevuelta;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Boolean getaDomicilio() {
		return aDomicilio;
	}

	public void setaDomicilio(Boolean aDomicilio) {
		this.aDomicilio = aDomicilio;
	}
	
	
	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	public boolean compararFecha() {
		Long x = ChronoUnit.DAYS.between(getFechaHoraADevolver(), getFechaDevuelta());
		if (x>=0) {
			return true;
		}else {
			return false;
		}
	}
}
