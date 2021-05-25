/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACKEND.Interfaces;

import BACKEND.Clases.Reuniones;

/**
 *
 * @author Axcell Espinal
 */
public interface Editar {
    
    public void guardar(Reuniones r);
    public void actualizar(Reuniones r);
    public void eliminar(Reuniones r);
}
