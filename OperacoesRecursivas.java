public class OperacoesRecursivas
{
    public static void main(String[] args) {
        System.out.println(" ");

        System.out.println("Teste ehNegativo ");
        System.out.println("8 < 0 = " + ehNegativo(8));
        System.out.println("-8 < 0 = " + ehNegativo(-8));
        System.out.println(" ");

        System.out.println("Teste menor");
        System.out.println("8 < -8 = " + menor(8, -8));
        System.out.println("8 < 8 = " + menor(8, 8));
        System.out.println(" ");

        System.out.println("Teste menorIgual");
        System.out.println("8 <= -8 = " + menorIgual(8, -8));
        System.out.println("8 <= 8 = " + menorIgual(8, 8));
        System.out.println(" ");

        System.out.println("Teste maior");
        System.out.println("8 > -8 = " + maior(8, -8));
        System.out.println("8 > 8 = " + maior(8, 8));
        System.out.println(" ");

        System.out.println("Teste menor");
        System.out.println("-8 < -8 = " + subtracao(-8, -8));
        System.out.println("-8 < 8 = " + subtracao(-8, 8));
        System.out.println(" ");

        System.out.println("Teste modulo");
        System.out.println("8 = " + modulo(8));
        System.out.println("-8 = " + modulo(-8));
        System.out.println(" ");
    }

    /*Faça uma função de nome saoDiferentes que, recebendo como parâmetro dois números
    inteiros, resulta true, caso o primeiro deles seja diferente do segundo, ou false, caso
    contrário. Esta função não será recursiva, porém pode ser útil para os exercícios abaixo.*/
    public static boolean saoDiferentes(int a, int b){
        if (a == b) return false;
        return true;
    }

    /*Faça uma função de nome ehNegativo que, recebendo como parâmetro um único número
    inteiro, resulta true, caso o mesmo seja negativo, ou false, caso contrário.*/
    public static boolean ehNegativo(int n){
        if (n == 0) return false;
        return neg(n, n);
    }

    private static boolean neg(int a, int b){
        if (a == 0) return true;
        if (b == 0) return false;

        return neg(++a,--b);
    }

    /*Faça uma função de nome menor que, recebendo como parâmetro dois números inteiros,
    resulta true, caso o primeiro deles seja menor que o segundo, ou false, caso contrário.*/
    public static boolean menor(int a, int b){
        if(ehNegativo(a)){
            if(ehNegativo(b)){
                return menorNegativo(++a, ++b);
            }
            return true;
        }
        if (ehNegativo(b)){
            return false;
        }
        return menorPositivo(--a, --b);
    }

    private static boolean menorPositivo(int a, int b){
        if(b==0) return false;
        if(a==0) return true;
        return menorPositivo(--a, --b);
    }

    private static boolean menorNegativo(int a, int b){
        if(a==0) return false;
        if(b==0) return true;
        return menorNegativo(++a, ++b);
    }

    /*Faça uma função de nome menorIgual que, recebendo como parâmetro dois números
    inteiros, resulta true, caso o primeiro deles seja menor ou igual o segundo, ou false, caso
    contrário.*/
    public static boolean menorIgual(int a, int b){
        if(a==b)return true;
        return menor(a, b);
    }

    /*Faça uma função de nome maior que, recebendo como parâmetro dois números inteiros,
    resulta true, caso o primeiro deles seja maior que o segundo, ou false, caso contrário.*/
    public static boolean maior(int a, int b){
        if(a==b)
            return false;

        if(ehNegativo(a))
            if(ehNegativo(b))
                return maior(a, b);

        if(menor(a, b))
            return false;
        return true;
    }

    /*Faça uma função de nome maiorIgual que, recebendo como parâmetro dois números
    inteiros, resulta true, caso o primeiro deles seja maior ou igual o segundo, ou false, caso
    contrário.*/

    public static boolean maiorIgual(int a, int b){
        if (a == b) return true;
            return maior(a, b);
    }

    /*Faça uma função de nome soma que, recebendo como parâmetro dois números inteiros,
    resulta a soma deles.*/
    public static int soma(int a, int b){
        if(b == 0) return a;
        if(a == 0) return b;

        return somaNegativo(a, b);
        
    }

    private static int somaNegativo(int a, int b){
        if(b == 0)
            return a;

        if(ehNegativo(b))
            return somaNegativo(--a, ++b);

        return somaNegativo(++a, --b);
    }

    public static int subtracao(int a, int b){
        if(b == 0) return a;

        return subtracaoNegativo(a, b);
    }

    private static int subtracaoNegativo(int a, int b){
        if(b==0)
            return a;
        
        if(ehNegativo(b))
            return subtracaoNegativo(++a, ++b);

        return subtracaoNegativo(--a, --b);
    }

    public static int modulo(int a){
            return mod(a, 0);
    }

    private static int mod(int a, int b){
        if(a==0)
            return b;
        
        if(ehNegativo(a))
            return mod(++a, ++b);

        return a;
    }
}