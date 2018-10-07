package ejb;

import ejb.Estadias;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-07T17:02:39")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> uf;
    public static volatile SingularAttribute<Clientes, String> cidade;
    public static volatile SingularAttribute<Clientes, String> telefone;
    public static volatile SingularAttribute<Clientes, String> endereco;
    public static volatile SingularAttribute<Clientes, Long> cpf;
    public static volatile SingularAttribute<Clientes, String> nome;
    public static volatile CollectionAttribute<Clientes, Estadias> estadiasCollection;
    public static volatile SingularAttribute<Clientes, String> email;

}