
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entiteis.Reserva;
import model.exceptions.DomainException;


public class Program {

    public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
        
        Scanner leia = new Scanner(System.in);
        
        try{
            System.out.print("Numero do quarto: ");
            int numero = leia.nextInt();
            System.out.print("CheckIn date (dd/MM/yyyy)");
            Date checkIn = sdf.parse(leia.next());
            System.out.print("ChecOut date (dd/MM/yyyy)");
            Date checkOut = sdf.parse(leia.next());

            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: "+reserva);
            
            System.out.println("Digite os dados para atualizar a reserva: ");
            System.out.print("CheckIn date (dd/MM/yyyy)");
            checkIn = sdf.parse(leia.next());
            System.out.print("ChecOut date (dd/MM/yyyy)");
            checkOut = sdf.parse(leia.next());

            

            reserva.AtualizarData(checkIn, checkOut);
            System.out.println("Reserva: "+reserva);
        }
        catch (ParseException e){      
            System.out.println("Formato de data invalido ");    
        }
        
        catch (DomainException e){
            
            System.out.print("Erro na reserva: "+e.getMessage());
            
        }
     
        
        
    }
}

