package beans;

import beans.Computadora;
import beans.Lugar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-15T15:17:37")
@StaticMetamodel(Reporte.class)
public class Reporte_ { 

    public static volatile SingularAttribute<Reporte, String> area;
    public static volatile SingularAttribute<Reporte, String> fechaCreado;
    public static volatile SingularAttribute<Reporte, String> estadoReporte;
    public static volatile SingularAttribute<Reporte, Lugar> lugar;
    public static volatile SingularAttribute<Reporte, String> titulo;
    public static volatile SingularAttribute<Reporte, String> solucion;
    public static volatile SingularAttribute<Reporte, String> conformidad;
    public static volatile SingularAttribute<Reporte, String> especialista;
    public static volatile SingularAttribute<Reporte, String> correo;
    public static volatile SingularAttribute<Reporte, String> equipo;
    public static volatile SingularAttribute<Reporte, String> fechaSolucion;
    public static volatile SingularAttribute<Reporte, String> usuario;
    public static volatile SingularAttribute<Reporte, Integer> id;
    public static volatile SingularAttribute<Reporte, String> telefono;
    public static volatile SingularAttribute<Reporte, Computadora> computadoraid;
    public static volatile SingularAttribute<Reporte, String> observacion;

}