/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author JeAnA
 */

/**
 * Pasajero del avión.
 */
public class Pasajero {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cédula del pasajero.
     */
    private String cedula;

    /**
     * Nombre del pasajero.
     */
    private String nombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un pasajero con su cédula y nombre.
     * El pasajero tiene sus datos básicos cédula y nombre asignados.
     * @param pCedula Cédula del pasajero. pCedula > 0.
     * @param pNombre Nombre del pasajero. pNombre != null && pNombre != "".
     */
    public Pasajero( String pCedula, String pNombre )
    {
        cedula = pCedula;
        nombre = pNombre;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cédula del pasajero.
     * @return La cédula del pasajero.
     */
    public String darCedula( )
    {
        return cedula;
    }

    /**
     * Retorna el nombre del pasajero.
     * @return El nombre del pasajero.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Indica si el pasajero es igual a otro.
     * @param pOtroPasajero Pasajero a comparar. pOtroPasajero != null.
     * @return Retorna true si es el mismo pasajero, false en caso contrario.
     */
    public boolean igualA( Pasajero pOtroPasajero )
    {
        boolean esIgual = false;
        if( cedula.equals( pOtroPasajero.darCedula( ) ) )
        {
            esIgual = true;
        }
        return esIgual;
    }
}
