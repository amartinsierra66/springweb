package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Libro;

@Service(value="instanciaBd")
public class LibrosServiceBDImpl implements LibrosService {
	
	@Autowired
	DataSource ds;

	@Override
	public Libro libroPorIsbn(int isbn) {
		try(Connection con=ds.getConnection();){
			String sql="select * from libros where isbn=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, isbn);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				return new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("tematica"));
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Libro> librosPorTematica(String tematica) {
		List<Libro> libros=new ArrayList<Libro>();
		try(Connection con=ds.getConnection();){
			String sql="select * from libros where tematica=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, tematica);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				libros.add(new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("tematica")));
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return libros;
	}

}
