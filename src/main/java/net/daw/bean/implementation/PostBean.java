/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean.implementation;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.daw.bean.publicinterface.GenericBean;
import net.daw.dao.implementation.CategoriaDao;
import net.daw.dao.implementation.UsuarioDao;

/**
 *
 * @author casa
 */
public class PostBean implements GenericBean{
    
    @Expose
    private Integer id = 0;
    @Expose
    private String titulo;
    @Expose
    private String descripcion;
    @Expose
    private Integer valoracion = 0;
    @Expose(serialize = false)
    private Integer id_categoria = 0;
    @Expose(deserialize = false)
    private CategoriaBean obj_categoria = null;
    @Expose(serialize = false)
    private Integer id_usuario = 0;
    @Expose(deserialize = false)
    private UsuarioBean obj_usuario = null;
    
    public PostBean(int id){
        this.id = id;
    }
    
    public PostBean(){
        this.id = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public CategoriaBean getObj_categoria() {
        return obj_categoria;
    }

    public void setObj_categoria(CategoriaBean obj_categoria) {
        this.obj_categoria = obj_categoria;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public UsuarioBean getObj_usuario() {
        return obj_usuario;
    }

    public void setObj_usuario(UsuarioBean obj_usuario) {
        this.obj_usuario = obj_usuario;
    }
    

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "titulo,";
        strColumns += "dscripcion,";
        strColumns += "valoracion,";
        strColumns += "id_categoria,";
        strColumns += "id_usuario";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += titulo + ",";
        strColumns += descripcion + ",";
        strColumns += valoracion + ",";
        strColumns += id_categoria+ ",";
        strColumns += id_usuario;
        return strColumns;
    }

    @Override
    public String toPairs() {
       String strPairs = "";
        strPairs += "titulo=" + titulo + ",";
        strPairs += "descripcion=" + descripcion + ",";
        strPairs += "valoracion=" + valoracion + ",";
        strPairs += "id_categoria=" + id_categoria + ",";
        strPairs += "id_usuario=" + id_usuario;
        return strPairs;
    }

    @Override
    public PostBean fill(ResultSet oResultSet, Connection pooledConnection, UsuarioBean oPuserBean_security, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setTitulo(oResultSet.getString("titulo"));
        this.setDescripcion(oResultSet.getString("descripcion"));
        this.setValoracion(oResultSet.getInt("valoracion"));
        if (expand > 0) {
            CategoriaBean oCategoriaBean = new CategoriaBean();
            CategoriaDao oCategoriaDao = new CategoriaDao(pooledConnection, oPuserBean_security, null);
            oCategoriaBean.setId(oResultSet.getInt("id_categoria"));
            oCategoriaBean = oCategoriaDao.get(oCategoriaBean, expand - 1);
            this.setObj_categoria(oCategoriaBean);
        } else {
            this.setId_categoria(oResultSet.getInt("id_categoria"));
        }
        
        if (expand > 0) {
            UsuarioBean oUsuarioBean = new UsuarioBean();
            UsuarioDao oUsuarioDao = new UsuarioDao(pooledConnection, oPuserBean_security, null);
            oUsuarioBean.setId(oResultSet.getInt("id_usuario"));
            oUsuarioBean = oUsuarioDao.get(oUsuarioBean, expand - 1);
            this.setObj_usuario(oUsuarioBean);
        } else {
            this.setId_usuario(oResultSet.getInt("id_usuario"));
        }
        
        return this;
    }
    
}
