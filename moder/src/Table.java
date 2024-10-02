import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

// Lớp RoundedPanel để hiển thị JPanel có góc bo tròn
class RoundedPanel extends JPanel {
    private int cornerRadius;

    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
        setLayout(null);
        setBackground(new Color(255, 255, 255));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
    }
}
// Tạo 1 nút trong table
class EditButton extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    private JPanel panel;
    private JButton deleteButton;
    private JTable table;

    public EditButton(JTable table) {
        this.table = table;
        initializePanel();
    }

    private void initializePanel() {
        // Khởi tạo JPanel và nút
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.WHITE);

        deleteButton = new JButton("Delete");
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(241, 5, 5, 121));
        deleteButton.setOpaque(true);
        // Hành động khi bấm nút
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                if (row != -1) {
                    // Hiển thị thông báo
                    int response = JOptionPane.showConfirmDialog(
                            null,
                            "Bạn có muốn xóa hàng này ?",
                            "Detele this.",
                             JOptionPane.OK_CANCEL_OPTION
                    );

                    // Xác nhận lựa chọn
                    if (response == JOptionPane.YES_OPTION) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(row);
                    }
                }
            }
        });

        panel.add(deleteButton);
    }

    // Trả về panel khi hiển thị
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return panel;
    }

    // Trả về panel khi nhấn
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    //Trả về giá trị null khi ô được chỉnh sửa
    @Override
    public Object getCellEditorValue() {
        return null;
    }
}

// Lớp ScrollPane để tạo JScrollPane chứa JTable
class ScrollPane extends JScrollPane {
    public ScrollPane(JTable table) {
        super(table);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setBackground(Color.WHITE);
        setBounds(25, 50, 750, 400);
        setBorder(BorderFactory.createEmptyBorder());
    }
}

// Lớp TableHeader để tùy chỉnh phần tiêu đề của bảng
class TableHeader extends JLabel {
    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("sansserif", 1, 12));
        setForeground(new Color(102, 102, 102, 197));
        setBorder(new EmptyBorder(10, 40, 10, 5));
    }
}

// Lớp Table để hiển thị bảng và xử lý hiển thị và sự kiện của nút
public class Table extends JTable {
    private EditButton editButton = new EditButton(this);
    public Table(DefaultTableModel model) {
        super(model);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setResizingAllowed(false);
        getTableHeader().setBorder(null);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + " ");
                return header;
            }
        });

        // Thiết lập renderer cho từng ô trong bảng
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column != 6) {  // Cột chứa nút
                    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    component.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if (isSelected) {
                        component.setForeground(new Color(15, 89, 140));
                    } else {
                        component.setForeground(new Color(102, 102, 102));
                    }
                    return component;
                } else {
                    return editButton.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });

        // Đặt Editor cho cột chứa nút
        getColumnModel().getColumn(5).setCellEditor(new EditButton(this));
        setShowHorizontalLines(true);
        setRowHeight(40);
        setBorder(null);
        setShowVerticalLines(false);
    }
}
