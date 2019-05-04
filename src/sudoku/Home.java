/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author HebaM
 */
public class Home extends javax.swing.JFrame {

    public String consult = "consult('Sudoku.pl')";
    public Query initiation = new Query(consult);
    public String level = null;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * Queries the knowledge base to check if the answer entered by the user is
     * correct or not.
     *
     */
    public void checkAns() {
        try {
            //System.out.println(consult + "" + (initiation.hasMoreSolutions() ? "Good" : "Fail"));
            //Checks if the user has selected a level
            if (!(comboBox_Level.getSelectedIndex() == -1 || comboBox_Level.getSelectedIndex() == 0)) {
                //Ensures that the user has filled all the cells
                if (checktxt1() && checktxt2() && checktxt3() && checktxt4() && checktxt5() && checktxt6() && checktxt7() && checktxt8() && checktxt9()) {
                    //If the user selected a level and filled all the cells
                    String solution = "solve_problem(["
                            + "[" + Integer.parseInt(this.txt1_1.getText()) + "," + Integer.parseInt(this.txt1_2.getText()) + "," + Integer.parseInt(this.txt1_3.getText()) + "," + Integer.parseInt(this.txt1_4.getText()) + "," + Integer.parseInt(this.txt1_5.getText()) + "," + Integer.parseInt(this.txt1_6.getText()) + "," + Integer.parseInt(this.txt1_7.getText()) + "," + Integer.parseInt(this.txt1_8.getText()) + "," + Integer.parseInt(this.txt1_9.getText()) + "],"
                            + "[" + Integer.parseInt(this.txt2_1.getText()) + "," + Integer.parseInt(this.txt2_2.getText()) + "," + Integer.parseInt(this.txt2_3.getText()) + "," + Integer.parseInt(this.txt2_4.getText()) + "," + Integer.parseInt(this.txt2_5.getText()) + "," + Integer.parseInt(this.txt2_6.getText()) + "," + Integer.parseInt(this.txt2_7.getText()) + "," + Integer.parseInt(this.txt2_8.getText()) + "," + Integer.parseInt(this.txt2_9.getText()) + "],"
                            + "[" + Integer.parseInt(this.txt3_1.getText()) + "," + Integer.parseInt(this.txt3_2.getText()) + "," + Integer.parseInt(this.txt3_3.getText()) + "," + Integer.parseInt(this.txt3_4.getText()) + "," + Integer.parseInt(this.txt3_5.getText()) + "," + Integer.parseInt(this.txt3_6.getText()) + "," + Integer.parseInt(this.txt3_7.getText()) + "," + Integer.parseInt(this.txt3_8.getText()) + "," + Integer.parseInt(this.txt3_9.getText()) + "],"
                            + "[" + Integer.parseInt(this.txt4_1.getText()) + "," + Integer.parseInt(this.txt4_2.getText()) + "," + Integer.parseInt(this.txt4_3.getText()) + "," + Integer.parseInt(this.txt4_4.getText()) + "," + Integer.parseInt(this.txt4_5.getText()) + "," + Integer.parseInt(this.txt4_6.getText()) + "," + Integer.parseInt(this.txt4_7.getText()) + "," + Integer.parseInt(this.txt4_8.getText()) + "," + Integer.parseInt(this.txt4_9.getText()) + "],"
                            + "[" + Integer.parseInt(this.txt5_1.getText()) + "," + Integer.parseInt(this.txt5_2.getText()) + "," + Integer.parseInt(this.txt5_3.getText()) + "," + Integer.parseInt(this.txt5_4.getText()) + "," + Integer.parseInt(this.txt5_5.getText()) + "," + Integer.parseInt(this.txt5_6.getText()) + "," + Integer.parseInt(this.txt5_7.getText()) + "," + Integer.parseInt(this.txt5_8.getText()) + "," + Integer.parseInt(this.txt5_9.getText()) + "],"
                            + "[" + Integer.parseInt(this.txt6_1.getText()) + "," + Integer.parseInt(this.txt6_2.getText()) + "," + Integer.parseInt(this.txt6_3.getText()) + "," + Integer.parseInt(this.txt6_4.getText()) + "," + Integer.parseInt(this.txt6_5.getText()) + "," + Integer.parseInt(this.txt6_6.getText()) + "," + Integer.parseInt(this.txt6_7.getText()) + "," + Integer.parseInt(this.txt6_8.getText()) + "," + Integer.parseInt(this.txt6_9.getText()) + "],"
                            + "[" + Integer.parseInt(this.txt7_1.getText()) + "," + Integer.parseInt(this.txt7_2.getText()) + "," + Integer.parseInt(this.txt7_3.getText()) + "," + Integer.parseInt(this.txt7_4.getText()) + "," + Integer.parseInt(this.txt7_5.getText()) + "," + Integer.parseInt(this.txt7_6.getText()) + "," + Integer.parseInt(this.txt7_7.getText()) + "," + Integer.parseInt(this.txt7_8.getText()) + "," + Integer.parseInt(this.txt7_9.getText()) + "],"
                            + "[" + Integer.parseInt(this.txt8_1.getText()) + "," + Integer.parseInt(this.txt8_2.getText()) + "," + Integer.parseInt(this.txt8_3.getText()) + "," + Integer.parseInt(this.txt8_4.getText()) + "," + Integer.parseInt(this.txt8_5.getText()) + "," + Integer.parseInt(this.txt8_6.getText()) + "," + Integer.parseInt(this.txt8_7.getText()) + "," + Integer.parseInt(this.txt8_8.getText()) + "," + Integer.parseInt(this.txt8_9.getText()) + "],"
                            + "[" + Integer.parseInt(this.txt9_1.getText()) + "," + Integer.parseInt(this.txt9_2.getText()) + "," + Integer.parseInt(this.txt9_3.getText()) + "," + Integer.parseInt(this.txt9_4.getText()) + "," + Integer.parseInt(this.txt9_5.getText()) + "," + Integer.parseInt(this.txt9_6.getText()) + "," + Integer.parseInt(this.txt9_7.getText()) + "," + Integer.parseInt(this.txt9_8.getText()) + "," + Integer.parseInt(this.txt9_9.getText()) + "]"
                            + "])";//Holds the prolog query

                    Query query = new Query(solution);//Holds the results obtained from the query
                    if (query.hasSolution()) {
                        //If the solution is correct
                        JOptionPane.showMessageDialog(null, "Good work, you successfully completed this level.", "Good", JOptionPane.INFORMATION_MESSAGE);
                        clearTextFields();
                        comboBox_Level.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please try again", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }//end of if-else
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: Please fill all the cells", "ERROR", JOptionPane.ERROR_MESSAGE);
                }//end of if-else
            } else {
                JOptionPane.showMessageDialog(null, "Please choose a level to start playing.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }//end of if-else
        } catch (Exception exception) {
            exception.printStackTrace();
        }//end of try-catch
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 1st raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt1() {
        return (!this.txt1_1.getText().isEmpty() && !this.txt1_2.getText().isEmpty() && !this.txt1_3.getText().isEmpty() && !this.txt1_4.getText().isEmpty() && !this.txt1_5.getText().isEmpty() && !this.txt1_6.getText().isEmpty() && !this.txt1_7.getText().isEmpty() && !this.txt1_8.getText().isEmpty() && !this.txt1_9.getText().isEmpty());
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 2nd raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt2() {
        return (!this.txt2_1.getText().isEmpty() && !this.txt2_2.getText().isEmpty() && !this.txt2_3.getText().isEmpty() && !this.txt2_4.getText().isEmpty() && !this.txt2_5.getText().isEmpty() && !this.txt2_6.getText().isEmpty() && !this.txt2_7.getText().isEmpty() && !this.txt2_8.getText().isEmpty() && !this.txt2_9.getText().isEmpty());
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 3rd raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt3() {
        return (!this.txt3_1.getText().isEmpty() && !this.txt3_2.getText().isEmpty() && !this.txt3_3.getText().isEmpty() && !this.txt3_4.getText().isEmpty() && !this.txt3_5.getText().isEmpty() && !this.txt3_6.getText().isEmpty() && !this.txt3_7.getText().isEmpty() && !this.txt3_8.getText().isEmpty() && !this.txt3_9.getText().isEmpty());
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 4th raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt4() {
        return (!this.txt4_1.getText().isEmpty() && !this.txt4_2.getText().isEmpty() && !this.txt4_3.getText().isEmpty() && !this.txt4_4.getText().isEmpty() && !this.txt4_5.getText().isEmpty() && !this.txt4_6.getText().isEmpty() && !this.txt4_7.getText().isEmpty() && !this.txt4_8.getText().isEmpty() && !this.txt4_9.getText().isEmpty());
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 5th raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt5() {
        return (!this.txt5_1.getText().isEmpty() && !this.txt5_2.getText().isEmpty() && !this.txt5_3.getText().isEmpty() && !this.txt5_4.getText().isEmpty() && !this.txt5_5.getText().isEmpty() && !this.txt5_6.getText().isEmpty() && !this.txt5_7.getText().isEmpty() && !this.txt5_8.getText().isEmpty() && !this.txt5_9.getText().isEmpty());
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 6th raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt6() {
        return (!this.txt6_1.getText().isEmpty() && !this.txt6_2.getText().isEmpty() && !this.txt6_3.getText().isEmpty() && !this.txt6_4.getText().isEmpty() && !this.txt6_5.getText().isEmpty() && !this.txt6_6.getText().isEmpty() && !this.txt6_7.getText().isEmpty() && !this.txt6_8.getText().isEmpty() && !this.txt6_9.getText().isEmpty());
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 7th raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt7() {
        return (!this.txt7_1.getText().isEmpty() && !this.txt7_2.getText().isEmpty() && !this.txt7_3.getText().isEmpty() && !this.txt7_4.getText().isEmpty() && !this.txt7_5.getText().isEmpty() && !this.txt7_6.getText().isEmpty() && !this.txt7_7.getText().isEmpty() && !this.txt7_8.getText().isEmpty() && !this.txt7_9.getText().isEmpty());
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 8th raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt8() {
        return (!this.txt8_1.getText().isEmpty() && !this.txt8_2.getText().isEmpty() && !this.txt8_3.getText().isEmpty() && !this.txt8_4.getText().isEmpty() && !this.txt8_5.getText().isEmpty() && !this.txt8_6.getText().isEmpty() && !this.txt8_7.getText().isEmpty() && !this.txt8_8.getText().isEmpty() && !this.txt8_9.getText().isEmpty());
    }

    /**
     * Returns a boolean value indicating whether the user filled all the cells
     * in the 9th raw
     *
     * @return true if all cells are filled. Otherwise,false
     */
    public boolean checktxt9() {
        return (!this.txt9_1.getText().isEmpty() && !this.txt9_2.getText().isEmpty() && !this.txt9_3.getText().isEmpty() && !this.txt9_4.getText().isEmpty() && !this.txt9_5.getText().isEmpty() && !this.txt9_6.getText().isEmpty() && !this.txt9_7.getText().isEmpty() && !this.txt9_8.getText().isEmpty() && !this.txt9_9.getText().isEmpty());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel19 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        comboBox_Level = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        txt4_8 = new javax.swing.JTextField();
        txt4_7 = new javax.swing.JTextField();
        txt4_9 = new javax.swing.JTextField();
        txt5_7 = new javax.swing.JTextField();
        txt5_8 = new javax.swing.JTextField();
        txt5_9 = new javax.swing.JTextField();
        txt6_7 = new javax.swing.JTextField();
        txt6_8 = new javax.swing.JTextField();
        txt6_9 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        txt1_5 = new javax.swing.JTextField();
        txt1_4 = new javax.swing.JTextField();
        txt1_6 = new javax.swing.JTextField();
        txt2_4 = new javax.swing.JTextField();
        txt2_5 = new javax.swing.JTextField();
        txt2_6 = new javax.swing.JTextField();
        txt3_4 = new javax.swing.JTextField();
        txt3_5 = new javax.swing.JTextField();
        txt3_6 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        txt7_2 = new javax.swing.JTextField();
        txt7_1 = new javax.swing.JTextField();
        txt7_3 = new javax.swing.JTextField();
        txt8_1 = new javax.swing.JTextField();
        txt8_2 = new javax.swing.JTextField();
        txt8_3 = new javax.swing.JTextField();
        txt9_1 = new javax.swing.JTextField();
        txt9_2 = new javax.swing.JTextField();
        txt9_3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txt4_5 = new javax.swing.JTextField();
        txt4_4 = new javax.swing.JTextField();
        txt4_6 = new javax.swing.JTextField();
        txt5_4 = new javax.swing.JTextField();
        txt5_5 = new javax.swing.JTextField();
        txt5_6 = new javax.swing.JTextField();
        txt6_4 = new javax.swing.JTextField();
        txt6_5 = new javax.swing.JTextField();
        txt6_6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txt1_2 = new javax.swing.JTextField();
        txt1_1 = new javax.swing.JTextField();
        txt1_3 = new javax.swing.JTextField();
        txt2_1 = new javax.swing.JTextField();
        txt2_2 = new javax.swing.JTextField();
        txt2_3 = new javax.swing.JTextField();
        txt3_1 = new javax.swing.JTextField();
        txt3_2 = new javax.swing.JTextField();
        txt3_3 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        txt7_5 = new javax.swing.JTextField();
        txt7_4 = new javax.swing.JTextField();
        txt7_6 = new javax.swing.JTextField();
        txt8_4 = new javax.swing.JTextField();
        txt8_5 = new javax.swing.JTextField();
        txt8_6 = new javax.swing.JTextField();
        txt9_4 = new javax.swing.JTextField();
        txt9_5 = new javax.swing.JTextField();
        txt9_6 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        txt4_2 = new javax.swing.JTextField();
        txt4_1 = new javax.swing.JTextField();
        txt4_3 = new javax.swing.JTextField();
        txt5_1 = new javax.swing.JTextField();
        txt5_2 = new javax.swing.JTextField();
        txt5_3 = new javax.swing.JTextField();
        txt6_1 = new javax.swing.JTextField();
        txt6_2 = new javax.swing.JTextField();
        txt6_3 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        txt7_8 = new javax.swing.JTextField();
        txt7_7 = new javax.swing.JTextField();
        txt7_9 = new javax.swing.JTextField();
        txt8_7 = new javax.swing.JTextField();
        txt8_8 = new javax.swing.JTextField();
        txt8_9 = new javax.swing.JTextField();
        txt9_7 = new javax.swing.JTextField();
        txt9_8 = new javax.swing.JTextField();
        txt9_9 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        txt1_8 = new javax.swing.JTextField();
        txt1_7 = new javax.swing.JTextField();
        txt1_9 = new javax.swing.JTextField();
        txt2_7 = new javax.swing.JTextField();
        txt2_8 = new javax.swing.JTextField();
        txt2_9 = new javax.swing.JTextField();
        txt3_7 = new javax.swing.JTextField();
        txt3_8 = new javax.swing.JTextField();
        txt3_9 = new javax.swing.JTextField();
        check = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel19.setBackground(new java.awt.Color(163, 228, 215));

        title.setFont(new java.awt.Font("Bradley Hand", 3, 24)); // NOI18N
        title.setForeground(new java.awt.Color(91, 44, 111));
        title.setText("Sudoku Game");

        comboBox_Level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Level", "1- Easy", "2- Meduim", "3- Hard" }));
        comboBox_Level.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBox_LevelItemStateChanged(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(163, 228, 215));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txt4_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_8FocusLost(evt);
            }
        });
        txt4_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_8KeyTyped(evt);
            }
        });

        txt4_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_7FocusLost(evt);
            }
        });
        txt4_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_7KeyTyped(evt);
            }
        });

