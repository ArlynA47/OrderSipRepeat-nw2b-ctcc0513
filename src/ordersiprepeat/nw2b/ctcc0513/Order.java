package ordersiprepeat.nw2b.ctcc0513;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author arlyn musada
 */
public class Order extends javax.swing.JFrame {
    
    ArrayList<MenuItem> items;                                                  // ArrayList for the menu items; MenuItem is a custom class
    MyStack<String> orderStack = new MyStack<>();                               // Stack for the list of items intended for an order; MyStack is a custom class
    MyStack<String> orderInfoStack = new MyStack<>();
    MyStack<Integer> amountStack = new MyStack<>();                             // Stack for the price of each of the list of items intended for an order
    MyQueue<Integer> orderQueue = new MyQueue<>();                              // Queue for the placed orders; MyQueue is a custom class
    MyQueue<Integer> itemsNumbersQueue = new MyQueue<>();
    MyQueue<String> orderInfoQueue = new MyQueue<>();  
    ArrayList<Integer> ordersForClaim = new ArrayList<>();                      // ArrayList for the orders ready for claim
    String selectedDrink;
    String totalAmount = "", totalAmountString = "", paymentReceivedString = "";
    int sizeM, sLevel; // drink size and sweetness level
    double paymentReceivedDouble = 0, totalAmountDouble = 0, change = 0;
    int orderNumber = 0, itemsNumbers = 0;
    Font headFont = new Font("Monospaced", Font.BOLD, 15), recFont = new Font("Monospaced", Font.BOLD, 12), itemFont = new Font("Monospaced", Font.PLAIN, 10);
    
