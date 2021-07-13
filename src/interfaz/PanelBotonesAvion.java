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
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel de botones de interacción con el programa del avión.
 */
@SuppressWarnings("serial")
public class PanelBotonesAvion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Opción registrar.
     */
    public final static String REGISTRAR = "REGISTRAR_PASAJERO";

    /**
     * Opción anular.
     */
    public final static String ANULAR = "ANULAR_PASAJERO";

    /**
     * Opción buscar.
     */
    public final static String BUSCAR = "BUSCAR_PASAJERO";

    /**
     * Opción porcentaje de ocupación.
     */
    public final static String PORCENTAJE = "PORCENTAJE_OCUPACION";
    
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón Registro de nuevo pasajero.
     */
    private JButton bRegistro;

    /**
     * Botón Anular.
     */
    private JButton bAnular;

    /**
     * Botón de búsqueda.
     */
    private JButton bBuscarPasajero;

    /**
     * Botón porcentaje de ocupación.
     */
    private JButton bPorcOcupacion;

    /**
     * Interfaz principal.
     */
    private InterfazAvion ventana;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones.
     * Se crean y alistan los botones de la interfaz.
     * @param pVentana Ventana o frame padre. pVentana != null.
     */
    public PanelBotonesAvion( InterfazAvion pVentana )
    {
        // Guarda la referencia a la ventana padre
        ventana = pVentana;

        // Configura propiedades visuales
        setLayout( new GridLayout( 2, 3, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Botón registrar
        bRegistro = new JButton( "Registrar Pasajero" );
        bRegistro.setActionCommand( REGISTRAR );
        bRegistro.addActionListener( this );
        bRegistro.setPreferredSize( new Dimension( 40, 10 ) );
        add( bRegistro );

        // Botón anular registro
        bAnular = new JButton( "Eliminar Pasajero" );
        bAnular.setActionCommand( ANULAR );
        bAnular.addActionListener( this );
        add( bAnular );

        // Botón buscar pasajero
        bBuscarPasajero = new JButton( "Buscar Pasajero" );
        bBuscarPasajero.setActionCommand( BUSCAR );
        bBuscarPasajero.addActionListener( this );
        add( bBuscarPasajero );

        // Botón porcentaje de ocupación
        bPorcOcupacion = new JButton( "Porcentaje Ocupación" );
        bPorcOcupacion.setActionCommand( PORCENTAJE );
        bPorcOcupacion.addActionListener( this );
        add( bPorcOcupacion );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Acciones de respuesta a los eventos de la interfaz.
     * @param pEvento Evento generado por un elemento de la interfaz.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( REGISTRAR ) )
        {
            ventana.registrarPasajero( );
        }
        else if( comando.equals( ANULAR ) )
        {
            ventana.eliminarPasajero( );
        }
        else if( comando.equals( BUSCAR ) )
        {
            ventana.buscarPasajero( );
        }
        else if( comando.equals( PORCENTAJE ) )
        {
            ventana.mostrarPorcentajeOcupacion( );
        }
    }
}
