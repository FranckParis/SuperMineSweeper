/*
package view;

import model.GameModel;

import java.awt.geom.Dimension2D;
import java.util.Observable;
import java.util.Observer;


public final class MainFrame implements Observer {

    public Grid grid;
    public int timer;

    public MainFrame()
    {
        super();

        build();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void build()
    {
        //setTitle("Démineur");
        this.timer =0;
        //this.setLayout(new BorderLayout());
        GameModel g = new GameModel();
        g.addObserver(this);
        this.grid = new Grid(9,9,10, new Dimension2D(40,40), g);

        this.info = new JPanel();
        time = new JLabel();
        flags = new JLabel();

        this.text = new JPanel();
        textf = new JLabel();
        textt = new JLabel();

        this.center = new JPanel();

        time.setText("0");
        flags.setText("10");

        textf.setText("Flags");
        textt.setText("Timer");


        info.add(time, FlowLayout.LEFT);
        info.add(flags, FlowLayout.CENTER);

        text.add(textt, FlowLayout.LEFT);
        text.add(textf, FlowLayout.CENTER);

        this.menubar = new JMenuBar();
        JMenu menu = new JMenu("Nouvelle partie");
        menubar.add(menu);

        JMenuItem menuItem1 = new JMenuItem("Niveau Facile",MouseEvent.BUTTON1);
        menuItem1.addActionListener((ActionEvent e) -> {
            this.timer = 0;
            grid.removeAll();
            GameModel gm = new GameModel();
            gm.addObserver(this);
            grid.build(9, 9, 10, new Dimension(40,40), gm);
            flags.setText("10");
            add(grid,BorderLayout.SOUTH);
            this.pack();
            validate();
        });
        menu.add(menuItem1);


        JMenuItem menuItem2 = new JMenuItem("Niveau Moyen",MouseEvent.BUTTON1);
        menuItem2.addActionListener((ActionEvent e) -> {
            this.timer = 0;
            grid.removeAll();
            GameModel gm = new GameModel();
            gm.addObserver(this);
            grid.build(16, 16, 40, new Dimension(35,35), gm);
            flags.setText("40");
            add(grid,BorderLayout.SOUTH);
            this.pack();
            validate();
        });
        menu.add(menuItem2);

        JMenuItem menuItem3 = new JMenuItem("Niveau Difficile",MouseEvent.BUTTON1);
        menuItem3.addActionListener((ActionEvent e) -> {
            this.timer = 0;
            grid.removeAll();
            GameModel gm = new GameModel();
            gm.addObserver(this);
            grid.build(16, 30, 99, new Dimension(30,30), gm);
            flags.setText("99");
            add(grid,BorderLayout.SOUTH);
            this.pack();
            validate();
        });
        menu.add(menuItem3);
        flags.setVisible(true);
        time.setVisible(true);
        textt.setVisible(true);
        textf.setVisible(true);

        this.add(menubar,BorderLayout.NORTH);

        center.add(text, BorderLayout.NORTH);
        center.add(info, BorderLayout.SOUTH);

        this.add(center, BorderLayout.CENTER);

        this.add(this.grid,BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        GameModel gm = (GameModel) o;
        if(gm.getGameStatus() == 1){
            JOptionPane.showMessageDialog(this, "Bien joué ! Rejouez !");
        }
        else if(gm.getGameStatus() == 2){
            JOptionPane.showMessageDialog(this, "Partie perdue, réessayez ! ", "Défaite!", JOptionPane.ERROR_MESSAGE);
        }
        if(gm.getVal()>this.timer+1){
            gm.setRunning(false);
        }
        this.timer = gm.getVal();

        flags.setText(Integer.toString(gm.getNbFlagsRemaining()));
        time.setText(Integer.toString(gm.getVal()));

    }


    @Override
    public void update(Observable o, Object arg) {

    }
}

*/