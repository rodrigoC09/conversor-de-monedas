
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static SleeperBasic sleeper;

    public Principal(){
        sleeper = new SleeperBasic();
    }
    public void esperar(){
        System.out.println("Realizando tarea");
    }


    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);

        ConsultaMoneda consulta = new ConsultaMoneda();
        long time = 3500;
        Principal principal = new Principal();
        DecimalFormat limitDecimales = new DecimalFormat("#0.00");

        ArrayList historico = new ArrayList<>();

        String menu = """
                *************************************************
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>>Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Dólar =>> Peso chileno
                8) Peso chileno =>> Dólar
                9) Salir
                                
                Escoja una opcion
                *************************************************
                """;

        System.out.println(menu);
        String busqueda = "";

        while (!IsInteger(busqueda)) {
                try {


                    busqueda = leer.nextLine();

                    if (Integer.valueOf(busqueda) == 9) {

                        System.out.println("Fin de la convercion");
                        System.out.println("///////Historial de converciones////////\n");
                        //System.out.println(historico);
                        for (int i = 0; i < historico.size(); i++) {
                            System.out.println(historico.get(i));
                        }
                        break;
                    } else if (Integer.valueOf(busqueda) > 0 && Integer.valueOf(busqueda) < 9) {
                        String monedaOrigen = "";
                        String monedaDestino = "";
                        Moneda moneda;
                        String monto = "";
                        double resultado = 0;

                        switch (Integer.valueOf(busqueda)) {

                            case 1:
                                System.out.println("Dolar a peso argentino");

                                System.out.println("Cuanto quieres convertir");

                                    monto = leer.nextLine();

                                    monedaOrigen = "USD";
                                    monedaDestino = "ARS";
                                    moneda = consulta.convertirMoneda(monedaOrigen, monedaDestino);

                                    resultado = moneda.conversion_rate() * Integer.valueOf(monto);
                                    System.out.println(monto + " USD en pesos Argentino son: " + limitDecimales.format(resultado) + " pesos");
                                    historico.add(monto + " USD en pesos Argentino son: " + limitDecimales.format(resultado) + " pesos");

                                    sleeper.runWithDelay(() -> principal.esperar(), time);
                                    System.out.println(menu);
                                    break;



                            case 2:
                                System.out.println("Peso Argentino a Dólar");
                                System.out.println("Cuanto quieres convertir");
                                monto = leer.nextLine();

                                monedaOrigen = "ARS";
                                monedaDestino = "USD";
                                moneda = consulta.convertirMoneda(monedaOrigen, monedaDestino);
                                resultado = moneda.conversion_rate() * Integer.valueOf(monto);

                                System.out.println(monto + " Pesos Argentino en USD son: " + limitDecimales.format(resultado) + " dólares ");
                                historico.add(monto + " Pesos Argentino en USD son: " + limitDecimales.format(resultado) + " dólares ");

                                sleeper.runWithDelay(() -> principal.esperar(), time);
                                System.out.println(menu);
                                break;
                            case 3:
                                System.out.println("Dólar a Real brasileño");
                                System.out.println("Cuanto quieres convertir");
                                monto = leer.nextLine();

                                monedaOrigen = "USD";
                                monedaDestino = "BRL";

                                moneda = consulta.convertirMoneda(monedaOrigen, monedaDestino);
                                resultado = moneda.conversion_rate() * Integer.valueOf(monto);
                                ;
                                System.out.println(monto + " USD en Reales brasileño son : " + limitDecimales.format(resultado));

                                historico.add(monto + " USD en Reales brasileño son : " + limitDecimales.format(resultado));
                                sleeper.runWithDelay(() -> principal.esperar(), time);
                                System.out.println(menu);
                                break;
                            case 4:
                                System.out.println("Real brasileño a Dólar");
                                System.out.println("Cuanto quieres convertir");
                                monto = leer.nextLine();

                                monedaOrigen = "BRL";
                                monedaDestino = "USD";
                                moneda = consulta.convertirMoneda(monedaOrigen, monedaDestino);
                                resultado = moneda.conversion_rate() * Integer.valueOf(monto);
                                ;
                                System.out.println(monto + " Reales brasileños en USD son : " + limitDecimales.format(resultado) + " dolares");

                                historico.add(monto + " Reales brasileños en USD son : " + limitDecimales.format(resultado) + " dolares");
                                sleeper.runWithDelay(() -> principal.esperar(), time);
                                System.out.println(menu);
                                break;
                            case 5:
                                System.out.println("Dólar a Peso colombiano");
                                System.out.println("Cuanto quieres convertir");
                                monto = leer.nextLine();

                                monedaOrigen = "USD";
                                monedaDestino = "COP";
                                moneda = consulta.convertirMoneda(monedaOrigen, monedaDestino);
                                resultado = moneda.conversion_rate() * Integer.valueOf(monto);
                                ;
                                System.out.println(monto + " USD en pesos colombianos son : " + limitDecimales.format(resultado));

                                historico.add(monto + " USD en pesos colombianos son : " + limitDecimales.format(resultado));
                                sleeper.runWithDelay(() -> principal.esperar(), time);
                                System.out.println(menu);
                                break;
                            case 6:
                                System.out.println("Peso colombiano a Dólar");
                                System.out.println("Cuanto quieres convertir");
                                monto = leer.nextLine();

                                monedaOrigen = "COP";
                                monedaDestino = "USD";
                                moneda = consulta.convertirMoneda(monedaOrigen, monedaDestino);
                                resultado = moneda.conversion_rate() * Integer.valueOf(monto);


                                System.out.println(monto + " Pesos Colombianos en USD en son : " + limitDecimales.format(resultado) + " dolares");

                                historico.add(monto + " Pesos Colombianos en USD en son : " + limitDecimales.format(resultado) + " dolares");
                                sleeper.runWithDelay(() -> principal.esperar(), time);
                                System.out.println(menu);
                                break;
                            case 7:
                                System.out.println("Dólar a pesos chilenos");
                                System.out.println("Cuanto quieres convertir");
                                monto=leer.nextLine();

                                monedaOrigen="USD";
                                monedaDestino = "CLP";
                                moneda = consulta.convertirMoneda(monedaOrigen, monedaDestino);
                                resultado = moneda.conversion_rate() * Integer.valueOf(monto);

                                System.out.println(monto +" dolares en pesos chilenos es:  "+limitDecimales.format(resultado));

                                historico.add(monto +" dolares en pesos chilenos es:  "+limitDecimales.format(resultado));
                                sleeper.runWithDelay(()->principal.esperar(),time);
                                System.out.println(menu);
                                break;
                            case 8:
                                System.out.println("Peso Chileno a Dólar");
                                System.out.println("Cuanto quieres convertir");
                                monto=leer.nextLine();

                                monedaOrigen="CLP";
                                monedaDestino = "USD";
                                moneda = consulta.convertirMoneda(monedaOrigen, monedaDestino);
                                resultado = moneda.conversion_rate() * Integer.valueOf(monto);

                                System.out.println(monto +" Pesos chilenos en Dólares es:  "+limitDecimales.format(resultado));

                                historico.add(monto +" Pesos chilenos en Dólares es:  "+limitDecimales.format(resultado));
                                sleeper.runWithDelay(()->principal.esperar(),time);
                                System.out.println(menu);
                                break;

                        }

                    } else {
                        System.out.println("opcion no valida");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("no es un numero asegurece de ingresar numeros");
                    //throw new RuntimeException("no es un numero asegurece de ingresar numeros"+e);


                } catch (NumberFormatException e) {
                    System.out.println("El caracter ingresado no es un numero");
                }
            busqueda = "";
            }

    }

    private static boolean IsInteger(String busqueda) {
        int valor;
        try{
            valor = Integer.parseInt(busqueda);
            return true;
        }catch (NumberFormatException e){
            System.out.println("por favor ingrese solo numeros");
            return false;
        }
    }

}
