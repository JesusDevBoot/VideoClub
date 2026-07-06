package gonzalez.jesus.videoclub.main;

import gonzalez.jesus.videoclub.model.Alquiler;
import gonzalez.jesus.videoclub.model.Cliente;
import gonzalez.jesus.videoclub.model.Novedad;
import gonzalez.jesus.videoclub.model.Old;
import gonzalez.jesus.videoclub.model.Pelicula;
import gonzalez.jesus.videoclub.model.TipoCliente;
import gonzalez.jesus.videoclub.model.Vhs;
import gonzalez.jesus.videoclub.service.AlquilerService;
import gonzalez.jesus.videoclub.service.ClienteService;
import gonzalez.jesus.videoclub.service.PeliculaService;
import java.time.LocalDate;



import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        // Servicios
        PeliculaService peliculaService = new PeliculaService();
        ClienteService clienteService = new ClienteService();
        AlquilerService alquilerService = new AlquilerService();

        // Cargar datos iniciales
        inicializarPeliculas(peliculaService);
        inicializarClientes(clienteService);

        // Lanzar menú
        mostrarMenu(peliculaService, clienteService, alquilerService);
    }

    private static void inicializarPeliculas(PeliculaService peliculaService) {

        peliculaService.agregarPelicula(
                new Novedad(1, "Inception", "Sci-Fi", true, "PG-13", LocalDate.of(2010, 7, 16), true));

        peliculaService.agregarPelicula(
                new Vhs(2, "The Matrix", "Action", true, "R"));

        peliculaService.agregarPelicula(
                new Old(3, "Finding Nemo", "Animation", true, "G", 2003, false));
    }

    private static void inicializarClientes(ClienteService clienteService) {

        clienteService.agregarCliente(
                new Cliente(1,
                        "Juan Pérez",
                        "juanperez@ole.es",
                        "123456789",
                        TipoCliente.SOCIO_FUNDADOR));

        clienteService.agregarCliente(
                new Cliente(2,
                        "María López",
                        "maria@gmail.com",
                        "987654321",
                        TipoCliente.SOCIO));

        clienteService.agregarCliente(
                new Cliente(3,
                        "Pedro García",
                        "pedro@yahoo.es",
                        "555555555",
                        TipoCliente.NO_SOCIO));
    }

    private static void mostrarMenu(PeliculaService peliculaService,
                                    ClienteService clienteService,
                                    AlquilerService alquilerService) {

        while (true) {

            String opcion = JOptionPane.showInputDialog(
                    null,
                    "Bienvenido al VideoClub El Feriante\n\n" +
                            "1. Ver películas disponibles\n" +
                            "2. Alquilar una película\n" +
                            "3. Devolver una película\n" +
                            "4. Buscar usuario\n" +
                            "5. Crear usuario\n" +
                            "6. Mostrar alquileres activos\n" +
                            "7. Mostrar clientes\n" +
                            "8. Buscar película por ID\n" +
                            "9. Salir");

            if (opcion == null || opcion.equals("9")) {
                JOptionPane.showMessageDialog(null,
                        "Gracias por usar VideoClub El Feriante");
                break;
            }

            switch (opcion) {

                case "1":
                    mostrarPeliculas(peliculaService);
                    break;

                case "2":
                    gestionarAlquiler(
                            peliculaService,
                            clienteService,
                            alquilerService);
                    break;

                case "3":
                    gestionarDevolucion(alquilerService);
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null,
                            "Pendiente de implementar.");
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null,
                            "Pendiente de implementar.");
                    break;

                case "6":
                    mostrarAlquileresActivos(alquilerService);
                    break;

                case "7":
                    mostrarClientes(clienteService);
                    break;

                case "8":
                    buscarPelicula(peliculaService);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción no válida.");
            }
        }
    }

    private static void mostrarPeliculas(PeliculaService peliculaService) {

        StringBuilder listado = new StringBuilder();

        for (Pelicula pelicula : peliculaService.peliculasDisponibles()) {
            listado.append(pelicula).append("\n");
        }

        JOptionPane.showMessageDialog(null, listado.toString());
    }

    private static void mostrarClientes(ClienteService clienteService) {

        StringBuilder listado = new StringBuilder();

        for (Cliente cliente : clienteService.getClientes()) {
            listado.append(cliente).append("\n");
        }

        JOptionPane.showMessageDialog(null, listado.toString());
    }

    private static void gestionarAlquiler(
            PeliculaService peliculaService,
            ClienteService clienteService,
            AlquilerService alquilerService) {

        try {

            int idCliente = Integer.parseInt(
                    JOptionPane.showInputDialog("ID del cliente"));

            int idPelicula = Integer.parseInt(
                    JOptionPane.showInputDialog("ID de la película"));

            Cliente cliente = clienteService.buscaPorId(idCliente);
            Pelicula pelicula = peliculaService.buscaPorId(idPelicula);

            if (cliente == null || pelicula == null) {
                JOptionPane.showMessageDialog(null,
                        "Cliente o película no encontrados.");
                return;
            }

            Alquiler alquiler =
                    alquilerService.crearAlquiler(cliente, pelicula);

            JOptionPane.showMessageDialog(null,
                    "Alquiler realizado correctamente.\n\n" + alquiler);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    private static void gestionarDevolucion(
            AlquilerService alquilerService) {

        if (alquilerService.getAlquileres().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "No existen alquileres.");

            return;
        }

        try {

            Alquiler alquiler =
                    alquilerService.getAlquileres().get(0);

            alquilerService.devolverAlquiler(alquiler);

            JOptionPane.showMessageDialog(null,
                    "Película devuelta correctamente.");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    private static void mostrarAlquileresActivos(
            AlquilerService alquilerService) {

        StringBuilder listado = new StringBuilder();

        for (Alquiler alquiler : alquilerService.getAlquileres()) {

            if (!alquiler.isDevuelta()) {
                listado.append(alquiler).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, listado.toString());
    }

    private static void buscarPelicula(
            PeliculaService peliculaService) {

        try {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Introduce el ID de la película"));

            Pelicula pelicula = peliculaService.buscaPorId(id);

            if (pelicula == null) {

                JOptionPane.showMessageDialog(null,
                        "Película no encontrada.");

            } else {

                JOptionPane.showMessageDialog(null,
                        pelicula);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "ID no válido.");
        }
    }
}