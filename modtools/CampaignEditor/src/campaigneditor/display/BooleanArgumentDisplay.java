/*
 * BooleanArgumentDisplay.java
 *
 * Created on October 15, 2005, 11:54 AM
 */

package campaigneditor.display;

import campaigneditor.arguments.Argument;
import campaigneditor.arguments.BooleanArgument;

/**
 *
 * @author  Daniel Aleksandrow
 */
public class BooleanArgumentDisplay extends ArgumentDisplay {
    private BooleanArgument argument;
    /** Creates new form BooleanArgumentDisplay */
    public BooleanArgumentDisplay(BooleanArgument argument) {
        this.argument = argument;
        initComponents();
    }
    public BooleanArgumentDisplay()
    {
        this.argument = new BooleanArgument("Boolean");
        initialiseDisplay();
    }
    private void initialiseDisplay()
    {
        initComponents();
        reinitialiseDisplay();
    }
    private void reinitialiseDisplay()
    {
        this.jCheckBox1.setText(this.argument.getLabel()+" (String Argument)");
        this.jCheckBox1.setSelected(this.argument.getValue());
    }
    public Argument getArgument()
    {
        return this.argument;
    }
    public void updateDisplay()
    {
        this.reinitialiseDisplay();
    }
    public void updateArgument()
    {
        this.argument.setValue(this.jCheckBox1.getModel().isSelected());
    }
    public void setArgument(Argument argument)
    {
        BooleanArgument newarg = (BooleanArgument) argument;
        this.argument = newarg;
        reinitialiseDisplay();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jCheckBox1 = new javax.swing.JCheckBox();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        jCheckBox1.setText("jCheckBox1");
        add(jCheckBox1);

    }
    // </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    // End of variables declaration//GEN-END:variables
    
}
