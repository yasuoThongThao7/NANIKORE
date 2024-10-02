import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JPanelHome extends JPanelMini {
    private JLabel text = new JLabel("Trang chủ");
    private JLabel image = new JLabel();

    public JPanelHome() {
        //image
        image.setIcon(new ImageIcon("C:\\Users\\admin\\IdeaProjects\\moder\\icons\\nhane.png"));
        image.setBounds(20,2,48,48);
        add(image);
        //text
        text.setFont(new Font("Tahoma", Font.BOLD, 15));
        text.setBounds(130, 10, 100, 30);
        add(text);
        // Thiết lập JPanelHome
        setBounds(0, 250, 280, 60);
        setLayout(null);
        setBackground(new Color(25, 188, 211));

    }
}
class JPanelHomeMenu extends JPanel {
    private JPanel searchPanel= new Search();
    public JPanelHomeMenu() {
        //thanh tìm kiếm
        searchPanel.setVisible(true);
        searchPanel.setBounds(0,0,920,50);
        //
        add(searchPanel);
        setLayout(null);
        setBackground(new Color(239, 239, 239));
        setBounds(280, 0, 920, 680);
    }
}
// Thanh tìm kiếm
class Search extends JPanel {
    private JTextField search = new JTextField("Tìm kiếm....");
    private JTextField imageSearch = new JTextField();
    public Search() {

        // Văn bản
        search.setBounds(50, 5, 770, 40);
        search.setMargin(new Insets(10, 20, 5, 20));
        search.setFont(new Font("Tahoma", Font.PLAIN, 16));
        search.setOpaque(false);
        search.setBorder(null);
        search.setForeground(new Color(102, 102, 102, 97));
        // set
        setLayout(null);
        addListeners(search);
        add(search);
        setBackground(Color.white);
        search.setBackground(Color.WHITE);
        search.setForeground(new Color(102, 102, 102, 82));
    }
    private void addListeners(JTextField search) {
        search.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(search.getText().equals("Tìm kiếm....")){
                    search.setText("");
                    search.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if(search.getText().equals("")){
                    search.setText("Tìm kiếm....");
                    search.setForeground(new Color(10,10,10, 23));
                }
            }
        });
    }
}
