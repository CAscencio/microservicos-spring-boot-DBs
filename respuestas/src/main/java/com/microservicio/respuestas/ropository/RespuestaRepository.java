package com.microservicio.respuestas.ropository;

import com.microservicio.respuestas.model.Respuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {

    @Query("select r from Respuesta r join fetch r.pregunta p join fetch p.examen e where r.AlumnoId=?1 and e.id=?2")
    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);

    @Query("select e.id from Respuesta r join r.pregunta p join p.examen e where r.AlumnoId=?1 group by e.id")
    public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
}
