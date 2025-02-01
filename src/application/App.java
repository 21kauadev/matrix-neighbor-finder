package application;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of columns: ");
        int m = sc.nextInt();

        System.out.print("Enter the number of lines: ");
        int n = sc.nextInt();

        int matrixOfNumbers[][] = new int[m][n];

        System.out.println("Enter the values of the matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixOfNumbers[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter a number to search in the matrix: ");
        int isNumberEqual = sc.nextInt();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixOfNumbers[i][j] == isNumberEqual) {
                    // o que diz respeito a coluna é o i
                    // o que diz respeito a linha é j

                    // se a soma for maior do que j (ou seja, o indice atual) não existe e,
                    // portanto, o valor é nulo. caso seja nulo, atribuo o valor 0 por padrão. se
                    // não for nulo só somo e acho o valor próximo.
                    int validRightIndex = (j + 1) >= matrixOfNumbers[i].length ? 0 : (j + 1);

                    // mesma lógica pros outros.
                    int validLeftIndex = (j - 1) < 0 ? 0 : (j - 1);
                    int validUpIndex = (i - 1) < 0 ? 0 : (i - 1); // se i for 1 e eu subtrair 1 dele, obviamente será
                                                                  // 0.
                    int validDownIndex = (i + 1) >= matrixOfNumbers[i].length ? 0 : (i + 1);

                    int left = matrixOfNumbers[i][validLeftIndex];
                    int right = matrixOfNumbers[i][validRightIndex];
                    int up = matrixOfNumbers[validUpIndex][j];
                    int down = matrixOfNumbers[validDownIndex][j];

                    System.out.printf("Position %d,%d%n", i, j);

                    // checagem pra ver se há indices presentes em cada posição.

                    // checa se tem um valor presente na esquerda. se tiver (valor da linha for
                    // diferente de 0, pois atrbuí 0 caso não fosse válido) será mostrado.
                    if (j != 0)
                        System.out.println("Left: " + left);

                    // checa se tem um valor presente na esquerda, calculando o valor da coluna e
                    // vendo se ele é maior do que o limite máximo de indices
                    if ((j + 1) < matrixOfNumbers[i].length)
                        System.out.println("Right: " + right);

                    // checa se tem um valor presente acima, na coluna acima, que encontramos
                    // subtraindo 1 de i. se i fosse 0, subtraindo 1 dele, teriamos um indice que
                    // não existe (-1).

                    if (i != 0)
                        System.out.println("Up: " + up);

                    // checa se tem um valor presente abaixo, calculando o valor da coluna e
                    // vendo se ele é menor do que o limite mínimo de indices
                    if ((i + 1) < matrixOfNumbers.length)
                        System.out.println("Down: " + down);

                }
            }
        }

        sc.close();
    }
}
