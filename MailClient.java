
public class MailClient
{
    private MailServer server;
    //Es el servidor asociado con ese cliente
    private String user;
    //Representa la dirección de correo del usuario que usa ese cliente
    /**
     * Constructor para la calse MailClient
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }

    /**
     * Metodo para recuperar del servidor un correo 
     * que tenga el usuario y devuelva dicho objeto 
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    /**
     * Metodo para recuperar del servidor un correo
     * que tenga el usuario e imprima por pantalla 
     * los datos de dicho mensaje
     */
    public void printNextMailItem()
    {
          MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            item.print();
        }
    }
    
    /**
     * Metodo para crear un email y enviarlo al servidor asociado a ese cliente
     */
    public void sendMailItem(String to, String message)
    {
        MailItem item = new MailItem(user, to, message);
        server.post(item);
    }
}
