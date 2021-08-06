package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Beer;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Brewery> getAllBreweries() {
        List <Brewery> breweryList = new ArrayList<>();
        String sql = "SELECT * FROM breweries ORDER BY brewery_name"; //order by for sorting order by breweries
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Brewery brewery = mapRowSetToBrewery(result);
            breweryList.add(brewery);
        }
        return breweryList;
    }
    @Override
    public Brewery getBreweryById(int id) {
        String sqlGetBrewery = "SELECT * FROM breweries WHERE brewery_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetBrewery, id);
        result.next();
        Brewery brewery = mapRowSetToBrewery(result);
        return brewery;
    }
    @Override
    public long createBrewery(Brewery newBrewery) {
        String sqlInsert = "INSERT INTO breweries(name, contactInfo, history, operationTime, address, city, state, zipCode, website) VALUES(?,?,?,?,?,?,?,?,?) RETURNING brewery_id";
        long newId =
                jdbcTemplate.queryForObject(sqlInsert, Long.class, newBrewery.getName(),newBrewery.getContactInfo(), newBrewery.getHistory(), newBrewery.getHistory(), newBrewery.getOperationTime(),
                        newBrewery.getAddress(), newBrewery.getCity(), newBrewery.getState(), newBrewery.getZipCode(), newBrewery.getWebsite());
        return newId;
    }
    @Override
    public void deleteBrewery(int id) {
        String sql = "DELETE FROM breweries WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public void updateBrewery(Brewery oneBrewery) {
        String sql = "UPDATE Breweries SET brewery_name =?, contact_info =?, brewery_history =?, operation_time =?, " +
                "address =?, city =?, state_abrev =?, zip =?, website =? WHERE brewery_id = ?";
        jdbcTemplate.update(sql, oneBrewery.getName(),oneBrewery.getContactInfo(), oneBrewery.getHistory(), oneBrewery.getHistory(), oneBrewery.getOperationTime(),
                oneBrewery.getAddress(), oneBrewery.getCity(), oneBrewery.getState(), oneBrewery.getZipCode(), oneBrewery.getWebsite(), oneBrewery.getId());
    }
    @Override
    public List<Brewery> getAllBreweriesWithGFBeer() {
        List<Brewery> gfList = new ArrayList<>();
        String sqlGetGfree = "SELECT * FROM breweries JOIN beers ON beers.brewery_id = breweries.brewery_id WHERE beers.gluten_free = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetGfree, true);
        while(result.next()) {
            gfList.add(mapRowSetToBrewery(result));
        }
        return gfList;
    }
    private Brewery mapRowSetToBrewery(SqlRowSet result) {
        Brewery brewery = new Brewery();
        brewery.setId(result.getInt("brewery_id"));
        brewery.setActive(result.getBoolean("active"));
        brewery.setCity(result.getString("city"));
        brewery.setHistory(result.getString("brewery_history"));
        brewery.setContactInfo(result.getString("contact_info"));
        brewery.setName(result.getString("brewery_name"));
        brewery.setState(result.getString("state_abrev"));
        brewery.setAddress(result.getString("address"));
        brewery.setWebsite(result.getString("website"));
        brewery.setZipCode(result.getString("zip"));
        brewery.setImage(result.getString("image"));
        brewery.setOperationTime(result.getString("operation_time"));
        brewery.setFoodServedId(result.getLong("food_served"));
        return brewery;
    }
}