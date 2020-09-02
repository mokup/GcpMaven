package com.nttdata.HelloMaven.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nttdata.HelloMaven.entity.Show;

@Repository
@Component
public class WishDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;  
	
    
    public List findAll() {
        return jdbcTemplate.query("select * from public.tabellatest", new ShowRowMapper());
    }
	
}


class ShowRowMapper implements RowMapper {

	@Override
    public Show mapRow(ResultSet rs, int rowNum) throws SQLException {
        Show show = new Show();
        show.setId(rs.getInt("ID"));
        show.setNome(rs.getString("Nome"));
        show.setDescrizione(rs.getString("Descrizione"));
        return show;
    }

	
    
}
