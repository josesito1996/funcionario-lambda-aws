package com.javatechie.aws.lambda.respository.jdbc;

import static com.javatechie.aws.lambda.util.Utils.convertToDateViaInstant;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.aws.lambda.domain.jdbc.PuntuacionInspector;
import com.javatechie.aws.lambda.domain.jdbc.PuntuacionMaestro;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class PuntuacionJdbc {

    private static final String QUERY_INSERT_MAESTRO = "insert into puntuacion_maestro "
            + "(item_valoracion,puntaje_maximo,estado) " + "values (?, ?, ?);";

    private static final String QUERY_INSERT_PUNTUACION_INSPECTOR = "insert into puntuacion_inspector"
            + " (user_name,fecha_registro,id_inspector,id_puntuacion_maestro,calificacion) values "
            + "(?,?,?,?,?);";

    private static final String QUERY_GET_MAESTRO_BY_ID = "select * from puntuacion_maestro where id_item = ?;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PuntuacionMaestro verPorId(int idMaestro) {
        log.info("PuntuacionJdbc.verPorId");
        PuntuacionMaestro puntuacion = jdbcTemplate.queryForObject(QUERY_GET_MAESTRO_BY_ID,
                new PuntuacionMaestroMapper(), new Object[] { idMaestro });
        return puntuacion;
    }

    @Transactional
    public PuntuacionMaestro insertarPuntuacionMaestro(PuntuacionMaestro puntuacion) {
        log.info("PuntuacionJdbc.insertarPuntuacionMaestro");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(QUERY_INSERT_MAESTRO,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, puntuacion.getItemValoracion());
            ps.setInt(2, puntuacion.getPuntajeMaximo());
            ps.setBoolean(3, puntuacion.isEstado());
            return ps;
        }, keyHolder);

        int id = keyHolder.getKey().intValue();
        return verPorId(id);
    }

    @Transactional
    public int[][] insertarPuntuacionInspector(List<PuntuacionInspector> puntuaciones) {
        log.info("PuntuacionJdbc.insertarPuntuacionInspector");
        return jdbcTemplate.batchUpdate(QUERY_INSERT_PUNTUACION_INSPECTOR, puntuaciones,
                puntuaciones.size(),
                new ParameterizedPreparedStatementSetter<PuntuacionInspector>() {
                    public void setValues(PreparedStatement ps, PuntuacionInspector argument)
                            throws SQLException {
                        ps.setString(1, argument.getUserName());
                        ps.setDate(2, new Date(
                                convertToDateViaInstant(argument.getFechaRegistro()).getTime()));
                        ps.setString(3, argument.getIdInspector());
                        ps.setInt(4, argument.getIdPuntuacionMaestro());
                        ps.setInt(5, argument.getCalificacion());
                    }
                });
    }
}
