/**
 * Universidad de San Carlos de Guatemala
 * Facultad de Ingenieria
 * Ingenieria en Ciencias y Sistemas
 * Esdras Benjamin Cotto Revolorio
 * Carnet: 200412823
 */

package Principal;

import static Principal.Principal.webClient;
import java.net.URL;
import javax.swing.JTextField;
import java.io.IOException;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.json.*;

/**
 *
 * @author Ben
 */
public class ConectarWebService {

    public ConectarWebService() {
    }    
    
    //con este metodo meto el aeropuerto a la lista doble
    public static void crearAeropuerto(String nombr, String Passwordd,String ppais) throws IOException{
        URL url = new URL("http://localhost:5000/aeropuerto/insertar");

	RequestBody formBody = new FormEncodingBuilder()
                .add("NombreAeropuerto", nombr)
                .add("Contrasenia", Passwordd)
                .add("Pais", ppais)            
                .build();

	Request request = new Request.Builder().url(url).post(formBody).build();
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println(request);
	Response response = webClient.newCall(request).execute();
	String response_string = response.body().string();
        System.out.println("********************* Este se ingreso ************************+");
	System.out.println(response_string);
        
    }
    
    //con este metodo meto el usuario al arbol de usuarios
    public static void crearUsuario(String nombr, String Passwordd,String nicc,String dirre, String telle, String creddit,String dirAcctu) throws IOException{
        URL url = new URL("http://localhost:5000/usuario/insertar");

	RequestBody formBody = new FormEncodingBuilder()
                .add("Nombre", nombr)
                .add("Contrasenia", Passwordd)
                .add("NameUsuario", nicc)
                .add("Direccion", dirre)
                .add("Telefono", telle)
                .add("TarjetaCredito", creddit)
                .add("DireccionActual", dirAcctu)
                .build();

	Request request = new Request.Builder().url(url).post(formBody).build();
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println(request);
	Response response = webClient.newCall(request).execute();
	String response_string = response.body().string();
        System.out.println("********************* Este se ingreso ************************+");
	System.out.println(response_string);
        
    }
    
    //con este metodo meto el vuelo al arbol de vuelos
    public static void crearVuelo(String LugarSalida,String LugarLlegada,String HoraSalida,String FechaSalida,String HoraLLegada,String FechaLLegada,int CantPrimeraClase,double CostoPrimeraClase,int CantTurista,double CostoTurista,int CantEjecutiva,double CostoEjecutiva, String EstadoVuelo) throws IOException{
        URL url = new URL("http://localhost:5000/vuelo/insertar");

	RequestBody formBody = new FormEncodingBuilder()
                .add("LugarSalida", LugarSalida)
                .add("LugarLlegada", LugarLlegada)
                .add("HoraSalida", HoraSalida)
                .add("FechaSalida", FechaSalida)
                .add("HoraLLegada", HoraLLegada)
                .add("FechaLLegada", FechaLLegada)
                .add("CantPrimeraClase", Integer.toString(CantPrimeraClase))
                .add("CostoPrimeraClase", Double.toString(CostoPrimeraClase))
                .add("CantTurista", Integer.toString(CantTurista))
                .add("CostoTurista", Double.toString(CostoTurista))
                .add("CantEjecutiva", Integer.toString(CantEjecutiva))
                .add("CostoEjecutiva", Double.toString(CostoEjecutiva))
                .add("EstadoVuelo", EstadoVuelo)
                .build();

	Request request = new Request.Builder().url(url).post(formBody).build();
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println(request);
	Response response = webClient.newCall(request).execute();
	String response_string = response.body().string();
        System.out.println("********************* Este se ingreso ************************+");
	System.out.println(response_string);
        
    }
    
    //este es un metodo de pruebas 
    public static void holaMundo(JTextField textoArea) throws IOException{
        URL url = new URL("http://localhost:5000/bienvenido");
	Request request = new Request.Builder().url(url).build();
	Response response = webClient.newCall(request).execute();
	String response_string = response.body().string();
        textoArea.setText(response_string);
    }
    
    //este metodo servira para saber si se logueo 
    public boolean  loguearAlUsuario(String nicc,String passs) throws IOException{
        boolean devuelve=false;
       URL url = new URL("http://localhost:5000/usuario/loguear");

	RequestBody formBody = new FormEncodingBuilder()
                .add("Nicck", nicc)
                .add("Passw", passs)                        
                .build();

	Request request = new Request.Builder().url(url).post(formBody).build();
        System.out.println(request);
	Response response = webClient.newCall(request).execute();
	String response_string = response.body().string();
        if(response_string.equalsIgnoreCase("success")){
            devuelve=true;
        }else {
            devuelve=false;
        }
        return devuelve;
    }
    
}
