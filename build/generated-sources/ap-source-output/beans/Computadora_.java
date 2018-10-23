package beans;

import beans.Antivirus;
import beans.CategoriaEquipo;
import beans.Direccion;
import beans.Lugar;
import beans.Reporte;
import beans.SistemaOperativo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-15T15:17:37")
@StaticMetamodel(Computadora.class)
public class Computadora_ { 

    public static volatile SingularAttribute<Computadora, CategoriaEquipo> categoriaEquipo;
    public static volatile SingularAttribute<Computadora, String> estado;
    public static volatile SingularAttribute<Computadora, SistemaOperativo> sistemaOperativo;
    public static volatile SingularAttribute<Computadora, String> nombrePc;
    public static volatile SingularAttribute<Computadora, Integer> noSello;
    public static volatile SingularAttribute<Computadora, Antivirus> antivirus;
    public static volatile SingularAttribute<Computadora, Lugar> lugar;
    public static volatile CollectionAttribute<Computadora, Reporte> reporteCollection;
    public static volatile SingularAttribute<Computadora, Integer> id;
    public static volatile SingularAttribute<Computadora, String> noIp;
    public static volatile SingularAttribute<Computadora, String> noMac;
    public static volatile SingularAttribute<Computadora, Direccion> nombreDireccion;

}