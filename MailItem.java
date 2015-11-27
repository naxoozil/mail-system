public class MailItem
{
	//La direccion del remitente
	private String from;
	//La dirección del receptor
	private String to;
	//El cuerpo del mensaje de email
	private String message;
	// Guarda el asunto del mensaje
	private String subject;
	
	/**
	 * Crea un objeto MailItem inicializando sus atributos
	 * a los valores dados como parametros
	 */
	public MailItem(String from, String to, String message, String subject)
	{
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.message = message;
	}
	
	/**
	 * Devuelve la direccion el remitente
	 */
	public String getFrom()
	{
		return from;
	}
	
	/**
	 * Devuelve la dirección del receptor
	 */
	public String getTo()
	{
		return to;
	}
	
	/**
	 * Devuelve el cuerpo del mensaje
	 */
	public String getMessage() 
	{	
		return message;
	}

	/**
	 * Devuelve el asunto del mensaje
	 */
	public String getsubject()
	{
	    return subject;
	}
	
	/**
	 * Imprime por pantalla el remitente, el receptor y el
	 * cuerpo del email
	 */
	public void print()
	{
		System.out.println ("De: " + from);
		System.out.println ("Para: " + to);
		System.out.println("Subject: " + subject);
		System.out.println ("Mensaje: " + message);
	}
}