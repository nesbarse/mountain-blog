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
import net.daw.dao.implementation.PostDao;
import net.daw.dao.implementation.UsuarioDao;

/**
 *
 * @author casa
 */
public class ComentarioBean implements GenericBean{

    @Expose
    private Integer id = 0;
    @Expose
    private String descripcion;
    @Expose(serialize = false)
    private Integer id_post = 0;
    @Expose(deserialize = false)
    private PostBean obj_post = null;
    @Expose(serialize = false)
    private Integer id_usuario = 0;
    @Expose(deserialize = false)
    private UsuarioBean obj_usuario = null;
    
    public ComentarioBean(int id){
        this.id = id;
    }
    
    public ComentarioBean(){
        this.id = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public PostBean getObj_post() {
        return obj_post;
    }

    public void setObj_post(PostBean obj_post) {
        this.obj_post = obj_post;
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
        strColumns += "dscripcion,";
        strColumns += "id_post,";
        strColumns += "id_usuario";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += descripcion + ",";
        strColumns += id_post+ ",";
        strColumns += id_usuario;
        return strColumns;
    }

    @Override
    public String toPairs() {
        String strPairs = "";
        strPairs += "descripcion=" + descripcion + ",";
        strPairs += "id_post=" + id_post + ",";
        strPairs += "id_usuario=" + id_usuario;
        return strPairs;
    }

    @Override
    public ComentarioBean fill(ResultSet oResultSet, Connection pooledConnection, UsuarioBean oPuserBean_security, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setDescripcion(oResultSet.getString("descripcion"));
        if (expand > 0) {
            PostBean oPostBean = new PostBean();
            PostDao oPostDao = new PostDao(pooledConnection, oPuserBean_security, null);
            oPostBean.setId(oResultSet.getInt("id_post"));
            oPostBean = oPostDao.get(oPostBean, expand - 1);
            this.setObj_post(oPostBean);
        } else {
            this.setId_post(oResultSet.getInt("id_post"));
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
