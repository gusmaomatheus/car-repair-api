package br.com.gusmaomatheus.api.application.security;

import br.com.gusmaomatheus.api.application.auth.JWTService;
import br.com.gusmaomatheus.api.model.entity.Usuario;
import br.com.gusmaomatheus.api.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SegurancaFiltro extends OncePerRequestFilter {
    private final JWTService tokenService;
    private final UsuarioRepository usuarioRepository;

    public SegurancaFiltro(JWTService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String token = authHeader.replace("Bearer ", "");
            final String subject = tokenService.getSubject(token);
            final Usuario usuario = (Usuario) usuarioRepository.findByLogin(subject);
            final Authentication auth = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}