        txt4_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_9FocusLost(evt);
            }
        });
        txt4_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_9KeyTyped(evt);
            }
        });

        txt5_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_7FocusLost(evt);
            }
        });
        txt5_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_7KeyTyped(evt);
            }
        });

        txt5_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_8FocusLost(evt);
            }
        });
        txt5_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_8KeyTyped(evt);
            }
        });

        txt5_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_9FocusLost(evt);
            }
        });
        txt5_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_9KeyTyped(evt);
            }
        });

        txt6_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt6_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_7FocusLost(evt);
            }
        });
        txt6_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_7KeyTyped(evt);
            }
        });

        txt6_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt6_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_8FocusLost(evt);
            }
        });
        txt6_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_8KeyTyped(evt);
            }
        });

        txt6_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_9FocusLost(evt);
            }
        });
        txt6_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_9KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(txt4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt4_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(txt5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(txt6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt6_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6_9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(163, 228, 215));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        txt1_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_5FocusLost(evt);
            }
        });
        txt1_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_5KeyTyped(evt);
            }
        });

        txt1_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_4FocusLost(evt);
            }
        });
        txt1_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_4KeyTyped(evt);
            }
        });

        txt1_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_6FocusLost(evt);
            }
        });
        txt1_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_6KeyTyped(evt);
            }
        });

        txt2_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_4FocusLost(evt);
            }
        });
        txt2_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_4KeyTyped(evt);
            }
        });

        txt2_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_5FocusLost(evt);
            }
        });
        txt2_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_5KeyTyped(evt);
            }
        });

        txt2_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_6FocusLost(evt);
            }
        });
        txt2_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_6KeyTyped(evt);
            }
        });

        txt3_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txt3_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_4FocusLost(evt);
            }
        });
        txt3_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_4KeyTyped(evt);
            }
        });

        txt3_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt3_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_5FocusLost(evt);
            }
        });
        txt3_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_5KeyTyped(evt);
            }
        });

        txt3_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt3_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_6FocusLost(evt);
            }
        });
        txt3_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(txt1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(txt2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(txt3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel12.setBackground(new java.awt.Color(163, 228, 215));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        txt7_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_2FocusLost(evt);
            }
        });
        txt7_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_2KeyTyped(evt);
            }
        });

        txt7_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_1FocusLost(evt);
            }
        });
        txt7_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_1KeyTyped(evt);
            }
        });

        txt7_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_3FocusLost(evt);
            }
        });
        txt7_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_3KeyTyped(evt);
            }
        });

        txt8_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_1FocusLost(evt);
            }
        });
        txt8_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_1KeyTyped(evt);
            }
        });

        txt8_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_2FocusLost(evt);
            }
        });
        txt8_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_2KeyTyped(evt);
            }
        });

        txt8_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_3FocusLost(evt);
            }
        });
        txt8_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_3KeyTyped(evt);
            }
        });

        txt9_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_1FocusLost(evt);
            }
        });
        txt9_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_1KeyTyped(evt);
            }
        });

        txt9_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_2FocusLost(evt);
            }
        });
        txt9_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_2KeyTyped(evt);
            }
        });

        txt9_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_3FocusLost(evt);
            }
        });
        txt9_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(txt7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(txt8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(txt9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(163, 228, 215));

        txt4_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_5FocusLost(evt);
            }
        });
        txt4_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_5KeyTyped(evt);
            }
        });

        txt4_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_4FocusLost(evt);
            }
        });
        txt4_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_4KeyTyped(evt);
            }
        });

        txt4_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_6FocusLost(evt);
            }
        });
        txt4_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_6KeyTyped(evt);
            }
        });

        txt5_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_4FocusLost(evt);
            }
        });
        txt5_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_4KeyTyped(evt);
            }
        });

        txt5_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_5FocusLost(evt);
            }
        });
        txt5_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_5KeyTyped(evt);
            }
        });

        txt5_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_6FocusLost(evt);
            }
        });
        txt5_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_6KeyTyped(evt);
            }
        });

        txt6_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt6_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_4FocusLost(evt);
            }
        });
        txt6_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_4KeyTyped(evt);
            }
        });

        txt6_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt6_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_5FocusLost(evt);
            }
        });
        txt6_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_5KeyTyped(evt);
            }
        });

        txt6_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt6_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_6FocusLost(evt);
            }
        });
        txt6_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txt4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txt5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txt6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(163, 228, 215));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        txt1_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_2FocusLost(evt);
            }
        });
        txt1_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_2KeyTyped(evt);
            }
        });

        txt1_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_1FocusLost(evt);
            }
        });
        txt1_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_1KeyTyped(evt);
            }
        });

        txt1_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_3FocusLost(evt);
            }
        });
        txt1_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_3KeyTyped(evt);
            }
        });

        txt2_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_1FocusLost(evt);
            }
        });
        txt2_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_1KeyTyped(evt);
            }
        });

        txt2_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_2FocusLost(evt);
            }
        });
        txt2_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_2KeyTyped(evt);
            }
        });

        txt2_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_3FocusLost(evt);
            }
        });
        txt2_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_3KeyTyped(evt);
            }
        });

        txt3_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt3_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_1FocusLost(evt);
            }
        });
        txt3_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_1KeyTyped(evt);
            }
        });

        txt3_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt3_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_2FocusLost(evt);
            }
        });
        txt3_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_2KeyTyped(evt);
            }
        });

        txt3_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt3_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_3FocusLost(evt);
            }
        });
        txt3_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txt1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txt2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txt3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel18.setBackground(new java.awt.Color(163, 228, 215));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        txt7_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_5FocusLost(evt);
            }
        });
        txt7_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_5KeyTyped(evt);
            }
        });

        txt7_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_4FocusLost(evt);
            }
        });
        txt7_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_4KeyTyped(evt);
            }
        });

        txt7_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_6FocusLost(evt);
            }
        });
        txt7_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_6KeyTyped(evt);
            }
        });

        txt8_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_4FocusLost(evt);
            }
        });
        txt8_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_4KeyTyped(evt);
            }
        });

        txt8_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_5FocusLost(evt);
            }
        });
        txt8_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_5KeyTyped(evt);
            }
        });

        txt8_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_6FocusLost(evt);
            }
        });
        txt8_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_6KeyTyped(evt);
            }
        });

        txt9_4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_4FocusLost(evt);
            }
        });
        txt9_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_4KeyTyped(evt);
            }
        });

        txt9_5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_5FocusLost(evt);
            }
        });
        txt9_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_5KeyTyped(evt);
            }
        });

        txt9_6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_6FocusLost(evt);
            }
        });
        txt9_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(txt7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(txt8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt8_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(txt9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8_5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(163, 228, 215));

        txt4_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_2FocusLost(evt);
            }
        });
        txt4_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_2KeyTyped(evt);
            }
        });

        txt4_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_1FocusLost(evt);
            }
        });
        txt4_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_1KeyTyped(evt);
            }
        });

        txt4_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt4_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt4_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt4_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4_3FocusLost(evt);
            }
        });
        txt4_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt4_3KeyTyped(evt);
            }
        });

        txt5_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_1FocusLost(evt);
            }
        });
        txt5_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_1KeyTyped(evt);
            }
        });

        txt5_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_2FocusLost(evt);
            }
        });
        txt5_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_2KeyTyped(evt);
            }
        });

        txt5_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt5_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt5_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt5_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5_3FocusLost(evt);
            }
        });
        txt5_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt5_3KeyTyped(evt);
            }
        });

        txt6_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt6_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_1FocusLost(evt);
            }
        });
        txt6_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_1KeyTyped(evt);
            }
        });

        txt6_2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt6_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_2FocusLost(evt);
            }
        });
        txt6_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_2KeyTyped(evt);
            }
        });

        txt6_3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt6_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt6_3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt6_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6_3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6_3FocusLost(evt);
            }
        });
        txt6_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt6_3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(txt4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(txt5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(txt6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(163, 228, 215));

        txt7_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_8FocusLost(evt);
            }
        });
        txt7_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_8KeyTyped(evt);
            }
        });

        txt7_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_7FocusLost(evt);
            }
        });
        txt7_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_7KeyTyped(evt);
            }
        });

        txt7_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt7_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt7_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt7_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt7_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7_9FocusLost(evt);
            }
        });
        txt7_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt7_9KeyTyped(evt);
            }
        });

        txt8_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_7FocusLost(evt);
            }
        });
        txt8_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_7KeyTyped(evt);
            }
        });

        txt8_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_8FocusLost(evt);
            }
        });
        txt8_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_8KeyTyped(evt);
            }
        });

        txt8_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt8_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt8_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt8_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt8_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt8_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt8_9FocusLost(evt);
            }
        });
        txt8_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt8_9KeyTyped(evt);
            }
        });

        txt9_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_7FocusLost(evt);
            }
        });
        txt9_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_7KeyTyped(evt);
            }
        });

        txt9_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_8FocusLost(evt);
            }
        });
        txt9_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_8KeyTyped(evt);
            }
        });

        txt9_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt9_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt9_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt9_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt9_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt9_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt9_9FocusLost(evt);
            }
        });
        txt9_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt9_9KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(txt7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(txt8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt8_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt8_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(txt9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8_8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8_9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        txt1_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_8FocusLost(evt);
            }
        });
        txt1_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_8KeyTyped(evt);
            }
        });

        txt1_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_7FocusLost(evt);
            }
        });
        txt1_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_7KeyTyped(evt);
            }
        });

        txt1_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt1_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt1_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt1_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1_9FocusLost(evt);
            }
        });
        txt1_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1_9KeyTyped(evt);
            }
        });

        txt2_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_7FocusLost(evt);
            }
        });
        txt2_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_7KeyTyped(evt);
            }
        });

        txt2_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_8FocusLost(evt);
            }
        });
        txt2_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_8KeyTyped(evt);
            }
        });

        txt2_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt2_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt2_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt2_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_9FocusLost(evt);
            }
        });
        txt2_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2_9KeyTyped(evt);
            }
        });

        txt3_7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt3_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_7FocusLost(evt);
            }
        });
        txt3_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_7KeyTyped(evt);
            }
        });

        txt3_8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt3_8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_8FocusLost(evt);
            }
        });
        txt3_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_8KeyTyped(evt);
            }
        });

        txt3_9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt3_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt3_9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt3_9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3_9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3_9FocusLost(evt);
            }
        });
        txt3_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt3_9KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(txt1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(txt2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(txt3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        check.setText("Check");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(title))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(comboBox_Level, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(check)))
                .addGap(17, 17, 17))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addComponent(title)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboBox_Level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))
                                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(check)))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jMenu1.setText("Help");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt4_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_8FocusGained
        this.txt4_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_8FocusGained

    private void txt4_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_8FocusLost
        this.txt4_8.setBackground(Color.white);
    }//GEN-LAST:event_txt4_8FocusLost

    private void txt4_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_8KeyTyped

    private void txt4_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_7FocusGained
        this.txt4_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_7FocusGained

    private void txt4_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_7FocusLost
        this.txt4_7.setBackground(Color.white);
    }//GEN-LAST:event_txt4_7FocusLost

    private void txt4_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_7KeyTyped

    private void txt4_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_9FocusGained
        this.txt4_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_9FocusGained

    private void txt4_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_9FocusLost
        this.txt4_9.setBackground(Color.white);
    }//GEN-LAST:event_txt4_9FocusLost

    private void txt4_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_9KeyTyped

    private void txt5_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_7FocusGained
        this.txt5_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_7FocusGained

    private void txt5_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_7FocusLost
        this.txt5_7.setBackground(Color.white);
    }//GEN-LAST:event_txt5_7FocusLost

    private void txt5_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_7KeyTyped

    private void txt5_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_8FocusGained
        this.txt5_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_8FocusGained

    private void txt5_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_8FocusLost
        this.txt5_8.setBackground(Color.white);
    }//GEN-LAST:event_txt5_8FocusLost

    private void txt5_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_8KeyTyped

    private void txt5_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_9FocusGained
        this.txt5_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_9FocusGained

    private void txt5_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_9FocusLost
        this.txt5_9.setBackground(Color.white);
    }//GEN-LAST:event_txt5_9FocusLost

    private void txt5_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_9KeyTyped

    private void txt6_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_7FocusGained
        this.txt6_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_7FocusGained

    private void txt6_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_7FocusLost
        this.txt6_7.setBackground(Color.white);
    }//GEN-LAST:event_txt6_7FocusLost

    private void txt6_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_7KeyTyped

    private void txt6_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_8FocusGained
        this.txt6_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_8FocusGained

    private void txt6_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_8FocusLost
        this.txt6_8.setBackground(Color.white);
    }//GEN-LAST:event_txt6_8FocusLost

    private void txt6_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_8KeyTyped

    private void txt6_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_9FocusGained
        this.txt6_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_9FocusGained

    private void txt6_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_9FocusLost
        this.txt6_9.setBackground(Color.white);
    }//GEN-LAST:event_txt6_9FocusLost

    private void txt6_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_9KeyTyped

    private void txt1_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_5FocusGained
        this.txt1_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_5FocusGained

    private void txt1_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_5FocusLost
        this.txt1_5.setBackground(Color.white);
    }//GEN-LAST:event_txt1_5FocusLost

    private void txt1_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_5KeyTyped

    private void txt1_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_4FocusGained
        this.txt1_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_4FocusGained

    private void txt1_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_4FocusLost
        this.txt1_4.setBackground(Color.white);
    }//GEN-LAST:event_txt1_4FocusLost

    private void txt1_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_4KeyTyped

    private void txt1_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_6FocusGained
        this.txt1_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_6FocusGained

    private void txt1_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_6FocusLost
        this.txt1_6.setBackground(Color.white);
    }//GEN-LAST:event_txt1_6FocusLost

    private void txt1_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_6KeyTyped

    private void txt2_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_4FocusGained
        this.txt2_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_4FocusGained

    private void txt2_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_4FocusLost
        this.txt2_4.setBackground(Color.white);
    }//GEN-LAST:event_txt2_4FocusLost

    private void txt2_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_4KeyTyped

    private void txt2_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_5FocusGained
        this.txt2_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_5FocusGained

    private void txt2_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_5FocusLost
        this.txt2_5.setBackground(Color.white);
    }//GEN-LAST:event_txt2_5FocusLost

    private void txt2_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_5KeyTyped

    private void txt2_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_6FocusGained
        this.txt2_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_6FocusGained

    private void txt2_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_6FocusLost
        this.txt2_6.setBackground(Color.white);
    }//GEN-LAST:event_txt2_6FocusLost

    private void txt2_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_6KeyTyped

    private void txt3_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_4FocusGained
        this.txt3_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_4FocusGained

    private void txt3_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_4FocusLost
        this.txt3_4.setBackground(Color.white);
    }//GEN-LAST:event_txt3_4FocusLost

    private void txt3_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_4KeyTyped

    private void txt3_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_5FocusGained
        this.txt3_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_5FocusGained

    private void txt3_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_5FocusLost
        this.txt3_5.setBackground(Color.white);
    }//GEN-LAST:event_txt3_5FocusLost

    private void txt3_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_5KeyTyped

    private void txt3_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_6FocusGained
        this.txt3_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_6FocusGained

    private void txt3_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_6FocusLost
        this.txt3_6.setBackground(Color.white);
    }//GEN-LAST:event_txt3_6FocusLost

    private void txt3_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_6KeyTyped

    private void txt7_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_2FocusGained
        this.txt7_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_2FocusGained

    private void txt7_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_2FocusLost
        this.txt7_2.setBackground(Color.white);
    }//GEN-LAST:event_txt7_2FocusLost

    private void txt7_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_2KeyTyped

    private void txt7_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_1FocusGained
        this.txt7_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_1FocusGained

    private void txt7_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_1FocusLost
        this.txt7_1.setBackground(Color.white);
    }//GEN-LAST:event_txt7_1FocusLost

    private void txt7_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_1KeyTyped

    private void txt7_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_3FocusGained
        this.txt7_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_3FocusGained

    private void txt7_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_3FocusLost
        this.txt7_3.setBackground(Color.white);
    }//GEN-LAST:event_txt7_3FocusLost

    private void txt7_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_3.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_3KeyTyped

    private void txt8_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_1FocusGained
        this.txt8_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_1FocusGained

    private void txt8_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_1FocusLost
        this.txt8_1.setBackground(Color.white);
    }//GEN-LAST:event_txt8_1FocusLost

    private void txt8_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_1KeyTyped

    private void txt8_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_2FocusGained
        this.txt8_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_2FocusGained

    private void txt8_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_2FocusLost
        this.txt8_2.setBackground(Color.white);
    }//GEN-LAST:event_txt8_2FocusLost

    private void txt8_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_2KeyTyped

    private void txt8_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_3FocusGained
        this.txt8_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_3FocusGained

    private void txt8_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_3FocusLost
        this.txt8_3.setBackground(Color.white);
    }//GEN-LAST:event_txt8_3FocusLost

    private void txt8_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_3.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_3KeyTyped

    private void txt9_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_1FocusGained
        this.txt9_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_1FocusGained

    private void txt9_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_1FocusLost
        this.txt9_1.setBackground(Color.white);
    }//GEN-LAST:event_txt9_1FocusLost

    private void txt9_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_1KeyTyped

    private void txt9_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_2FocusGained
        this.txt9_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_2FocusGained

    private void txt9_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_2FocusLost
        this.txt9_2.setBackground(Color.white);
    }//GEN-LAST:event_txt9_2FocusLost

    private void txt9_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_2KeyTyped

    private void txt9_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_3FocusGained
        this.txt9_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_3FocusGained

    private void txt9_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_3FocusLost
        this.txt9_3.setBackground(Color.white);
    }//GEN-LAST:event_txt9_3FocusLost

    private void txt9_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_3.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_3KeyTyped

    private void txt4_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_5FocusGained
        this.txt4_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_5FocusGained

    private void txt4_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_5FocusLost
        this.txt4_5.setBackground(Color.white);
    }//GEN-LAST:event_txt4_5FocusLost

    private void txt4_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_5KeyTyped

    private void txt4_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_4FocusGained
        this.txt4_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_4FocusGained

    private void txt4_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_4FocusLost
        this.txt4_4.setBackground(Color.white);
    }//GEN-LAST:event_txt4_4FocusLost

    private void txt4_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_4KeyTyped

    private void txt4_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_6FocusGained
        this.txt4_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_6FocusGained

    private void txt4_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_6FocusLost
        this.txt4_6.setBackground(Color.white);
    }//GEN-LAST:event_txt4_6FocusLost

    private void txt4_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_6KeyTyped

    private void txt5_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_4FocusGained
        this.txt5_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_4FocusGained

    private void txt5_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_4FocusLost
        this.txt5_4.setBackground(Color.white);
    }//GEN-LAST:event_txt5_4FocusLost

    private void txt5_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_4KeyTyped

    private void txt5_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_5FocusGained
        this.txt5_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_5FocusGained

    private void txt5_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_5FocusLost
        this.txt5_5.setBackground(Color.white);
    }//GEN-LAST:event_txt5_5FocusLost

    private void txt5_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_5KeyTyped

    private void txt5_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_6FocusGained
        this.txt5_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_6FocusGained

    private void txt5_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_6FocusLost
        this.txt5_6.setBackground(Color.white);
    }//GEN-LAST:event_txt5_6FocusLost

    private void txt5_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_6KeyTyped

    private void txt6_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_4FocusGained
        this.txt6_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_4FocusGained

    private void txt6_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_4FocusLost
        this.txt6_4.setBackground(Color.white);
    }//GEN-LAST:event_txt6_4FocusLost

    private void txt6_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_4KeyTyped

    private void txt6_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_5FocusGained
        this.txt6_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_5FocusGained

    private void txt6_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_5FocusLost
        this.txt6_5.setBackground(Color.white);
    }//GEN-LAST:event_txt6_5FocusLost

    private void txt6_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_5KeyTyped

    private void txt6_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_6FocusGained
        this.txt6_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_6FocusGained

    private void txt6_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_6FocusLost
        this.txt6_6.setBackground(Color.white);
    }//GEN-LAST:event_txt6_6FocusLost

    private void txt6_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_6KeyTyped

    private void txt1_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_2FocusGained
        this.txt1_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_2FocusGained

    private void txt1_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_2FocusLost
        this.txt1_2.setBackground(Color.white);
    }//GEN-LAST:event_txt1_2FocusLost

    private void txt1_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_2KeyTyped

    private void txt1_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_1FocusGained
        this.txt1_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_1FocusGained

    private void txt1_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_1FocusLost
        this.txt1_1.setBackground(Color.white);
    }//GEN-LAST:event_txt1_1FocusLost

    private void txt1_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_1KeyTyped

    private void txt1_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_3FocusGained
        this.txt1_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_3FocusGained

    private void txt1_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_3FocusLost
        this.txt1_3.setBackground(Color.white);
    }//GEN-LAST:event_txt1_3FocusLost

    private void txt1_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_3.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_3KeyTyped

    private void txt2_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_1FocusGained
        this.txt2_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_1FocusGained

    private void txt2_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_1FocusLost
        this.txt2_1.setBackground(Color.white);
    }//GEN-LAST:event_txt2_1FocusLost

    private void txt2_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_1KeyTyped

    private void txt2_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_2FocusGained
        this.txt2_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_2FocusGained

    private void txt2_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_2FocusLost
        this.txt2_2.setBackground(Color.white);
    }//GEN-LAST:event_txt2_2FocusLost

    private void txt2_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_2KeyTyped

    private void txt2_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_3FocusGained
        this.txt2_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_3FocusGained

    private void txt2_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_3FocusLost
        this.txt2_3.setBackground(Color.white);
    }//GEN-LAST:event_txt2_3FocusLost

    private void txt2_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_3.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_3KeyTyped

    private void txt3_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_1FocusGained
        this.txt3_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_1FocusGained

    private void txt3_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_1FocusLost
        this.txt3_1.setBackground(Color.white);
    }//GEN-LAST:event_txt3_1FocusLost

    private void txt3_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_1KeyTyped

    private void txt3_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_2FocusGained
        this.txt3_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_2FocusGained

    private void txt3_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_2FocusLost
        this.txt3_2.setBackground(Color.white);
    }//GEN-LAST:event_txt3_2FocusLost

    private void txt3_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_2KeyTyped

    private void txt3_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_3FocusGained
        this.txt3_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_3FocusGained

    private void txt3_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_3FocusLost
        this.txt3_3.setBackground(Color.white);
    }//GEN-LAST:event_txt3_3FocusLost

    private void txt3_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_3.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_3KeyTyped

    private void txt7_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_5FocusGained
        this.txt7_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_5FocusGained

    private void txt7_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_5FocusLost
        this.txt7_5.setBackground(Color.white);
    }//GEN-LAST:event_txt7_5FocusLost

    private void txt7_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_5KeyTyped

    private void txt7_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_4FocusGained
        this.txt7_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_4FocusGained

    private void txt7_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_4FocusLost
        this.txt7_4.setBackground(Color.white);
    }//GEN-LAST:event_txt7_4FocusLost

    private void txt7_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_4KeyTyped

    private void txt7_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_6FocusGained
        this.txt7_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_6FocusGained

    private void txt7_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_6FocusLost
        this.txt7_6.setBackground(Color.white);
    }//GEN-LAST:event_txt7_6FocusLost

    private void txt7_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_6KeyTyped

    private void txt8_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_4FocusGained
        this.txt8_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_4FocusGained

    private void txt8_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_4FocusLost
        this.txt8_4.setBackground(Color.white);
    }//GEN-LAST:event_txt8_4FocusLost

    private void txt8_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_4KeyTyped

    private void txt8_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_5FocusGained
        this.txt8_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_5FocusGained

    private void txt8_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_5FocusLost
        this.txt8_5.setBackground(Color.white);
    }//GEN-LAST:event_txt8_5FocusLost

    private void txt8_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_5KeyTyped

    private void txt8_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_6FocusGained
        this.txt8_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_6FocusGained

    private void txt8_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_6FocusLost
        this.txt8_6.setBackground(Color.white);
    }//GEN-LAST:event_txt8_6FocusLost

    private void txt8_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_6KeyTyped

    private void txt9_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_4FocusGained
        this.txt9_4.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_4FocusGained

    private void txt9_4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_4FocusLost
        this.txt9_4.setBackground(Color.white);
    }//GEN-LAST:event_txt9_4FocusLost

    private void txt9_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_4KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_4.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_4KeyTyped

    private void txt9_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_5FocusGained
        this.txt9_5.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_5FocusGained

    private void txt9_5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_5FocusLost
        this.txt9_5.setBackground(Color.white);
    }//GEN-LAST:event_txt9_5FocusLost

    private void txt9_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_5KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_5.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_5KeyTyped

    private void txt9_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_6FocusGained
        this.txt9_6.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_6FocusGained

    private void txt9_6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_6FocusLost
        this.txt9_6.setBackground(Color.white);
    }//GEN-LAST:event_txt9_6FocusLost

    private void txt9_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_6.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_6KeyTyped

    private void txt4_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_2FocusGained
        this.txt4_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_2FocusGained

    private void txt4_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_2FocusLost
        this.txt4_2.setBackground(Color.white);
    }//GEN-LAST:event_txt4_2FocusLost

    private void txt4_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_2KeyTyped

    private void txt4_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_1FocusGained
        this.txt4_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_1FocusGained

    private void txt4_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_1FocusLost
        this.txt4_1.setBackground(Color.white);
    }//GEN-LAST:event_txt4_1FocusLost

    private void txt4_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_1KeyTyped

    private void txt4_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_3FocusGained
        this.txt4_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt4_3FocusGained

    private void txt4_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4_3FocusLost
        this.txt4_3.setBackground(Color.white);
    }//GEN-LAST:event_txt4_3FocusLost

    private void txt4_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt4_3.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt4_3KeyTyped

    private void txt5_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_1FocusGained
        this.txt5_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_1FocusGained

    private void txt5_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_1FocusLost
        this.txt5_1.setBackground(Color.white);
    }//GEN-LAST:event_txt5_1FocusLost

    private void txt5_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_1KeyTyped

    private void txt5_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_2FocusGained
        this.txt5_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_2FocusGained

    private void txt5_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_2FocusLost
        this.txt5_2.setBackground(Color.white);
    }//GEN-LAST:event_txt5_2FocusLost

    private void txt5_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_2KeyTyped

    private void txt5_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_3FocusGained
        this.txt5_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt5_3FocusGained

    private void txt5_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5_3FocusLost
        this.txt5_3.setBackground(Color.white);
    }//GEN-LAST:event_txt5_3FocusLost

    private void txt5_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt5_3.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt5_3KeyTyped

    private void txt6_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_1FocusGained
        this.txt6_1.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_1FocusGained

    private void txt6_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_1FocusLost
        this.txt6_1.setBackground(Color.white);
    }//GEN-LAST:event_txt6_1FocusLost

    private void txt6_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_1.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_1KeyTyped

    private void txt6_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_2FocusGained
        this.txt6_2.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_2FocusGained

    private void txt6_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_2FocusLost
        this.txt6_2.setBackground(Color.white);
    }//GEN-LAST:event_txt6_2FocusLost

    private void txt6_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_2.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_2KeyTyped

    private void txt6_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_3FocusGained
        this.txt6_3.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt6_3FocusGained

    private void txt6_3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6_3FocusLost
        this.txt6_3.setBackground(Color.white);
    }//GEN-LAST:event_txt6_3FocusLost

    private void txt6_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6_3KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt6_3.getText().length() == 1) {
            evt.consume();
        }
        if (Character.isSpace(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt6_3KeyTyped

    private void txt7_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_8FocusGained
        this.txt7_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_8FocusGained

    private void txt7_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_8FocusLost
        this.txt7_8.setBackground(Color.white);
    }//GEN-LAST:event_txt7_8FocusLost

    private void txt7_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_8KeyTyped

    private void txt7_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_7FocusGained
        this.txt7_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_7FocusGained

    private void txt7_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_7FocusLost
        this.txt7_7.setBackground(Color.white);
    }//GEN-LAST:event_txt7_7FocusLost

    private void txt7_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_7KeyTyped

    private void txt7_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_9FocusGained
        this.txt7_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt7_9FocusGained

    private void txt7_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7_9FocusLost
        this.txt7_9.setBackground(Color.white);
    }//GEN-LAST:event_txt7_9FocusLost

    private void txt7_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt7_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt7_9KeyTyped

    private void txt8_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_7FocusGained
        this.txt8_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_7FocusGained

    private void txt8_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_7FocusLost
        this.txt8_7.setBackground(Color.white);
    }//GEN-LAST:event_txt8_7FocusLost

    private void txt8_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_7KeyTyped

    private void txt8_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_8FocusGained
        this.txt8_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_8FocusGained

    private void txt8_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_8FocusLost
        this.txt8_8.setBackground(Color.white);
    }//GEN-LAST:event_txt8_8FocusLost

    private void txt8_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_8KeyTyped

    private void txt8_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_9FocusGained
        this.txt8_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt8_9FocusGained

    private void txt8_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt8_9FocusLost
        this.txt8_9.setBackground(Color.white);
    }//GEN-LAST:event_txt8_9FocusLost

    private void txt8_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt8_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt8_9KeyTyped

    private void txt9_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_7FocusGained
        this.txt9_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_7FocusGained

    private void txt9_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_7FocusLost
        this.txt9_7.setBackground(Color.white);
    }//GEN-LAST:event_txt9_7FocusLost

    private void txt9_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_7KeyTyped

    private void txt9_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_8FocusGained
        this.txt9_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_8FocusGained

    private void txt9_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_8FocusLost
        this.txt9_8.setBackground(Color.white);
    }//GEN-LAST:event_txt9_8FocusLost

    private void txt9_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_8KeyTyped

    private void txt9_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_9FocusGained
        this.txt9_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt9_9FocusGained

    private void txt9_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt9_9FocusLost
        this.txt9_9.setBackground(Color.white);
    }//GEN-LAST:event_txt9_9FocusLost

    private void txt9_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt9_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt9_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt9_9KeyTyped

    private void txt1_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_8FocusGained
        this.txt1_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_8FocusGained

    private void txt1_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_8FocusLost
        this.txt1_8.setBackground(Color.white);
    }//GEN-LAST:event_txt1_8FocusLost

    private void txt1_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_8KeyTyped

    private void txt1_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_7FocusGained
        this.txt1_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_7FocusGained

    private void txt1_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_7FocusLost
        this.txt1_7.setBackground(Color.white);
    }//GEN-LAST:event_txt1_7FocusLost

    private void txt1_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_7KeyTyped

    private void txt1_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_9FocusGained
        this.txt1_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt1_9FocusGained

    private void txt1_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1_9FocusLost
        this.txt1_9.setBackground(Color.white);
    }//GEN-LAST:event_txt1_9FocusLost

    private void txt1_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt1_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1_9KeyTyped

    private void txt2_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_7FocusGained
        this.txt2_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_7FocusGained

    private void txt2_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_7FocusLost
        this.txt2_7.setBackground(Color.white);
    }//GEN-LAST:event_txt2_7FocusLost

    private void txt2_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_7KeyTyped

    private void txt2_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_8FocusGained
        this.txt2_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_8FocusGained

    private void txt2_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_8FocusLost
        this.txt2_8.setBackground(Color.white);
    }//GEN-LAST:event_txt2_8FocusLost

    private void txt2_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_8KeyTyped

    private void txt2_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_9FocusGained
        this.txt2_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt2_9FocusGained

    private void txt2_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_9FocusLost
        this.txt2_9.setBackground(Color.white);
    }//GEN-LAST:event_txt2_9FocusLost

    private void txt2_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt2_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2_9KeyTyped

    private void txt3_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_7FocusGained
        this.txt3_7.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_7FocusGained

    private void txt3_7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_7FocusLost
        this.txt3_7.setBackground(Color.white);
    }//GEN-LAST:event_txt3_7FocusLost

    private void txt3_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_7.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_7KeyTyped

    private void txt3_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_8FocusGained
        this.txt3_8.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_8FocusGained

    private void txt3_8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_8FocusLost
        this.txt3_8.setBackground(Color.white);
    }//GEN-LAST:event_txt3_8FocusLost

    private void txt3_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_8KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_8.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_8KeyTyped

    private void txt3_9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_9FocusGained
        this.txt3_9.setBackground(Color.decode("#DEE1E5"));
    }//GEN-LAST:event_txt3_9FocusGained

    private void txt3_9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3_9FocusLost
        this.txt3_9.setBackground(Color.white);
    }//GEN-LAST:event_txt3_9FocusLost

    private void txt3_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3_9KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (txt3_9.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txt3_9KeyTyped

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        checkAns();
    }//GEN-LAST:event_checkActionPerformed

    private void comboBox_LevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_LevelItemStateChanged
        clearTextFields();//clears all the cells
        System.out.println(consult + "" + (initiation.hasMoreSolutions() ? "_2" : "_2"));

        if (comboBox_Level.getSelectedIndex() == -1 || comboBox_Level.getSelectedIndex() == 0) {
            clearTextFields();//clears all the cells
        } else {
            level = comboBox_Level.getSelectedItem().toString().substring(0, 1);//hols the value of the level the user selected

            ArrayList<Term> arrayList = new ArrayList<Term>();//holds the template of the selected level
            Term[][] problem = new Term[10][10];//holds the template of the selected level as a 2D array
            String predicate2 = "problem(" + level + ",X)";
            Query query = new Query(predicate2);//Queries the KB to get the template of the selected level
            Map<String, Term>[] solutions = query.allSolutions();//holds the returned template
            //Iterates through the returned solution to save it in a 2D array for better access
            for (int i = 0; i < solutions.length; i++) {
                Term term = solutions[i].get("X");
                int u = 0;
                for (Term oneTerm : term.toTermArray()) {
                    arrayList.add(oneTerm);
                    u++;
                    int c = 0;
                    for (Term smallerTerm : oneTerm.toTermArray()) {
                        problem[u][c] = smallerTerm;
                        c++;
                    }
                }//end of inner loop
            }//end of outer loop

            //Iterates through the returned solution to display it in the correct cell
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    if (problem[i][j].isInteger()) {
                        String name = i + "_".concat((j + 1) + "");

                        setHints(this.txt1_1, "txt1_1", name, problem[i][j]);
                        setHints(this.txt1_2, "txt1_2", name, problem[i][j]);
                        setHints(this.txt1_3, "txt1_3", name, problem[i][j]);
                        setHints(this.txt1_4, "txt1_4", name, problem[i][j]);
                        setHints(this.txt1_5, "txt1_5", name, problem[i][j]);
                        setHints(this.txt1_6, "txt1_6", name, problem[i][j]);
                        setHints(this.txt1_7, "txt1_7", name, problem[i][j]);
                        setHints(this.txt1_8, "txt1_8", name, problem[i][j]);
                        setHints(this.txt1_9, "txt1_9", name, problem[i][j]);

                        setHints(this.txt2_1, "txt2_1", name, problem[i][j]);
                        setHints(this.txt2_2, "txt2_2", name, problem[i][j]);
                        setHints(this.txt2_3, "txt2_3", name, problem[i][j]);
                        setHints(this.txt2_4, "txt2_4", name, problem[i][j]);
                        setHints(this.txt2_5, "txt2_5", name, problem[i][j]);
                        setHints(this.txt2_6, "txt2_6", name, problem[i][j]);
                        setHints(this.txt2_7, "txt2_7", name, problem[i][j]);
                        setHints(this.txt2_8, "txt2_8", name, problem[i][j]);
                        setHints(this.txt2_9, "txt2_9", name, problem[i][j]);

                        setHints(this.txt3_1, "txt3_1", name, problem[i][j]);
                        setHints(this.txt3_2, "txt3_2", name, problem[i][j]);
                        setHints(this.txt3_3, "txt3_3", name, problem[i][j]);
                        setHints(this.txt3_4, "txt3_4", name, problem[i][j]);
                        setHints(this.txt3_5, "txt3_5", name, problem[i][j]);
                        setHints(this.txt3_6, "txt3_6", name, problem[i][j]);
                        setHints(this.txt3_7, "txt3_7", name, problem[i][j]);
                        setHints(this.txt3_8, "txt3_8", name, problem[i][j]);
                        setHints(this.txt3_9, "txt3_9", name, problem[i][j]);

                        setHints(this.txt4_1, "txt4_1", name, problem[i][j]);
                        setHints(this.txt4_2, "txt4_2", name, problem[i][j]);
                        setHints(this.txt4_3, "txt4_3", name, problem[i][j]);
                        setHints(this.txt4_4, "txt4_4", name, problem[i][j]);
                        setHints(this.txt4_5, "txt4_5", name, problem[i][j]);
                        setHints(this.txt4_6, "txt4_6", name, problem[i][j]);
                        setHints(this.txt4_7, "txt4_7", name, problem[i][j]);
                        setHints(this.txt4_8, "txt4_8", name, problem[i][j]);
                        setHints(this.txt4_9, "txt4_9", name, problem[i][j]);

                        setHints(this.txt5_1, "txt5_1", name, problem[i][j]);
                        setHints(this.txt5_2, "txt5_2", name, problem[i][j]);
                        setHints(this.txt5_3, "txt5_3", name, problem[i][j]);
                        setHints(this.txt5_4, "txt5_4", name, problem[i][j]);
                        setHints(this.txt5_5, "txt5_5", name, problem[i][j]);
                        setHints(this.txt5_6, "txt5_6", name, problem[i][j]);
                        setHints(this.txt5_7, "txt5_7", name, problem[i][j]);
                        setHints(this.txt5_8, "txt5_8", name, problem[i][j]);
                        setHints(this.txt5_9, "txt5_9", name, problem[i][j]);

                        setHints(this.txt6_1, "txt6_1", name, problem[i][j]);
                        setHints(this.txt6_2, "txt6_2", name, problem[i][j]);
                        setHints(this.txt6_3, "txt6_3", name, problem[i][j]);
                        setHints(this.txt6_4, "txt6_4", name, problem[i][j]);
                        setHints(this.txt6_5, "txt6_5", name, problem[i][j]);
                        setHints(this.txt6_6, "txt6_6", name, problem[i][j]);
                        setHints(this.txt6_7, "txt6_7", name, problem[i][j]);
                        setHints(this.txt6_8, "txt6_8", name, problem[i][j]);
                        setHints(this.txt6_9, "txt6_9", name, problem[i][j]);

                        setHints(this.txt7_1, "txt7_1", name, problem[i][j]);
                        setHints(this.txt7_2, "txt7_2", name, problem[i][j]);
                        setHints(this.txt7_3, "txt7_3", name, problem[i][j]);
                        setHints(this.txt7_4, "txt7_4", name, problem[i][j]);
                        setHints(this.txt7_5, "txt7_5", name, problem[i][j]);
                        setHints(this.txt7_6, "txt7_6", name, problem[i][j]);
                        setHints(this.txt7_7, "txt7_7", name, problem[i][j]);
                        setHints(this.txt7_8, "txt7_8", name, problem[i][j]);
                        setHints(this.txt7_9, "txt7_9", name, problem[i][j]);

                        setHints(this.txt8_1, "txt8_1", name, problem[i][j]);
                        setHints(this.txt8_2, "txt8_2", name, problem[i][j]);
                        setHints(this.txt8_3, "txt8_3", name, problem[i][j]);
                        setHints(this.txt8_4, "txt8_4", name, problem[i][j]);
                        setHints(this.txt8_5, "txt8_5", name, problem[i][j]);
                        setHints(this.txt8_6, "txt8_6", name, problem[i][j]);
                        setHints(this.txt8_7, "txt8_7", name, problem[i][j]);
                        setHints(this.txt8_8, "txt8_8", name, problem[i][j]);
                        setHints(this.txt8_9, "txt8_9", name, problem[i][j]);

                        setHints(this.txt9_1, "txt9_1", name, problem[i][j]);
                        setHints(this.txt9_2, "txt9_2", name, problem[i][j]);
                        setHints(this.txt9_3, "txt9_3", name, problem[i][j]);
                        setHints(this.txt9_4, "txt9_4", name, problem[i][j]);
                        setHints(this.txt9_5, "txt9_5", name, problem[i][j]);
                        setHints(this.txt9_6, "txt9_6", name, problem[i][j]);
                        setHints(this.txt9_7, "txt9_7", name, problem[i][j]);
                        setHints(this.txt9_8, "txt9_8", name, problem[i][j]);
                        setHints(this.txt9_9, "txt9_9", name, problem[i][j]);
                    }//end of if
                }//end of inner loop
            }//end of outer loop
        }//end of outer if-else
    }//GEN-LAST:event_comboBox_LevelItemStateChanged

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        JOptionPane.showMessageDialog(null, "Game requirements: \n"
                + "1) The game has 9x9 grid. Each box has smaller nine boxes with different number of solved cells and empty cells. Each box group should be filled with numbers from 1 to 9.\n"
                + "2) You are required to solve the empty boxes using numbers which:\n"
                + "• Don’t exist in the same box group. That's to complete the box group listing from one to nine. \n"
                + "• Don't exist in the same column and row throughout the 9x9 grid.", "Sudoku game guide", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenu1MouseClicked
    /**
     * Set each hint from the template in its place
     *
     * @param textField
     * @param textName
     * @param name
     * @param number
     */
    public void setHints(JTextField textField, String textName, String name, Term number) {
        if (textName.contains(name)) {
            textField.setText(number + "");
            textField.setEnabled(false);
            textField.setDisabledTextColor(Color.BLACK);
        }//end of if
    }

    /**
     * Clears the 9x9 grid for the next game.
     *
     */
    public void clearTextFields() {
        this.txt1_1.setText("");
        this.txt1_2.setText("");
        this.txt1_3.setText("");
        this.txt1_4.setText("");
        this.txt1_5.setText("");
        this.txt1_6.setText("");
        this.txt1_7.setText("");
        this.txt1_8.setText("");
        this.txt1_9.setText("");

        this.txt2_1.setText("");
        this.txt2_2.setText("");
        this.txt2_3.setText("");
        this.txt2_4.setText("");
        this.txt2_5.setText("");
        this.txt2_6.setText("");
        this.txt2_7.setText("");
        this.txt2_8.setText("");
        this.txt2_9.setText("");

        this.txt3_1.setText("");
        this.txt3_2.setText("");
        this.txt3_3.setText("");
        this.txt3_4.setText("");
        this.txt3_5.setText("");
        this.txt3_6.setText("");
        this.txt3_7.setText("");
        this.txt3_8.setText("");
        this.txt3_9.setText("");

        this.txt4_1.setText("");
        this.txt4_2.setText("");
        this.txt4_3.setText("");
        this.txt4_4.setText("");
        this.txt4_5.setText("");
        this.txt4_6.setText("");
        this.txt4_7.setText("");
        this.txt4_8.setText("");
        this.txt4_9.setText("");

        this.txt5_1.setText("");
        this.txt5_2.setText("");
        this.txt5_3.setText("");
        this.txt5_4.setText("");
        this.txt5_5.setText("");
        this.txt5_6.setText("");
        this.txt5_7.setText("");
        this.txt5_8.setText("");
        this.txt5_9.setText("");

        this.txt6_1.setText("");
        this.txt6_2.setText("");
        this.txt6_3.setText("");
        this.txt6_4.setText("");
        this.txt6_5.setText("");
        this.txt6_6.setText("");
        this.txt6_7.setText("");
        this.txt6_8.setText("");
        this.txt6_9.setText("");

        this.txt7_1.setText("");
        this.txt7_2.setText("");
        this.txt7_3.setText("");
        this.txt7_4.setText("");
        this.txt7_5.setText("");
        this.txt7_6.setText("");
        this.txt7_7.setText("");
        this.txt7_8.setText("");
        this.txt7_9.setText("");

        this.txt8_1.setText("");
        this.txt8_2.setText("");
        this.txt8_3.setText("");
        this.txt8_4.setText("");
        this.txt8_5.setText("");
        this.txt8_6.setText("");
        this.txt8_7.setText("");
        this.txt8_8.setText("");
        this.txt8_9.setText("");

        this.txt9_1.setText("");
        this.txt9_2.setText("");
        this.txt9_3.setText("");
        this.txt9_4.setText("");
        this.txt9_5.setText("");
        this.txt9_6.setText("");
        this.txt9_7.setText("");
        this.txt9_8.setText("");
        this.txt9_9.setText("");

        this.txt1_1.setEnabled(true);
        this.txt1_2.setEnabled(true);
        this.txt1_3.setEnabled(true);
        this.txt1_4.setEnabled(true);
        this.txt1_5.setEnabled(true);
        this.txt1_6.setEnabled(true);
        this.txt1_7.setEnabled(true);
        this.txt1_8.setEnabled(true);
        this.txt1_9.setEnabled(true);

        this.txt2_1.setEnabled(true);
        this.txt2_2.setEnabled(true);
        this.txt2_3.setEnabled(true);
        this.txt2_4.setEnabled(true);
        this.txt2_5.setEnabled(true);
        this.txt2_6.setEnabled(true);
        this.txt2_7.setEnabled(true);
        this.txt2_8.setEnabled(true);
        this.txt2_9.setEnabled(true);

        this.txt3_1.setEnabled(true);
        this.txt3_2.setEnabled(true);
        this.txt3_3.setEnabled(true);
        this.txt3_4.setEnabled(true);
        this.txt3_5.setEnabled(true);
        this.txt3_6.setEnabled(true);
        this.txt3_7.setEnabled(true);
        this.txt3_8.setEnabled(true);
        this.txt3_9.setEnabled(true);

        this.txt4_1.setEnabled(true);
        this.txt4_2.setEnabled(true);
        this.txt4_3.setEnabled(true);
        this.txt4_4.setEnabled(true);
        this.txt4_5.setEnabled(true);
        this.txt4_6.setEnabled(true);
        this.txt4_7.setEnabled(true);
        this.txt4_8.setEnabled(true);
        this.txt4_9.setEnabled(true);

        this.txt5_1.setEnabled(true);
        this.txt5_2.setEnabled(true);
        this.txt5_3.setEnabled(true);
        this.txt5_4.setEnabled(true);
        this.txt5_5.setEnabled(true);
        this.txt5_6.setEnabled(true);
        this.txt5_7.setEnabled(true);
        this.txt5_8.setEnabled(true);
        this.txt5_9.setEnabled(true);

        this.txt6_1.setEnabled(true);
        this.txt6_2.setEnabled(true);
        this.txt6_3.setEnabled(true);
        this.txt6_4.setEnabled(true);
        this.txt6_5.setEnabled(true);
        this.txt6_6.setEnabled(true);
        this.txt6_7.setEnabled(true);
        this.txt6_8.setEnabled(true);
        this.txt6_9.setEnabled(true);

        this.txt7_1.setEnabled(true);
        this.txt7_2.setEnabled(true);
        this.txt7_3.setEnabled(true);
        this.txt7_4.setEnabled(true);
        this.txt7_5.setEnabled(true);
        this.txt7_6.setEnabled(true);
        this.txt7_7.setEnabled(true);
        this.txt7_8.setEnabled(true);
        this.txt7_9.setEnabled(true);

        this.txt8_1.setEnabled(true);
        this.txt8_2.setEnabled(true);
        this.txt8_3.setEnabled(true);
        this.txt8_4.setEnabled(true);
        this.txt8_5.setEnabled(true);
        this.txt8_6.setEnabled(true);
        this.txt8_7.setEnabled(true);
        this.txt8_8.setEnabled(true);
        this.txt8_9.setEnabled(true);

        this.txt9_1.setEnabled(true);
        this.txt9_2.setEnabled(true);
        this.txt9_3.setEnabled(true);
        this.txt9_4.setEnabled(true);
        this.txt9_5.setEnabled(true);
        this.txt9_6.setEnabled(true);
        this.txt9_7.setEnabled(true);
        this.txt9_8.setEnabled(true);
        this.txt9_9.setEnabled(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton check;
    private javax.swing.JComboBox<String> comboBox_Level;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txt1_1;
    private javax.swing.JTextField txt1_2;
    private javax.swing.JTextField txt1_3;
    private javax.swing.JTextField txt1_4;
    private javax.swing.JTextField txt1_5;
    private javax.swing.JTextField txt1_6;
    private javax.swing.JTextField txt1_7;
    private javax.swing.JTextField txt1_8;
    private javax.swing.JTextField txt1_9;
    private javax.swing.JTextField txt2_1;
    private javax.swing.JTextField txt2_2;
    private javax.swing.JTextField txt2_3;
    private javax.swing.JTextField txt2_4;
    private javax.swing.JTextField txt2_5;
    private javax.swing.JTextField txt2_6;
    private javax.swing.JTextField txt2_7;
    private javax.swing.JTextField txt2_8;
    private javax.swing.JTextField txt2_9;
    private javax.swing.JTextField txt3_1;
    private javax.swing.JTextField txt3_2;
    private javax.swing.JTextField txt3_3;
    private javax.swing.JTextField txt3_4;
    private javax.swing.JTextField txt3_5;
    private javax.swing.JTextField txt3_6;
    private javax.swing.JTextField txt3_7;
    private javax.swing.JTextField txt3_8;
    private javax.swing.JTextField txt3_9;
    private javax.swing.JTextField txt4_1;
    private javax.swing.JTextField txt4_2;
    private javax.swing.JTextField txt4_3;
    private javax.swing.JTextField txt4_4;
    private javax.swing.JTextField txt4_5;
    private javax.swing.JTextField txt4_6;
    private javax.swing.JTextField txt4_7;
    private javax.swing.JTextField txt4_8;
    private javax.swing.JTextField txt4_9;
    private javax.swing.JTextField txt5_1;
    private javax.swing.JTextField txt5_2;
    private javax.swing.JTextField txt5_3;
    private javax.swing.JTextField txt5_4;
    private javax.swing.JTextField txt5_5;
    private javax.swing.JTextField txt5_6;
    private javax.swing.JTextField txt5_7;
    private javax.swing.JTextField txt5_8;
    private javax.swing.JTextField txt5_9;
    private javax.swing.JTextField txt6_1;
    private javax.swing.JTextField txt6_2;
    private javax.swing.JTextField txt6_3;
    private javax.swing.JTextField txt6_4;
    private javax.swing.JTextField txt6_5;
    private javax.swing.JTextField txt6_6;
    private javax.swing.JTextField txt6_7;
    private javax.swing.JTextField txt6_8;
    private javax.swing.JTextField txt6_9;
    private javax.swing.JTextField txt7_1;
    private javax.swing.JTextField txt7_2;
    private javax.swing.JTextField txt7_3;
    private javax.swing.JTextField txt7_4;
    private javax.swing.JTextField txt7_5;
    private javax.swing.JTextField txt7_6;
    private javax.swing.JTextField txt7_7;
    private javax.swing.JTextField txt7_8;
    private javax.swing.JTextField txt7_9;
    private javax.swing.JTextField txt8_1;
    private javax.swing.JTextField txt8_2;
    private javax.swing.JTextField txt8_3;
    private javax.swing.JTextField txt8_4;
    private javax.swing.JTextField txt8_5;
    private javax.swing.JTextField txt8_6;
    private javax.swing.JTextField txt8_7;
    private javax.swing.JTextField txt8_8;
    private javax.swing.JTextField txt8_9;
    private javax.swing.JTextField txt9_1;
    private javax.swing.JTextField txt9_2;
    private javax.swing.JTextField txt9_3;
    private javax.swing.JTextField txt9_4;
    private javax.swing.JTextField txt9_5;
    private javax.swing.JTextField txt9_6;
    private javax.swing.JTextField txt9_7;
    private javax.swing.JTextField txt9_8;
    private javax.swing.JTextField txt9_9;
    // End of variables declaration//GEN-END:variables
}
