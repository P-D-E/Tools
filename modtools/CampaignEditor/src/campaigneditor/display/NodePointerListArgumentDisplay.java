/*
 * NewThing.java
 *
 * Created on September 26, 2005, 6:41 PM
 */

package campaigneditor.display;

import campaigneditor.AbstractCampaignNode;
import campaigneditor.Campaign;
import campaigneditor.arguments.Argument;
import campaigneditor.arguments.NodePointerArgument;
import campaigneditor.arguments.NodePointerListArgument;
import campaigneditor.display.GeneralListPicker.PickerType;

/**
 *
 * @author  Daniel Aleksandrow
 */
public class NodePointerListArgumentDisplay extends ArgumentDisplay
{

    private NodePointerListArgument argument;
    private GeneralListPicker picker;
    private Object[] selections = new Object[0];

    /** Creates a new instance of NodePointerListArgumentDisplay */
    public NodePointerListArgumentDisplay(NodePointerListArgument argument, Object[] selections)
    {
        System.out.println("selections a plenty");
        this.argument = argument;
        this.selections = selections;
        this.picker = new GeneralListPicker(this.argument.getLabel()+" (Node Pointer List Argument)", this.selections, this.argument.getValues(), PickerType.FiniteSelection);
    }
    public NodePointerListArgumentDisplay(NodePointerListArgument argument)
    {
        System.out.println("no selections");
        this.argument = argument;
        initialiseDisplay();
    }
    public NodePointerListArgumentDisplay()
    {
        System.out.println("selections none");
        this.argument = new NodePointerListArgument("NodePointerList");
        initialiseDisplay();
    }
    private void initialiseDisplay()
    {
        initComponents();
        reinitialiseDisplay();
    }
    private void reinitialiseDisplay()
    {
        GeneralListPicker newpicker = new GeneralListPicker(this.argument.getLabel()+" (Node Pointer List Argument)", this.selections, this.argument.getValues(), PickerType.FiniteSelection);
        this.removeAll();
        this.add(newpicker);
        this.picker = newpicker;
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
        this.argument.setValues(this.picker.getSelected());
    }
    public void setArgument(Argument argument)
    {
        NodePointerListArgument newarg = (NodePointerListArgument) argument;
        this.argument = newarg;
        reinitialiseDisplay();
    }
    public void setCampaign(Campaign campaign)
    {
        AbstractCampaignNode[] nodelist = campaign.getNodeList();
        NodePointerArgument[] nodenamelist = new NodePointerArgument[nodelist.length];
        for (int i = 0 ; i < nodelist.length ; i++)
        {
            nodenamelist[i] = new NodePointerArgument();
            nodenamelist[i].setValue(nodelist[i].getName());
        }
        this.selections = nodenamelist;
        this.reinitialiseDisplay();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());

    }
    // </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
