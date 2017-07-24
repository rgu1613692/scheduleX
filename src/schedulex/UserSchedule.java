/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulex;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import schedulex.algorithm.Data;
import schedulex.algorithm.EventScheduler;
import schedulex.algorithm.Fitness;
import schedulex.domain.Events;
import schedulex.domain.Groups;
import schedulex.domain.Modules;
import schedulex.domain.Periods;
import schedulex.domain.Staff;

/**
 *
 * @author eniol
 */
public class UserSchedule extends javax.swing.JFrame {

    /**
     * Creates new form UserSchedule
     */
	 ArrayList<Events> createdEvents = new ArrayList<Events>();
	 Data full_Data = new Data ();
	 ArrayList<Modules> participating_Modules= new ArrayList<>();
	 ArrayList<Groups> participating_Groups = new ArrayList<>();
	 ArrayList<Staff> participating_Staffs = new ArrayList<>();
	 ArrayList<EventScheduler> population;
	 EventScheduler Schedule ;
	 
    public UserSchedule() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        add_Event_Button = new javax.swing.JButton();
        Generate_TimeTable_Button = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Select Module");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Shedule Event");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Select Student Groups");
        String[] strings1 = new String[full_Data.getModules().size()];
        for(int i=0; i<full_Data.getModules().size(); i++){
        	strings1[i]=full_Data.getModules().get(i).getModuleName(); 
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(strings1));
        String[] strings = new String[full_Data.getGroups().size()];
        for(int i=0; i<full_Data.getGroups().size(); i++){
        	strings[i]=full_Data.getGroups().get(i).getGroupID(); 
        }
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Select Staff (s)");
        
        String[] str = new String[full_Data.getStaff().size()];
        for(int i=0; i<full_Data.getStaff().size(); i++){
        	str[i]=full_Data.getStaff().get(i).getStaffName(); 
        }
        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            
            public int getSize() { return str.length; }
            public String getElementAt(int i) { return str[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Event Duration (Hours)");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select the duration", "One", "Two", "Three" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Event Type");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select a type", "Lecture", "Lab", "Tutorial" }));

        add_Event_Button.setText("Add Event ");
        add_Event_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_Event_ButtonActionPerformed(evt);
            }
        });

        Generate_TimeTable_Button.setText("Generate Timetable");
        Generate_TimeTable_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generate_TimeTable_ButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_Event_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Generate_TimeTable_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(133, 133, 133))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Generate_TimeTable_Button, add_Event_Button});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Generate_TimeTable_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_Event_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Generate_TimeTable_Button, add_Event_Button});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_Event_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_Event_ButtonActionPerformed
                      
                      String Modulenum = jComboBox1.getSelectedItem().toString();
                      Modules newModule = new Modules();
                      ArrayList<String> grpz = (ArrayList<String>)jList2.getSelectedValuesList();
                      ArrayList<String> stfs = (ArrayList<String>)jList3.getSelectedValuesList();
                      ArrayList<Groups> selectedGroups = new ArrayList<Groups>();
                      ArrayList<Staff> selectedStaffs = new ArrayList<>();
                     
                      Data data2 = new Data();
                      for(Modules m:data2.getModules() ){
                    	  if(m.getModuleName().equals(Modulenum))
                    		  newModule = m;  
                      }
                    
                     int duration = jComboBox2.getSelectedIndex();
                       String lectureType = jComboBox3.getSelectedItem().toString();
                       
                      /* stfs.forEach(x ->{ 
                           System.out.println( x.toString()); 
                          });
                      
                       grpz.forEach(x->{
                           System.out.println( x.toString()); 
                       });*/
                       for(String strng: grpz){
                    	   String s = strng;
                    	   for(Groups gr : data2.getGroups()){
                    		   if (gr.getGroupID().equals(s))
                    			 selectedGroups.add(gr);
                    	   }
                       }
                      
                       for(String strng: stfs){
                    	   String s = strng;
                    	   for(Staff gr : data2.getStaff()){
                    		   if (gr.getStaffName().equals(s))
                    			 selectedStaffs.add(gr);
                    	   }
                       }
                       
                       int n= -1;
                      if(participating_Modules.size()==0)participating_Modules.add(newModule);
                      else {
                    	  for (int a=0; a< participating_Modules.size(); a++){
                    		  
                    		  if (participating_Modules.get(a).getModuleID()==newModule.getModuleID())
                    			  n=0;
                    		  
                    	  }
                    	  if(n !=0)
                    		  participating_Modules.add(newModule);
                      }
                      
                      
                      if(participating_Groups.size()==0){
                      selectedGroups.forEach(x-> {
                    	   participating_Groups.add(x);
                      });
                      }
                      else{
                    	  for(int ab=0; ab<selectedGroups.size(); ab++ ){
                    		  int xox = 0;
                    	  for(int b= 0 ; b<participating_Groups.size(); b++){
                    	  if(selectedGroups.get(ab).getGroupID().equals(participating_Groups.get(b).getGroupID()))
                    		  xox=1;
                      }
                    	  if(xox !=1){
                    		  participating_Groups.add(selectedGroups.get(ab));
                    	  }
                    	  }
                      }
                      
                      if(participating_Staffs.size()==0){
                          selectedStaffs.forEach(x-> {
                        	   participating_Staffs.add(x);
                          });
                          }
                      else{
                    	  for(int ab=0; ab<selectedStaffs.size(); ab++ ){
                    		  int xox = 0;
                    	  for(int b= 0 ; b<participating_Staffs.size(); b++){
                    	  if(selectedStaffs.get(ab).getStaffID()==participating_Staffs.get(b).getStaffID())
                    		  xox=1;
                      }
                    	  if(xox !=1){
                    		  participating_Staffs.add(selectedStaffs.get(ab));
                    	  }
                    	  }
                    	  
                      }
                      
                      
                       Events events= new Events(newModule,selectedGroups,selectedStaffs,duration,lectureType);
                       createdEvents.add(events);
                       System.out.println("The size of the list is : "+ createdEvents.size());
                      
                   
    }//GEN-LAST:event_add_Event_ButtonActionPerformed

    private void Generate_TimeTable_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if(createdEvents.size()>0){
    		Data dataCollection = new Data(participating_Modules,participating_Groups,participating_Staffs );
    	 Schedule = new EventScheduler(createdEvents, dataCollection);
    	 		population = new ArrayList<>(12); 
    	 		
    	 		population.forEach(x-> Schedule.initialize());
    		Fitness fitness = new Fitness();
    		ArrayList<Integer> conflicts = fitness.getperiodConflicts(createdEvents);
    		conflicts.forEach(x-> System.out.println(x));
    		
    	}else{
                JOptionPane.showMessageDialog(null,"There are no Events to be Scheduled, please add Events");
        }
    	
    	
    	
    	
       
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
            java.util.logging.Logger.getLogger(UserSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSchedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generate_TimeTable_Button;
    private javax.swing.JButton add_Event_Button;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
