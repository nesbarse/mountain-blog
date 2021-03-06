/*
 * Copyright (c) 2016 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 *
 * sisane-server: Helps you to develop easily AJAX web applications
 *                   by copying and modifying this Java Server.
 *
 * Sources at https://github.com/rafaelaznar/sisane-server
 *
 * sisane-server is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.daw.bean.implementation;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.daw.bean.publicinterface.GenericBean;
import net.daw.dao.implementation.TipousuarioDao;
import net.daw.helper.statics.EncodingUtilHelper;

public class UsuarioBean implements GenericBean {

    @Expose
    private Integer id = 0;
    @Expose
    private String dni;
    @Expose
    private String nombre;
    @Expose
    private String apellido1;
    @Expose
    private String apellido2;
    @Expose
    private String login;
    @Expose(serialize = false)
    private String password;
    @Expose
    private String direccion;
    @Expose
    private String ciudad;
    @Expose
    private String codigo_postal;
    @Expose
    private String provincia;
    @Expose
    private String pais;
    @Expose
    private String email;
    @Expose
    private String telefono;

    @Expose(serialize = false)
    private Integer id_tipousuario = 0;
    @Expose(deserialize = false)
    private TipousuarioBean obj_tipousuario = null;

    @Expose(serialize = false)
    private Integer id_medico = 0;

    /*@Expose(deserialize = false)
    private MedicoBean obj_medico = null;*/
    public UsuarioBean() {
    }

    public UsuarioBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return apellido1;
    }

    public void setPrimerapellido(String primerapellido) {
        this.apellido1 = primerapellido;
    }

    public String getSegundoapellido() {
        return apellido2;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.apellido2 = segundoapellido;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigopostal() {
        return codigo_postal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigo_postal = codigopostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(Integer id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public TipousuarioBean getObj_tipousuario() {
        return obj_tipousuario;
    }

    public void setObj_tipousuario(TipousuarioBean obj_tipousuario) {
        this.obj_tipousuario = obj_tipousuario;
    }

//    public Integer getId_medico() {
//        return id_medico;
//    }
//
//    public void setId_medico(Integer id_medico) {
//        this.id_medico = id_medico;
//    }

    /*public MedicoBean getObj_medico() {
        return obj_medico;
    }

    public void setObj_medico(MedicoBean obj_medico) {
        this.obj_medico = obj_medico;
    }*/
    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "dni,";
        strColumns += "nombre,";
        strColumns += "apellido1,";
        strColumns += "apellido2,";
        strColumns += "login,";
        strColumns += "password,";
        strColumns += "direccion,";
        strColumns += "ciudad,";
        strColumns += "codigo_postal,";
        strColumns += "provincia,";
        strColumns += "pais,";
        strColumns += "email,";
        strColumns += "telefono,";
        strColumns += "id_tipousuario";
//        strColumns += "id_medico";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += EncodingUtilHelper.quotate(dni) + ",";
        strColumns += EncodingUtilHelper.quotate(nombre) + ",";
        strColumns += EncodingUtilHelper.quotate(apellido1) + ",";
        strColumns += EncodingUtilHelper.quotate(apellido2) + ",";
        strColumns += EncodingUtilHelper.quotate(login) + ",";
        strColumns += EncodingUtilHelper.quotate(password) + ",";
        strColumns += EncodingUtilHelper.quotate(direccion) + ",";
        strColumns += EncodingUtilHelper.quotate(ciudad) + ",";
        strColumns += EncodingUtilHelper.quotate(codigo_postal) + ",";
        strColumns += EncodingUtilHelper.quotate(provincia) + ",";
        strColumns += EncodingUtilHelper.quotate(pais) + ",";
        strColumns += EncodingUtilHelper.quotate(email) + ",";
        strColumns += EncodingUtilHelper.quotate(telefono) + ",";
        strColumns += id_tipousuario;
//        strColumns += id_medico;
        return strColumns;
    }

    @Override
    public String toPairs() {
        String strPairs = "";
        strPairs += "dni=" + EncodingUtilHelper.quotate(dni) + ",";
        strPairs += "nombre=" + EncodingUtilHelper.quotate(nombre) + ",";
        strPairs += "primerapellido=" + EncodingUtilHelper.quotate(apellido1) + ",";
        strPairs += "segundoapellido=" + EncodingUtilHelper.quotate(apellido2) + ",";
        strPairs += "login=" + EncodingUtilHelper.quotate(login) + ",";
        strPairs += "password=" + EncodingUtilHelper.quotate(password) + ",";
        strPairs += "direccion=" + EncodingUtilHelper.quotate(direccion) + ",";
        strPairs += "ciudad=" + EncodingUtilHelper.quotate(ciudad) + ",";
        strPairs += "codigopostal=" + EncodingUtilHelper.quotate(codigo_postal) + ",";
        strPairs += "provincia=" + EncodingUtilHelper.quotate(provincia) + ",";
        strPairs += "pais=" + EncodingUtilHelper.quotate(pais) + ",";
        strPairs += "email=" + EncodingUtilHelper.quotate(email) + ",";
        strPairs += "telefono=" + EncodingUtilHelper.quotate(telefono) + ",";
        strPairs += "id_tipousuario=" + id_tipousuario;
//        strPairs += "id_medico=" + id_medico;
        return strPairs;
    }

    @Override
    public UsuarioBean fill(ResultSet oResultSet, Connection pooledConnection, UsuarioBean oPusuarioBean_security, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setDni(oResultSet.getString("dni"));
        this.setNombre(oResultSet.getString("nombre"));
        this.setPrimerapellido(oResultSet.getString("apellido1"));
        this.setSegundoapellido(oResultSet.getString("apellido2"));
        this.setLogin(oResultSet.getString("login"));
        this.setPassword(oResultSet.getString("password"));
        this.setDireccion(oResultSet.getString("direccion"));
        this.setCiudad(oResultSet.getString("ciudad"));
        this.setCodigopostal(oResultSet.getString("codigo_postal"));
        this.setProvincia(oResultSet.getString("provincia"));
        this.setPais(oResultSet.getString("pais"));
        this.setEmail(oResultSet.getString("email"));
        this.setTelefono(oResultSet.getString("telefono"));

        if (expand > 0) {
            TipousuarioBean oTipousuarioBean = new TipousuarioBean();
            TipousuarioDao oTipousuarioDao = new TipousuarioDao(pooledConnection, oPusuarioBean_security, null);
            oTipousuarioBean.setId(oResultSet.getInt("id_tipousuario"));
            oTipousuarioBean = oTipousuarioDao.get(oTipousuarioBean, expand - 1);
            this.setObj_tipousuario(oTipousuarioBean);
        } else {
            this.setId_tipousuario(oResultSet.getInt("id_tipousuario"));
        }

        /*if (expand > 0) {
            MedicoBean oMedicoBean = new MedicoBean();
            MedicoDao oMedicoDao = new MedicoDao(pooledConnection, oPusuarioBean_security, null);
            oMedicoBean.setId(oResultSet.getInt("id_medico"));
            oMedicoBean = oMedicoDao.get(oMedicoBean, expand - 1);
            this.setObj_medico(oMedicoBean);
        } else {
            this.setId_medico(oResultSet.getInt("id_medico"));
        }*/
        return this;
    }

}
