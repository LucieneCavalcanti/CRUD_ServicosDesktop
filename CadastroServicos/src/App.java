import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao = 0;
        Scanner ler = new Scanner(System.in);
        ServicoRepository DAO = new ServicoRepository();
        ServicoEntity obj = new ServicoEntity();

        do{
            try {
                System.out.println("---MENU---");
                System.out.println("1 - Cadastrar serviço");
                System.out.println("2 - Editar serviço");
                System.out.println("3 - Excluir serviço");
                System.out.println("4 - Listar serviços");
                System.out.println("5 - Pesquisar serviços por descrição");
                System.out.println("6 - Pesquisar serviços por id");
                System.out.println("10 - SAIR");
                System.out.print("------> Digite uma opção:");
                opcao = ler.nextInt();
                switch (opcao) {
                    case 1:
                        obj = new ServicoEntity();
                        System.out.print("\nDigite a descrição:");
                        obj.setDescricao(ler.next());
                        System.out.print("\nDigite o preço: ");
                        obj.setPreco(ler.nextFloat());
                        //gravar no BD (insert)
                        if(DAO.incluir(obj)) System.out.println(" ##### Serviço Salvo com sucesso #####");
                        else System.out.println("Erro ao salvar.");
                        break;
                    case 2:
                        obj = new ServicoEntity();
                        System.out.print("\nDigite o id do Serviço a ser editado:");
                        obj.setId(ler.nextInt());
                        System.out.print("\nDigite a descrição:");
                        obj.setDescricao(ler.next());
                        System.out.print("\nDigite o preço: ");
                        obj.setPreco(ler.nextFloat());
                        //gravar no BD (insert)
                        if(DAO.editar(obj)) System.out.println(" ##### Serviço Atualizado com sucesso #####");
                        else System.out.println("Erro ao atualizar.");
                        break;
                    case 3:
                        System.out.println("Digite o id a ser excluído: ");
                        int idExclusao = ler.nextInt();
                        if(DAO.excluir(idExclusao)) System.out.println(" ----- Serviço excluído com sucesso -----");
                        else System.out.println("Erro ao excluir.");
                        break;
                    case 4:
                        System.out.println(DAO.listar());
                        break;
                    case 5:
                        System.out.println("Digite parte da descrição a ser pesquisada: ");
                        String pesquisa = ler.next();
                        ArrayList<ServicoEntity> lista = new ArrayList<>();
                        lista = DAO.pesquisar(pesquisa);
                        if(lista.size()==0) System.out.println("----> Não encontrado");
                        else System.out.println(lista);
                        break;
                    case 6:
                        System.out.println("Digite o id a ser pesquisado: ");
                        int id = ler.nextInt();
                        obj = DAO.pesquisar(id);
                        if(obj==null) System.out.println("----> Não encontrado");
                        else System.out.println(obj);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("======== Erro: " + e.getMessage() + " ========");
                ler.next();
            }
            
        }while(opcao!=10);
    }
}
