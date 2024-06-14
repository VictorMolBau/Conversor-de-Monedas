import java.io.IOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Integer monedaReferencia = null;
        Integer monedaConvertir = null;
        String arg1 = null;
        String arg2 = null;
        double tasa = 0;
        double cantidadAConvertir = 0;
        double TipoCambio= 0;
        Menu.mensajeInicial();

        while (true) {
            System.out.println("Escoge la moneda que deseas CAMBIAR:");
            Scanner teclado = new Scanner(System.in);
            try {
                monedaReferencia = (Integer) teclado.nextInt();
                if(monedaReferencia < 1 || monedaReferencia > 7) {
                    System.out.println("Opción no valida");
                    System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                    continue;
                }
                switch (monedaReferencia) {
                    case 1:
                        arg1 = "COP";
                        break;
                    case 2:
                        arg1 = "ARS";
                        break;
                    case 3:
                        arg1 = "MXN";
                        break;
                    case 4:
                        arg1 = "BRL";
                        break;
                    case 5:
                        arg1 = "USD";
                        break;
                    case 6:
                        arg1 = "CAD";
                        break;
                    case 7:
                        arg1 = "EUR";
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                continue;
            }
            System.out.println("Escoge la moneda DESTINO:");
            Scanner teclado2 = new Scanner(System.in);
            try {
                monedaConvertir = (Integer) teclado2.nextInt();
                if(monedaConvertir < 1 || monedaConvertir > 7) {
                    System.out.println("Opción no valida");
                    System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                    continue;
                }
                switch (monedaConvertir) {
                    case 1:
                        arg2 = "COP";
                        break;
                    case 2:
                        arg2 = "ARS";
                        break;
                    case 3:
                        arg2 = "MXN";
                        break;
                    case 4:
                        arg2 = "BRL";
                        break;
                    case 5:
                        arg2 = "USD";
                        break;
                    case 6:
                        arg2 = "CAD";
                        break;
                    case 7:
                        arg2 = "EUR";
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                continue;
            }
            System.out.println(("Ingrese la cantidad de dinero a cambiar (" + arg1 + "):"));
            Scanner teclado3 = new Scanner(System.in);
            try {
                cantidadAConvertir = teclado3.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                continue;
            }
            tasa = TipoDeCambio.Tasa(arg1, arg2);
            TipoCambio = (tasa * cantidadAConvertir);

            System.out.println(cantidadAConvertir + " " + arg1 + " Equivalen a: " + new DecimalFormat("#.##").format(TipoCambio) + " " + arg2);
            Reiniciar.reinicio();
            String rta = null;
            Scanner teclado4 = new Scanner(System.in);
            rta = teclado4.nextLine();
            if(rta.equals("si")) {
                Menu.mensajeInicial();
                continue;
            } else if (rta.equals("no")) {
                break;
            } else {
                System.out.println("Opción no valida");
                break;
            }
        }

    }
}