    /**
     * Creates new form Order
     */
    public Order() {
        // If this window is closed, the system will redirect the user to the authentication window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SwingUtilities.invokeLater(() -> {
                    Authentication auth = new Authentication();
                    auth.setLocationRelativeTo(null); // sets the window at the center of the screen
                    auth.setVisible(true);
                    dispose();
                });
            }
        });
        
        items = new ArrayList<>();

        // Coffee menu items
        items.add(new MenuItem("CF1", "Espresso", 100.0, "Coffee"));
        items.add(new MenuItem("CF2", "Americano", 110.0, "Coffee"));
        items.add(new MenuItem("CF3","Latte", 130.0, "Coffee"));
        items.add(new MenuItem("CF4","Cappuccino", 130.0, "Coffee"));
        items.add(new MenuItem("CF5","Mocha", 150.0, "Coffee"));

        // Milktea menu items
        items.add(new MenuItem("MT1","Classic Milktea", 100.0, "Milktea"));
        items.add(new MenuItem("MT2","Mango Fruit Tea", 110.0, "Milktea"));
        items.add(new MenuItem("MT3","Taro Milk Tea", 120.0, "Milktea"));
        items.add(new MenuItem("MT4","Brown Sugar Boba Milk", 130.0, "Milktea"));
        items.add(new MenuItem("MT5","Matcha Green Tea Latte", 150.0, "Milktea"));
        
        initComponents();
        setPanelLayout();
        
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, // Initial value, min value
                                                  10, 1); // Max value, step size
        
        // Sets the quantity spinner to not editable
        spQuantity.setModel(model);
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spQuantity.getEditor();
        editor.getTextField().setEditable(false);
    }
    
    public ArrayList<MenuItem> getMenuItems() {
        return items;
    }
    
    // These panels will contain the stacks, queues and arraylists
    // set to BoxLayout to ensure that components are arranged vertically, stacked one on top of the other
    public void setPanelLayout() {
        panelOrder.setLayout(new javax.swing.BoxLayout(panelOrder, javax.swing.BoxLayout.Y_AXIS));
        panelReceipt.setLayout(new javax.swing.BoxLayout(panelReceipt, javax.swing.BoxLayout.Y_AXIS));
        panelQueue1.setLayout(new javax.swing.BoxLayout(panelQueue1, javax.swing.BoxLayout.Y_AXIS));
        panelQueue2.setLayout(new javax.swing.BoxLayout(panelQueue2, javax.swing.BoxLayout.Y_AXIS));
        panelClaim1.setLayout(new javax.swing.BoxLayout(panelClaim1, javax.swing.BoxLayout.Y_AXIS));
        panelClaim2.setLayout(new javax.swing.BoxLayout(panelClaim2, javax.swing.BoxLayout.Y_AXIS));
        panelClaim3.setLayout(new javax.swing.BoxLayout(panelClaim3, javax.swing.BoxLayout.Y_AXIS));
        panelClaim4.setLayout(new javax.swing.BoxLayout(panelClaim4, javax.swing.BoxLayout.Y_AXIS));
        panelClaim5.setLayout(new javax.swing.BoxLayout(panelClaim5, javax.swing.BoxLayout.Y_AXIS));
        panelClaim6.setLayout(new javax.swing.BoxLayout(panelClaim6, javax.swing.BoxLayout.Y_AXIS));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePay = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfPaymentReceived = new javax.swing.JTextField();
        btProceed = new javax.swing.JButton();
        frameReceipt = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btOkReceipt = new javax.swing.JButton();
        panelReceipt = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        labelOrderNum = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btDequeue = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btClaim = new javax.swing.JButton();
        tfOrderNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        panelOrderQueue = new javax.swing.JPanel();
        panelQueue1 = new javax.swing.JPanel();
        panelQueue2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        labelOrderCount = new javax.swing.JLabel();
        panelClaim = new javax.swing.JPanel();
        panelClaim1 = new javax.swing.JPanel();
        panelClaim5 = new javax.swing.JPanel();
        panelClaim2 = new javax.swing.JPanel();
        panelClaim3 = new javax.swing.JPanel();
        panelClaim6 = new javax.swing.JPanel();
        panelClaim4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbDrink = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbSort = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbSLevel = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbSize = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        cT1 = new javax.swing.JCheckBox();
        cT2 = new javax.swing.JCheckBox();
        cT3 = new javax.swing.JCheckBox();
        cT4 = new javax.swing.JCheckBox();
        cT5 = new javax.swing.JCheckBox();
        cT6 = new javax.swing.JCheckBox();
        cT7 = new javax.swing.JCheckBox();
        cT8 = new javax.swing.JCheckBox();
        cT9 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        cE1 = new javax.swing.JCheckBox();
        cE2 = new javax.swing.JCheckBox();
        cE3 = new javax.swing.JCheckBox();
        cE4 = new javax.swing.JCheckBox();
        cE5 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        spQuantity = new javax.swing.JSpinner();
        btCancel = new javax.swing.JButton();
        btUndo = new javax.swing.JButton();
        btClearOrder = new javax.swing.JButton();
        btOrderNow = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        sPane1 = new javax.swing.JScrollPane();
        panelOrder = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelTotal1 = new javax.swing.JLabel();

        framePay.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        framePay.setSize(new java.awt.Dimension(500, 400));

        jPanel4.setBackground(new java.awt.Color(254, 247, 234));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(124, 92, 32)));
        jPanel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(124, 92, 32));
        jLabel14.setText("Order Total:");

        labelTotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setText("......................");
        labelTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(124, 92, 32));
        jLabel16.setText("Payment Received:");

        tfPaymentReceived.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        tfPaymentReceived.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(124, 92, 32), null));

        btProceed.setBackground(new java.awt.Color(0, 153, 51));
        btProceed.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btProceed.setForeground(new java.awt.Color(255, 255, 255));
        btProceed.setText("PROCEED");
        btProceed.setPreferredSize(new java.awt.Dimension(130, 35));
        btProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProceedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(tfPaymentReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel16)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(labelTotal)
                .addGap(35, 35, 35)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(tfPaymentReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout framePayLayout = new javax.swing.GroupLayout(framePay.getContentPane());
        framePay.getContentPane().setLayout(framePayLayout);
        framePayLayout.setHorizontalGroup(
            framePayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        framePayLayout.setVerticalGroup(
            framePayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frameReceipt.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frameReceipt.setSize(new java.awt.Dimension(525, 828));

        jPanel5.setBackground(new java.awt.Color(254, 247, 234));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(124, 92, 32)));
        jPanel5.setPreferredSize(new java.awt.Dimension(525, 828));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(124, 92, 32));
        jLabel15.setText("Receipt");

        btOkReceipt.setBackground(new java.awt.Color(0, 153, 51));
        btOkReceipt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btOkReceipt.setForeground(new java.awt.Color(255, 255, 255));
        btOkReceipt.setText("PROCEED");
        btOkReceipt.setPreferredSize(new java.awt.Dimension(130, 35));
        btOkReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkReceiptActionPerformed(evt);
            }
        });

        panelReceipt.setBackground(new java.awt.Color(255, 255, 255));
        panelReceipt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panelReceipt.setPreferredSize(new java.awt.Dimension(400, 550));

        javax.swing.GroupLayout panelReceiptLayout = new javax.swing.GroupLayout(panelReceipt);
        panelReceipt.setLayout(panelReceiptLayout);
        panelReceiptLayout.setHorizontalGroup(
            panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        panelReceiptLayout.setVerticalGroup(
            panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel18.setText("Order number:");

        labelOrderNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        labelOrderNum.setText("....................");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btOkReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel15))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(labelOrderNum)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel15)
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(labelOrderNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(btOkReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        frameReceipt.getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Order");
        setSize(new java.awt.Dimension(1900, 1030));

        jPanel1.setBackground(new java.awt.Color(254, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1900, 950));

        jPanel2.setBackground(new java.awt.Color(124, 92, 32));
        jPanel2.setPreferredSize(new java.awt.Dimension(2000, 100));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 247, 234));
        jLabel1.setText("OrderSipRepeat");

        logo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(124, 92, 32));
        logo.setText("Place Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(84, 84, 84))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(254, 247, 234));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(124, 92, 32)));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(124, 92, 32));
        jLabel10.setText("Orders in Queue");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(124, 92, 32));
        jLabel11.setText("Ready for Claim");

        btDequeue.setBackground(new java.awt.Color(0, 153, 51));
        btDequeue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btDequeue.setForeground(new java.awt.Color(255, 255, 255));
        btDequeue.setText("COMPLETE TOP ORDER");
        btDequeue.setPreferredSize(new java.awt.Dimension(187, 40));
        btDequeue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDequeueActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 153, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 153, 0));

        btClaim.setBackground(new java.awt.Color(0, 153, 51));
        btClaim.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btClaim.setForeground(new java.awt.Color(255, 255, 255));
        btClaim.setText("CLAIMED");
        btClaim.setPreferredSize(new java.awt.Dimension(187, 40));
        btClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClaimActionPerformed(evt);
            }
        });

        tfOrderNumber.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        tfOrderNumber.setForeground(new java.awt.Color(124, 92, 32));
        tfOrderNumber.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 51), null));
        tfOrderNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOrderNumberActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(124, 92, 32));
        jLabel12.setText("Order number");

        jSeparator5.setForeground(new java.awt.Color(0, 153, 0));

        jSeparator6.setForeground(new java.awt.Color(0, 153, 0));

        panelOrderQueue.setBackground(new java.awt.Color(255, 255, 255));
        panelOrderQueue.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(0, 153, 51)));
        panelOrderQueue.setMinimumSize(new java.awt.Dimension(552, 298));

        panelQueue1.setBackground(new java.awt.Color(255, 255, 255));
        panelQueue1.setMinimumSize(new java.awt.Dimension(238, 260));

        javax.swing.GroupLayout panelQueue1Layout = new javax.swing.GroupLayout(panelQueue1);
        panelQueue1.setLayout(panelQueue1Layout);
        panelQueue1Layout.setHorizontalGroup(
            panelQueue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        panelQueue1Layout.setVerticalGroup(
            panelQueue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        panelQueue2.setBackground(new java.awt.Color(255, 255, 255));
        panelQueue2.setMinimumSize(new java.awt.Dimension(238, 260));

        javax.swing.GroupLayout panelQueue2Layout = new javax.swing.GroupLayout(panelQueue2);
        panelQueue2.setLayout(panelQueue2Layout);
        panelQueue2Layout.setHorizontalGroup(
            panelQueue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        panelQueue2Layout.setVerticalGroup(
            panelQueue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelOrderQueueLayout = new javax.swing.GroupLayout(panelOrderQueue);
        panelOrderQueue.setLayout(panelOrderQueueLayout);
        panelOrderQueueLayout.setHorizontalGroup(
            panelOrderQueueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrderQueueLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelQueue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelQueue2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelOrderQueueLayout.setVerticalGroup(
            panelOrderQueueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrderQueueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOrderQueueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelQueue2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelQueue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel19.setText("Orders:");

        labelOrderCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        labelOrderCount.setText("0");

        panelClaim.setBackground(new java.awt.Color(255, 255, 255));
        panelClaim.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(0, 153, 51)));
        panelClaim.setMinimumSize(new java.awt.Dimension(552, 298));

        panelClaim1.setBackground(new java.awt.Color(255, 255, 255));
        panelClaim1.setMinimumSize(new java.awt.Dimension(98, 260));

        javax.swing.GroupLayout panelClaim1Layout = new javax.swing.GroupLayout(panelClaim1);
        panelClaim1.setLayout(panelClaim1Layout);
        panelClaim1Layout.setHorizontalGroup(
            panelClaim1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelClaim1Layout.setVerticalGroup(
            panelClaim1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        panelClaim5.setBackground(new java.awt.Color(255, 255, 255));
        panelClaim5.setMinimumSize(new java.awt.Dimension(98, 260));

        javax.swing.GroupLayout panelClaim5Layout = new javax.swing.GroupLayout(panelClaim5);
        panelClaim5.setLayout(panelClaim5Layout);
        panelClaim5Layout.setHorizontalGroup(
            panelClaim5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelClaim5Layout.setVerticalGroup(
            panelClaim5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        panelClaim2.setBackground(new java.awt.Color(255, 255, 255));
        panelClaim2.setMinimumSize(new java.awt.Dimension(98, 260));

        javax.swing.GroupLayout panelClaim2Layout = new javax.swing.GroupLayout(panelClaim2);
        panelClaim2.setLayout(panelClaim2Layout);
        panelClaim2Layout.setHorizontalGroup(
            panelClaim2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelClaim2Layout.setVerticalGroup(
            panelClaim2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        panelClaim3.setBackground(new java.awt.Color(255, 255, 255));
        panelClaim3.setMinimumSize(new java.awt.Dimension(98, 260));

        javax.swing.GroupLayout panelClaim3Layout = new javax.swing.GroupLayout(panelClaim3);
        panelClaim3.setLayout(panelClaim3Layout);
        panelClaim3Layout.setHorizontalGroup(
            panelClaim3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelClaim3Layout.setVerticalGroup(
            panelClaim3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        panelClaim6.setBackground(new java.awt.Color(255, 255, 255));
        panelClaim6.setMinimumSize(new java.awt.Dimension(98, 260));

        javax.swing.GroupLayout panelClaim6Layout = new javax.swing.GroupLayout(panelClaim6);
        panelClaim6.setLayout(panelClaim6Layout);
        panelClaim6Layout.setHorizontalGroup(
            panelClaim6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelClaim6Layout.setVerticalGroup(
            panelClaim6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        panelClaim4.setBackground(new java.awt.Color(255, 255, 255));
        panelClaim4.setMinimumSize(new java.awt.Dimension(98, 260));

        javax.swing.GroupLayout panelClaim4Layout = new javax.swing.GroupLayout(panelClaim4);
        panelClaim4.setLayout(panelClaim4Layout);
        panelClaim4Layout.setHorizontalGroup(
            panelClaim4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelClaim4Layout.setVerticalGroup(
            panelClaim4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelClaimLayout = new javax.swing.GroupLayout(panelClaim);
        panelClaim.setLayout(panelClaimLayout);
        panelClaimLayout.setHorizontalGroup(
            panelClaimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClaimLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelClaim1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(panelClaim3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(panelClaim4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(panelClaim5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelClaim6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(panelClaimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelClaimLayout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(panelClaim2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(374, Short.MAX_VALUE)))
        );
        panelClaimLayout.setVerticalGroup(
            panelClaimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClaimLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClaimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelClaim4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelClaim6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelClaim3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelClaim5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelClaim1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(panelClaimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelClaimLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelClaim2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelOrderCount)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelOrderQueue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelClaim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btDequeue, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(tfOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDequeue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(labelOrderCount))
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(panelOrderQueue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(panelClaim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(124, 92, 32));
        jLabel2.setText("Drink");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(124, 92, 32));
        jLabel3.setText("SORT BY:");

        cbDrink.setBackground(new java.awt.Color(124, 92, 32));
        cbDrink.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cbDrink.setForeground(new java.awt.Color(254, 247, 234));
        cbDrink.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CF1 - Americano - Php 110  |  Coffee", "CF2 - Cappuccino - Php 130  |  Coffee", "CF3 - Espresso - Php 100  |  Coffee", "CF4 - Latte - Php 130  |  Coffee", "CF5 - Mocha - Php 150  |  Coffee", "MT1 - Brown Sugar Boba Milk - Php 130  |  Milktea", "MT2 - Classic Milktea - Php 100  |  Milktea", "MT3 - Mango Fruit Tea - Php 110  |  Milktea", "MT4 - Matcha Green Tea Latte - Php 150  |  Milktea", "MT5 - Taro Milk Tea - Php 120  |  Milktea", " " }));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(124, 92, 32));
        jLabel4.setText("Place Order");

        cbSort.setBackground(new java.awt.Color(124, 92, 32));
        cbSort.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cbSort.setForeground(new java.awt.Color(254, 247, 234));
        cbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category", "Name", "Price" }));
        cbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSortActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(124, 92, 32));
        jLabel5.setText("Size");

        cbSLevel.setBackground(new java.awt.Color(124, 92, 32));
        cbSLevel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cbSLevel.setForeground(new java.awt.Color(254, 247, 234));
        cbSLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "R - Regular (100% sugar)", "LS - Less Sweet (75% sugar)", "HS - Half Sweet (50% sugar)", "U - Unsweetened (0% sugar)", "ES - Extra Sweet (125% sugar) | +Php 5" }));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(124, 92, 32));
        jLabel6.setText("Sweetness Level");

        cbSize.setBackground(new java.awt.Color(124, 92, 32));
        cbSize.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cbSize.setForeground(new java.awt.Color(254, 247, 234));
        cbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S - Small", "M - Medium | + Php 10", "L - Large | + Php 20" }));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 0));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(124, 92, 32));
        jLabel7.setText("Toppings");

        cT1.setBackground(new java.awt.Color(254, 255, 255));
        cT1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT1.setText("T1 - Caramel Drizzle | +Php 35");
        cT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cT1ActionPerformed(evt);
            }
        });

        cT2.setBackground(new java.awt.Color(254, 255, 255));
        cT2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT2.setText("T2 - Marshmallows | +Php 30");
        cT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cT2ActionPerformed(evt);
            }
        });

        cT3.setBackground(new java.awt.Color(254, 255, 255));
        cT3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT3.setText("T3 - Cocoa Powder Sprinkle | +Php 30");

        cT4.setBackground(new java.awt.Color(254, 255, 255));
        cT4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT4.setText("T4 - Cinnamon Sprinkle | +Php 30");
        cT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cT4ActionPerformed(evt);
            }
        });

        cT5.setBackground(new java.awt.Color(254, 255, 255));
        cT5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT5.setText("T5 - Fruit Jelly | +Php 30");
        cT5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cT5ActionPerformed(evt);
            }
        });

        cT6.setBackground(new java.awt.Color(254, 255, 255));
        cT6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT6.setText("T6 - Aloe Vera | +Php 25");
        cT6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cT6ActionPerformed(evt);
            }
        });

        cT7.setBackground(new java.awt.Color(254, 255, 255));
        cT7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT7.setText("T7 - Pudding | +Php 25");
        cT7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cT7ActionPerformed(evt);
            }
        });

        cT8.setBackground(new java.awt.Color(254, 255, 255));
        cT8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT8.setText("T8 - Glass Jelly | +Php 20");
        cT8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cT8ActionPerformed(evt);
            }
        });

        cT9.setBackground(new java.awt.Color(254, 255, 255));
        cT9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cT9.setText("T9 - Tapioca Pearls | +Php 20");
        cT9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cT9ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(124, 92, 32));
        jLabel8.setText("Extras");

        cE1.setBackground(new java.awt.Color(254, 255, 255));
        cE1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cE1.setText("E1 - Extra Boba Pearls | +Php 30");
        cE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cE1ActionPerformed(evt);
            }
        });

        cE2.setBackground(new java.awt.Color(254, 255, 255));
        cE2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cE2.setText("E2 - Vanilla Syrup | +Php 30");
        cE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cE2ActionPerformed(evt);
            }
        });

        cE3.setBackground(new java.awt.Color(254, 255, 255));
        cE3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cE3.setText("E3 - Whipped Cream | +Php 30");
        cE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cE3ActionPerformed(evt);
            }
        });

        cE4.setBackground(new java.awt.Color(254, 255, 255));
        cE4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cE4.setText("E4 - Caramel Syrup | +Php 20");
        cE4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cE4ActionPerformed(evt);
            }
        });

        cE5.setBackground(new java.awt.Color(254, 255, 255));
        cE5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cE5.setText("E5 - Chocolate Syrup | +Php 20");
        cE5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cE5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(124, 92, 32));
        jLabel9.setText("Quantity");

        spQuantity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        spQuantity.setPreferredSize(new java.awt.Dimension(30, 30));

        btCancel.setBackground(new java.awt.Color(124, 92, 32));
        btCancel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btCancel.setForeground(new java.awt.Color(254, 247, 234));
        btCancel.setText("CANCEL");
        btCancel.setPreferredSize(new java.awt.Dimension(89, 35));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btUndo.setBackground(new java.awt.Color(124, 92, 32));
        btUndo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btUndo.setForeground(new java.awt.Color(254, 247, 234));
        btUndo.setText("UNDO");
        btUndo.setPreferredSize(new java.awt.Dimension(73, 35));
        btUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUndoActionPerformed(evt);
            }
        });

        btClearOrder.setBackground(new java.awt.Color(204, 0, 0));
        btClearOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btClearOrder.setForeground(new java.awt.Color(255, 255, 255));
        btClearOrder.setText("CLEAR ODER");
        btClearOrder.setPreferredSize(new java.awt.Dimension(130, 35));
        btClearOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearOrderActionPerformed(evt);
            }
        });

        btOrderNow.setBackground(new java.awt.Color(0, 153, 51));
        btOrderNow.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btOrderNow.setForeground(new java.awt.Color(255, 255, 255));
        btOrderNow.setText("ORDER NOW");
        btOrderNow.setPreferredSize(new java.awt.Dimension(130, 35));
        btOrderNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrderNowActionPerformed(evt);
            }
        });

        btAdd.setBackground(new java.awt.Color(124, 92, 32));
        btAdd.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        btAdd.setForeground(new java.awt.Color(254, 247, 234));
        btAdd.setText("ADD");
        btAdd.setMinimumSize(new java.awt.Dimension(61, 35));
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 153, 0));

        sPane1.setBackground(new java.awt.Color(255, 255, 255));
        sPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(0, 153, 0)));

        panelOrder.setBackground(new java.awt.Color(255, 255, 255));
        panelOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelOrder.setLayout(new javax.swing.BoxLayout(panelOrder, javax.swing.BoxLayout.LINE_AXIS));
        sPane1.setViewportView(panelOrder);

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(124, 92, 32));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ordersiprepeat/nw2b/ctcc0513/osrIcon.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(124, 92, 32));
        jLabel17.setText("Total: ");

        labelTotal1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 16)); // NOI18N
        labelTotal1.setText("Php 0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1900, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(cbSLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cT1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cT2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cT3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cE1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cE2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cT5)
                                    .addComponent(cT6)
                                    .addComponent(cT4)
                                    .addComponent(cE4)
                                    .addComponent(cE3))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cT8)
                                    .addComponent(cT9)
                                    .addComponent(cT7)
                                    .addComponent(cE5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jSeparator2))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btClearOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btOrderNow, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel13)))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sPane1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(94, 94, 94))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbSLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cT1)
                            .addComponent(cT4)
                            .addComponent(cT7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cT8)
                            .addComponent(cT5)
                            .addComponent(cT2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cT3)
                            .addComponent(cT6)
                            .addComponent(cT9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cE1)
                            .addComponent(cE3)
                            .addComponent(cE5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cE4)
                            .addComponent(cE2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btClearOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btOrderNow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(labelTotal1)))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cT1ActionPerformed

    private void cT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cT4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cT4ActionPerformed

    private void cT5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cT5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cT5ActionPerformed

    private void cT6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cT6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cT6ActionPerformed

    private void cT7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cT7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cT7ActionPerformed

    private void cT8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cT8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cT8ActionPerformed

    private void cT9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cT9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cT9ActionPerformed

    private void cE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cE1ActionPerformed
        
    }//GEN-LAST:event_cE1ActionPerformed

    private void cE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cE2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cE2ActionPerformed

    private void cE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cE3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cE3ActionPerformed

    private void cE4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cE4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cE4ActionPerformed

    private void cE5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cE5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cE5ActionPerformed

    private void cT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cT2ActionPerformed

    // Sort combobox action listener
    private void cbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSortActionPerformed
        String selectedSort = (String) cbSort.getSelectedItem();
                populateDrinkComboBox(selectedSort);
    }//GEN-LAST:event_cbSortActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // initializations
        int subtotalCont = 0;
        int quantity = 0;
        String toppings = "";
        String extras = "";
        String dtype="";
        String size="";
        String slvl="";
        String orderString = "";
        String orderString2 = "";
        String quantityString = "";

        // gets the selected milktea; initial prices of milktea
        selectedDrink = cbDrink.getSelectedItem().toString();
        if (selectedDrink.startsWith("CF1")) { 
            subtotalCont = 110; 
            dtype = "CF1";
        } else if(selectedDrink.startsWith("CF2")) {
            subtotalCont = 130;
            dtype = "CF2";
        } else if(selectedDrink.startsWith("CF3")) {
            subtotalCont = 100;
            dtype = "CF3";
        } else if(selectedDrink.startsWith("CF4")) {
            subtotalCont = 130;
            dtype = "CF4";
        } else if(selectedDrink.startsWith("CF5")) {
            subtotalCont = 150;
            dtype = "CF5";
        } else if(selectedDrink.startsWith("MT1")) {
            subtotalCont = 130;
            dtype = "MT1";
        } else if(selectedDrink.startsWith("MT2")) {
            subtotalCont = 100;
            dtype = "MT2";
        } else if(selectedDrink.startsWith("MT3")) {
            subtotalCont = 110;
            dtype = "MT3";
        } else if(selectedDrink.startsWith("MT4")) {
            subtotalCont = 150;
            dtype = "MT4";
        } else if(selectedDrink.startsWith("MT5")) {
            subtotalCont = 120;
            dtype = "MT5";
        }

        // gets the selected milktea size
        sizeM = cbSize.getSelectedIndex();

        if(sizeM==1) {
            subtotalCont += 10; // adds to the subtotal; same with others below
            size = "M";
        } else if (sizeM==2) {
            subtotalCont += 20;
            size = "L";
        } else {
            size = "S";
        }

        // gets the selected sweetness level
        sLevel = cbSLevel.getSelectedIndex();

        if(sLevel==4) {
            subtotalCont += 5;
            slvl = "ES";
        } else if(sLevel==0) {
            slvl = "R";
        } else if(sLevel==1) {
            slvl = "LS";
        } else if(sLevel==2) {
            slvl = "HS";
        } else if(sLevel==3) {
            slvl = "U";
        }

        // checks if toppings and extras are added
        if(cT1.isSelected()) {
            subtotalCont += 35;
            toppings = toppings + " T1";
        }
        if(cT2.isSelected()) {
            subtotalCont += 30;
            toppings = toppings + " T2";
        }
        if(cT3.isSelected()) {
            subtotalCont += 30;
            toppings = toppings + " T3";
        }
        if(cT4.isSelected()) {
            subtotalCont += 30;
            toppings = toppings + " T4";
        }
        if(cT5.isSelected()) {
            subtotalCont += 30;
            toppings = toppings + " T5";
        }
        if(cT6.isSelected()) {
            subtotalCont += 25;
            toppings = toppings + " T6";
        }
        if(cT7.isSelected()) {
            subtotalCont += 25;
            toppings = toppings + " T7";
        }
        if(cT8.isSelected()) {
            subtotalCont += 20;
            toppings = toppings + " T8";
        }
        if(cT9.isSelected()) {
            subtotalCont += 20;
            toppings = toppings + " T9";
        }
        if(cE1.isSelected()) {
            subtotalCont += 30;
            extras = extras + " E1";
        }
        if(cE2.isSelected()) {
            subtotalCont += 30;
            extras = extras + " E2";
        }
        if(cE3.isSelected()) {
            subtotalCont += 30;
            extras = extras + " E3";
        }
        if(cE4.isSelected()) {
            subtotalCont += 20;
            extras = extras + " E4";
        }
         if(cE5.isSelected()) {
            subtotalCont += 30;
            extras = extras + " E5";
        }

        // gets the selected quantity
        quantity = Integer.parseInt(spQuantity.getValue().toString());

        quantityString = "Qty. " + quantity;

        // subtotal for each order = price of each milktea multiplied to the quantity
        subtotalCont *= quantity;

        // String for the order item
        orderString = dtype + "   | " + size + " | " + slvl + " |" + toppings + " |" + extras + " | " + quantityString + "     ..........     Php " + subtotalCont;
        orderString2 = dtype + "   | " + size + " | " + slvl + " |" + toppings + " |" + extras + " | " + quantityString;
        
        orderStack.push(orderString); // stacks the order item string
        amountStack.push(subtotalCont); // stacks the order item price

        orderInfoStack.push(orderString2); // queues the order information
        itemsNumbers++;
        
        // Refresh panel
        clearPanelOrder();
        displayOrderItems();

    }//GEN-LAST:event_btAddActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        
        // reset the checkboxes
        cT1.setSelected(false);
        cT2.setSelected(false);
        cT3.setSelected(false);
        cT4.setSelected(false);
        cT5.setSelected(false);
        cT6.setSelected(false);
        cT7.setSelected(false);
        cT8.setSelected(false);
        cT9.setSelected(false);
        cE1.setSelected(false);
        cE2.setSelected(false);
        cE3.setSelected(false);
        cE4.setSelected(false);
        cE5.setSelected(false);
        
        // reset the quantity spinner
        spQuantity.setValue(1);
        
        itemsNumbers = 0;
        
        // reset the comboboxes
        cbDrink.setSelectedIndex(0);
        cbSize.setSelectedIndex(0);
        cbSLevel.setSelectedIndex(0);
    }//GEN-LAST:event_btCancelActionPerformed

    // Undo button action listener
    private void btUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUndoActionPerformed
       
        // Check if there are items to undo:
        if (!orderStack.isEmpty() && !amountStack.isEmpty()) {

            // Remove the last item and its amount from their respective stacks:
            orderStack.pop();                                                   // Removes the most recently added item from the order stack
            amountStack.pop();                                                  // Removes the amount associated with that item from the amount stack
            orderInfoStack.pop();
        }

        itemsNumbers--;
        
        // Refresh the order panel
        clearPanelOrder(); 
        displayOrderItems();
        
    }//GEN-LAST:event_btUndoActionPerformed

    // Clear order button action listener
    private void btClearOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearOrderActionPerformed

        // Check if there are items to clear:
        if (!orderStack.isEmpty() && !amountStack.isEmpty()) {

            // Completely clear both the order stack and amount stack:
            orderStack.clear();                                                 // Removes all items from the order stack
            amountStack.clear();                                                // Removes all items from the amount stack
            orderInfoStack.clear();                                             // Removes all items from the order information stack
        }
        
        // Refresh the order panel
        clearPanelOrder();
        displayOrderItems();
    }//GEN-LAST:event_btClearOrderActionPerformed

    private void jPanel4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4AncestorAdded

    // Order now button action listener
    private void btOrderNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrderNowActionPerformed

        // Check if there are items in the order:
        if (!orderStack.isEmpty() && !amountStack.isEmpty()) {

            // Calculate the total amount and display it:
            double ta = getTotal();                                             // Calls a method to calculate the total cost of the order
            totalAmountString = Double.toString(ta);                          // Converts the total to a string for display
            totalAmount = "Php " + ta;                                          // Formats the total amount with a currency label
            labelTotal.setText(totalAmount);                                // Updates a label to show the total amount                               
            
            // Show the payment window:
            framePay.setVisible(true);                                        // Makes the payment window visible
            framePay.setLocationRelativeTo(null);                             // Centers the payment window on the screen

        } else {
            // If there are no items, show an error message:
            JOptionPane.showMessageDialog(panelOrder, "No items have been added.", "Cannot process order", JOptionPane.INFORMATION_MESSAGE);
        }
       
        
    }//GEN-LAST:event_btOrderNowActionPerformed

    // Proceed button action listener (Payment)
    private void btProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProceedActionPerformed
        
         // Get the payment amount from the user input:
        paymentReceivedString = tfPaymentReceived.getText().toString();         // Get the text entered in the payment field
        paymentReceivedDouble = Double.parseDouble(paymentReceivedString);    // Convert it to a double for calculations
        totalAmountDouble = Double.parseDouble(totalAmountString);            // Get the total amount as a double

        // Check if payment is sufficient:
        if (paymentReceivedDouble >= totalAmountDouble) {

            // Process the payment:
            change = paymentReceivedDouble - totalAmountDouble;                 // Calculate the change to be given back
            orderNumber++;                                                      // Increment the order number for the new order

            // Close the payment window and display the receipt:
            framePay.dispose();                                                 // Close the payment window
            labelOrderNum.setText(Integer.toString(orderNumber));         // Update a label to show the new order number
            displayOrderItemsReceipt();                                         // Show the order items on the receipt
            frameReceipt.setVisible(true);                                    // Make the receipt window visible
            frameReceipt.setLocationRelativeTo(null);                         // Center the receipt window on the screen
            tfPaymentReceived.setText("");                                    // Clear the payment field for the next order

        } else {
            // Show an error message if payment is insufficient:
            JOptionPane.showMessageDialog(null, "Insufficient amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btProceedActionPerformed

    // Proceed button (Receipt) action listener
    private void btOkReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkReceiptActionPerformed
        
        // Close the receipt window:
        frameReceipt.dispose();                                                 // Closes the window displaying the receipt

        // Add the order number back to the queue:
        orderQueue.enqueue(orderNumber);                                    // Puts the order number at the back of the queue

        itemsNumbersQueue.enqueue(itemsNumbers);
        
        // Clear everything for a new order:
        clearAllForNewOrder();                                                  // This likely resets input fields and other elements for a fresh order

        // Update the visual display of the order queue:**
        clearPanelQueue();                                                      // Clears the panel showing the queue to prepare for an updated display
        displayOrderQueue();                                                    // Shows the updated queue with the added order
        
    }//GEN-LAST:event_btOkReceiptActionPerformed

    // Dequeque button action listener
    private void btDequeueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDequeueActionPerformed
        
        // Check if there are orders in the queue:**
        if (!orderQueue.isEmpty()) {

            // Remove the next order from the queue and move it to orders for claim:
            int orderDequeued = orderQueue.dequeue();                   // Removes the first order from the queue
            ordersForClaim.add(orderDequeued);                        // Adds the removed order to the list of claimable orders

            
            int on = itemsNumbersQueue.dequeue();
            for(int i=0; i<on; i++) {
                orderInfoQueue.dequeue();
            }
                
            
            // Update the visual displays for both queues:**
            clearPanelClaim();                                          // Clears the panel for claimed orders to prepare for fresh display
            displayOrdersForClaim();                                    // Shows the updated list of claimable orders

            clearPanelQueue();                                          // Clears the panel for the main queue to prepare for fresh display
            displayOrderQueue();                                        // Shows the updated order queue
        }
        
        
    }//GEN-LAST:event_btDequeueActionPerformed

    private void tfOrderNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOrderNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfOrderNumberActionPerformed

    private void btClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClaimActionPerformed
      
        
        // Get the order number from the user input:
        String inputText = tfOrderNumber.getText();                             // Get the text entered in the order number field

        try {
            // Try to parse the input as an integer:
            int orderNumber = Integer.parseInt(inputText);                    // Attempt to convert the input to an integer

            // Check if the order number exists and can be claimed:
            if (ordersForClaim.contains(orderNumber)) {

                // Process the order claim:
                removeClaimedOrder(orderNumber);                    // Remove the claimed order from the list
                clearPanelClaim();                                              // Clear the visual panel for claiming orders
                displayOrdersForClaim();                                        // Show the updated list of orders available for claim

                // Display a success message:
                JOptionPane.showMessageDialog(panelClaim, "Order Claimed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                tfOrderNumber.setText("");                                    // Clear the order number field for the next claim

            } else {
                // Handle the case where the order number doesn't exist:
                JOptionPane.showMessageDialog(panelClaim, "Order number does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                tfOrderNumber.setText("");                                    // Clear the order number field for re-entry
            }

        } catch (NumberFormatException e) {
            // Handle invalid input (not an integer):
            JOptionPane.showMessageDialog(panelClaim, "Invalid order number. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
            tfOrderNumber.setText("");                                        // Clear the order number field for re-entry
        }
        
    }//GEN-LAST:event_btClaimActionPerformed

    // This method fills a combo box (dropdown menu) with drink options, sorted according to the user's choice
    private void populateDrinkComboBox(String sortOption) {

        // Get a list of available menu items:
        ArrayList<MenuItem> items = getMenuItems();                             // Fetches the list of drinks

        // Sort the items based on the selected sorting preference:
        if (sortOption.equals("Name")) {
            // Sort alphabetically by name:
            Collections.sort(items, new Comparator<MenuItem>() {
                // This part compares two items and decides which one comes first alphabetically.
                @Override
                public int compare(MenuItem item1, MenuItem item2) {
                    return item1.getName().compareTo(item2.getName());
                }
            });

        } else if (sortOption.equals("Price")) {
            // Sort by price, from lowest to highest:
            Collections.sort(items, new Comparator<MenuItem>() {
                @Override
                public int compare(MenuItem item1, MenuItem item2) {
                    return Double.compare(item1.getPrice(), item2.getPrice());
                }
            });

        } else {
            // Default: Sort by category:
            Collections.sort(items, new Comparator<MenuItem>() {
                @Override
                public int compare(MenuItem item1, MenuItem item2) {
                    return item1.getCategory().compareTo(item2.getCategory());
                }
            });
        }

        // Fill the combo box with the sorted items:
        // Clear any existing items in the combo box to start fresh:
        cbDrink.removeAllItems();

        // Add each item to the combo box, showing its abbreviation, name, price, and category:
        for (MenuItem item : items) {
            cbDrink.addItem(item.getAbbrv() + " - " + item.getName() + " - Php " + item.getPrice() + " | " + item.getCategory());
        }
    }

    
    // method to calculate the order total amount
    public int getTotal() {
        int sum = 0;
        Stack<Integer> tempStack = new Stack<>();

        // Copy elements to tempStack to preserve original order
        while (!amountStack.isEmpty()) {
            tempStack.push(amountStack.pop());
        }

        // Calculate sum from tempStack
        while (!tempStack.isEmpty()) {
            sum += tempStack.peek();  // Peek
            amountStack.push(tempStack.pop());  // Restore elements to original stack
        }

        return sum;
    }
    
    // This method displays the ordered items on a panel and updates the total amount label.
    public void displayOrderItems() {

        // Show each item from the order stack:
        for (String text : orderStack) {                                        // Loops through each item in the order stack
            JLabel textLabel = new JLabel(text);                          // Creates a new label to display the item
            textLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16));
            panelOrder.add(textLabel);                                      // Adds the label to the panel so it's visible
        }

        // Update the total amount:
        double ta = getTotal();                                                 // Fetches the total cost of the order 
        totalAmountString = "Php " + ta;                                        // Formats the total amount as a string

        // Display the total amount on the label:
        labelTotal1.setText(totalAmountString);                             // Shows the total amount on the label
    }

    
    // This method displays the order details as a receipt on a panel.
    public void displayOrderItemsReceipt() {

        // Create the receipt header:
        JLabel textLabel = new JLabel("        --------------------------------------------"); // Line break for visual organization.
        textLabel.setFont(recFont); 
        panelReceipt.add(textLabel);                                        // Add the label to the receipt panel

        JLabel textLabelHead = new JLabel("                OrderSipRepeat");      // Store name
        textLabelHead.setFont(headFont);
        panelReceipt.add(textLabelHead);

        JLabel textLabelHead2 = new JLabel("                   RECEIPT");            // Receipt label
        textLabelHead2.setFont(headFont);
        panelReceipt.add(textLabelHead2);

        JLabel textLabell = new JLabel("        --------------------------------------------"); // Another line break.
        textLabell.setFont(recFont);
        panelReceipt.add(textLabell);

        // Display the ordered items:
        for (String text : orderStack) {                                        // Loop through each item in the order stack
            JLabel textLabel1 = new JLabel("  " + text);                        // Create a label for each item
            textLabel1.setFont(itemFont);                                   
            panelReceipt.add(textLabel1);
            
        }

        // Add a separator line:
        JLabel textLabel2 = new JLabel("-----------------------------------------------------------");
        textLabel2.setFont(recFont);
        panelReceipt.add(textLabel2);

        // Display total amount, payment received, and change:**
        double ta = getTotal();                                                 // Get the total cost of the order
        totalAmountString = "Php " + ta;                                        // Format the total amount as a string

        JLabel textLabel3 = new JLabel("  Total:      " + totalAmountString);
        textLabel3.setFont(recFont);
        panelReceipt.add(textLabel3);

        JLabel textLabel4 = new JLabel("  Amount Received: Php " + paymentReceivedString + ".0"); // fetched from payment input
        textLabel4.setFont(recFont);
        panelReceipt.add(textLabel4);

        JLabel textLabel5 = new JLabel("  Change:      Php " + change);         // Calculated as payment received - total amount.
        textLabel5.setFont(recFont);
        panelReceipt.add(textLabel5);

        // **5. Add a final separator line:**
        JLabel textLabel6 = new JLabel("-----------------------------------------------------------");
        textLabel6.setFont(recFont);
        panelReceipt.add(textLabel6);
        
        for(String oi: orderInfoStack) {
            orderInfoQueue.enqueue(oi);
        }
    }

    
    // This method displays the order queue visually, distributing items across multiple panels
    public void displayOrderQueue() {

        // Prepare variables for counting and displaying orders:
        int orderCountNum = 0;                                                  // Keeps track of the number of orders processed
        MyQueue<Integer> copy = new MyQueue<>(orderQueue);             // Creates a copy of the actual order queue to avoid modifying it
        MyQueue<String> copyOrders = new MyQueue<>(orderInfoQueue);
        MyQueue<Integer> copyOrdersNumbers = new MyQueue<>(itemsNumbersQueue);
        int queueCount = copy.size();                                           // Gets the total number of orders in the queue
        labelOrderCount.setText("" + queueCount);                               // Updates a label to show the total count

        
          // Process each order in the queue:
          while (!copy.isEmpty()) {                                             // Continues until all orders have been displayed
            int item = copy.dequeue();                                          // Removes the next order from the copy queue
            JLabel textLabel = new JLabel(Integer.toString(item));      // Creates a label to display the order number
            textLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18));
            
            int in = 0;
            
            if(!copyOrdersNumbers.isEmpty()) {
                in = copyOrdersNumbers.dequeue();
            }
            
            // Distribute orders visually across multiple panels:
            if (orderCountNum <= 14) {
                orderCountNum++;                                                    // Increment the order count
              panelQueue1.add(textLabel);                                   // Add the label to the first panel if it's within the first 12 orders
            
            for(int i=0; i<in; i++) {
                String oi = "";
                if(!copyOrders.isEmpty()) {
                    oi = copyOrders.dequeue();
                } 
                JLabel textLabel2 = new JLabel(oi);     
                textLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10));
                if (orderCountNum <= 14) {
                    panelQueue1.add(textLabel2); 
                    orderCountNum++; 
                } else {
                    panelQueue2.add(textLabel2); 
                    orderCountNum++; 
                }
            }   
            
            } else { 
                orderCountNum++;                                                    // Increment the order count
              panelQueue2.add(textLabel);                                   // Add to the second panel for orders >14
                for(int i=0; i<in; i++) {
                String oi = "";
                if(!copyOrders.isEmpty()) {
                    oi = copyOrders.dequeue();
                }
                JLabel textLabel2 = new JLabel(oi);     
                textLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10));
                panelQueue2.add(textLabel2); 
                orderCountNum++; 
                }    
        }
        
    }
    
    }
    
    // This method displays orders that are ready for claiming, distributing them across multiple panels.
    public void displayOrdersForClaim() {

        // Prepare variables for counting and displaying orders:
        int orderCountNum = 0;                                                  // Keeps track of the number of orders processed

        // Process each order ready for claim:
        for (int claimOrdersInt : ordersForClaim) {                             // Loops through each order in the list of claimable orders
            orderCountNum++;                                                    // Increment the order count

            // Create a label to display the order number:
            JLabel textLabel = new JLabel(Integer.toString(claimOrdersInt)); // Shows the order number
            textLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18));

            // Distribute orders visually across multiple panels:
            if (orderCountNum <= 12) {
                panelClaim1.add(textLabel);                                 // Add the label to the first panel if it's within the first 12 orders
            } else if (orderCountNum <= 24) {
                panelClaim2.add(textLabel);                                 // Add to the second panel for orders 13-24
            } else if (orderCountNum <= 36) {
                panelClaim3.add(textLabel);                                 // Add to the third panel for orders 25-36, and so on
            } // ... (similar conditions for other panels)
            else if(orderCountNum>36 && orderCountNum<=48) {
                panelClaim4.add(textLabel);
            } else if(orderCountNum>48 && orderCountNum<=60) {
                panelClaim5.add(textLabel);
            } else {
                panelClaim6.add(textLabel);
            }
            
        }
    }
    
    // This method removes a claimed order from the list of orders awaiting claim
    public void removeClaimedOrder(int orderNumClaimed) {

        // Use an iterator to safely remove items during looping:
        Iterator<Integer> iterator = ordersForClaim.iterator();                 // An iterator allows you to modify a collection while iterating over it

        // Find the order to remove:
        while (iterator.hasNext()) {                                            // Continue as long as there are more items to check
            int number = iterator.next();                                       // Get the next order number in the collection
            if (number == orderNumClaimed) {                                    // If it matches the claimed order...
                iterator.remove();                                              // ...remove it from the collection.
                break;                                                          // Exit the loop since we found the order.
            }
        }
    }

    
    public void clearPanelReceipt() {
        panelReceipt.removeAll();
        panelReceipt.revalidate();
        panelReceipt.repaint();
    }
    
    public void clearPanelOrder() {
        panelOrder.removeAll();
        panelOrder.revalidate();
        panelOrder.repaint();
    }
    
    public void clearPanelQueue() {
        panelQueue1.removeAll();
        panelQueue1.revalidate();
        panelQueue1.repaint();
        panelQueue2.removeAll();
        panelQueue2.revalidate();
        panelQueue2.repaint();
    }
    
    public void clearPanelClaim() {
        panelClaim1.removeAll();
        panelClaim1.revalidate();
        panelClaim1.repaint();
        panelClaim2.removeAll();
        panelClaim2.revalidate();
        panelClaim2.repaint();
        panelClaim3.removeAll();
        panelClaim3.revalidate();
        panelClaim3.repaint();
        panelClaim4.removeAll();
        panelClaim4.revalidate();
        panelClaim4.repaint();
        panelClaim5.removeAll();
        panelClaim5.revalidate();
        panelClaim5.repaint();
        panelClaim6.removeAll();
        panelClaim6.revalidate();
        panelClaim6.repaint();
    }
    
    public void clearAllForNewOrder() {
        orderStack.clear();
        amountStack.clear();
        orderInfoStack.clear();
        itemsNumbers = 0;
        
        labelTotal1.setText("Php 0.0");
        
        clearPanelOrder();
        clearPanelReceipt();
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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // THE FRAME WILL ONLY BE VISIBLE WHEN INVOKED IN THE AUTHENTICATION FRAME
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btClaim;
    private javax.swing.JButton btClearOrder;
    private javax.swing.JButton btDequeue;
    private javax.swing.JButton btOkReceipt;
    private javax.swing.JButton btOrderNow;
    private javax.swing.JButton btProceed;
    private javax.swing.JButton btUndo;
    private javax.swing.JCheckBox cE1;
    private javax.swing.JCheckBox cE2;
    private javax.swing.JCheckBox cE3;
    private javax.swing.JCheckBox cE4;
    private javax.swing.JCheckBox cE5;
    private javax.swing.JCheckBox cT1;
    private javax.swing.JCheckBox cT2;
    private javax.swing.JCheckBox cT3;
    private javax.swing.JCheckBox cT4;
    private javax.swing.JCheckBox cT5;
    private javax.swing.JCheckBox cT6;
    private javax.swing.JCheckBox cT7;
    private javax.swing.JCheckBox cT8;
    private javax.swing.JCheckBox cT9;
    private javax.swing.JComboBox<String> cbDrink;
    private javax.swing.JComboBox<String> cbSLevel;
    private javax.swing.JComboBox<String> cbSize;
    private javax.swing.JComboBox<String> cbSort;
    private javax.swing.JFrame framePay;
    private javax.swing.JFrame frameReceipt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel labelOrderCount;
    private javax.swing.JLabel labelOrderNum;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotal1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelClaim;
    private javax.swing.JPanel panelClaim1;
    private javax.swing.JPanel panelClaim2;
    private javax.swing.JPanel panelClaim3;
    private javax.swing.JPanel panelClaim4;
    private javax.swing.JPanel panelClaim5;
    private javax.swing.JPanel panelClaim6;
    private javax.swing.JPanel panelOrder;
    private javax.swing.JPanel panelOrderQueue;
    private javax.swing.JPanel panelQueue1;
    private javax.swing.JPanel panelQueue2;
    private javax.swing.JPanel panelReceipt;
    private javax.swing.JScrollPane sPane1;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTextField tfOrderNumber;
    private javax.swing.JTextField tfPaymentReceived;
    // End of variables declaration//GEN-END:variables
}
