package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.jdbc.MultaUitQuery;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MultaUitJdbc {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public MultaUitQuery viewMultaUitQuery(String tipoEmpresa, String tipoInfraccion,
      Integer cantidadTrabajadores) {
    log.info("MultaUitJdbc.viewMultaUitQuery");
    List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR),
        new SqlParameter(Types.NVARCHAR), new SqlParameter(Types.INTEGER));
    return transformToList(jdbcTemplate.call(new CallableStatementCreator() {
      @Override
      public CallableStatement createCallableStatement(Connection con) throws SQLException {
        CallableStatement cs = con.prepareCall("{call SP_calcula_multa_por_uit(?,?,?)}");
        cs.setString(1, tipoEmpresa);
        cs.setString(2, tipoInfraccion);
        cs.setInt(3, cantidadTrabajadores);
        return cs;
      }
    }, parameters));
  }

  @SuppressWarnings("unchecked")
  private MultaUitQuery transformToList(Map<String, Object> mapResult) {
    log.info("MultaUitJdbc.transformToList");
    if (mapResult.isEmpty()) {
      return MultaUitQuery.builder().build();
    }
    MultaUitQuery multaUit = new MultaUitQuery();
    Object result = mapResult.get("#result-set-1");
    if (result instanceof List) {
      List<Map<String, Object>> newList = (List<Map<String, Object>>) result;
      for (Map<String, Object> map : newList) {
        multaUit = MultaUitQuery.builder().tipoEmpresa(map.get("tipo_empresa").toString())
            .tipoInfraccion(map.get("tipo_infraccion").toString())
            .monto(Double.parseDouble(map.get("monto").toString()))
            .montoUit(Double.parseDouble(map.get("monto_uit").toString()))
            .cantidadTrabajadores(Integer.parseInt(map.get("cantidad_trabajadores").toString()))
            .montoMulta(Double.parseDouble(map.get("monto_multa").toString())).build();
        break;
      }
    }
    return multaUit;
  }

}
