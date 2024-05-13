import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;

public class GeneradorDeMoneda {
    public void guardarJson(Moneda moneda){
        Gson gson =new GsonBuilder()
                .setPrettyPrinting()
                .create();



    }
}
