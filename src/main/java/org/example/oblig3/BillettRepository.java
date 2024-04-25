package org.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Billett innBillett) {
        String sql = "INSERT INTO Billett(film, antallBilletter, navn, telefonnr, epost) VALUES(?,?,?,?,?)";
        db.update(sql,innBillett.getFilm(), innBillett.getAntallBilletter(), innBillett.getNavn(), innBillett.getTelefonnr(), innBillett.getEpost());
    }

    public List<Billett> hentBilletter() {
        String sql = "SELECT * FROM Billett ORDER BY navn";
        return db.query(sql, new BeanPropertyRowMapper(Billett.class));
    }

    public void slettBilletter() {
        String sql = "DELETE FROM Billett";
        db.update(sql);
    }

    public Billett hentBillett(int id) {
        String sql = "SELECT * FROM Billett WHERE id=?";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(Billett.class), id);
    }

    public void endreBillett(Billett billett) {
        String sql = "UPDATE Billett SET film=?, antallBilletter=?, navn=?, telefonnr=?, epost=? WHERE id=?";
        db.update(sql, billett.getFilm(), billett.getAntallBilletter(), billett.getNavn(),
                billett.getTelefonnr(), billett.getEpost(), billett.getId());
    }

    public void slettBillett(int innId) {
        String sql = "DELETE FROM Billett WHERE id=?";
        db.update(sql, innId);
    }

}
