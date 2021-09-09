package Lesson6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        test();
        test2();
    }

    private static void test() {
        // количество бинарных деревьев
        int treesNumber = 20;

        // глубина дерева
        int inDepth = 4;

        // диапазон для генерации случайного значения
        int min = -25, max = 25;

        int balanced = 0;

        for(int i = 0; i < treesNumber; i++){
            BiTree tree = new BiTree();
            fillTree(tree, min, max, inDepth);

            if(tree.isBalanced(tree.getRoot()))
                balanced++;
        }
        System.out.println("Тест 1");
        System.out.println("Из " + treesNumber + " BiTree сбалансированы " + balanced + "\r\nнесбалансированы " + (treesNumber- balanced) + " деревьев");
        System.out.println("Несбалансированы " + ((((float) (treesNumber - balanced)) * 100) / (float) treesNumber) + " %");
    }

    private static void fillTree(BiTree<Integer> tree, int min, int max, int inDepth) {

        Random rnd = new Random();
        while (tree.height(tree.getRoot()) < inDepth){
            int randomNum = rnd.ints(1, min, max).findFirst().getAsInt();
            tree.add(randomNum);
        }
    }

    private static void test2() {
        System.out.println("\nТест 2");
        Random rnd = new Random();
        BiTree tree = new BiTree();
        fillTree(tree,- 25, 25, 4);
        tree.display();

        String str = tree.isBalanced(tree.getRoot())? "Дерево сбалансировано": "Дерево не сбалансировано";
        System.out.println(str);
    }

}
