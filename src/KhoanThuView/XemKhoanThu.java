/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package KhoanThuView;

import KhoanThuController.XemKhoanThuController;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import HoKhauView.taoMoiHoKhau;
import model.DongTienModel;
import model.HoKhauModel;
import model.KhoanThu;
import view.KhoanThuView;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

/**
 *
 * @author MY PC
 */
public class XemKhoanThu extends javax.swing.JFrame {

    /**
     * Creates new form XemKhoanThu
     */
    XemKhoanThuController xemKT;
    private JFrame parentJframe;
    DefaultTableModel table;
    String makhoanthu ="";
    public XemKhoanThu(JFrame parent, String maKhoanThu, String loaiKhoanThu) {
    	setTitle("Xem khoản thu");
    	
    	setIconImage(Toolkit.getDefaultToolkit().getImage(XemKhoanThu.class.getResource("/img/apartment_13889041-min.png")));
        initComponents();
        this.parentJframe = parent;
        this.makhoanthu = maKhoanThu;
        
        this.setLocationRelativeTo(null);
        xemKT = new XemKhoanThuController(this);
        table = (DefaultTableModel)jTable1.getModel();
        
        xemKT.getKhoanThu(maKhoanThu, loaiKhoanThu);
        xemKT.getDanhSachCanThu(maKhoanThu);
        
        Dimension fixedSize = new Dimension(776, 632);
        jPanel3.setPreferredSize(fixedSize);
        jPanel3.setMinimumSize(fixedSize);
        jPanel3.setMaximumSize(fixedSize);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        
        this.setVisible(true);
    }
    
    public void hienThiKhoanThu(KhoanThu kt){
        
        
        this.TenKhoanThu2.setText(kt.getTenKhoanThu());
        
        
        this.LoaiKhoanThu.setSelectedItem(kt.getLoaiKhoanThu());
        this.LoaiKhoanThu.setEnabled(false);
        
        if(this.LoaiKhoanThu.getSelectedItem().equals("Phí dịch vụ")||LoaiKhoanThu.getSelectedItem().equals("Phí quản lý")){
            this.DonGia.setVisible(true);
            this.jLabel15.setVisible(true);
            this.jLabel14.setVisible(true);
            this.CongTy.setVisible(false);
            this.jLabel16.setVisible(false);
            this.DichVu.setVisible(false);
            this.jLabel17.setVisible(false);
            this.Oto.setVisible(false);
            this.jLabel18.setVisible(false);
            this.XeMay.setVisible(false);
            this.jLabel19.setVisible(false);
            this.jLabel20.setVisible(false);
            this.jLabel24.setVisible(false);
            this.ThuDuocText.setVisible(false);
            this.DonGia.setText(kt.getDonGia()+"");
        }else if(this.LoaiKhoanThu.getSelectedItem().equals("Phí gửi xe")){
            this.Oto.setVisible(true);
            this.jLabel18.setVisible(true);
            this.XeMay.setVisible(true);
             this.jLabel19.setVisible(true);
                this.DonGia.setVisible(false);
                this.jLabel15.setVisible(false);
                this.jLabel14.setVisible(false);
                 this.CongTy.setVisible(false);
                this.jLabel16.setVisible(false);
                 this.DichVu.setVisible(false);
                 this.jLabel17.setVisible(false);
            this.jLabel24.setVisible(false);
            this.ThuDuocText.setVisible(false);
            this.jLabel20.setVisible(true);
                    this.Oto.setText(kt.getOto()+"");
                    this.XeMay.setText(kt.getXemay()+"");
        }else if(this.LoaiKhoanThu.getSelectedItem().equals("Phí thu hộ")){
                             this.CongTy.setVisible(true);
                this.jLabel16.setVisible(true);
                 this.DichVu.setVisible(true);
                 this.jLabel17.setVisible(true);
            this.DonGia.setVisible(false);
            this.jLabel15.setVisible(false);
            this.jLabel14.setVisible(false);
            this.Oto.setVisible(false);
            this.jLabel18.setVisible(false);
            this.XeMay.setVisible(false);
             this.jLabel19.setVisible(false);
            this.jLabel20.setVisible(false);
            this.jLabel24.setVisible(false);
            this.ThuDuocText.setVisible(false);            
            this.CongTy.setText(kt.getTenCongTy());
            this.DichVu.setSelectedItem(kt.getDichVu());
            this.DichVu.setEnabled(false);
        }else if(this.LoaiKhoanThu.getSelectedItem().equals("Phí đóng góp")){
            this.jLabel24.setVisible(true);
            this.ThuDuocText.setVisible(true);            
            this.DonGia.setVisible(false);
            this.jLabel15.setVisible(false);
            this.jLabel14.setVisible(false);
            this.CongTy.setVisible(false);
            this.jLabel16.setVisible(false);
            this.DichVu.setVisible(false);
            this.jLabel17.setVisible(false);
            this.Oto.setVisible(false);
            this.jLabel18.setVisible(false);
            this.XeMay.setVisible(false);
            this.jLabel19.setVisible(false);
            this.jLabel20.setVisible(false);    
            this.ThuDuocText.setText(kt.getTongThu()+"");
        }
        
        this.idText.setText(kt.getIdKhoanThu());
        this.NgayBatDau.setText(kt.getNgayBatDau()+"");
        this.TrangThai.setText(kt.getTrangThai());
        

        System.out.println(kt.getDichVu()+" "+kt.getLoaiKhoanThu());
    }
    
