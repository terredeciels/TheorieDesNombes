package visualiser;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Visu extends Canvas {
    int[] Valeurs;
    int WIDTH = 600;
    int HEIGHT = 600;
    Color NOIR = new Color(50, 50, 50);
    Color BLEU = new Color(0, 0, 255);
    Color BLEU1 = new Color(50, 50, 251);
    Color BLEU2 = new Color(100, 100, 255);
    Color BLEU3 = new Color(150, 150, 255);
    Color BLEU4 = new Color(200, 200, 255);
    Color ROUGE = new Color(255, 0, 0);
    Color VERT = new Color(0, 255, 0);
    Graphics g;
    int zoom = 16;
    int taille = 2;
    int N;
    int[][] tab;
    BiConsumer<Integer, Integer> F;

    {
        F = new BiConsumer<>() {

            @Override
            public void accept(Integer x, Integer y) {
                int X = zoom * x;
                int Y = zoom * y;
                // if (x <= y)

                if (tab[x][y] == 6) {
                    g.setColor(NOIR);
                    g.drawRect(X, Y, taille, taille);
                    g.fillRect(X, Y, taille, taille);
                }

                //g.setColor(new Color((int)(pow(2,6))*mat[x][y]));
                int m = tab[x][y];
//                int c0=25,c1=50,c2=75;
//                g.setColor(new Color(m*255/c0,m*255/c1,m*255/c2));
                //g.drawRect(X, Y, taille, taille);
                //g.fillRect(X, Y, taille, taille);

//                if (m < 5) {
//                    //g.setColor(NOIR);
//                    g.setColor(BLEU1);
//                    tracer(X, Y);
//                }
//                if (m > 5 && m < 10) {
//                    //g.setColor(ROUGE);
//                    g.setColor(BLEU2);
//                    tracer(X, Y);
//                }
//                if (m > 10 && m < 15) {
//                    //g.setColor(BLEU);
//                    g.setColor(BLEU3);
//                    tracer(X, Y);
//                }
//                if (m > 15) {
//                   // g.setColor(VERT);
//                    g.setColor(BLEU4);
//                    tracer(X, Y);
//                }
//                switch (mat[x][y]) {
//
//                    case 1 -> {
//                        g.setColor(NOIR);
//                        tracer(X, Y);
//                    }
//                    case 4 -> {
//                        g.setColor(ROUGE);
//                        tracer(X, Y);
//                    }
//                    case 8 -> {
//                        g.setColor(VERT);
//                        tracer(X, Y);
//                    }
//                }
            }
        };
    }

    public Visu(int[][] matrice, int n, int[] valeurs) {
        Valeurs = valeurs;
        N = n - 1;
        tab = matrice;
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.add(this);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void tracer(Integer x, Integer y) {
        g.drawRect(x, y, taille, taille);
        g.fillRect(x, y, taille, taille);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.g = g;
        range(1, N).forEach(i -> rangeClosed(1, N).forEach(j -> F.accept(i, j)));

    }

}