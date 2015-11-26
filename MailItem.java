
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MailItem
{
    private String from;
    //Guarda el nombre de la persona que envía el mensaje
    private String to;
    //Guarda el nombre de la persona que lo recibe
    private String message;
    //Guarda el mensaje
    /**
     * Constructor para la clase MailItem
     * 
     */
    public MailItem(String from1, String to1, String message1)
    {
        from = from1;
        to = to1;
        message = message1;
    }

    /**
     * Metodo para saber el destinatario
     */
    public String getFrom()
    {
        return from;
    }
    
    /**
     * Metodo para saber el receptor
     */
    public String getTo()
    {
        return to;
    }
    
    /**
     * Metodo para saber el mensaje
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Metodo para imprimir destinatario, receptor y mensaje 
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("The message is " + message);
    }
}
