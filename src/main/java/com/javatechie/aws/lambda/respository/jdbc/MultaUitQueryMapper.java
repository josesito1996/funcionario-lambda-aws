package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.MultaUitQuery;

public class MultaUitQueryMapper implements RowMapper<MultaUitQuery> {

  @Override
  public MultaUitQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
    return MultaUitQuery
        .builder()
        .tipoEmpresa(rs.getString("tipo_empresa"))
        .tipoInfraccion(rs.getString("tipo_infraccion"))
        .monto(rs.getDouble("monto"))
        .montoUit(rs.getDouble("monto_uit"))
        .cantidadTrabajadores(rs.getInt("cantidad_trabajadores"))
        .montoMulta(rs.getDouble("monto_multa"))
        .build();
  }

}
