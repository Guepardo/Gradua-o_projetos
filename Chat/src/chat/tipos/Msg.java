/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */

package chat.tipos;

public class Msg 
{
	private int idEmissor,contMsg,hora,minuto,segundo,dia,mes,ano,qtdCaracter;
	private String texto;
	
	public Msg(int idEmissor , int contMsg , int hora , int minuto , int segundo , int dia , int mes , int ano , int qtdCaracter, String texto )
	{
		this.idEmissor   = idEmissor;
		this.contMsg     = contMsg;
		this.hora        = hora;
		this.minuto      = minuto;
		this.segundo     = segundo;
		this.dia         = dia;
		this.mes         = mes;
		this.ano         = ano;
		this.qtdCaracter = qtdCaracter;
		this.texto       = texto;
	}

	public int getIdEmissor() {
		return idEmissor;
	}

	public int getContMsg() {
		return contMsg;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public int getQtdCaracter() {
		return qtdCaracter;
	}

	public String getTexto() {
		return texto;
	}
}
