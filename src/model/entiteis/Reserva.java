
package model.entiteis;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
    
    private int numeroQuarto;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");

    public Reserva(int numeroQuarto, Date checkIn, Date checkOut) {
        
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duracao(){ /*Long é um inteiro mais longo*/
        
        long diff = checkOut.getTime() - checkIn.getTime(); /*Vai armazenar na variavel diff o valor da subtração em milsegundos entre as variaveis checkOut (data de saida) e checkIn (data de entrada) */
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); /*Convertendo em dias o valor em milesegundos armazenado na variavel diff */
              /*TimeUnit é um classe do tipo enumerado que contem varias operações. */
    }
    
    public void AtualizarData (Date checkIn, Date checkOut) throws DomainException{
        
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){ /*se a data armazenada na varaivel "checkIn" for anteior a data atual ou...*/
            throw new DomainException("As datas de reserva para atualização devem ser futuras");
            /*A classe de exceção "IllegalAccessException" usamos quando o dados passados como argumentos são invalidos.
            Dentro deste "if", se as datas informadas atendenrem a condicional, vai exibir a msg de erro*/
        }
        
        if(!checkOut.after(checkIn)){ /*"!" é uma negação. Se a data armazenada na variavel "checkOut" NÃO for depois da variavel checkIn*/
            throw new DomainException("Erro na reserva: a data do check-out deve ser após o check-in");         
        } 
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;    
    
    }
    
    @Override
    public String toString(){
    
        return "Quarto: "+numeroQuarto+", checkIn: "+getCheckIn()+", checkOut: "+getCheckOut()+", "+duracao();
    
    }
    
}
