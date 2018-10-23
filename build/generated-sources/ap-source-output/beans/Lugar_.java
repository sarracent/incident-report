package beans;

import beans.Computadora;
import beans.Direccion;
import beans.Reporte;
import beans.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-15T15:17:37")
@StaticMetamodel(Lugar.class)
public class Lugar_ { 

    public static volatile CollectionAttribute<Lugar, Computadora> computadoraCollection;
    public static volatile CollectionAttribute<Lugar, Usuarios> usuariosCollection;
    public static volatile CollectionAttribute<Lugar, Direccion> direccionCollection;
    public static volatile SingularAttribute<Lugar, Integer> id;
    public static volatile CollectionAttribute<Lugar, Reporte> reporteCollection;
    public static volatile SingularAttribute<Lugar, String> nombre;

}