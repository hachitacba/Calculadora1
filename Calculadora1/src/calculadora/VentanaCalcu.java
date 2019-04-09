/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import negocio.Calculos;
/**
 *
 * @author Aldo
 */
public class VentanaCalcu extends JFrame {

    private JButton btnsuma;
    private JButton btnresta;
    private JButton btnmultip;
    private JButton btndivid;
    private JButton btnborra;
    private JButton btnresult;
    private JTextField txtdisplay;

    private String mem1, mem2, signo;

    public VentanaCalcu() {
        this.setTitle("Calculadora 1");
        this.setLayout(null);
        this.setSize(230, 220);
        this.setResizable(false);

        txtdisplay = new JTextField("");
        txtdisplay.setHorizontalAlignment(4);
        txtdisplay.setLocation(10, 20);
        txtdisplay.setSize(190, 20);

        btnsuma = new JButton(" + ");
        btnsuma.setLocation(10, 50);
        btnsuma.setSize(50, 50);

        btnmultip = new JButton("*");
        btnmultip.setLocation(10, 110);
        btnmultip.setSize(50, 50);

        btnresta = new JButton("-");
        btnresta.setLocation(80, 50);
        btnresta.setSize(50, 50);

        btndivid = new JButton("/");
        btndivid.setLocation(80, 110);
        btndivid.setSize(50, 50);

        btnborra = new JButton(" C ");
        btnborra.setLocation(150, 50);
        btnborra.setSize(50, 50);

        btnresult = new JButton(" = ");
        btnresult.setLocation(150, 110);
        btnresult.setSize(50, 50);

        this.getContentPane().add(txtdisplay);
        this.getContentPane().add(btnsuma);
        this.getContentPane().add(btnresta);
        this.getContentPane().add(btndivid);
        this.getContentPane().add(btnmultip);
        this.getContentPane().add(btnresult);
        this.getContentPane().add(btnborra);

        btnsuma.addActionListener(new EscuchaAcction());
        btnresta.addActionListener(new EscuchaAcction());
        btnmultip.addActionListener(new EscuchaAcction());
        btndivid.addActionListener(new EscuchaAcction());
        btnresult.addActionListener(new EscuchaAcction());
        btnborra.addActionListener(new EscuchaAcction());
    }

    class EscuchaAcction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnsuma) {
                if (!txtdisplay.getText().equals("")) {
                    mem1 = txtdisplay.getText();
                    signo = "+";
                    txtdisplay.setText("");

                }
            }
            if (e.getSource() == btnresta) {
                if (!txtdisplay.getText().equals("")) {
                    mem1 = txtdisplay.getText();
                    signo = "-";
                    txtdisplay.setText("");

                }
            }
            if (e.getSource() == btndivid) {
                if (!txtdisplay.getText().equals("")) {
                    mem1 = txtdisplay.getText();
                    signo = "/";
                    txtdisplay.setText("");
                }

            }
            if (e.getSource() == btnmultip) {
                if (!txtdisplay.getText().equals("")) {
                    mem1 = txtdisplay.getText();
                    signo = "+";
                    txtdisplay.setText("");

                }
            }

            if (e.getSource() == btnresult) {
                String resultado;
                if (!txtdisplay.getText().equals("")) {
                    mem2 = txtdisplay.getText();
                    resultado = calculos(mem1, signo, mem2);
                    txtdisplay.setText(resultado);

                }
            }
            if (e.getSource() == btnborra) {
                txtdisplay.setText("");
            }

        }

        private String calculos(String mem1, String signo, String mem2) {
            int num1, num2;
            String respuesta;
            Double resultado = 0.0;
            if (signo.equals("-")) {
                resultado = Double.parseDouble(mem1) - Double.parseDouble(mem2);
            }
            if (signo.equals("+")) {
                resultado = Double.parseDouble(mem1) + Double.parseDouble(mem2);
            }
            if (signo.equals("/")) {
                resultado = Double.parseDouble(mem1) / Double.parseDouble(mem2);
            }
            if (signo.equals("*")) {
                resultado = Double.parseDouble(mem1) * Double.parseDouble(mem2);
            }
            respuesta = resultado.toString();
            return respuesta;
        }
    }

}
