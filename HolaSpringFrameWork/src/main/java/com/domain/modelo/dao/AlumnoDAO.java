package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.StringUtils;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;

import util.ConnectionManager;

public class AlumnoDAO implements DAO {

	public AlumnoDAO() {
	}
	
	@Override
	public void agregar(Model pModel) throws ClassNotFoundException, SQLException {
		try {
			//1 conectar a la base
			ConnectionManager.conectar();
			
			//2 obtengo la conexion
			Connection con = ConnectionManager.getConexion();
			
			//3 SQL
			StringBuilder sql = new StringBuilder("insert into alumnos(alu_nombre, alu_apellido, alu_email, alu_conocimientos, alu_git, alu_observaciones)")
					.append(" values(?,?,?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(sql.toString());
			Alumno alumno = (Alumno)pModel;
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellido());
			ps.setString(3, alumno.getEmail());
			ps.setString(4, alumno.getEstudios());
			ps.setString(5, alumno.getLinkARepositorio());
			ps.setString(6, alumno.getObservaciones());
			
			//4 ejecutamos
			ps.execute();
		} finally {
			//5 cerramos la conexion
			ConnectionManager.desconectar();
		}
	}

	@Override
	public void modificar(Model pModel) throws ClassNotFoundException, SQLException {
		try {
			//1 conectar a la base
			ConnectionManager.conectar();
			
			//2 obtengo la conexion
			Connection con = ConnectionManager.getConexion();
			
			//3 SQL
			StringBuilder sql = new StringBuilder("update alumnos set alu_nombre=?")
					.append(",alu_apellido=?")
					.append(",alu_email=?")
					.append(",alu_conocimientos=?")
					.append(",alu_git=?")
					.append(",alu_observaciones=?")
					.append(" where alu_id=?");
			PreparedStatement ps = con.prepareStatement(sql.toString());
			Alumno alumno = (Alumno)pModel;
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellido());
			ps.setString(3, alumno.getEmail());
			ps.setString(4, alumno.getEstudios());
			ps.setString(5, alumno.getLinkARepositorio());
			ps.setString(6, alumno.getObservaciones());
			ps.setInt(7, alumno.getCodigo());
			
			//4 ejecutamos
			ps.execute();
		} finally {
			//5 cerramos la conexion
			ConnectionManager.desconectar();
		}
	}

	@Override
	public void eliminar(Model pModel) throws ClassNotFoundException, SQLException {
		try {
			//1 conectar a la base
			ConnectionManager.conectar();
			
			//2 obtengo la conexion
			Connection con = ConnectionManager.getConexion();
			
			//3 SQL
			StringBuilder sql = new StringBuilder("delete from alumnos")
					.append(" where alu_id=?");
			PreparedStatement ps = con.prepareStatement(sql.toString());
			Alumno alumno = (Alumno)pModel;
			ps.setInt(1, alumno.getCodigo());
			
			//4 ejecutamos
			ps.execute();
		} finally {
			//5 cerramos la conexion
			ConnectionManager.desconectar();
		}
	}

	@Override
	public List<Model> leer(Model pModel) throws ClassNotFoundException, SQLException {
		List<Model> listado = null;
		try {
			//1 conectar a la base
			ConnectionManager.conectar();
			
			//2 obtengo la conexion
			Connection con = ConnectionManager.getConexion();
			
			//3 SQL	
			StringBuilder sql = new StringBuilder("select alu_id, alu_nombre, alu_apellido, alu_email, alu_conocimientos, alu_git, alu_observaciones")
					.append(" from alumnos");
			Alumno alumno = (Alumno)pModel;
			Map<Integer, Object> atributos = new HashMap<Integer, Object>();
			if (alumno.getCodigo() != 0) {
				sql.append(" where alu_id=?");
				atributos.put(1, alumno.getCodigo());
			} else {
				boolean where = false;
				int i = 1;
				if (StringUtils.hasLength(alumno.getNombre())) {
					sql.append(" where alu_nombre=?");
					where = true;
					atributos.put(i, alumno.getNombre());
					i++;
				}
				if (StringUtils.hasLength(alumno.getApellido())) {
					if (where) {
						sql.append(" and alu_apellido=?");
					} else {
						sql.append(" where alu_apellido=?");
						where = true;
					}
					atributos.put(i, alumno.getApellido());
					i++;
				}
				if (StringUtils.hasLength(alumno.getEmail())) {
					if (where) {
						sql.append(" and alu_email=?");
					} else {
						sql.append(" where alu_email=?");
						where = true;
					}
					atributos.put(i, alumno.getEmail());
					i++;
				}
				if (StringUtils.hasLength(alumno.getEstudios())) {
					if (where) {
						sql.append(" and alu_conocimientos=?");
					} else {
						sql.append(" where alu_conocimientos=?");
						where = true;
					}
					atributos.put(i, alumno.getEstudios());
					i++;
				}
				if (StringUtils.hasLength(alumno.getLinkARepositorio())) {
					if (where) {
						sql.append(" and alu_git=?");
					} else {
						sql.append(" where alu_git=?");
						where = true;
					}
					atributos.put(i, alumno.getLinkARepositorio());
					i++;
				}
				if (StringUtils.hasLength(alumno.getObservaciones())) {
					if (where) {
						sql.append(" and alu_observaciones=?");
					} else {
						sql.append(" where alu_observaciones=?");
						where = true;
					}
					atributos.put(i, alumno.getObservaciones());
					i++;
				}
			}
			PreparedStatement ps = con.prepareStatement(sql.toString());
			for (final Entry<Integer, Object> atributo : atributos.entrySet()) {
				if (atributo.getValue() instanceof Integer) {
					ps.setInt(atributo.getKey(), (Integer)atributo.getValue());
				} else if (atributo.getValue() instanceof String) {
					ps.setString(atributo.getKey(), (String)atributo.getValue());
				}
			}
			
			//4 ejecutamos y obtenemos ResultSet
			ResultSet rs = ps.executeQuery();
			
			//5 recorremos ResultSet y guardamos en un ArrayList<Model>
			listado = new ArrayList<Model>();
			while (rs.next()) {
				Alumno alu = new Alumno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				listado.add(alu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5 cerramos la conexion
			ConnectionManager.desconectar();
		}
		return listado;
	}

}
