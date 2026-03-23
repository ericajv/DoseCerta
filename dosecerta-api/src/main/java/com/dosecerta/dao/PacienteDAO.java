package com.dosecerta.dao;

import com.dosecerta.model.PacienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PacienteDAO {

    @Autowired
    private DataSource dataSource;

  
    public void salvar(PacienteModel paciente) {
        String sql = "INSERT INTO paciente (nome_paciente, cpf_paciente, sexo, data_nascimento) VALUES (?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNomePaciente());

            if (paciente.getCpfPaciente() != null) {
                stmt.setString(2, paciente.getCpfPaciente());
            } else {
                stmt.setNull(2, Types.VARCHAR);
            }

            stmt.setString(3, paciente.getSexo().name());
            stmt.setDate(4, Date.valueOf(paciente.getDataNascimento()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar paciente", e);
        }
    }

    
    public void atualizar(int id, PacienteModel paciente) {
        String sql = "UPDATE paciente SET nome_paciente=?, cpf_paciente=?, sexo=?, data_nascimento=? WHERE id_paciente=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNomePaciente());

            if (paciente.getCpfPaciente() != null) {
                stmt.setString(2, paciente.getCpfPaciente());
            } else {
                stmt.setNull(2, Types.VARCHAR);
            }

            stmt.setString(3, paciente.getSexo().name());
            stmt.setDate(4, Date.valueOf(paciente.getDataNascimento()));
            stmt.setInt(5, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar paciente", e);
        }
    }

    
    public void deletar(int id) {
        String sql = "DELETE FROM paciente WHERE id_paciente=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar paciente", e);
        }
    }

    
    public Optional<PacienteModel> buscarPorId(int id) {
        String sql = "SELECT * FROM paciente WHERE id_paciente=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(mapearPaciente(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar paciente por ID", e);
        }

        return Optional.empty();
    }

   
    public List<PacienteModel> listarTodos() {
        String sql = "SELECT * FROM paciente";
        List<PacienteModel> lista = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearPaciente(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pacientes", e);
        }

        return lista;
    }

    public boolean existePorId(int id) {
        String sql = "SELECT 1 FROM paciente WHERE id_paciente=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar existência do paciente", e);
        }
    }

    
    private PacienteModel mapearPaciente(ResultSet rs) throws SQLException {
        PacienteModel p = new PacienteModel();

        p.setIdPaciente(rs.getInt("id_paciente"));
        p.setNomePaciente(rs.getString("nome_paciente"));
        p.setCpfPaciente(rs.getString("cpf_paciente"));

        String sexoStr = rs.getString("sexo");
        if (sexoStr != null) {
            p.setSexo(PacienteModel.Sexo.valueOf(sexoStr));
        }

        Date data = rs.getDate("data_nascimento");
        if (data != null) {
            p.setDataNascimento(data.toLocalDate());
        }

        return p;
    }
}