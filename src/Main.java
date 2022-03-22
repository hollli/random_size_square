import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

class Main extends JFrame {
    private static final long serialVersionUID = 1L;
    int [] hights = new int[5];
    Color [] colors = new Color[5];
    public Main() {
        setLayout(null);
        setSize(750,400);

        JButton btnSort = new JButton("sort");
        btnSort.setBounds(300,300,150,50);
        add(btnSort);
        btnSort.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                sort();
                setSize(751,400);
            }
        });
        rnw();
        setVisible(true);
    }
    public void sort(){
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < hights.length-1; i++) {
                if(hights[i] > hights[i+1]){
                    isSorted = false;
                    buf = hights[i];
                    hights[i] = hights[i+1];
                    hights[i+1] = buf;
                }
            }
        }
       System.out.println(Arrays.toString(hights));
    }
    public void rnw(){
        Random hght = new Random();
        for (int i=0;i<5;i++) {
            hights[i] = hght.nextInt(200);
            colors[i] = new Color(hght.nextInt(256), hght.nextInt(256), hght.nextInt(256));
        }
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D mysquare = (Graphics2D) g;
        Random random = new Random();

        for (int i=0;i<5;i++) {
            mysquare.setColor(colors[i]);
            mysquare.fillRect(22+150*i, 100, 50,hights[i]);
        }
    }

    public static void main(String args[]) {
        Main app = new Main();
    }
}