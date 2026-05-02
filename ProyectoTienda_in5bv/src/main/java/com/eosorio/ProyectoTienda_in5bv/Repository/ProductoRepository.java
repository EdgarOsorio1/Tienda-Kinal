package com.eosorio.ProyectoTienda_in5bv.Repository;

import com.eosorio.ProyectoTienda_in5bv.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Aquí ya tienes heredados métodos como findAll(), save(), deleteById(), etc.
}
