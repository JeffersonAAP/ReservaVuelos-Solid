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

import javax.swing.*;

import negocio.*;
import negocio.Silla.Clase;

/**
 * Representación gráfica de una silla del avión.
 */
@SuppressWarnings("serial")
public class SillaGrafica extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Imagen de la silla.
     */
    private ImageIcon imagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la representación gráfica de la silla.
     * La imagen de la silla distingue si está libre u ocupada.
     * @param pSilla Silla a representar. pSilla != null.
     */
    public SillaGrafica( Silla pSilla )
    {
        super( new BorderLayout( ) );
        JLabel lSilla = new JLabel( );
        if( pSilla.darClase( ) == Clase.EJECUTIVA && pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "./imagenes/interfaz/ocupada.png" );
        }
        else if( pSilla.darClase( ) == Clase.EJECUTIVA && !pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "./imagenes/interfaz/ejecutiva.png" );
        }
        else if( pSilla.darClase( ) == Clase.ECONOMICA && pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "./imagenes/interfaz/ocupada.png" );
        }
        else if( pSilla.darClase( ) == Clase.ECONOMICA && !pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "./imagenes/interfaz/economica.png" );
            lSilla.setForeground( Color.black );
        }
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );
        lSilla.setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        lSilla.setText( "" + pSilla.darNumero( ) );
        lSilla.setHorizontalAlignment( SwingConstants.CENTER );
        lSilla.setVerticalAlignment( SwingConstants.CENTER );
        add( lSilla );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Dibuja la imagen de la silla.
     * @param pGrafica Gráfica de la silla.
     */
    public void paint( Graphics pGrafica )
    {
        pGrafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( pGrafica );
    }
}
