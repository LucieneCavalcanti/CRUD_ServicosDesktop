import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServicoRepository extends Conexao{
    public ServicoRepository() throws Exception{}
    public boolean incluir(ServicoEntity obj) throws Exception{
        String sql = "insert into tbservicos (descricao,preco) values (?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getDescricao());
        ps.setFloat(2, obj.getPreco());
        return ps.executeUpdate()>0;
    }
    public boolean editar(ServicoEntity obj) throws Exception{
        String sql = "update tbservicos set descricao=?,preco=? where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getDescricao());
        ps.setFloat(2, obj.getPreco());
        ps.setInt(3, obj.getId());
        return ps.executeUpdate()>0;
    }
    public boolean excluir(int id) throws Exception{
        String sql = "delete from tbservicos where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate()>0;
    }
    public ServicoEntity pesquisar(int id) throws Exception {
        String sql = "Select * from tbservicos " +
        " where id = ? order by descricao";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return new ServicoEntity(rs.getInt("id"), 
            rs.getString("descricao"), rs.getFloat("preco"));
        }
        return null;
    }
    public ArrayList<ServicoEntity> pesquisar (String pesquisa) throws Exception{
        ArrayList<ServicoEntity> dados = new ArrayList<>();
        String sql = "Select * from tbservicos " +
        " where descricao like ? order by descricao";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, pesquisa+"%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dados.add(new ServicoEntity(rs.getInt("id"), 
            rs.getString("descricao"), rs.getFloat("preco")));
        }
        return dados;
    }
    public ArrayList<ServicoEntity> listar () throws Exception{
        ArrayList<ServicoEntity> dados = new ArrayList<>();
        String sql = "Select * from tbservicos order by descricao";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dados.add(new ServicoEntity(rs.getInt("id"), 
            rs.getString("descricao"), rs.getFloat("preco")));
        }
        return dados;
    }
}
