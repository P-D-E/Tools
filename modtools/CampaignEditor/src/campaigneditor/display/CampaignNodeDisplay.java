/*
 * CampaignNodeDisplay.java
 *
 * Created on November 30, 2006, 10:17 PM
 */

package campaigneditor.display;

import campaigneditor.AbstractCampaignNode;
import campaigneditor.Campaign;
import campaigneditor.arguments.Argument;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author  daniel
 */
public class CampaignNodeDisplay extends javax.swing.JPanel {
    
    private static int NODEIMAGEWIDTH = 100;
    private static int NODEIMAGEHEIGHT = 100;
    
    private AbstractCampaignNode campaignnode;
    private ArgumentDisplay[] argumentdisplays;
    private Campaign campaign;

    /**
     * Creates new form CampaignNodeDisplay
     */
    public CampaignNodeDisplay(AbstractCampaignNode node, Campaign campaign)
    {
        initComponents();
        this.campaignnode = node;
        this.campaign = campaign;
        makeNodeDisplay();
    }
    
    private void scaleNodeImage(ImageIcon icon)
    {
        int origwidth = icon.getIconWidth();
        int origheight = icon.getIconHeight();
        int maxwidth = this.NODEIMAGEWIDTH;
        int maxheight = this.NODEIMAGEHEIGHT;
        System.out.println(maxwidth);
        System.out.println(maxheight);
        if (origwidth/maxwidth > origheight/maxheight)
        {
            icon.setImage(icon.getImage().getScaledInstance(maxwidth,-maxheight,Image.SCALE_SMOOTH));
        }
        else
        {
            icon.setImage(icon.getImage().getScaledInstance(-maxwidth,maxheight,Image.SCALE_SMOOTH));
        }
        return;
    }
    
    public void makeNodeDisplay()
    {
        this.nodetypeLabel.setText(this.campaignnode.getClass().getSimpleName());
        this.titleTextField.setText(this.campaignnode.getName());
        this.descriptionTextArea.setText(this.campaignnode.getDescription());
        this.nodeImageLabel.setText("");
        ImageIcon icon = new ImageIcon(getClass().getResource("/campaigneditor/resources/default-nodelogo.png"));
        this.scaleNodeImage(icon);
        this.nodeImageLabel.setIcon(icon);
        
        Argument[] args = this.campaignnode.getArgList();
        this.argumentdisplays = new ArgumentDisplay[args.length];
        for (int i = 0 ; i < args.length ; i++)
        {
            ArgumentDisplay panel = ArgumentDisplayFactory.getArgumentDisplay(args[i]);
            panel.setCampaign(this.campaign);
            panel.setOpaque(false);
            this.argumentTabbedPane.addTab(panel.getArgument().getLabel(),panel);
            this.argumentdisplays[i] = panel;
        }
        this.revalidate();
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        staticDescriptionLabel = new javax.swing.JLabel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        nodeImagePanel = new javax.swing.JPanel();
        nodeImageLabel = new javax.swing.JLabel();
        argumentTabbedPane = new javax.swing.JTabbedPane();
        titleTextField = new javax.swing.JTextField();
        nodetypeLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        revertButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(350, 250));
        staticDescriptionLabel.setFont(new java.awt.Font("Lucida Grande", 3, 13));
        staticDescriptionLabel.setText("Description:");

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(3);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionScrollPane.setViewportView(descriptionTextArea);

        nodeImagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nodeImagePanel.setMinimumSize(new java.awt.Dimension(100, 100));
        nodeImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nodeImageLabel.setText("Node Image");

        GroupLayout nodeImagePanelLayout = new GroupLayout(nodeImagePanel);
        nodeImagePanel.setLayout(nodeImagePanelLayout);
        nodeImagePanelLayout.setHorizontalGroup(
            nodeImagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(nodeImageLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        nodeImagePanelLayout.setVerticalGroup(
            nodeImagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(nodeImageLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        argumentTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        argumentTabbedPane.setMinimumSize(new java.awt.Dimension(400, 150));

        titleTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        nodetypeLabel.setFont(new java.awt.Font("Lucida Grande", 2, 16));
        nodetypeLabel.setText("Node Type Label");
        nodetypeLabel.setEnabled(false);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campaigneditor/resources/document-save.png")));
        saveButton.setText("Save");
        saveButton.setToolTipText("Save the current node.");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });

        revertButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/campaigneditor/resources/edit-undo.png")));
        revertButton.setText("Revert");
        revertButton.setToolTipText("Revert the current node to it's original state.");
        revertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                revertButtonMouseClicked(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(argumentTabbedPane, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(staticDescriptionLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleTextField, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(descriptionScrollPane, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
                        .addGap(72, 72, 72)
                        .addComponent(nodeImagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(revertButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(nodetypeLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nodetypeLabel))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(revertButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(nodeImagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(staticDescriptionLabel)
                            .addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descriptionScrollPane)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(argumentTabbedPane, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void revertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revertButtonMouseClicked
        this.titleTextField.setText(this.campaignnode.getName());
        this.descriptionTextArea.setText(this.campaignnode.getDescription());
        
        for (int i = 0 ; i < this.argumentdisplays.length ; i++)
        {
            this.argumentdisplays[i].updateDisplay();
        }
        System.out.println("Node Data Reverted.");
    }//GEN-LAST:event_revertButtonMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        this.campaignnode.setName(this.titleTextField.getText());
        this.campaignnode.setDescription(this.descriptionTextArea.getText());
        
        for (int i = 0 ; i < this.argumentdisplays.length ; i++)
        {
            this.argumentdisplays[i].updateArgument();
        }
        System.out.println("Node Data Saved.");
    }//GEN-LAST:event_saveButtonMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane argumentTabbedPane;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel nodeImageLabel;
    private javax.swing.JPanel nodeImagePanel;
    private javax.swing.JLabel nodetypeLabel;
    private javax.swing.JButton revertButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel staticDescriptionLabel;
    private javax.swing.JTextField titleTextField;
    // End of variables declaration//GEN-END:variables
    
}
