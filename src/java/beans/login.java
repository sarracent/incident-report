/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author yohana
 */
@Named(value = "login")
@RequestScoped
public class login {
    //   ServiceLogin_Service services=new ServiceLogin_Service();

    @EJB
    private UsuariosFacade usuariosFacade;
    private String usuario;
    private String password;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private final HttpServletRequest httpServletRequest;
    private final FacesContext facesContext;
    private FacesMessage FacesMessage;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Creates a new instance of login
     */
    public login() {
        facesContext = getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public String logout() {
        // HttpSession hs = getSession();
        httpServletRequest.getSession(false).invalidate();
        out.println("se cerro la session");
        // hs.invalidate();

        System.err.println("hola:" + httpServletRequest.getServletContext().getContextPath());
        return "/login";
    }

    public void crearVsession() {
        for (Usuarios findAll : usuariosFacade.findAll()) {
            httpServletRequest.getSession().setAttribute(findAll.getUsuario(), findAll.getNombre() + " " + findAll.getApellidos());
        }
    }

    public String auth() {
        crearVsession();
        try {
            Ldap ldap = new Ldap(getUsuario(), getPassword());

            boolean valor = false;
            for (Usuarios findAll : usuariosFacade.findAll()) {
                if (findAll.getUsuario().equals(getUsuario())) {
                    valor = true;
                }
            }

            if (valor) {
                httpServletRequest.getSession().setAttribute("correoOp", getUsuario() + "@aica.cu");
                httpServletRequest.getSession().setAttribute("Especialista", ldap.getDisplayName());

                //  httpServletRequest.getSession().setAttribute("correoOp", getUsuario() + "@aica.cu");
                //   httpServletRequest.getSession().setAttribute("Especialista", "Harold Williams");
                return "template_admin";

            } else {

                httpServletRequest.getSession().setAttribute("correoOp", getUsuario() + "@aica.cu");
                httpServletRequest.getSession().setAttribute("Operario", ldap.getDisplayName());

                //  httpServletRequest.getSession().setAttribute("correoOp", getUsuario() + "@aica.cu");
                //   httpServletRequest.getSession().setAttribute("Operario", "Operario");
                return "template";
            }

        } catch (NamingException ex) {
            System.out.println("no entro");
            return "/login";
        }

    }

    public void cerrar() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

        try {
            System.out.println("paso la prueba test");
            ctx.redirect(ctxPath + "/faces/login.xhtml");

        } catch (IOException ex) {
        }
    }

}

//}
