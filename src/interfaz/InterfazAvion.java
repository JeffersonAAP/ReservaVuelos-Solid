/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author JeAnA
 */
import java.awt.*;
import java.text.*;

import javax.swing.*;

import negocio.*;

/**
 * Ventana principal del avión.
 */
@SuppressWarnings("serial")
public class InterfazAvion extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Avión.
     */
    private Avion avion;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que contiene el banner de la aplicación.
     */
    private PanelImagen panelImagen;

    /**
     * Panel que contiene el avión.
     */
    private PanelAvion panelAvion;

    /**
     * Panel de botones.
     */
    private PanelBotonesAvion panelBotones;

    /**
     * Diálogo de nuevo pasajero.
     */
    private DialogoAsignacion dAsignacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la interfaz del avión.
     * Se crea el avión y se presenta en una gráfica su estado inicial.
     */
    public InterfazAvion( )
    {
        setTitle( "Reserva Vuelos" );
        setSize( 580, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Crea al avión
        avion = new Avion( );

        // Configura la interfaz
        setLayout( new BorderLayout( ) );

        // Panel del banner
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        // Panel del avión
        panelAvion = new PanelAvion( avion );
        add( panelAvion, BorderLayout.CENTER );

        // Panel de botones
        panelBotones = new PanelBotonesAvion( this );
        add( panelBotones, BorderLayout.SOUTH );

        setResizable( false );
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Procesa el registro un pasajero.
     */
    public void registrarPasajero( )
    {
        dAsignacion = new DialogoAsignacion( this, avion );
        dAsignacion.setVisible( true );
        actualizar( );
    }

    /**
     * Procesa la anulación del registro de un pasajero.
     */
    public void eliminarPasajero( )
    {
        // Pregunta el número de cédula

        String cedula = JOptionPane.showInputDialog( this, "Ingrese el número de cédula", "Eliminar pasajero", JOptionPane.QUESTION_MESSAGE );
        if( cedula != null && !cedula.isEmpty( ) )
        {
            Pasajero pasajero = new Pasajero( cedula, "no importa" );
            if( !avion.desasignarSilla( pasajero ) )
            {
                JOptionPane.showMessageDialog( this, "El pasajero no tenía silla asignada", "Eliminar pasajero", JOptionPane.ERROR_MESSAGE );
            }
            JOptionPane.showMessageDialog( this, "El pasajero ha sido eliminado.", "Eliminar pasajero", JOptionPane.ERROR_MESSAGE );
        }

        actualizar( );
    }

    /**
     * Muestra el porcentaje de ocupación que tiene el avión.
     */
    public void mostrarPorcentajeOcupacion( )
    {
        double porcentaje;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupación es " + df.format( porcentaje ) + "%", "Ocupación del avión", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Procesa la búsqueda de un pasajero.
     */
    public void buscarPasajero( )
    {
        // Pregunta el número de cédula
        String cedula = JOptionPane.showInputDialog( this, "Ingrese el número de cédula", "Buscar pasajero", JOptionPane.QUESTION_MESSAGE );
        if( cedula != null && !cedula.isEmpty( ) )
        {
            Pasajero pasajero = new Pasajero( cedula, "no importa" );

            Silla silla = avion.buscarPasajero( pasajero );

            if( silla != null )
            {
                DialogoDatosPasajero vDatos = new DialogoDatosPasajero( this, silla );
                vDatos.setVisible( true );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El pasajero no se encuentra registrado", "Buscar pasajero", JOptionPane.INFORMATION_MESSAGE );
            }

        }
    }

    /**
     * Repinta la gráfica del avión.
     */
    public void actualizar( )
    {
        remove( panelAvion );

        // Panel del avión
        panelAvion = new PanelAvion( avion );
        add( panelAvion, BorderLayout.CENTER );
        validate( );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazAvion interfaz = new InterfazAvion( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
