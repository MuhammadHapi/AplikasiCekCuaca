/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 *
 * @author Muhammad Hapi
 */
public class FormCekCuaca extends javax.swing.JFrame {
    private ArrayList<String> favoritCities = new ArrayList<>();

    
    private static final String API_KEY = "b4af45d698e42ab8d09a639d163d2f6d"; // Ganti dengan API Key OpenWeatherMap
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";
    /**
     * Creates new form FormCekCuaca
     */
    public FormCekCuaca() {
        initComponents();
        comboFavorit.addItem("Pilih Kota");
    }

    private String getCuaca(String kota) throws Exception {
        URL url = new URL(API_URL + "?q=" + kota + "&appid=" + API_KEY + "&units=metric");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            String kondisi = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            String suhu = String.valueOf(jsonObject.getJSONObject("main").getDouble("temp"));
            String kelembapan = String.valueOf(jsonObject.getJSONObject("main").getInt("humidity"));
            String iconCode = jsonObject.getJSONArray("weather").getJSONObject(0).getString("icon");

            // Mengembalikan data cuaca dan URL ikon
            return kondisi + ";" + suhu + ";" + kelembapan + ";" + iconCode;
        } else {
            throw new Exception("Gagal mengambil data cuaca! Kode respons: " + responseCode);
        }
    }


    private boolean isKotaFavorit(String kota) {
        return favoritCities.contains(kota);
    }

    private void updateComboBox() {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboFavorit.getModel();
        model.removeAllElements(); // Clear the existing items

        // Add "Pilih Kota" as default option
        model.addElement("Pilih Kota");

        // Add favorite cities to the combo box
        for (String city : favoritCities) {
            model.addElement(city);
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
    // Ini akan memuat kota favorit jika ada saat aplikasi dibuka
    updateComboBox();  // Memanggil metode untuk memuat kota favorit
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputKota = new javax.swing.JTextField();
        comboFavorit = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cekCuaca = new javax.swing.JButton();
        pilihFavorit = new javax.swing.JButton();
        textKondisiCuaca = new javax.swing.JTextField();
        textSuhu = new javax.swing.JTextField();
        textKelembapan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelRiwayat = new javax.swing.JTable();
        simpanCSV = new javax.swing.JButton();
        muatCSV = new javax.swing.JButton();
        iconInformasi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("APLIKASI CEK CUACA");

        jLabel2.setText("Nama Kota :");

        jLabel3.setText("Kota Favorit :");

        comboFavorit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bali", "Banjarbaru", "Martapura", "Jakarta", "Banjarmasin", " " }));

        jLabel4.setText("Kondisi Cuaca :");

        jLabel5.setText("Informasi Cuaca :");

        jLabel6.setText("Kelembapan :");

        jLabel7.setText("Suhu :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("INPUT DATA");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("INFORMASI CUACA");

        cekCuaca.setText("Cek Cuaca");
        cekCuaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekCuacaActionPerformed(evt);
            }
        });

        pilihFavorit.setText("Kota Favorit");
        pilihFavorit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihFavoritActionPerformed(evt);
            }
        });

        textKondisiCuaca.setText("jTextField2");
        textKondisiCuaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKondisiCuacaActionPerformed(evt);
            }
        });

        textSuhu.setText("jTextField3");

        textKelembapan.setText("jTextField4");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("RIWAYAT CUACA");

        tabelRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kota", "Suhu", "Kondisi", "Kelembaban"
            }
        ));
        jScrollPane1.setViewportView(tabelRiwayat);

        simpanCSV.setText("Simpan Ke CSV");
        simpanCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanCSVActionPerformed(evt);
            }
        });

        muatCSV.setText("Muat Dari CSV");
        muatCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muatCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inputKota, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cekCuaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textKelembapan, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textSuhu, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textKondisiCuaca, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboFavorit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pilihFavorit))
                                    .addComponent(iconInformasi, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(simpanCSV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(muatCSV)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekCuaca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboFavorit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihFavorit))
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textKondisiCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSuhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textKelembapan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(iconInformasi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanCSV)
                    .addComponent(muatCSV))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cekCuacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekCuacaActionPerformed
        String kota = inputKota.getText();
        if (!kota.isEmpty()) {
            try {
                String hasil = getCuaca(kota);
                String[] data = hasil.split(";");
                textKondisiCuaca.setText(data[0]); // Kondisi
                textSuhu.setText(data[1]); // Suhu
                textKelembapan.setText(data[2]); // Kelembapan

                // Menampilkan ikon cuaca
                String iconCode = data[3];
                String iconUrl = "http://openweathermap.org/img/wn/" + iconCode + "@2x.png";
                ImageIcon icon = new ImageIcon(new URL(iconUrl)); // Memuat ikon cuaca dari URL
                JLabel iconLabel = new JLabel(icon);
                iconInformasi.setIcon(icon); // Menampilkan ikon di JLabel11

                // Menambah data ke tabel
                DefaultTableModel model = (DefaultTableModel) tabelRiwayat.getModel();
                model.addRow(new Object[]{kota, data[0], data[1], data[2]});

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Kesalahan: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Masukkan nama kota!");
        }
    }//GEN-LAST:event_cekCuacaActionPerformed

    private void simpanCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanCSVActionPerformed
        try (FileWriter writer = new FileWriter("cuaca.csv", true)) {
            DefaultTableModel model = (DefaultTableModel) tabelRiwayat.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                String data = model.getValueAt(i, 0) + "," +
                              model.getValueAt(i, 1) + "," +
                              model.getValueAt(i, 2) + "," +
                              model.getValueAt(i, 3) + "\n";
                writer.write(data);
            }
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke CSV!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_simpanCSVActionPerformed

    private void muatCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muatCSVActionPerformed
        try (BufferedReader reader = new BufferedReader(new FileReader("cuaca.csv"))) {
            String line;
            DefaultTableModel model = (DefaultTableModel) tabelRiwayat.getModel();
            model.setRowCount(0);
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
            JOptionPane.showMessageDialog(this, "Data berhasil dimuat dari CSV!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_muatCSVActionPerformed

    private void pilihFavoritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihFavoritActionPerformed
        String kota = inputKota.getText();  // Mengambil input kota dari textfield
    if (!kota.isEmpty() && !isKotaFavorit(kota)) {  // Memeriksa apakah kota belum ada di daftar
        favoritCities.add(kota);  // Menambahkan kota ke daftar kota favorit
        updateComboBox();  // Memperbarui ComboBox
        JOptionPane.showMessageDialog(this, "Kota " + kota + " ditambahkan ke favorit!");
    } else {
        JOptionPane.showMessageDialog(this, "Kota sudah ada di daftar favorit atau tidak ada nama kota!");
    }
    }//GEN-LAST:event_pilihFavoritActionPerformed

    private void textKondisiCuacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKondisiCuacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKondisiCuacaActionPerformed

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
            java.util.logging.Logger.getLogger(FormCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCekCuaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCekCuaca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cekCuaca;
    private javax.swing.JComboBox<String> comboFavorit;
    private javax.swing.JLabel iconInformasi;
    private javax.swing.JTextField inputKota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton muatCSV;
    private javax.swing.JButton pilihFavorit;
    private javax.swing.JButton simpanCSV;
    private javax.swing.JTable tabelRiwayat;
    private javax.swing.JTextField textKelembapan;
    private javax.swing.JTextField textKondisiCuaca;
    private javax.swing.JTextField textSuhu;
    // End of variables declaration//GEN-END:variables
}
