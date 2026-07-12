package com.sl.dao;


import com.sl.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO {

   @Autowired
   JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD Ops
    public List<Product> getAllProducts(){
        String sqlCommand = "select * from products";
        List<Product> products = jdbcTemplate.query(sqlCommand, new ProductRowMapper());

        return products;
    }

}


// ProductRowMapper class
class ProductRowMapper implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getFloat("price"));
        product.setDescription(rs.getString("description"));

        return product;
    }
}
