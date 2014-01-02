package com.daoleen.springlearning.jdbc.dao;

import com.daoleen.springlearning.jdbc.domain.Group;
import com.daoleen.springlearning.jdbc.repository.IGroupDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/30/13
 * Time: 3:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class GroupDao implements IGroupDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    // Для преобразования строки sql в Bean используется интерфейс RowMapper<T>
    // И ниже определен статический класс, который реализует его
    @Override
    public List<Group> findAll() {
        String sql = "SELECT * FROM `Group`";
        return jdbcTemplate.query(sql, new GroupMapper());
    }

    // Используется JdbcTemplate
    @Override
    public String findGroupNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT `name` FROM `Group` WHERE ID = ?",
                new Object[] { id },
                String.class
        );
    }

    // Используется NamedParameterJdbcTemplate
    @Override
    public Long findIdByGroupName(String name) {
        String sql = "SELECT `id` FROM `Group` WHERE `name` = :groupName";

        // 1. Вариант создания карты
        SqlParameterSource namedParameters = new MapSqlParameterSource("groupName", name);

        // 2. Вариант создания карты
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("groupName", name);

        return namedParameterJdbcTemplate.queryForObject(
                sql, namedParameters, Long.class
        );
    }


    private static final class GroupMapper implements RowMapper<Group> {
        @Override
        public Group mapRow(ResultSet resultSet, int i) throws SQLException {
            Group group = new Group();
            group.setId(resultSet.getLong("id"));
            group.setName(resultSet.getString("name"));
            group.setCreatedAt(resultSet.getDate("created_at"));
            return group;
        }
    }
}
