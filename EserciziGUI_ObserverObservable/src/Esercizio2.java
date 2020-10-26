import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.*;
import java.util.List;

public class Esercizio2 {
    public static void main(String[] args) {
        Model m = new Model();
        Vista v = new Vista();  // seconda vista
        Controller c = new Controller(m, v);   // controller
        
        m.addObserver(v); // aggiungo la vista come osservatore del model
        v.setController(c);	// aggancio il controller alla vista
    }
}

class Model extends Observable {
    List<String> proverbi = new ArrayList<>();
    int indiceProverbio= 0;
    
    public Model() {
        this.proverbi.add("Proverbio 1");
        this.proverbi.add("Proverbio 2");
        this.proverbi.add("Proverbio 3");
        this.proverbi.add("Proverbio 4");
        this.proverbi.add("Proverbio 5");
        this.proverbi.add("Proverbio 6");
        this.proverbi.add("Proverbio 7");
    }
    
    public List<String> getProverbi() {
        return proverbi;
    }
    
    public void setProverbi(List<String> proverbi) {
        this.proverbi = proverbi;
    }
    
    public void setNewProverbio(){
        Random random = new Random();
        indiceProverbio = random.nextInt(((proverbi.size()-1) + 1));
        
        setChanged();
        notifyObservers();
    }
    
    public String getProverbio() {
        return proverbi.get(indiceProverbio);
    }
}

// seconda versione della GUI
class Vista extends JFrame implements Observer{ // seconda view
    private JButton button;
    private JLabel proverbio;
    private JPanel panel;
    
    public Vista() {
        super("GestisciOperazioni");
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        add(panel);
        
        button = new JButton("Genera proverbio");
        panel.add(button);
        proverbio = new JLabel("Genera un proverbio!");
        panel.add(proverbio);
        
        setLocation(100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,100);
        setVisible(true);
    }
    
    public JLabel getProverbio() {
        return proverbio;
    }
    
    public void setController(Controller c) {
        button.addActionListener(c); // aggancia il listener del controller al bottone
    }
    
    @Override
    public void update(Observable ob, Object arg) {
        if (ob!=null && ob instanceof Model) {
            proverbio.setText(((Model)ob).getProverbio());
        }
    }
}

class Controller implements ActionListener {
    private Model m;
    private Vista view;
    private JLabel proverbio;
    
    public Controller(Model model, Vista vista) {
        m = model;
        view = vista;
        proverbio = view.getProverbio();
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            m.setNewProverbio();
        } catch(NumberFormatException ecc) {
            proverbio.setText("Errore");
            return;
        }
    }
}