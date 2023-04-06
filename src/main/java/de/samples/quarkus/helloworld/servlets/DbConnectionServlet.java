package de.samples.quarkus.helloworld.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@SuppressWarnings("serial")
@WebServlet("/db")
public class DbConnectionServlet extends HttpServlet {

	@Inject
	DataSource ds;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Antwort generieren
		resp.setContentType("text/plain");
		try (PrintWriter out = resp.getWriter(); Connection con = ds.getConnection()) {
			out.println(con.getMetaData().getDriverName());
			out.println(con.getMetaData().getDriverVersion());
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
