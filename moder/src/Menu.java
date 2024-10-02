import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  @author admin
 *  JPanel chính sẽ dùng để bấm vào còn JPanel menu sẽ add các chức năng chính vào.
 */
abstract class JPanelMini extends JPanel {
    private boolean k = false;

    public boolean getK() {
        return k;
    }

    public void setK(boolean k) {
        this.k = k;
    }
}

class JPanelMenu extends JPanel {
    public JPanelMenu() {
        setLayout(null);
        setBounds(0, 0, 280, 750);
        setBackground(new Color(25, 188, 211));
    }
}

public class Menu extends JFrame {
    private JPanel[] menuPanels;
    private JPanelMini[] mainPanels;

    public Menu() {
        menu();
    }

    public void menu() {
        JPanel jPanelMenu = new JPanelMenu();
        //thêm logo
        JLabel jLabelLogo = new JLabel("");
        jLabelLogo.setIcon(new ImageIcon("C:\\Users\\admin\\IdeaProjects\\moder\\icons\\liem.png"));
        jLabelLogo.setBounds(45,10,175,200);
        jPanelMenu.add(jLabelLogo);
        //tạo vạch
        JPanel jPanelVach = new JPanel();
        jPanelVach.setBounds(45,205,200,2);
        jPanelVach.setBackground(Color.BLACK);
        jPanelMenu.add(jPanelVach);
        // Tạo các JPanel chính và menu
        JPanelMini jPanelHome = new JPanelHome();
        JPanelMini jPanelSupplier = new JPanelSupplier();
        JPanelMini jPanelWarehouse = new JPanelWarehouse();
        JPanelMini jPanelEnterWarehouse = new JPanelEnterWarehouse();
        JPanelMini jPanelWarehouseExport = new JPanelWarehouseExport();
        JPanelMini jPanelCustomer = new JPanelCustomer();

        JPanel jPanelHomeMenu = new JPanelHomeMenu();
        JPanel jPanelSupplierMenu = new JPanelSupplierMenu();
        JPanel jPanelWarehouseMenu = new JPanelWarehouseMenu();
        JPanel jPanelEnterWarehouseMenu = new JPanelEnterWarehouseMenu();
        JPanel jPanelWarehouseExportMenu = new JPanelWarehouseExportMenu();
        JPanel jPanelCustomerMenu = new JPanelCustomerMenu();

        // Đặt các JPanel vào mảng
        menuPanels = new JPanel[]{jPanelHomeMenu, jPanelSupplierMenu, jPanelWarehouseMenu, jPanelEnterWarehouseMenu, jPanelWarehouseExportMenu,jPanelCustomerMenu};
        mainPanels = new JPanelMini[]{jPanelHome, jPanelSupplier, jPanelWarehouse, jPanelEnterWarehouse, jPanelWarehouseExport,jPanelCustomer};

        // Tắt và thêm tất cả các menu khi khởi động
        add(jPanelMenu);
        for (JPanel panel : menuPanels) {
            add(panel);
            panel.setVisible(false);
        }

        // Thêm các JPanel chính vào jPanelMenu

        for (JPanel panel : mainPanels) {
            jPanelMenu.add(panel);
        }

        // Thêm sự kiện panel
        for(int i = 0 ; i < 6 ; i++){
            addListeners(mainPanels[i],menuPanels[i]);
        }

        // Thiết lập JFrame
        setLayout(null);
        setSize(1200, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Hàm để thêm sự kiện và ẩn tất cả các panel khác
    public void addListeners(JPanelMini panelMain, JPanel panelMenu) {
        panelMain.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {
                if(panelMain.getK() == false)
                    panelMain.setBackground(new Color(43, 125, 136));
            }

            public void mouseExited(MouseEvent evt) {
                if(panelMain.getK() == false)
                    panelMain.setBackground(new Color(25, 188, 211));
            }

            public void mouseClicked(MouseEvent evt) {
                if(panelMain.getK() == false){
                    for (JPanel panel : menuPanels) {
                        panel.setVisible(false);
                    }
                    for (JPanelMini panel : mainPanels) {
                        panel.setBackground(new Color(25, 188, 211));
                        panel.setK(false);
                    }
                    // hiển thị JPanel menu đã chọn
                    panelMenu.setVisible(true);
                    panelMain.setBackground(new Color(43, 125, 136));
                    panelMain.setK(true);
                }
            }
        });
    }

}



