package com.demo.transacciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.transacciones.entity.Usuario;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByUsernameAndPass(String username, String pass);
}
