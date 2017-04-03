package pizzaria;

import java.util.HashMap;

/**
 * 20/03/2017
 *
 * @author RAFAEL TORRES
 */
public class Pizza {

    private double preco;
    private int quantidadeDeIngredientes;
    private static HashMap<String, Integer> listaDeIngredientes = new HashMap<String, Integer>();

    /*
    Método que recebe como parâmetro o nome do ingrediente e verifica se já está incluso na lista, caso sim adiciona uma unidade a mais
    Se for um novo ingrediente adiciona ana lista e contabiliza o total de ingredientes.
     */
    public void adiconarIngrediente(String ingrediente) {

        if (listaDeIngredientes.containsKey(ingrediente)) {
            int contador = listaDeIngredientes.get(ingrediente);
            listaDeIngredientes.put(ingrediente, contador + 1);
        } else {
            listaDeIngredientes.put(ingrediente, 1);
        }

        contabilizarIngrediente();

    }

    //Método para verificar a quantidade de ingredientes da pizza e selecionar o valor correpondente
    public double getPreco() {

        if (quantidadeDeIngredientes <= 2) {

            preco = 15;

        } else if (quantidadeDeIngredientes < 6) {

            preco = 20;
        } else {
            preco = 23;
        }

        return preco;
    }

    //Método que faz o incremento dos ingredientes
    public void contabilizarIngrediente() {
        quantidadeDeIngredientes++;

    }

    //Limpa lista de ingredientes
    public static void zerarRegistroIngredientes() {
        listaDeIngredientes.clear();
    }

    //Retorno da variável estática listaDeIngredientes
    public static HashMap<String, Integer> getListaDeIngredientes() {

        return listaDeIngredientes;
    }

    public static void main(String[] args) {
        Pizza p = new Pizza();
        p.adiconarIngrediente("Queijo");
        p.adiconarIngrediente("Calabresa");
        System.out.println(p.getListaDeIngredientes());

    }
}
