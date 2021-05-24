/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND.Imagenes;

import javax.swing.*;

/**
 *
 * @author Axcell Espinal
 */
public class Imagen {

    private String NombreA; //nombre del archivo
    private int X; //posicion horizontal de la imagen en relacion con el JLabel
    private int Y; //posicion vertical de la imagen en relacion con el JLabel
    private int Height; //altura de la imagen
    private int Width; //anchura de la imagen

    public void Imagen() {

    }

    public void getAll(String NombreA, int x, int y, int height, int width) {
        this.NombreA = NombreA;
        this.X = x;
        this.Y = y;
        this.Height = height;
        this.Width = width;
    }

    public void cargarImagen(JPanel contenedor) {
        System.out.println("imagen "+NombreA +" cargada exitosamente");
        JLabel cImagen = new JLabel(new ImageIcon("src/main/java/FRONTEND/Imagenes/" + NombreA));
        cImagen.setBounds(X, Y, Height, Width);
        contenedor.add(cImagen);
    }
}
