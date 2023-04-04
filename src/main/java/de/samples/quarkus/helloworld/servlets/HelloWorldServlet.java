package de.samples.quarkus.helloworld.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Parameter "name"
		String name = req.getParameter("name");
		if (name == null || name.isEmpty()) {
			name = "World";
		}

		// Antwort generieren
		resp.setContentType("text/plain");
		try (PrintWriter out = resp.getWriter()) {
			out.println("<h1>Hello " + name + "</h1>");
		}
	}

}
