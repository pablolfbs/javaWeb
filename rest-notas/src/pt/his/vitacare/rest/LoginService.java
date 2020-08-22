package pt.his.vitacare.rest;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import pt.his.vitacare.entidade.Credencial;

@Path("/login")
public class LoginService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fazerLogin(String credenciaisJson) {
		try {
			Gson gson = new Gson();
			Credencial credencial = gson.fromJson(credenciaisJson, Credencial.class);

			validarCredenciais(credencial);

			String token = gerarToken(credencial.getLogin(), 1);
			return Response.ok(token).build();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Status.UNAUTHORIZED).build();
	}

	private String gerarToken(String login, int i) {
		SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;

		Date agora = new Date();

		Calendar expira = Calendar.getInstance();
		expira.add(Calendar.MINUTE, 15);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("teste:123");

		SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritimoAssinatura.getJcaName());

		JwtBuilder construtor = Jwts.builder().setIssuedAt(agora).setIssuer(login).signWith(algoritimoAssinatura, key)
				.setExpiration(expira.getTime());

		return construtor.compact();
	}

	private void validarCredenciais(Credencial credencial) throws Exception {
		try {
			if (!credencial.getLogin().contentEquals("teste") || !credencial.getSenha().equals("123")) {
				throw new Exception("Credenciais não válidas");
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public Claims validaToken(String token) {

		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("teste:123"))
					.parseClaimsJws(token).getBody();

			System.out.println(claims.getIssuer());

			return claims;
		} catch (Exception e) {
			throw e;
		}
	}
}
