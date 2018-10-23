package beans;

import beans.Computadora;
import beans.Lugar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-15T15:17:37")
@StaticMetamodel(Direccion.class)
public class Direccion_ { 

    public static volatile CollectionAttribute<Direccion, Computadora> computadoraCollection;
    public static volatile SingularAttribute<Direccion, Lugar> lugar;
    public static volatile SingularAttribute<Direccion, String> nombrecompleto;
    public static volatile SingularAttribute<Direccion, Integer> id;
    public static volatile SingularAttribute<Direccion, String> nombre;

}