    public void hienThiDanhSachCanThu(ArrayList<DongTienModel> list){
      int countDaDong = 0;
      for(DongTienModel i : list){
        if(i.getTrangThai().equals("Đã đóng") && this.LoaiKhoanThu.getSelectedItem().equals("Phí đóng góp")){
        table.addRow(new Object[]{i.getSoNha(),i.getTenChuHo(),i.getSoTien(), i.getTrangThai(),i.getNgayDong()});
        if(i.getTrangThai().equals("Đã đóng"))
                countDaDong++;
        }
        if(!this.LoaiKhoanThu.getSelectedItem().equals("Phí đóng góp")){
            table.addRow(new Object[]{i.getSoNha(),i.getTenChuHo(),i.getSoTien(), i.getTrangThai(),i.getNgayDong()});
            if(i.getTrangThai().equals("Đã đóng"))
                countDaDong++;
        }
      }
      
      this.dathu.setText(countDaDong+"");
      this.tong.setText(list.size()+"");
      this.chuathu.setText(list.size()-countDaDong+"");
      
      
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setForeground(new Color(0, 102, 153));
        jLabel9.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel10 = new javax.swing.JLabel();
        jLabel10.setForeground(new Color(0, 102, 153));
        jLabel10.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel11 = new javax.swing.JLabel();
        jLabel11.setForeground(new Color(0, 102, 153));
        jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel12 = new javax.swing.JLabel();
        jLabel12.setForeground(new Color(0, 102, 153));
        jLabel12.setFont(new Font("Tahoma", Font.PLAIN, 13));
        TenKhoanThu2 = new javax.swing.JTextField();
        NgayBatDau = new javax.swing.JTextField();
        TrangThai = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton2.setBorderPainted(false);
        jLabel13 = new javax.swing.JLabel();
        jLabel13.setForeground(new Color(0, 102, 153));
        jLabel13.setFont(new Font("Tahoma", Font.PLAIN, 13));
        idText = new javax.swing.JTextField();
        LoaiKhoanThu = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel14.setForeground(new Color(0, 102, 153));
        jLabel14.setFont(new Font("Tahoma", Font.PLAIN, 13));
        DonGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel15.setForeground(new Color(0, 102, 153));
        jLabel15.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel16 = new javax.swing.JLabel();
        jLabel16.setForeground(new Color(0, 102, 153));
        jLabel16.setFont(new Font("Tahoma", Font.PLAIN, 13));
        CongTy = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel17.setForeground(new Color(0, 102, 153));
        jLabel17.setFont(new Font("Tahoma", Font.PLAIN, 13));
        DichVu = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel18.setForeground(new Color(0, 102, 153));
        jLabel18.setFont(new Font("Tahoma", Font.PLAIN, 13));
        XeMay = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel19.setForeground(new Color(0, 102, 153));
        jLabel19.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Oto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel20.setForeground(new Color(0, 102, 153));
        jLabel20.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel21.setForeground(new Color(0, 102, 153));
        jLabel21.setFont(new Font("Tahoma", Font.BOLD, 13));
        tong = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel22.setForeground(new Color(0, 102, 153));
        jLabel22.setFont(new Font("Tahoma", Font.BOLD, 13));
        dathu = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel23.setForeground(new Color(0, 102, 153));
        jLabel23.setFont(new Font("Tahoma", Font.BOLD, 13));
        chuathu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton1.setBorderPainted(false);
        jButton3 = new javax.swing.JButton();
        jButton3.setBorderPainted(false);
        jLabel24 = new javax.swing.JLabel();
        jLabel24.setForeground(new Color(0, 102, 153));
        jLabel24.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ThuDuocText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new Color(230, 242, 255));
        jPanel3.setBorder(null); // NOI18N

