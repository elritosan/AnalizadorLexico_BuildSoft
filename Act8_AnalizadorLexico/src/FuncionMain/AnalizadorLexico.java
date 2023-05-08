package FuncionMain;


import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;

public class AnalizadorLexico {

	public String CadenaSinEspeciales(String A)
	{
		String NuevaCad = "";
		int valorASCII = 0;
		
		for(int i = 0; i<A.length(); i++)
		{
			char caracter = A.charAt(i);
			valorASCII = (int) caracter;
			
			if( (valorASCII >= 97 && valorASCII <= 122) || (valorASCII >= 65 && valorASCII <= 90) )
			{
				NuevaCad += caracter;
			}
		}
		
		return NuevaCad;
	}
	
	public int ContCoincidencias(String A, String Cadena)
	{
		int Cont = 0;
		
		AnalizadorLexico oB = new AnalizadorLexico();
		
    	StringTokenizer st = new StringTokenizer(Cadena);
    	while(st.hasMoreTokens())
    	{
    		String Aux = oB.CadenaSinEspeciales(st.nextToken());	//Solo para Este Particular
    		if(A.equals(Aux))
    		{
    			Cont = Cont + 1;
    		}
    	}
		
		return Cont;
	}
	
	public void MostrarContadores(int A1, int A2, int A3, int A4)
	{
		System.out.println("Ocurrencias de 'alto': " + A1);
		System.out.println("Ocurrencias de 'viva': " + A2);
		System.out.println("Ocurrencias de 'persona': " + A3);
		System.out.println("Ocurrencias de 'cielo': " + A4);
	}
	
	public static void main(String[] args) {
		
		FileReader archivo;
		BufferedReader lector;
				
		//alto, viva, persona, cielo
		
		AnalizadorLexico oB = new AnalizadorLexico();
		
		int A1 = 0, A2 = 0, A3 = 0, A4 = 0;
		
		try
		{
			archivo = new FileReader("test.txt");
			
			if(archivo.ready())
			{
				lector = new BufferedReader(archivo);
				String cadena;
				while((cadena=lector.readLine()) != null)
				{
					//System.out.println(cadena);
					A1 += oB.ContCoincidencias("alto",cadena);
					A2 += oB.ContCoincidencias("viva",cadena);
					A3 += oB.ContCoincidencias("persona",cadena);
					A4 += oB.ContCoincidencias("cielo",cadena);
				}
				
				oB.MostrarContadores(A1, A2, A3, A4);
			}
			else
			{
				System.out.println("El Archivo No Esta Disponible");
			}
			
			
		} 
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}

//M