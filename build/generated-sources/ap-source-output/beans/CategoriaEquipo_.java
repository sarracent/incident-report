package beans;

import beans.Computadora;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-15T15:17:37")
@StaticMetamodel(CategoriaEquipo.class)
public class CategoriaEquipo_ { 

    public static volatile CollectionAttribute<CategoriaEquipo, Computadora> computadoraCollection;
    public static volatile SingularAttribute<CategoriaEquipo, String> categoria;
    public static volatile SingularAttribute<CategoriaEquipo, Integer> id;

}