        jLabel9.setText("Tên khoản thu");

        jLabel10.setText("Loại khoản thu");

        jLabel11.setText("Ngày bắt đầu:");

        jLabel12.setText("Trạng thái");

        TenKhoanThu2.setEditable(false);
        TenKhoanThu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenKhoanThu2ActionPerformed(evt);
            }
        });

        NgayBatDau.setEditable(false);
        NgayBatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NgayBatDauActionPerformed(evt);
            }
        });

        TrangThai.setEditable(false);
        TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrangThaiActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setText("ID: ");

        idText.setEditable(false);

        LoaiKhoanThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phí dịch vụ", "Phí quản lý", "Phí đóng góp", "Phí gửi xe", "Phí thu hộ" }));
        LoaiKhoanThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoaiKhoanThuActionPerformed(evt);
            }
        });

        jLabel14.setText("Đơn giá:");

        DonGia.setEditable(false);
        DonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DonGiaActionPerformed(evt);
            }
        });

        jLabel15.setText("( đơn vị: nghìn Đồng/m2 )");

        jLabel16.setText("Tên công ty cấp");

        CongTy.setEditable(false);
        CongTy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CongTyActionPerformed(evt);
            }
        });

        jLabel17.setText("Tên dịch vụ:");

        DichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Điện", "Nước", "Internet" }));

        jLabel18.setText("Giá xe máy: ");

        XeMay.setEditable(false);
        XeMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XeMayActionPerformed(evt);
            }
        });

        jLabel19.setText("Giá ô tô: ");

        Oto.setEditable(false);
        Oto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtoActionPerformed(evt);
            }
        });

        jLabel20.setText("( đơn vị: nghìn Đồng/xe)");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số nhà", "Tên chủ hộ", "Số tiền", "Trạng thái", "Ngày đóng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel21.setText("Tổng: ");

        tong.setEditable(false);

        jLabel22.setText("Đã thu:");

        dathu.setEditable(false);

        jLabel23.setText("Chưa thu:");

        chuathu.setEditable(false);
        chuathu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuathuActionPerformed(evt);
            }
        });

        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Hoàn thành");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel24.setText("Thu được:");

        ThuDuocText.setEditable(false);
        ThuDuocText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThuDuocTextActionPerformed(evt);
            }
        });
        
        jLabel9_1 = new JLabel();
        jLabel9_1.setForeground(new Color(0, 102, 153));
        jLabel9_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        lblThngTinKhon = new JLabel();
        lblThngTinKhon.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
        lblThngTinKhon.setForeground(new Color(0, 102, 153));
        lblThngTinKhon.setText("Thông tin khoản thu");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        					.addComponent(jLabel9_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel11, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        						.addComponent(jLabel12, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        						.addComponent(jLabel16, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        						.addComponent(jLabel10, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        						.addComponent(jLabel18)
        						.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        							.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING, false)
        									.addComponent(CongTy)
        									.addComponent(jLabel20, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        								.addGroup(jPanel3Layout.createSequentialGroup()
        									.addComponent(LoaiKhoanThu, 0, 159, Short.MAX_VALUE)
        									.addPreferredGap(ComponentPlacement.RELATED))
        								.addComponent(XeMay, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        								.addComponent(TrangThai, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        								.addComponent(NgayBatDau, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        							.addGap(35)
        							.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING, false)
        									.addGroup(jPanel3Layout.createSequentialGroup()
        										.addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(DichVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        										.addGap(234))
        									.addGroup(jPanel3Layout.createSequentialGroup()
        										.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        											.addGroup(jPanel3Layout.createSequentialGroup()
        												.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        												.addGap(62)
        												.addComponent(idText, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
        											.addGroup(jPanel3Layout.createSequentialGroup()
        												.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        													.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        													.addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        												.addPreferredGap(ComponentPlacement.UNRELATED)
        												.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        													.addComponent(ThuDuocText, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        													.addGroup(jPanel3Layout.createSequentialGroup()
        														.addComponent(DonGia, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        														.addPreferredGap(ComponentPlacement.UNRELATED)
        														.addComponent(jLabel15)))))
        										.addGap(32)))
        								.addGroup(jPanel3Layout.createSequentialGroup()
        									.addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(Oto, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
        							.addGap(47))
        						.addGroup(jPanel3Layout.createSequentialGroup()
        							.addComponent(TenKhoanThu2, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
        							.addContainerGap())))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGap(14)
        					.addComponent(jLabel21)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(tong, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        					.addGap(8)
        					.addComponent(jLabel22)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(dathu, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel23)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(chuathu, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
        					.addComponent(jButton1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton3)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGap(277)
        			.addComponent(lblThngTinKhon, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel9_1)
        				.addComponent(lblThngTinKhon))
        			.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(TenKhoanThu2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel9))
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(LoaiKhoanThu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel10)
        				.addComponent(jLabel13)
        				.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(24)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(NgayBatDau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel11)
        				.addComponent(jLabel14)
        				.addComponent(DonGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel15))
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(TrangThai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel12)
        				.addComponent(jLabel24)
        				.addComponent(ThuDuocText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(21)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(CongTy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel16)
        				.addComponent(DichVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel17))
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(XeMay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel19)
        				.addComponent(Oto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel18))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton2)
        				.addComponent(chuathu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel23)
        				.addComponent(dathu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel22)
        				.addComponent(tong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel21)
        				.addComponent(jButton3)
        				.addComponent(jButton1))
        			.addGap(10))
        );
        jPanel3.setLayout(jPanel3Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 773, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 599, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TenKhoanThu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenKhoanThu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenKhoanThu2ActionPerformed

    private void NgayBatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NgayBatDauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NgayBatDauActionPerformed

    private void TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrangThaiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            KhoanThuView mainView = new KhoanThuView();
            this.setVisible(false);
            mainView.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LoaiKhoanThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoaiKhoanThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoaiKhoanThuActionPerformed

    private void DonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DonGiaActionPerformed

    private void CongTyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CongTyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CongTyActionPerformed

    private void XeMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XeMayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XeMayActionPerformed

    private void OtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OtoActionPerformed

    private void chuathuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuathuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chuathuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.xemKT.xoaKhoanThu(makhoanthu);
        this.dispose();
        KhoanThuView viewMain = new KhoanThuView();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if((Integer.parseInt(this.tong.getText())==Integer.parseInt(this.dathu.getText()) && Integer.parseInt(this.tong.getText())!=0) || this.LoaiKhoanThu.getSelectedItem().equals("Phí đóng góp"))
            xemKT.hoanThanhKhoanThu(makhoanthu);
        else{
            JOptionPane.showMessageDialog(this, "Khoản thu " +makhoanthu+ " chưa hoàn thành");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ThuDuocTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThuDuocTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThuDuocTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CongTy;
    private javax.swing.JComboBox<String> DichVu;
    private javax.swing.JTextField DonGia;
    private javax.swing.JComboBox<String> LoaiKhoanThu;
    private javax.swing.JTextField NgayBatDau;
    private javax.swing.JTextField Oto;
    private javax.swing.JTextField TenKhoanThu2;
    private javax.swing.JTextField ThuDuocText;
    private javax.swing.JTextField TrangThai;
    private javax.swing.JTextField XeMay;
    private javax.swing.JTextField chuathu;
    private javax.swing.JTextField dathu;
    private javax.swing.JTextField idText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tong;
    private JLabel jLabel9_1;
    private JLabel lblThngTinKhon;
    // End of variables declaration//GEN-END:variables
}
