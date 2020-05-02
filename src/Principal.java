
/**
 * Implementação de Lista Sequencial de forma orientada a objeto utilizando ArrayList.
 *
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    /**
     * Método principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Declara e instancia a lista.
         */
        ArrayList<No> lista = new ArrayList<>();

        // Controla o menu da lista
        int opcao = -1;

        //Laço do menu de opções
        while (opcao != 99) {
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Lista Sequencial ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 1- Listar Nós\n"
                    + " 2- Inserir Nó no início\n"
                    + " 3- Inserir Nó em uma posição especifica\n"
                    + " 4- Inserir Nó no fim\n"
                    + " 5- Inserir Nó ordenado\n"
                    + " 6- Remover Nó do início\n"
                    + " 7- Remover Nó de uma posição específica\n"
                    + " 8- Remover Nó do fim\n"
                    + " 9- Remover Nó pelo valor\n"
                    + "10- Procurar o dado de uma posição específica\n"
                    + "11- Procurar a posição de um dado\n"
                    + "12- Mostrar a quantidade de Nós\n"
                    + "13- Está vazia?\n"
                    + "99- Sair\n"));
            switch (opcao) {
                case 1: {
                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia!");
                    } else {
                        String saida = "Listagem \n";
                        int i = 1;
                        for (No no : lista) {
                            saida = saida + (i) + "-" + no.paraString() + "\n";
                            i = i + 1;
                        }
                        JOptionPane.showMessageDialog(null, saida);
                    }
                    break;
                }
                case 2: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    No novo = new No(dado);
                    lista.add(0, novo);
                    JOptionPane.showMessageDialog(null, "Nó inserido no início com Sucesso!");
                    break;
                }
                case 3: {
                    //Le a posição a ser inserido o nó
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição:"));
                    //Preenche o valor do dado                    
                    int dado = leitura();
                    No novo = new No(dado);
                    lista.add(k, novo);
                    JOptionPane.showMessageDialog(null, "Nó inserido na posição " + k + " com Sucesso!");
                    break;
                }
                case 4: {
                    //Preenche o valor do dado                    
                    int dado = leitura();
                    No novo = new No(dado);
                    lista.add(novo);
                    JOptionPane.showMessageDialog(null, "Nó inserido no fim com Sucesso!");
                    break;
                }
                case 5: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    No novo = new No(dado);

                    //Procura a posição de inserção
                    int posicao = -1, i = 0;
                    No procurar = null;
                    //Vazio insere no início
                    if (lista.isEmpty()) {
                        lista.add(0,novo);
                    } else {
                        //Procura posicao
                        for (No no : lista) {
                            if (no.getDado() < novo.getDado()) {
                                i = i + 1;
                            } else {
                                posicao = i;
                            }
                        }
                        //Insere no fim
                        if (posicao == -1) {
                            lista.add(novo);
                        } else {
                            //Insere na posição                            
                            lista.add(posicao, novo);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Nó inserido ordenado com Sucesso!");

                    break;
                }
                case 6: {
                    if (lista.remove(0) != null) {
                        JOptionPane.showMessageDialog(null, "Nó do início foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó do início não foi excluído!");
                    }
                    break;
                }

                case 7: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição a ser excluída:"));
                    if (lista.remove(k) != null) {
                        JOptionPane.showMessageDialog(null, "O valor da posição " + k + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 8: {
                    if (lista.remove(lista.size() - 1) != null) {
                        JOptionPane.showMessageDialog(null, "Nó do fim foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó do fim não foi excluído!");
                    }
                    break;
                }
                case 9: {
                    //Preenche o valor do dado                    
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do Nó a ser excluído:"));
                    //Procura o objeto com o dado
                    No procurar = null;
                    for (No no : lista) {
                        if (no.getDado() == dado) {
                            procurar = no;
                        }
                    }
                    if (lista.remove(procurar)) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 10: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do dado a ser procurada:"));
                    No no = lista.get(k);
                    if (no != null) {
                        JOptionPane.showMessageDialog(null, "O valor da posição " + k + "  possui o dado = " + no.getDado());
                    } else {
                        JOptionPane.showMessageDialog(null, "A posição " + k + " não está preenchida");
                    }
                    break;
                }
                case 11: {
                    //Preenche o valor do dado
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser procurado:"));
                    //Procura o objeto com o dado
                    No procurar = null;
                    for (No no : lista) {
                        if (no.getDado() == dado) {
                            procurar = no;
                        }
                    }
                    int posicao = lista.indexOf(procurar);
                    JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + posicao);
                    break;
                }
                case 12: {
                    JOptionPane.showMessageDialog(null, "Quantidade de Nós na lista : " + lista.size());
                    break;
                }
                case 13: {
                    JOptionPane.showMessageDialog(null, "Lista está vazia : " + lista.isEmpty());
                    break;
                }
                //Opção de saída do programa
                case 99: {
                    System.out.println("Saindo do programa!");
                    break;
                }
                //Opção inválida do menu
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }//Fim switch
        }//Fim while
    }//Fim main
}//Fim Principal
