package entidades;

import java.awt.*;
import java.awt.event.*;

public class PlotFiguras2D extends Frame {
    /* Frame � a janela gr�fica onde as figuras ser�o dispostas */
    Pilha pf;
    /*� o vetor de Figuras que servira de container para adicionar as figuras.
    * 
    */

    private static final long serialVersionUID = 1L;

    /**
    * Um objeto PlotFiguras2D � criado. 
    **/
    // public static void main(String args[]) {
    //     new PlotFiguras2D();
    // }

    /**
    * Our PlotFiguras2D constructor sets the frame's size, adds the
    * visual components, and then makes them visible to the user.
    * It uses an adapter class to deal with the user closing
    * the frame.
    * O construtor de PlotFiguras2D define o tamanho do frame, adiciona componentes visuais, como o t�tulo
    * deixa o frame vis�vel para o usu�rio.
    **/
    public PlotFiguras2D(Pilha pf) {
        //Title our frame.
        super("Pilha de Figuras - A Figura mais interna está no topo");
        this.pf = pf;
        //Set the size for the frame.
        setSize(500,400);

        //We need to turn on the visibility of our frame
        //by setting the Visible parameter to true.
        setVisible(true);

        //Now, we want to be sure we properly dispose of resources
        //this frame is using when the window is closed.  We use
        //an anonymous inner class adapter for this.
        /* foi criado aqui um adapatador de classe para que a janela responda
        * corretamente  aos eventos de fechamento. Sem este adaptador a janela n�o fechara ao clique 
        * do close window
        */
        addWindowListener(new WindowAdapter()
          {public void windowClosing(WindowEvent e)
          {dispose(); System.exit(0);}
          }
        );
    }

    /**
    042    * The paint method provides the real magic.  Here we
    043    * cast the Graphics object to Graphics2D to illustrate
    044    * that we may use the same old graphics capabilities with
    * Graphics2D that we are used to using with Graphics.
    **/
    public void paint(Graphics g) {
        int nf,i=0;
        Figura f;
        //Here is how we used to draw a square with width
        //of 200, height of 200, and starting at x=50, y=50.
        g.setColor(Color.red);
        // g.drawRect(50,50,200,200);

        //Let's set the Color to blue and then use the Graphics2D
        //object to draw a rectangle, offset from the square.
        //So far, we've not done anything using Graphics2D that
        //we could not also do using Graphics.  (We are actually
        //using Graphics2D methods inherited from Graphics.)
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.blue);
        // g2d.drawRect(75,75,300,200);



        while(!pf.vazia()) {
            f = (Figura) pf.desempilhe();

            if( f instanceof Circulo ) {
                Circulo c = (Circulo) f;
                g2d.drawOval(c.getX() - c.getRaio() ,  c.getY() - c.getRaio() ,  2*c.getRaio() ,  2*c.getRaio());  		
            } else if (f instanceof Quadrado) {
                Quadrado q =(Quadrado) f;
                g2d.drawRect(q.getX()-q.getLado()/2,q.getY()-q.getLado()/2,q.getLado(),q.getLado());
            }
        }
    }
}