
public class MailClient
{
    //El servidor al que esta conectado este cliente
    private MailServer server;
    //La direccion del usuario que esta usando este cliente
    private String user;
    
    private MailItem lastMail;
    private MailItem lastSpam;
    private float countSpam;
    private float porcentajeSpam;
    /**
     * Crea un objeto MailClient a partir de los valores dados
     */
    public MailClient(MailServer server, String user)
    {
        this.server = new MailServer();
        this.server = server;
        this.user = user;
        countSpam = 0;
    }

    /**
     * Recupera del servidor el siguiente email destinado
     * al usuario que esta usando el cliente. Si no hay 
     * ningun email pendiente de ser descargado devuelve null;
     * si lo hay, devuelve el email
     */
    public MailItem getNextMailItem()
    {
        MailItem email = getNextMailItem();
        if (email.getMessage().contains("regalo") || email.getMessage().contains("promocion"))
        {
            if(email.getMessage().contains("trabajo"))
            {
                 return server.getNextMailItem(user);
            }
            else 
            {
                countSpam = countSpam + 1;
                return null;
                
            }
        }
        else
        {
             return server.getNextMailItem(user);
        }
    }
    
    /**
     * Recupera del servidor el siguiente email destinado al
     * usuario que esta usando el cliente e imprime sus datos
     * por pantalla. Si no hay ningun email imprime por pantalla
     * un mensaje advirtiendo de ello
     */
    public void printNextMailItem()
    {
        MailItem email = getNextMailItem();
        if (email != null)
        {
           if (email.getMessage().contains("regalo") || email.getMessage().contains("promocion"))
           {
               if(email.getMessage().contains("trabajo"))
               {
                    //Imprimimos los detalles del email
                    email.print();
               }
               else 
               {
                   System.out.println("Usted ha reccibido spam");
               }
           }    
           //Imprimimos los detalles del email
           email.print();
        }
        else 
        {
            //Avisamos de que no hay emails en el servidor
            System.out.println("No hay correo nuevo");  
        }
    }

    /**
     * Permite redactar un email indicando el destinatario y el
     * cuerpo del mensaje y enviarlo al servidor
     */
    public void sendMailItem(String to, String message, String subject)
    {
        MailItem email = new MailItem(user, to, message, subject);
        server.post(email);
    }
    
    public void numberOfEmails()
    {
        System.out.println("You have " + server.howManyMailItems(user) + " emails");
    }
    
    /**
     * Metodo para enviar automaticamente un correo cuando te llega un email
     * a su destinatario
     */
    public void getNextMailItemAndSendAutomaticRespond()
    {
        MailItem email = getNextMailItem();
        if (email != null)
        {
            if (email.getMessage().contains("regalo") || email.getMessage().contains("promocion"))
           {
               if(email.getMessage().contains("trabajo"))
               {
                   String to = email.getFrom();
                   String email1 = "Ahora mismo no estoy en la oficina. /n" + email.getMessage();
                   String subject = "RE"+ email.getSubject();
                   MailItem email2 = new MailItem(user, to, email1, subject);
                   server.post(email2);
               }
           }
        }
        else
        {
            System.out.println("No hay correo nuevo");  
        }
    }
    
    public void printLastMessage()
    {
       if (lastMail != null){
           lastMail.print();
        }
       else {
           System.out.println ("No hay mensajes nuevos.");
       }
    }
    
    public void showStats()
    {
         numberOfEmails();
         System.out.println("You have " + countSpam + " emails of Spam.");
         porcentajeSpam = (countSpam * 100 ) / server.howManyMailItems(user);
    }
    
   
}
