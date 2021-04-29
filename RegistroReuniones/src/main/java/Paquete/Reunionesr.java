/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete;

/**
 *
 * @author Axcell Espinal
 */
public class Reunionesr 
{
     private String Nombre;
     private String Fecha;
     private String HoraI;
     private String HoraF;
     private String Lugar;
     private String Detalles;
     
     //establecer nombre
     public String getNombre()
     {
       return Nombre;
     }
     //obtener nombre
     public void setNombre(String N)
     {
       this.Nombre = N;
     }
     
     //establecer Fecha
     public String getFecha()
     {
       return Fecha;
     }
     //obtener Fecha
     public void setFecha(String F)
     {
       this.Fecha = F;
     }
     
     //establecer Hora inicial
     public String getHoraI()
     {
       return HoraI;
     }
     //obtener hora inicial
     public void setHoraI(String HI)
     {
       this.HoraI = HI;
     }
     
     //establecer hora final
     public String getHoraF()
     {
       return HoraF;
     }
     //obtener hora final
     public void setHoraF(String HF)
     {
       this.HoraF = HF;
     }
     
     //establecer Lugar
     public String getLugar()
     {
       return Lugar;
     }
     //obtener Lugar
     public void setLugar(String L )
     {
       this.Lugar = L;
     }
     
     //establecer Detalles
     public String getDetalles()
     {
       return Detalles;
     }
     //obtener Detalles
     public void setDetalles(String D)
     {
       this.Detalles = D;
     }
}
