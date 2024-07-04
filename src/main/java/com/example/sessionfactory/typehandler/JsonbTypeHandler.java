package com.example.sessionfactory.typehandler;

import com.example.sessionfactory.domain.PanchayatMember;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.List;

public class JsonbTypeHandler extends BaseTypeHandler<List<PanchayatMember>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<PanchayatMember> parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setObject(i, objectMapper.writeValueAsString(parameter), Types.OTHER);
        } catch (JsonProcessingException e) {
            throw new SQLException("Error converting List to JSON string", e);
        }
    }

    @Override
    public List<PanchayatMember> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convertJsonToList(rs.getString(columnName));
    }

    @Override
    public List<PanchayatMember> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convertJsonToList(rs.getString(columnIndex));
    }

    @Override
    public List<PanchayatMember> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convertJsonToList(cs.getString(columnIndex));
    }

    private List<PanchayatMember> convertJsonToList(String json) throws SQLException {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, PanchayatMember.class));
        } catch (JsonProcessingException e) {
            throw new SQLException("Error converting JSON string to List", e);
        }
    }
}
