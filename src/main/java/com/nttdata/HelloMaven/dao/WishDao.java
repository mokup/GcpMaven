package com.nttdata.HelloMaven.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nttdata.HelloMaven.entity.Show;


@Component
public class WishDao {
	
	private static final Logger logger = LoggerFactory.getLogger(WishDao.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;  
	
    
    public List findAll() throws Exception{
    	try {
	    	logger.info("Logging findAll - Start");
	    	List toRet = jdbcTemplate.query("select * from public.tabellatest", new ShowRowMapper());
	    	if(toRet!=null) logger.info("Logging findAll - End - size:"+toRet.size());
	    	else logger.warn("Logging findAll - END - Errore dati");
	    	return toRet;
    	}
    	catch(Exception ex) {
    		logger.error("Logging findAll - END",ex);
    		throw ex;
    	}
    	
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
